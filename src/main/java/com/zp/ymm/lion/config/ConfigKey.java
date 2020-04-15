package com.zp.ymm.lion.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author :  pengzheng
 * create at:  2020-03-26  20:44
 * @description:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfigKey {
    String value() default "";

    boolean json() default false;

    String methodName() default "";
}