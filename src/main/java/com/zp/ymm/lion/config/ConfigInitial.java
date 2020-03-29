package com.zp.ymm.lion.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
//
//    private void setAttrValue(Field f, Config config, String value) {
//        if (value == null || "".equals(value.trim())) {
//            logger.warn(new StringBuilder("配置项").append(f.getName()).append("未配置").toString() );
//            return ;
//        }
//        Class<?> fieldType = f.getType();
//        try {
//            f.setAccessible(true);
//            if (fieldType == String.class) {
//                f.set(config, value);
//            } else if (fieldType == int.class || fieldType == Integer.class) {
//                f.set(config, Integer.valueOf(value));
//            } else if (fieldType == long.class || fieldType == Long.class) {
//                f.set(config, Long.valueOf(value));
//            } else if (fieldType == boolean.class || fieldType == Boolean.class) {
//                f.set(config, Boolean.valueOf(value));
//            } else if (fieldType == double.class || fieldType == Double.class) {
//                f.set(config, Double.valueOf(value));
//            } else if (fieldType == Date.class) {
//                f.set(config, convertToDate(f, value));
//            } else if (fieldType == short.class || fieldType == Short.class) {
//                f.set(config, Short.valueOf(value));
//            } else if (fieldType == float.class || fieldType == Float.class) {
//                f.set(config, Float.valueOf(value));
//            } else if (fieldType == byte.class || fieldType == Byte.class) {
//                f.set(config, Byte.valueOf(value));
//            } else if (fieldType == char.class || fieldType == Character.class) {
//                f.set(config, value.charAt(0));
//            } else if (fieldType == ClientVersionConfig.class){
//                f.set(config, JSONObject.parseObject(value, ClientVersionConfig.class));
//            }
//
//            // 根据注解解析Json对象
//            if (f.isAnnotationPresent(ConfigJson.class)) {
//                if("dealModelStrategyMap".equals(f.getName())) {
//                    Map<String,LineDealModelStrategy> parsedValue =   JSON.parseObject(value, new TypeReference<Map<String, LineDealModelStrategy>>(){});
//                    f.set(config, parsedValue);
//                }else if("competitiveDealModelStrategy".equals(f.getName())) {
//                    Map<String,LineDealModelStrategy> parsedValue =   JSON.parseObject(value, new TypeReference<Map<String, LineDealModelStrategy>>(){});
//                    f.set(config, parsedValue);
//                }else if("selectedCompetitiveRoutes".equals(f.getName())){
//                    List<LineModel> parsedValue = JSON.parseObject(value, new TypeReference<List<LineModel>>(){});
//                    f.set(config, parsedValue);
//                }else if("cargoCompetitiveRouteUserGrayRule".equals(f.getName())) {
//                    Map<String,String> parsedValue =   JSON.parseObject(value, new TypeReference<Map<String,String>>(){});
//                    f.set(config, parsedValue);
//                }else {
//                    Object parsedValue = JSON.parseObject(value, f.getType());
//                    f.set(config, parsedValue);
//                }
//            }
//        } catch (Exception e) {
//            logger.error(new StringBuilder("设置字段值出错，字段名：").append(f.getName()).toString(), e);
//        }
//    }

}