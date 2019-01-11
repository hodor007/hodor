/**
 * Copyright (C) 2006-2019 Tuniu All rights reserved
 */
package com.zp.spring.handlerMethodArgumentResolver.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description:
 * Date: 2019-01-11
 *
 * @author zhengpeng
 */

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonParam {

    String value() default "";

    String name() default "";

    boolean required() default true;

    String defaultValue() default "";
}
