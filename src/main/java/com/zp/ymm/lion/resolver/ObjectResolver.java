package com.zp.ymm.lion.resolver;

import com.alibaba.fastjson.JSON;
import com.zp.ymm.lion.config.ConfigKey;

import java.lang.reflect.Field;

/**
 * @author :  pengzheng
 * create at:  2020-04-14  11:13
 * @description:
 */
public class ObjectResolver implements FieldValueResolver {
    @Override
    public boolean support(Field field) {
        return field.getAnnotation(ConfigKey.class).json();
    }

    @Override
    public Object resolve(String value, Field field) throws Exception {
        return JSON.parseObject(value, field.getType());
    }
}