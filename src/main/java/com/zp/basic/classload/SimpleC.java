package com.zp.basic.classload;

/**
 * @Auther: zhengpeng
 * @Date: 2019/4/5 19:03
 * @Description:
 */
public class SimpleC implements ISimpleA {

    public int add(int a, int b) {
        int result = 0;
        result = (a + b) * 3;
        return result;
    }
}
