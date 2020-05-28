package com.zp.ymm.feature;

/**
 * @author :  pengzheng
 * create at:  2020-05-10  20:14
 * @description:
 */
public abstract class AbstractFeature<M> {

    // 反序列化值
    private M value;

    abstract String getName()
            ;

    public M getValue() {
        return value;
    }

    public void setValue(M value) {
        this.value = value;
    }
}