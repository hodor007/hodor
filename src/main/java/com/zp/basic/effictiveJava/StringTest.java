package com.zp.basic.effictiveJava;

import static com.sun.javafx.sg.prism.NGCanvas.LINE_WIDTH;

/**
 * @author :  pengzheng
 * create at:  2020-06-08  20:32
 * @description:  String类本身是final类型，字符串拼接时，会使用StringBuffer，并调用append，之后再调用toString方法。
 * 而StringBuffer转换成String时，开销相当大。中间不仅创立了临时对象StringBuffer，还每次完后再要转成String
 * effective java 63
 */
public class StringTest {

    public static String statement1() {
        String result = "";
        for (int i = 0; i < 1000; i++)
            result += i; // String concatenation
        return result;
    }

    public static String statement2() {
        StringBuilder b = new StringBuilder(1000 * LINE_WIDTH);
        for (int i = 0; i < 1000; i++)
            b.append(i);
        return b.toString();
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); //获取开始时间
        statement1(); //测试的代码段
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }

}