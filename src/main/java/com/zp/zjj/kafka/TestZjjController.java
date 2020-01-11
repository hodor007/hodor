package com.zp.zjj.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestZjjController {

    @Autowired
    private ProductMsg productMsg;

    @RequestMapping(value = "/kafka",method = RequestMethod.GET)
    public String testHello() throws JsonProcessingException, InterruptedException {
        productMsg.sendMessage();
       return "success";
    }

}