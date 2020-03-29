package com.zp.ymm.lion.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author :  pengzheng
 * create at:  2020-03-29  10:50
 * @description:
 */
@Component
public class ConfigInitial implements ConfigInitialService, ApplicationContextAware, InitializingBean {

    private static ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    @Override
    public void init() {
        // 获取所有config类 以及含有config属性的

        // 初始化

        // 添加监听


    }

//    private void initJobHandlerRepository(ApplicationContext applicationContext) {
//        if (applicationContext == null) {
//            return;
//        }
//
//        // init job handler action
//        Map<String, Object> serviceBeanMap = applicationContext.getBeansWithAnnotation(JobHandler.class);
//
//        if (serviceBeanMap != null && serviceBeanMap.size() > 0) {
//            for (Object serviceBean : serviceBeanMap.values()) {
//                if (serviceBean instanceof IJobHandler) {
//                    String name = serviceBean.getClass().getAnnotation(JobHandler.class).value();
//                    IJobHandler handler = (IJobHandler) serviceBean;
//                    if (loadJobHandler(name) != null) {
//                        throw new RuntimeException("xxl-job jobhandler[" + name + "] naming conflicts.");
//                    }
//                    registJobHandler(name, handler);
//                }
//            }
//        }
//    }

//    Field[] fields = config.getClass().getDeclaredFields();
//    String value;
//        for (Field f : fields) {
//        if (!f.isAnnotationPresent(ConfigIgnored.class)) {
//            value = getLionValue(f);
//            setAttrValue(f, config, value);
//        }
//    }

}