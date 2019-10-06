/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.thrift;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

/**
 * TODO: description
 * Date: 2019-09-05
 *
 * @author zhengpeng
 */
@Service
public class HelloWorldServiceImpl implements HelloWorldService.Iface {
    @Override
    public String sayHello(String username) throws TException {
        return username;
    }
}
