package com.zp.ymm.feature;

import java.util.HashSet;

/**
 * @author :  pengzheng
 * create at:  2020-05-10  20:18
 * @description:
 */
public class Test {

    public static void main(String[] args) {
        FeatureSet featureSet = new FeatureSet();
        TagFeature tagFeature = featureSet.get(TagFeature.FEATURE_NAME);
        if (tagFeature.getValue() == null) {
            tagFeature.setValue(new HashSet<>());
        }
        tagFeature.getValue().add("10");
        System.out.println(tagFeature.getValue().toString());
        System.out.println(String.join("@",tagFeature.getName(),"hhh"));
    }

}