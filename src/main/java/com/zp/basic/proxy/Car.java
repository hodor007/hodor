package com.zp.basic.proxy;

/**
 * @author :  pengzheng
 * create at:  2021-03-15  21:26
 * @description:
 */
public class Car<T> {
    private Class<T> serviceInterface;

    public Car(Class<T> serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

    public void play() {
        System.out.println("play car");
    }
}