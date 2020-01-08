/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.thrift.thriftZookeeper.zkclient;

import java.io.Closeable;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * description: zookeeper 客户端
 * Date: 2019-10-03
 *
 * @author zhengpeng
 */
@Component
public class ZookeeperFactory implements FactoryBean<CuratorFramework>, Closeable {
    @Value("${zkHosts}")
    private String zkHosts;
    // session超时
    private int sessionTimeout = 30000;
    private int connectionTimeout = 30000;

    // 共享一个zk链接
    private boolean singleton = true;

    // 全局path前缀,常用来区分不同的应用
    @Value("${namespace}")
    private String namespace;

    private final static String ROOT = "rpc";

    private CuratorFramework zkClient;

    public void setZkHosts(String zkHosts) {
        this.zkHosts = zkHosts;
    }

    public void setSessionTimeout(int sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public void setSingleton(boolean singleton) {
        this.singleton = singleton;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public void setZkClient(CuratorFramework zkClient) {
        this.zkClient = zkClient;
    }

    public ZookeeperFactory(String namespace) {
        this.namespace = namespace;
    }

    public ZookeeperFactory() {
    }

    @Override
    public CuratorFramework getObject(){
//        if (singleton) {
//            if (zkClient == null) {
//                zkClient = create();
//                zkClient.start();
//            }
//            return zkClient;
//        }
//        return create();
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return CuratorFramework.class;
    }

    @Override
    public boolean isSingleton() {
        return singleton;
    }

    private CuratorFramework create() {
        if (StringUtils.isEmpty(namespace)) {
            namespace = ROOT;
        } else {
            namespace = ROOT + "/" + namespace;
        }
        return create(zkHosts, sessionTimeout, connectionTimeout, namespace);
    }

    // 使用CuratorFramework创建zk客户端对象

    /**
     * connectString zk集群的地址，包括ip和端口
     * sessionTimeout
     * connectionTimeout
     * namespace 不同的应用可以使用不同的命名空间区分
     * ExponentialBackoffRetry表示重试机制，重连的时间间隔随着重
     * 试的次数递增的，如果时间间隔计算出来大于默认的最大sleep时
     * 间的话，则取最大sleep时间。ExponentialBackoffRetry 除了时间
     * 的限制以外，还有最大重连次数的限制。而
     * ExponentialBackoffRetry策略只是让用户设置最大sleep时间而
     * 已。默认的最大时间是Integer.MAX_VALUE毫秒。
     **/
    private CuratorFramework create(String connectString, int sessionTimeout, int connectionTimeout, String namespace) {
        CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder();
        return builder.connectString(connectString).sessionTimeoutMs(sessionTimeout).connectionTimeoutMs(30000)
                .canBeReadOnly(true).namespace(namespace).retryPolicy(new ExponentialBackoffRetry(1000, Integer.MAX_VALUE))
                .defaultData(null).build();
    }

    public void close() {
        if (zkClient != null) {
            zkClient.close();
        }
    }
}
