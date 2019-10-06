/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.thrift.thriftZookeeper.zkserver;

import java.io.UnsupportedEncodingException;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.imps.CuratorFrameworkState;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.framework.state.ConnectionStateListener;
import org.apache.zookeeper.CreateMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.zp.basic.selfException.InvalidParamException;
import com.zp.thrift.thriftZookeeper.zkclient.ZookeeperFactory;

/**
 * TODO: description
 * Date: 2019-10-03
 *
 * @author zhengpeng
 */
@Service
public class ThriftServerAddressRegisterImpl implements ThriftServerAddressRegister {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private CuratorFramework zkClient;

    @Autowired
    private ZookeeperFactory zookeeperFactory;

    public ThriftServerAddressRegisterImpl() {
    }

    public CuratorFramework getZkClient() {
        return zkClient;
    }

    public void setZkClient(CuratorFramework zkClient) {
        this.zkClient = zkClient;
    }


    @Override
    public void register(String service, String version, String address) throws InvalidParamException {

        zkClient = zookeeperFactory.getObject();

        if (zkClient.getState() == CuratorFrameworkState.LATENT) {
            zkClient.start();
        }
        if (StringUtils.isEmpty(version)) {
            version = "1.0.0";
        }
        //临时节点
        try {
            zkClient.create()
                    .creatingParentsIfNeeded()
                    .withMode(CreateMode.EPHEMERAL)
                    .forPath("/" + service + "/" + version + "/" + address);
        } catch (UnsupportedEncodingException e) {
            logger.error("register service address to zookeeper exception:{}", e);
            throw new InvalidParamException("register service address to zookeeper exception: address UnsupportedEncodingException", e);
        } catch (Exception e) {
            logger.error("register service address to zookeeper exception:{}", e);
            throw new InvalidParamException("register service address to zookeeper exception:{}", e);
        }
    }
}
