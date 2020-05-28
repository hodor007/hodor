package com.zp.ymm.feature;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :  pengzheng
 * create at:  2020-05-10  20:03
 * @description:
 */
public class FeatureSet {

    /**
     * 所有特性对象
     */
    private static Map<String, AbstractFeature<?>> featuresMap = new HashMap<>();

    static {
        TagFeature tagFeature = new TagFeature();
        featuresMap.put(tagFeature.getName(), tagFeature);
    }

    public <F extends AbstractFeature<?>> F get(String featureType) {
        return (F) featuresMap.get(featureType);
    }

}