package com.zp.ymm.lion.test;

import com.zp.ymm.lion.config.ConfigInitial;
import com.zp.ymm.lion.config.ConfigKey;

public class ConstantTestAnnotion {

    private static final String HODOR_NAME_KEY = "HODOR_NAME";

    @ConfigKey(HODOR_NAME_KEY)
    public static String HODOR_NAME_VALUE;

    public static int HODOR;

    static {
        // 初始化也可以利用注解的方式，在类上加个注解 方正静态方法 还是可以类.属性的形式引用
        ConfigInitial.getInstance()
                .setMethod(HODOR_NAME_KEY, ConstantTestAnnotion::setHodor)
                .initConfig(ConstantTestAnnotion.class);
    }

    public static void setHodor() {
        HODOR = HODOR_NAME_VALUE.length();
    }

}
