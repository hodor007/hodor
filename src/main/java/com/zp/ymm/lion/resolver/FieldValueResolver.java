package com.zp.ymm.lion.resolver;

import java.lang.reflect.Field;

public interface FieldValueResolver {

    /**
     * 是否支持
     *
     * @param field 字段
     * @return 是否支持
     */
    boolean support(Field field);

    /**
     * 解析
     *
     * @param value 配置
     * @param field 字段
     * @return 目标数据
     */
    Object resolve(String value, Field field) throws Exception;


}
