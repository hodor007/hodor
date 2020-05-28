package com.zp.ymm.lion.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :  pengzheng
 * create at:  2020-02-26  17:40
 * @description:
 */
public class Test {

    public static void main(String[] args) throws IOException {
        String temp = null;
//        while (true) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            if (!ConstantTest.HODOR_NAME_VALUE.equals(temp)) {
//                temp = ConstantTest.HODOR_NAME_VALUE;
//                System.out.println(temp);
//            }
//
//        }
        List<String> list =new ArrayList<>();
        list.add("12");
        list.add("13");
        String jsons = JSON.toJSONString(list);
        list = JSONArray.parseArray(jsons,String.class);
        System.out.println("==" + jsons);
        list = new ObjectMapper().readValue(jsons, list.getClass());
//        Type type=list.getClass().getGenericSuperclass();
//        System.out.println(type);
////ParameterizedType参数化类型，即泛型
//        ParameterizedType p=(ParameterizedType)type;
////getActualTypeArguments获取参数化类型的数组，泛型可能有多个
//        Class c=(Class) p.getActualTypeArguments()[0];
        System.out.println(list.size());
    }

}