package com.zp.ymm.lion.test;

import com.zp.ymm.lion.config.ConfigInitial;
import com.zp.ymm.lion.config.ConfigKey;

public class ConstantTestAnnotion {

    private static final String HODOR_NAME_KEY = "HODOR_NAME";

    @ConfigKey(HODOR_NAME_KEY)
    private static String HODOR_NAME_VALUE;

    private static int HODOR;

    static {
        ConfigInitial.getInstance().initConfig(ConstantTestAnnotion.class)
                .setMethod(HODOR_NAME_KEY, ConstantTestAnnotion::setHodor);
    }

    public static void setHodor() {
        HODOR = HODOR_NAME_VALUE.length();
    }

}
