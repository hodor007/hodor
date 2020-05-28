package com.zp.basic.thread.threadLocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author :  pengzheng
 * create at:  2020-05-17  14:19
 * @description:
 */
public class TtlTest {

    static TransmittableThreadLocal<String> parent = new TransmittableThreadLocal<String>();
    static TransmittableThreadLocal<String> parent2 = new TransmittableThreadLocal<String>();

    public static void main(String[] args) throws InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        parent.set("parent value");
//
//        Runnable task = new Task();
//// 额外的处理，生成修饰了的对象ttlRunnable
//        Runnable ttlRunnable = TtlRunnable.get(task);
//        parent.set("update parent value");
//        parent2.set("2 parent value");
//        executorService.submit(ttlRunnable);
//        TimeUnit.SECONDS.sleep(1);
////        executorService.submit(ttlRunnable);
////        TimeUnit.SECONDS.sleep(1);
//        executorService.submit(TtlRunnable.get(task));
//        TimeUnit.SECONDS.sleep(1);
//        String value = parent.get();
//        System.out.println("out value: " + value);
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        parent.set("parent value");
        Runnable task = new Task();
// 额外的处理，生成修饰了的对象ttlRunnable
//        Runnable ttlRunnable = TtlRunnable.get(task);
        executorService.submit(TtlRunnable.get(task));
        TimeUnit.SECONDS.sleep(1);
//        parent.set("parentAAA value");
        executorService.submit(TtlRunnable.get(task));
        TimeUnit.SECONDS.sleep(1);
// Task中可以读取, 值是"parent value"
        String value = parent.get();
        System.out.println("out value: " + value);
    }

    /**
     * Runnable task = new Task(); 这并没有创建线程
     * thread run和start区别
     * 1） start：
     * 　　用start方法来启动线程，真正实现了多线程运行，这时无需等待run方法体代码执行完毕而直接继续执行下面的代码。通过调用Thread类的start()方法来启动一个线程，这时此线程处于就绪（可运行）状态，并没有运行，一旦得到cpu时间片，就开始执行run()方法，这里方法 run()称为线程体，它包含了要执行的这个线程的内容，Run方法运行结束，此线程随即终止。
     * 2） run：
     * 　　run()方法只是类的一个普通方法而已，如果直接调用Run方法，程序中依然只有主线程这一个线程，其程序执行路径还是只有一条，还是要顺序执行，还是要等待run方法体执行完毕后才可继续执行下面的代码，这样就没有达到写线程的目的。总结：调用start方法方可启动线程，而run方法只是thread的一个普通方法调用，还是在主线程里执行。这两个方法应该都比较熟悉，
     *      把需要并行处理的代码放在run()方法中，start()方法启动线程将自动调用 run()方法，
     *      这是由jvm的内存机制规定的。并且run()方法必须是public访问权限，返回值类型为void。
     */
    public static class Task implements Runnable {

        @Override
        public void run() {
//            System.out.println(parent2.get());
            System.out.println("=======");
            String value1 = parent.get();
            System.out.println("in value1: " + value1);
            parent.set("child value");
            String value2 = parent.get();
//            System.out.println("in value2" + value2);
        }
    }
}