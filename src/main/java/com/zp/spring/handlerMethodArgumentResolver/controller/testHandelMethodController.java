/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.spring.handlerMethodArgumentResolver.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zp.spring.handlerMethodArgumentResolver.Entity.User;
import com.zp.spring.handlerMethodArgumentResolver.annotation.JsonParam;

/**
 * Description:
 * Date: 2019-01-11
 *
 * @author zhengpeng
 */
@RestController
public class testHandelMethodController {

    @RequestMapping("/login")
    public String login(@JsonParam(value = "userName") String userName, @JsonParam(value = "password") String password){
        System.out.println(userName+"==="+password);
        return "success";
    }

}
