/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    public String testHello() throws JsonProcessingException {
        return   objectMapper.writeValueAsString(Color.ALICEBLUE);
    }

}
