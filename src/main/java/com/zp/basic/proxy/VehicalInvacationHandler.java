package com.zp.basic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author :  pengzheng
 * create at:  2021-03-15  21:27
 * @description:
 */
public class VehicalInvacationHandler implements InvocationHandler {

    private Car car;

    public VehicalInvacationHandler(Car car) {
        this.car = car;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---------before-------");
        car.play();
        System.out.println("---------after-------");
        return null;
    }
}