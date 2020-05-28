package com.zp.basic.thread.threadLocal;

/**
 * @author :  pengzheng
 * create at:  2020-05-21  13:59
 * @description:
 */
public class ThreadLocalLeakTest {
    static ThreadLocal<String> LOCAL = new ThreadLocal<String>();

    /**
     * Thread里的ThreadLocalMap里的threadLocal是弱引用，当前LOCAL是自己new出来的，是强引用，
     * 两个引用变量指向一个存在于内存中的ThreadLocal对象的实例，由于存在强引用，所以弱引用在gc时也不会回收对象，
     * 但当强引用变量指向内存中其他的对象实例时，或者置为null时，只存在弱引用的threadLocal，会在gc时被回收掉
     */
    public static void main(String[] args) {
        LOCAL.set("测试ThreadLocalMap弱引用自动回收");
        Thread thread = Thread.currentThread();
//        LOCAL = null;
        LOCAL = new ThreadLocal<String>();
        System.gc();
        System.out.println("");
    }
}