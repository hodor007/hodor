package com.zp.basic.thread.threadLocal;

/**
 * @Auther: zhengpeng
 * @Date: 2019/5/16 11:06
 * @Description:
 */
public class ThreadLocalTest1 {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static String getThreadLocal() {
        return threadLocal.get();
    }

    public static void setThreadLocal(String info) {
        threadLocal.set(info);
    }
}
