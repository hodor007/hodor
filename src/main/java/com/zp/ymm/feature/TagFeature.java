package com.zp.ymm.feature;

import java.util.HashSet;

/**
 * @author :  pengzheng
 * create at:  2020-05-10  20:07
 * @description:
 */
public class TagFeature extends AbstractFeature<HashSet<String>> {


    public static final String FEATURE_NAME = "tags";

    @Override
    public String getName() {
        return FEATURE_NAME;
    }

}