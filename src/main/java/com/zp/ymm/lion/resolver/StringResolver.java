package com.zp.ymm.lion.resolver;


import java.lang.reflect.Field;

/**
 * @author :  pengzheng
 * create at:  2020-04-14  10:57
 * @description:
 */
public class StringResolver implements FieldValueResolver {
    @Override
    public boolean support(Field field) {
        return this.support(field.getType());
    }

    @Override
    public Object resolve(String value, Field field) throws Exception {
        return value;
    }

    public boolean support(Class<?> type) {
        return String.class == type;
    }
}