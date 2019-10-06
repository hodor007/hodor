/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.thrift.thriftZookeeper.zkserver;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO: description
 * Date: 2019-10-03
 *
 * @author zhengpeng
 */
public class ThriftServerIpLocalNetworkResolve implements ThriftServerIpResolve {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //缓存
    private String serverIp;

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    @Override
    public String getServerIp() {
        return getServerIp(false);
    }

    @Override
    public String getServerIp(boolean publicIpOnly) {
        if (serverIp != null) {
            return serverIp;
        }
        // 一个主机有多个网络接口
        try {
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = netInterfaces.nextElement();
                // 每个网络接口,都会有多个"网络地址",比如一定会有lookback地址,会有siteLocal地址等.以及IPV4或者IPV6 .
                Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress address = addresses.nextElement();
                    if(address instanceof Inet6Address){
                        continue;
                    }
                    if (!address.isLoopbackAddress()) {
                        if (publicIpOnly && !address.isSiteLocalAddress()) {
                            serverIp = address.getHostAddress();
                            logger.info("resolve server ip :" + serverIp);
                            continue;
                        } else if (!publicIpOnly && address.isSiteLocalAddress()) {
                            serverIp = address.getHostAddress();
                            logger.info("resolve server ip :" + serverIp);
                            continue;
                        }
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return serverIp;
    }

    @Override
    public void reset() {
        serverIp = null;
    }
}