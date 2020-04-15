package com.zp.ymm.lion.config;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zp.ymm.lion.ConfigCache;
import com.zp.ymm.lion.resolver.FieldValueResolver;
import com.zp.ymm.lion.resolver.IntegerResolver;
import com.zp.ymm.lion.resolver.StringResolver;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;

/**
 * @author :  pengzheng
 * create at:  2020-03-29  10:50
 * @description:
 */
public class ConfigInitial implements ConfigInitialService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigInitial.class);

    private ConfigInitial() {
    }

    ;

    private static volatile ConfigInitial configInitial;

    private Map<String, SetConfigValueMethod> methodMap = Maps.newHashMap();

    private static List<FieldValueResolver> valueResolver;

    public static ConfigInitial getInstance() {
        if (configInitial == null) {
            synchronized (ConfigInitial.class) {
                if (configInitial == null) {
                    configInitial = new ConfigInitial();
                }
            }
        }
        return configInitial;
    }

    static {
        valueResolver = Lists.newArrayList();
        valueResolver.add(new StringResolver());
        valueResolver.add(new IntegerResolver());
    }

    @Override
    public ConfigInitial initConfig(Class t) {
        // 初始化
        setConfigValue(t);
        // 添加监听
        addConfigListener(t);

        return getInstance();
    }

    private void setConfigValue(Class t) {
        Field[] fields = t.getDeclaredFields();
        String value;
        for (Field f : fields) {
            if (f.isAnnotationPresent(ConfigKey.class)) {
                String key = f.getAnnotation(ConfigKey.class).value();
                value = getLionValue(key, f);
                setAttrValue(t,f, key, value);
            }
        }

    }

    private void addConfigListener(Class t) {
        ConfigCache.getInstance().addChange(((key, value) -> {
            Field[] fields = t.getDeclaredFields();
            for (Field f : fields) {
                ConfigKey configKey = f.getAnnotation(ConfigKey.class);
                if (configKey != null && configKey.value().equals(key)) {
                    setAttrValue(t, f, key, value);
                }
            }
        }));
    }

    private void setAttrValue(Class t, Field f, String key, String value) {
        if (StringUtils.isEmpty(value)) {
            LOGGER.warn("配置项" + f.getName() + "未配置");
            return;
        }
        if (!Modifier.isStatic(f.getModifiers())) {
            return;
        }
//        Class<?> fieldType = f.getType();
        try {
            f.setAccessible(true);
//            if (fieldType == String.class) {
//                f.set(null, value);
//            } else if (fieldType == int.class || fieldType == Integer.class) {
//                f.set(null, Integer.valueOf(value));
//            } else if (fieldType == long.class || fieldType == Long.class) {
//                f.set(null, Long.valueOf(value));
//            } else if (fieldType == boolean.class || fieldType == Boolean.class) {
//                f.set(null, Boolean.valueOf(value));
//            } else if (fieldType == double.class || fieldType == Double.class) {
//                f.set(null, Double.valueOf(value));
//            } else if (fieldType == Date.class) {
//                f.set(null, convertToDate(f, value));
//            } else if (fieldType == short.class || fieldType == Short.class) {
//                f.set(null, Short.valueOf(value));
//            } else if (fieldType == float.class || fieldType == Float.class) {
//                f.set(null, Float.valueOf(value));
//            } else if (fieldType == byte.class || fieldType == Byte.class) {
//                f.set(null, Byte.valueOf(value));
//            } else if (fieldType == char.class || fieldType == Character.class) {
//                f.set(null, value.charAt(0));
//            } else {
//                f.set(null, value);
//            }
            Object val = null;
            for (FieldValueResolver fieldValueResolver : valueResolver) {
                if (fieldValueResolver.support(f)) {
                    val = fieldValueResolver.resolve(value, f);
                    break;
                }
            }
            f.set(null, val);
            String method = f.getAnnotation(ConfigKey.class).methodName();
            if (StringUtils.isNotEmpty(method)) {
              Method m = t.getDeclaredMethod(method);
              m.setAccessible(true);
              m.invoke(null);
            }
//            SetConfigValueMethod method = methodMap.get(key);
//            if (method != null) {
//                method.setConfigValueMethod();
//            }
        } catch (Exception e) {
            LOGGER.warn("lion配置赋值异常", e);
        }
    }


    private Object convertToDate(Field f, String value) {
        return null;
    }

    private String getLionValue(String key, Field f) {
        return ConfigCache.getInstance().getNodeVlue(key);
    }

    public ConfigInitial setMethod(String key, SetConfigValueMethod method) {
        methodMap.put(key, method);
        return getInstance();
    }

    public void setValueResolver(FieldValueResolver fieldValueResolver) {
        valueResolver.add(fieldValueResolver);
    }


}