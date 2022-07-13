package com.zp.basic.thread.threadLocal;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :  pengzheng
 * create at:  2022-01-01  18:57
 * @description:
 */
public class LockTest {

    public static void main(String[] args) {
        new LockTest().locktWaitTest();
    }

    public void locktWaitTest(){
        Lock lock=new ReentrantLock();
        Condition condition=lock.newCondition();
        for(int i=0;i<10;i++)
        {
            Thread thread=new Thread(()->
            {
                lock.lock();
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            });
            thread.start();
        }
    }

}