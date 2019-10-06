/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.thrift.thriftZookeeper.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zp.thrift.HelloWorldService;
import com.zp.thrift.thriftZookeeper.zkclient.ThriftServiceClientProxyFactory;


/**
 * TODO: description
 * Date: 2019-10-06
 *
 * @author zhengpeng
 */
@RestController()
public class TestThriftController {


    @Autowired
    private ThriftServiceClientProxyFactory thriftServiceClientProxyFactory;

    @RequestMapping("/thrift")
    public String thrift() throws Exception {
        HelloWorldService.Iface helloWorldService = (HelloWorldService.Iface) thriftServiceClientProxyFactory.getObject();
        System.out.println(helloWorldService.sayHello("hodor"));
        return "success";
    }

}
