/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.controller;

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
@RequestMapping("/hello")
public class testController {

    @RequestMapping(value = "/world",method = RequestMethod.GET)
    public String testHello() {
        return "helloWorld";
    }

    @RequestMapping(value = "/haha",method = RequestMethod.GET)
    public String testHaHa() {
        return "haha";
    }
}
