package com.zp.ms;

public class Single {


    /**
     * volatile作用 首先要理解new Singleton()做了什么。new一个对象有几个步骤。
     * 1.看class对象是否加载，如果没有就先加载class对象，2.分配内存空间，初始化实例，
     * 3.调用构造函数，4.返回地址给引用。
     * 而cpu为了优化程序，可能会进行指令重排序，打乱这3，4这几个步骤，导致实例还没有被初始化，就被使用了。
     */

    private static volatile Single single;

    private Single() {
    }

    ;

    public static Single getInstance() {
        if (single == null) {
            synchronized (Single.class) {
                if (single == null) {
                    single = new Single();
                }
            }
        }
        return single;
    }

}
