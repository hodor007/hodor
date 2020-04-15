package com.zp.ymm.lion.resolver;

import java.lang.reflect.Field;

/**
 * @author :  pengzheng
 * create at:  2020-04-14  11:03
 * @description:
 */
public class IntegerResolver implements FieldValueResolver {
    @Override
    public boolean support(Field field) {
        return this.support(field.getType());
    }

    @Override
    public Object resolve(String value, Field field) throws Exception {
        return Integer.valueOf(value);
    }

    public boolean support(Class<?> type) {
        return type == int.class || type == Integer.class;
    }
}