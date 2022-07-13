package com.zp.basic.map;

import java.util.HashMap;

/**
 * @author :  pengzheng
 * create at:  2021-07-10  13:49
 * @description:
 */
public class HashMapTest {

    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap();
        map.put("hodor1",1);
        map.put("hodor2",2);
        map.put("hodor3",3);
        map.put("hodor4",4);
        map.put("hodor5",5);
        map.put("hodor6",6);
        map.put("hodor7",7);
        map.put("hodor8",8);

        map.put("heihei1",1);
        map.put("heihei2",2);
        map.put("heihei3",3);
        map.put("heihei4",4);
        map.put("heihei5",5);
        map.put("heihei6",6);
        map.put("heihei7",7);
        map.put("heihei8",8);
        System.out.println(map.size());
    }

}