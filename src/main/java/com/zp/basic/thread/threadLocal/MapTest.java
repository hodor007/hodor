package com.zp.basic.thread.threadLocal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :  pengzheng
 * create at:  2020-05-17  18:43
 * @description:
 */
public class MapTest {

    public static Map<String, String> map = new HashMap<>();

    void put(String key, String value) {
        map.put(key, value);
    }

    void getAll(){
        System.out.println(map.size());
    }

    // static 公用
    public static void main(String[] args) {
        MapTest mapTest1 = new MapTest();
        MapTest mapTest2 = new MapTest();
        mapTest1.put("a","啊");
        mapTest2.put("b","吧");
        mapTest1.getAll();
    }

}