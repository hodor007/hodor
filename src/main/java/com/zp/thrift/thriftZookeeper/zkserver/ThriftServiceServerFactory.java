/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.thrift.thriftZookeeper.zkserver;

import java.io.Closeable;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Constructor;

import org.apache.thrift.TProcessor;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.zp.basic.selfException.InvalidParamException;
import com.zp.thrift.HelloWorldService;

/**
 * description：服务端注册服务工厂
 * Date: 2019-10-03
 *
 * @author zhengpeng
 */
@Component
public class ThriftServiceServerFactory implements InitializingBean, Closeable {

    // 服务注册本机端口
    private Integer port = 8299;
    // 优先级
    private Integer weight = 1;// default
    // 服务实现类
    private Object service;// serice实现类
    //服务版本号
    private String version;
    // 是否只取公网ip，如果是true，zk中只注册公网ip；如果是false，zk中只注册私网ip
    private boolean publicIpOnly = false;
    // 解析本机IP
    private ThriftServerIpResolve thriftServerIpResolve;
    //服务注册
    @Autowired
    private ThriftServerAddressRegister thriftServerAddressRegister;

    @Autowired
    private HelloWorldService.Iface helloWorldService;


    private ServerThread serverThread;

    private boolean zkUse = true;

    public void setPort(Integer port) {
        this.port = port;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setService(Object service) {
        this.service = service;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setZkUse(boolean zkUse) {
        this.zkUse = zkUse;
    }

    public void setPublicIpOnly(boolean publicIpOnly) {
        this.publicIpOnly = publicIpOnly;
    }

    public void setThriftServerIpResolve(ThriftServerIpResolve thriftServerIpResolve) {
        this.thriftServerIpResolve = thriftServerIpResolve;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
//        service = helloWorldService;
//        if (thriftServerIpResolve == null) {
//            thriftServerIpResolve = new ThriftServerIpLocalNetworkResolve();
//        }
//        String serverIP = thriftServerIpResolve.getServerIp(publicIpOnly);
//        if (StringUtils.isEmpty(serverIP)) {
//            throw new InvalidParamException("cant find server ip...");
//        }
//
//        String hostname = serverIP + ":" + port + ":" + weight;
//        Class<?> serviceClass = service.getClass();
//        // 获取实现类接口
//        Class<?>[] interfaces = serviceClass.getInterfaces();
//        if (interfaces.length == 0) {
//            throw new IllegalClassFormatException("service-class should implements Iface");
//        }
//        // reflect,load "Processor";
//        TProcessor processor = null;
//        String serviceName = null;
//
//        for (Class<?> clazz : interfaces) {
//            String cname = clazz.getSimpleName();
//            if (!cname.equals("Iface")) {
//                continue;
//            }
//            serviceName = clazz.getEnclosingClass().getName();
//            String pname = serviceName + "$Processor";
//            try {
//                ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//                Class<?> pclass = classLoader.loadClass(pname);
//                if (!TProcessor.class.isAssignableFrom(pclass)) {
//                    continue;
//                }
//                Constructor<?> constructor = pclass.getConstructor(clazz);
//                processor = (TProcessor) constructor.newInstance(service);
//                break;
//            } catch (Exception e) {
//                //
//            }
//        }
//        if (processor == null) {
//            throw new IllegalClassFormatException("service-class should implements Iface");
//        }
//        //需要单独的线程,因为serve方法是阻塞的.
//        serverThread = new ServerThread(processor, port);
//        serverThread.start();
//        // 注册服务
//        if (zkUse && thriftServerAddressRegister != null) {
//            thriftServerAddressRegister.register(serviceName, version, hostname);
//        }

    }

    class ServerThread extends Thread {
        private TServer server;

        ServerThread(TProcessor processor, int port) throws Exception {
            /**
             TThreadedSelectorServer模式是目前Thrift提供的最高级的模式，
             它内部有如果几个部分构成：

             （1）  一个AcceptThread线程对象，专门用于处理监听socket上的新连接；

             （2）  若干个SelectorThread对象专门用于处理业务socket的网络I/O操作，所有网络数据的读写均是有这些线程来完成；

             （3）  一个负载均衡器SelectorThreadLoadBalancer对象，主要用于AcceptThread线程接收到一个新socket连接请求时，决定将这个新连接请求分配给哪个SelectorThread线程。

             （4）  一个ExecutorService类型的工作线程池，在SelectorThread线程中，监听到有业务socket中有调用请求过来，则将请求读取之后，交个ExecutorService线程池中的线程完成此次调用的具体执行；
             **/
            TNonblockingServerSocket serverTransport = new TNonblockingServerSocket(port);
            TThreadedSelectorServer.Args tArgs = new TThreadedSelectorServer.Args(serverTransport);
            TProcessorFactory processorFactory = new TProcessorFactory(processor);
            tArgs.processorFactory(processorFactory);
            tArgs.transportFactory(new TFramedTransport.Factory());
            tArgs.protocolFactory(new TBinaryProtocol.Factory(true, true));
            tArgs.maxReadBufferBytes = 1024 * 1024L; // 防止direct memory oom
            tArgs.selectorThreads(4); // 设置selector线程数，默认是2
            tArgs.workerThreads(32); // 设置工作线程数，默认是5，在数据库负载高时有可能会堵塞
            server = new TThreadedSelectorServer(tArgs);
        }

        @Override
        public void run() {
            try {
                //启动服务
                server.serve();
            } catch (Exception e) {
                //
            }
        }

        public void stopServer() {
            server.stop();
        }
    }

    public void close() {
        serverThread.stopServer();
    }

}
