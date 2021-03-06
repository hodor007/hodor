package com.zp.ymm.lion.test;

import com.zp.ymm.lion.config.ConfigInitial;
import com.zp.ymm.lion.config.ConfigKey;

public class ConstantTestAnnotion {

    private static final String HODOR_NAME_KEY = "HODOR_NAME";

    @ConfigKey(value = HODOR_NAME_KEY, methodName = "setHodor")
    public static String HODOR_NAME_VALUE;

    public static int HODOR;

    static {
        // 公司的做法不同，可参考 SpringLionConfig
        // jdk1.8后static信息存在heap中 不用担心方法区溢出（1.8后不存在方法区）
        // 初始化也可以利用注解的方式，在类上加个注解 方正静态方法 还是可以类.属性的形式引用
        // 也可以不用setMethod的方式，通过注解传递method的名字，然后利用反射区执行方法
        ConfigInitial.getInstance()
//                .setMethod(HODOR_NAME_KEY, ConstantTestAnnotion::setHodor)
                .initConfig(ConstantTestAnnotion.class);
    }

    private static void setHodor() {
        HODOR = HODOR_NAME_VALUE.length();
    }

}
