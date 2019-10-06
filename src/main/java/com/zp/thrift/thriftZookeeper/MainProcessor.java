///**
// * Copyright (C) 2006-2019 Tuniu All rights reserved
// */
//package com.zp.thrift.thriftZookeeper;
//
//import java.io.IOException;
//
//import org.I0Itec.zkclient.ZkClient;
//import org.apache.zookeeper.CreateMode;
//import org.apache.zookeeper.WatchedEvent;
//import org.apache.zookeeper.Watcher;
//import org.apache.zookeeper.ZooKeeper;
//import org.springframework.beans.factory.annotation.Value;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//
///**
// * TODO: description
// * Date: 2019-09-19
// *
// * @author zhengpeng
// */
//public class MainProcessor {
//
//    @Value("${zookeeper}")
//    private String server;
//
//    public void connectZookeeper() throws IOException {
//        // 默认的监听器
//        MyDefaultWatcher defaultWatcher = new MyDefaultWatcher();
//        // 连接到zk服务器集群，添加默认的watcher监听
//        ZooKeeper zk = new ZooKeeper(server, 120000, defaultWatcher);
//    }
//
//    private class MyDefaultWatcher implements Watcher {
//        public void process(WatchedEvent event) {
//
//        }
//    }
//
//    public static void main(String[] args) {
////        ZkClient zkClient = new ZkClient("10.10.20.105:2181/walle/v1");
////    byte[] bytes = zkClient.readData("/agent", byte[].class);
////    System.out.println(new String(bytes, 0, bytes.length, UTF8));
////        System.out.println(zkClient.readData("/agent", JSONObject.class));
////        System.out.println(zkClient.readData("/master", JSONArray.class));
////        System.out.println(zkClient.readData("/master", JSON.class));
////    System.out.println(zkClient.readData("/agent", String.class));
//        ZkClient zkClient = new ZkClient("127.0.0.1:2181");//建立连接
//        zkClient.create("/root","mydata", CreateMode.PERSISTENT);//创建目录并写入数据
//        String data=zkClient.readData("/root");
//        System.out.println(data);
//        zkClient.delete("/root");//删除目录
//
//
//    }
//}
