/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.mq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zp.spring.jsonComponent.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Date: 2019-01-08
 *
 * @author zhengpeng
 */
@RestController
@RequestMapping("/mq")
public class MqTestController {

    @Autowired
    private ProducerSimple producerSimple;


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String mqTest(User user) throws JsonProcessingException {
        this.producerSimple.sendSyncMsg("my-topic", "第一条同步消息");
        System.out.println("end...");
        return "mq";
    }

}
