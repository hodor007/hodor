package com.zp.test;

/**
 * @author :  pengzheng
 * create at:  2020-10-20  10:29
 * @description:
 */
public class Entity {
    // 常量
    public static final Integer MODEL_NAME = 1024;

    // 静态变量
    public static int nums = 100;

    // 属性值
    private String name;

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Entity(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public Entity(String name) {
        this.name = name;
    }

    public static Integer getModelName() {
        return MODEL_NAME;
    }

    public static int getNums() {
        return nums;
    }

    public static void setNums(int nums) {
        Entity.nums = nums;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}