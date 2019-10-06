/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.thrift.thriftZookeeper.zkclient;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * description：thrift server-service地址提供者,以便构建客户端连接池
 * Date: 2019-10-05
 *
 * @author zhengpeng
 */
public interface ThriftServerAddressProvider {
    //获取服务名称
    String getService();

    /**
     * 获取所有服务端地址
     * @return
     */
    List<InetSocketAddress> findServerAddressList();

    /**
     * 选取一个合适的address,可以随机获取等'
     * 内部可以使用合适的算法.
     * @return
     */
    InetSocketAddress selector();

    void close();

}
