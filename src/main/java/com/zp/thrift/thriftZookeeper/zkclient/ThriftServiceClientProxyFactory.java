/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.thrift.thriftZookeeper.zkclient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.thrift.TServiceClient;
import org.apache.thrift.TServiceClientFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * description：客户端服务代理工厂实现
 * Date: 2019-10-05
 *
 * @author zhengpeng
 */
@Component
public class ThriftServiceClientProxyFactory implements FactoryBean, InitializingBean {

    private Integer maxActive = 32;// 最大活跃连接数

    // ms,default 3 min,链接空闲时间
    // -1,关闭空闲检测
    private Integer idleTime = 180000;

    @Autowired
    private ThriftServerAddressProvider serverAddressProvider;

    private Object proxyClient;
    private Class<?> objectClass;

    private GenericObjectPool<TServiceClient> pool;

    private ThriftClientPoolFactory.PoolOperationCallBack callback = new ThriftClientPoolFactory.PoolOperationCallBack() {
        @Override
        public void make(TServiceClient client) {
            System.out.println("create");
        }

        @Override
        public void destroy(TServiceClient client) {
            System.out.println("destroy");
        }
    };

    public void setMaxActive(Integer maxActive) {
        this.maxActive = maxActive;
    }

    public void setIdleTime(Integer idleTime) {
        this.idleTime = idleTime;
    }

    public void setServerAddressProvider(ThriftServerAddressProvider serverAddressProvider) {
        this.serverAddressProvider = serverAddressProvider;
    }

    /**
     * 1、makeObject 创建对象的具体实现
     * 2、borrowObject 获取对象池中的对象简单而言就是去LinkedList中获取一个对象，如果不存在的话，要调用构造方法中第一个参数Factory工厂类的makeObject()方法去创建一个对象再获取，获取到对象后要调用validateObject方法判断该对象是否是可用的，如果是可用的才拿去使用。LinkedList容器减一
     * 3、returnObject 先调用validateObject方法判断该对象是否是可用的，如果可用则归还到池中，LinkedList容器加一，如果是不可以的则则调用destroyObject方法进行销毁。
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        // 加载Iface接口
        objectClass = classLoader.loadClass(serverAddressProvider.getService() + "$Iface");
        // 加载Client.Factory类
        Class<TServiceClientFactory<TServiceClient>> fi = (Class<TServiceClientFactory<TServiceClient>>) classLoader.loadClass(serverAddressProvider.getService() + "$Client$Factory");
        TServiceClientFactory<TServiceClient> clientFactory = fi.newInstance();
        ThriftClientPoolFactory clientPool = new ThriftClientPoolFactory(serverAddressProvider, clientFactory, callback);
        GenericObjectPool.Config poolConfig = new GenericObjectPool.Config();
        poolConfig.maxActive = maxActive;
        poolConfig.minIdle = 0;
        poolConfig.minEvictableIdleTimeMillis = idleTime;
        poolConfig.timeBetweenEvictionRunsMillis = idleTime / 2L;
        pool = new GenericObjectPool<TServiceClient>(clientPool, poolConfig);
        proxyClient = Proxy.newProxyInstance(classLoader, new Class[] { objectClass }, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                TServiceClient client = pool.borrowObject();
                // finally语句在return语句执行之后return返回之前执行的
                try {
                    return method.invoke(client, args);
                } catch (Exception e) {
                    throw e;
                } finally {
                    pool.returnObject(client);
                }
            }
        });
    }

    @Override
    public Object getObject() throws Exception {
        return proxyClient;
    }

    @Override
    public Class<?> getObjectType() {
        return objectClass;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void close() {
        if (serverAddressProvider != null) {
            serverAddressProvider.close();
        }
    }

}
