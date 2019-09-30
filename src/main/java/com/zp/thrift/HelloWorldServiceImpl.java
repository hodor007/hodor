/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.thrift;

import org.apache.thrift.TException;

/**
 * TODO: description
 * Date: 2019-09-05
 *
 * @author zhengpeng
 */
public class HelloWorldServiceImpl implements HelloWorldService.Iface {
    @Override
    public String sayHello(String username) throws TException {
        return username;
    }
}
