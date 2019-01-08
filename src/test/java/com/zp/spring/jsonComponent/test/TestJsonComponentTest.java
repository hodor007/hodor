/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.spring.jsonComponent.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.scene.paint.Color;

/**
 * Description:
 * Date: 2019-01-08
 *
 * @author zhengpeng
 */
@JsonTest
@RunWith(SpringRunner.class)
public class TestJsonComponentTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSerialization() throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(Color.ALICEBLUE);
        System.out.println(json);
    }
}
