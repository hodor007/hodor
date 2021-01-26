package com.zp.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  pengzheng
 * create at:  2021-01-26  16:34
 * @description:
 *
 * jprofiler分析dump https://blog.csdn.net/axin1240101543/article/details/105142141
 */
public class Memory {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        // 创建n个1M大小的数组，耗尽内存
        for (int i = 0; i < 10000; i++) {
            list.add(new byte[1024 * 1024]);
        }
    }

}