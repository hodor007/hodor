/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zp.spring.jsonComponent.entity.User;

import javafx.scene.paint.Color;

/**
 * Description:
 * Date: 2019-01-08
 *
 * @author zhengpeng
 */
@RestController
@RequestMapping("/hello")
public class testController {

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(value = "/world",method = RequestMethod.GET)
    public String testHello(User user) throws JsonProcessingException {
        System.out.println(user);
        return   objectMapper.writeValueAsString(Color.ALICEBLUE);
    }

}
