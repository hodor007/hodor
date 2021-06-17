package com.zp.test;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :  pengzheng
 * create at:  2020-10-14  15:00
 * @description:
 */
public class Test {

    public static void main(String[] args) {
//        TestA testA = new TestB();
//        testA.test();
//        TestB testB = new TestB();
//        testB.test();
        Map<String,Entity> maps = new HashMap<>();
        maps.put("A",new Entity("好的","good"));
        maps.put("B",new Entity("坏的","bad"));
        System.out.println(JSON.toJSONString(maps));
        Map<String,Entity> maps2 = JSON.parseObject(JSON.toJSONString(maps),Map.class);
        System.out.println(maps2.get("A"));

    }

}