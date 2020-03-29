package com.zp.ymm.lion.test;

import com.zp.ymm.lion.config.ConfigInitial;
import com.zp.ymm.lion.config.ConfigKey;

public class ConstantTestAnnotion {

    private static final String HODOR_NAME_KEY = "HODOR_NAME";

    @ConfigKey(HODOR_NAME_KEY)
    public static String HODOR_NAME_VALUE;

    public static int HODOR;

    static {
        ConfigInitial.getInstance()
                .setMethod(HODOR_NAME_KEY, ConstantTestAnnotion::setHodor)
                .initConfig(ConstantTestAnnotion.class);
    }

    public static void setHodor() {
        HODOR = HODOR_NAME_VALUE.length();
    }

}
