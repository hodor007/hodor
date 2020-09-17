package com.zp.ymm.featureModel;

import java.lang.reflect.ParameterizedType;

/**
 * @author :  pengzheng
 * create at:  2020-07-14  11:30
 * @description:
 */
public abstract class AbstractModelFeature<T> {

    private Class<T> clazz;

    public  T getModelFeature() {

        if (clazz == null) {
            ParameterizedType ptype = (ParameterizedType) this.getClass().getGenericSuperclass();
            clazz = (Class<T>) ptype.getActualTypeArguments()[0];
        }
       return null;
    }

}