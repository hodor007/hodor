package com.zp.ymm.lion.test;

import com.zp.ymm.lion.ConfigCache;

/**
 * @author :  pengzheng
 * create at:  2020-02-26  17:14
 * @description:
 */
public class ConstantTest {

    private static ConfigCache configCache = ConfigCache.getInstance();

    private static final String HODOR_NAME_KEY = "HODOR_NAME";

    public static String HODOR_NAME_VALUE = configCache.getNodeVlue(HODOR_NAME_KEY);

    static {
        configCache.addChange(((key, value) -> {
            if (key.equals(HODOR_NAME_KEY)) {
                HODOR_NAME_VALUE = value;
            }
        }));
    }

}