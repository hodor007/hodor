package com.zp.basic.classload;

/**
 * @Auther: zhengpeng
 * @Date: 2019/3/26 16:51
 * @Description:
 */
public class SimpleB implements ISimpleA {

    public int add(int a, int b) {
        int result = 0;
        result = (a + b) * 2;
        return result;
    }
}