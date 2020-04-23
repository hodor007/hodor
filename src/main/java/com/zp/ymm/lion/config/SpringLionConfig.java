/**
 * 公司利用spring对象维护lion的属性
 * 1.BeanPostProcessor  在每个bean初始化时被lion注解修饰的字段和字段所在对象加入map中
 * 2.ApplicationListener<ContextRefreshedEvent>  在所有bean初始化完成后回调，添加lion监听，
 * 每次lion发生变化，从之前的map中取出field，然后重新给对象的属性赋值
 *
 * 我觉得也可以给lion类自定义一个注解，并注入到spring中，利用applicationContext取出所有被注解修饰的类，然后对这些类以及他们的字段进行操作
 * 不过也得存个被lion注解修饰的字段和字段所在对象map，每次lion变更，根据key取出对象然后利用反射给对象赋值
 */



//package com.zp.ymm.lion.config;
//
//import com.google.common.collect.Sets;
//import com.zp.ymm.lion.ConfigCache;
//import com.zp.ymm.lion.ConfigChange;
//import com.zp.ymm.lion.resolver.IntegerResolver;
//import com.zp.ymm.lion.resolver.ObjectResolver;
//import com.zp.ymm.lion.resolver.StringResolver;
//import org.slf4j.Logger;
//import org.springframework.aop.TargetClassAware;
//import org.springframework.aop.support.AopUtils;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.BeanNameAware;
//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.util.ClassUtils;
//import org.springframework.util.CollectionUtils;
//import org.springframework.util.ReflectionUtils;
//import org.springframework.util.StringUtils;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//import java.lang.reflect.Modifier;
//import java.util.*;
//
///**
// * @author :  pengzheng
// * create at:  2020-04-23  13:58
// * @description:
// */
//public class SpringLionConfig implements BeanNameAware, DisposableBean, BeanPostProcessor, ApplicationListener<ContextRefreshedEvent> {
//
//    private static final Logger LOGGER = LionLogUtil.getLogger(SpringLionConfig.class);
//
//    public static final String SPRING_LION_CONFIG_BEAN_NAME = "springLionConfig";
//
//    private static List<ValueResolver> valueResolvers;
//
//    static {
//        List<ValueResolver> defaultValueResolvers = new ArrayList<>(14);
//        defaultValueResolvers.add(new StringResolver());
//        defaultValueResolvers.add(new IntegerResolver());
//        defaultValueResolvers.add(new LongResolver());
//        defaultValueResolvers.add(new BooleanResolver());
//        defaultValueResolvers.add(new DoubleResolver());
//        defaultValueResolvers.add(new FloatResolver());
//        defaultValueResolvers.add(new ShortResolver());
//        defaultValueResolvers.add(new ByteResolver());
//        defaultValueResolvers.add(new CharResolver());
//        defaultValueResolvers.add(new DateResolver());
//
//        if (ClassUtils.isPresent("com.fasterxml.jackson.databind.ObjectMapper", Thread.currentThread().getContextClassLoader())) {
//            defaultValueResolvers.add(new ArrayResolver());
//            defaultValueResolvers.add(new CollectionResolver());
//            defaultValueResolvers.add(new MapResolver());
//            defaultValueResolvers.add(new ObjectResolver());
//        }
//
//        valueResolvers = new ArrayList<>();
//        valueResolvers.addAll(defaultValueResolvers);
//
//        Iterator<ValueResolver> iterator = ServiceLoader.load(ValueResolver.class).iterator();
//
//        List<Class<?>> defaultValueResolverClass = new ArrayList<>(defaultValueResolvers.size());
//        for (ValueResolver resolver : defaultValueResolvers) {
//            defaultValueResolverClass.add(resolver.getClass());
//        }
//
//        while (iterator.hasNext()) {
//            ValueResolver next = iterator.next();
//            int indexOf = defaultValueResolverClass.indexOf(next.getClass());
//            if (indexOf == -1) {
//                valueResolvers.add(0, next);
//                LOGGER.info("add customized valueResolver {} success", next.getClass().getName());
//            }
//        }
//    }
//
//    private Map<String, Set<ConfigMetaData>> configDataCache = new HashMap<>();
//
//    private String beanName;
//
//    private ConfigCache configCache = ConfigCache.getInstance();
//
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        if (!this.beanName.equals(beanName)) {
//            findConfigData(bean, beanName);
//        }
//        return bean;
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        return bean;
//    }
//
//    @Override
//    public void setBeanName(String name) {
//        this.beanName = name;
//    }
//
//    private Map<String, Set<ConfigMetaData>> getConfigDataCache() {
//        return this.configDataCache;
//    }
//
//    private void findConfigData(final Object bean, final String beanName) {
//        final Map<String, Set<ConfigMetaData>> result = getConfigDataCache();
//        final Map<String, Set<ConfigMetaData>> current = new HashMap<>();
//
//        //如果是aop代理
//        Class proxyClass = bean.getClass();
//        if (isProxy(bean)) {
//            proxyClass = getTargetClass(bean);
//        }
//        final Class targetClass = proxyClass;
//        final String targetClassName = targetClass.getName();
//
//        // field
//        ReflectionUtils.doWithFields(targetClass, new ReflectionUtils.FieldCallback() {
//                    @Override
//                    public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
//
//                        if (field.getModifiers() == Modifier.FINAL) {
//                            LOGGER.error("[Field] field is final, can not use, {}.{}", new Object[]{targetClassName, field.getName()});
//                            return;
//                        }
//                        ConfigKey configKey = field.getAnnotation(ConfigKey.class);
//                        String key = configKey.value();
//                        if (StringUtils.isEmpty(key)) {
//                            LOGGER.warn("[Field] config key is null, {}.{}", new Object[]{targetClassName, field.getName()});
//                        } else {
//                            boolean needChange = configKey.needChange();
//                            if (!needChange) {
//                                LOGGER.warn("[Field] config key: {} at {}.{} is not need change.", new Object[]{key, targetClassName, field.getName()});
//                            }
//
//                            ConfigMetaData configMetaData = new ConfigMetaData(bean, beanName, field, true, needChange);
//
//                            final Set<ConfigMetaData> allConfigMetaDataSet = result.get(key);
//                            if (!CollectionUtils.isEmpty(allConfigMetaDataSet)) {
//                                allConfigMetaDataSet.add(configMetaData);
//                                result.put(key, allConfigMetaDataSet);
//                            } else {
//                                result.put(key, Sets.newHashSet(configMetaData));
//                            }
//
//                            final Set<ConfigMetaData> currentMetaDataSet = current.get(key);
//                            if (!CollectionUtils.isEmpty(currentMetaDataSet)) {
//                                currentMetaDataSet.add(configMetaData);
//                                current.put(key, currentMetaDataSet);
//                            } else {
//                                current.put(key, Sets.newHashSet(configMetaData));
//                            }
//                        }
//                    }
//                },
//                new ReflectionUtils.FieldFilter() {
//                    @Override
//                    public boolean matches(Field field) {
//                        return field.isAnnotationPresent(ConfigKey.class);
//                    }
//                });
//
//        // method
//        ReflectionUtils.doWithMethods(targetClass, new ReflectionUtils.MethodCallback() {
//            @Override
//            public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {
//                if (method.getParameterTypes().length != 1) {
//                    LOGGER.error("[Method] parameter count must be 1, but this method has {} parameters,{}.{}", new Object[]{method.getParameterTypes().length, targetClassName, method.getName()});
//                    return;
//                }
//
//                ConfigKey configKey = method.getAnnotation(ConfigKey.class);
//                String key = configKey.value();
//                if (StringUtils.isEmpty(key)) {
//                    LOGGER.warn("[Method] key is null,{}.{}", new Object[]{targetClassName, method.getName()});
//                } else {
//                    boolean needChange = configKey.needChange();
//                    if (!needChange) {
//                        LOGGER.warn("[Method] key: {} at {}.{} is not need change.", new Object[]{key, targetClassName, method.getName()});
//                    }
//
//                    ConfigMetaData configMetaData = new ConfigMetaData(bean, beanName, method, false, needChange);
//
//                    final Set<ConfigMetaData> allConfigMetaDataSet = result.get(key);
//                    if (!CollectionUtils.isEmpty(allConfigMetaDataSet)) {
//                        allConfigMetaDataSet.add(configMetaData);
//                        result.put(key, allConfigMetaDataSet);
//                    } else {
//                        result.put(key, Sets.newHashSet(configMetaData));
//                    }
//
//                    final Set<ConfigMetaData> currentConfigMetaDataSet = current.get(key);
//                    if (!CollectionUtils.isEmpty(currentConfigMetaDataSet)) {
//                        currentConfigMetaDataSet.add(configMetaData);
//                        current.put(key, currentConfigMetaDataSet);
//                    } else {
//                        current.put(key, Sets.newHashSet(configMetaData));
//                    }
//                }
//            }
//        }, new ReflectionUtils.MethodFilter() {
//            @Override
//            public boolean matches(Method method) {
//                return method.isAnnotationPresent(ConfigKey.class);
//            }
//        });
//
//        if (!CollectionUtils.isEmpty(current)) {
//            // init
//            for (Map.Entry<String, Set<ConfigMetaData>> entry : current.entrySet()) {
//                String key = entry.getKey();
//                Set<ConfigMetaData> configMetaDatas = entry.getValue();
//
//                for (ConfigMetaData configMetaData : configMetaDatas) {
//                    Object object = configMetaData.getBean();
//                    Object member = configMetaData.getMember();
//
//                    if (configMetaData.isField()) {
//                        setFieldVal(object, (Field) member, key);
//                    } else {
//                        invokeMethod(object, (Method) member, key);
//                    }
//
//                }
//            }
//        }
//    }
//
//    private void invokeMethod(Object target, Method method, String key) {
//        String value = configCache.getProperty(key);
//        invokeMethod(target, method, key, value, false, true);
//    }
//
//    private void invokeMethod(Object target, Method method, String key, String value, boolean log, boolean shouldThrow) {
//        String targetClassName = target.getClass().getName();
//        if (isProxy(target)) {
//            targetClassName = getTargetClass(target).getName();
//        }
//
//        String displayValue = Utils.forDisplayLionConfig(key, value, true);
//        if (value == null) {
//            LOGGER.warn("[Method] key:{},value is null,{}.{}", new Object[]{key, targetClassName, method.getName()});
//            if (method.getAnnotation(ConfigKey.class).required()) {
//                throw new RuntimeException(String.format("[Method] key:%s, value is required, but value is null in %s.%s", key, targetClassName, method.getName()));
//            }
//        } else {
//            ValueResolver targetValueResolver = null;
//            for (ValueResolver valueResolver : valueResolvers) {
//                if (valueResolver.support(method)) {
//                    targetValueResolver = valueResolver;
//                    break;
//                }
//            }
//            if (targetValueResolver == null) {
//                throw new UnsupportedOperationException(String.format("[Method] %s is not support,key:%s,%s.%s", method.getParameterTypes()[0], key, targetClassName, method.getName()));
//            }
//
//            try {
//                final Object val = targetValueResolver.resolve(value, method);
//                method.setAccessible(true);
//                method.invoke(target, val);
//                if (log) {
//                    LOGGER.info("[Method] invoke method success,method:[{}.{}],value:[{}]", new Object[]{targetClassName, method.getName(), displayValue});
//                }
//            } catch (Exception e) {
//                if (shouldThrow) {
//                    throw new RuntimeException(String.format("[Method] invoke method fail,key:%s,value:%s,%s.%s", key, displayValue, targetClassName, method.getName()), e);
//                }
//                LOGGER.error("[Method] invoke method fail,key:{},value:{},{}.{}", new Object[]{key, displayValue, targetClassName, method.getName()}, e);
//            }
//        }
//    }
//
//    private void setFieldVal(Object target, Field field, String key) {
//        String value = configCache.getProperty(key);
//        setFieldVal(target, field, key, value, false, true);
//    }
//
//    private void setFieldVal(Object target, Field field, String key, String value, boolean log, boolean shouldThrow) {
//        String targetClassName = target.getClass().getName();
//        if (isProxy(target)) {
//            targetClassName = getTargetClass(target).getName();
//        }
//
//        String displayValue = Utils.forDisplayLionConfig(key, value, true);
//        if (value == null) {
//            LOGGER.warn("[Field] value is null,key:{},{}.{},please config", new Object[]{key, targetClassName, field.getName()});
//            ReflectionUtils.makeAccessible(field);
//
//            final Object defaultVal = ReflectionUtils.getField(field, target);
//            if (defaultVal == null) {
//                ConfigKey configKey = field.getAnnotation(ConfigKey.class);
//                if (configKey.required()) {
//                    throw new RuntimeException(String.format("[Field] key:%s, value is required, but value is null,%s.%s", key, targetClassName, field.getName()));
//                }
//            }
//        } else {
//            ValueResolver targetValueResolver = null;
//            for (ValueResolver valueResolver : valueResolvers) {
//                if (valueResolver.support(field)) {
//                    targetValueResolver = valueResolver;
//                    break;
//                }
//            }
//            if (targetValueResolver == null) {
//                throw new UnsupportedOperationException(String.format("[Field] %s is not support,key:%s,%s.%s", field.getType(), key, targetClassName, field.getName()));
//            }
//
//            try {
//                Object val = targetValueResolver.resolve(value, field);
//                field.setAccessible(true);
//                field.set(target, val);
//                if (log) {
//                    LOGGER.info("[Field] set field success,field:[{}.{}],value:[{}]", new Object[]{targetClassName, field.getName(), displayValue});
//                }
//            } catch (Exception e) {
//                if (shouldThrow) {
//                    throw new RuntimeException(String.format("[Field] set field fail,key:%s,value:%s,%s.%s", key, displayValue, targetClassName, field.getName()), e);
//                }
//                LOGGER.error(String.format("[Field] set field fail,key:%s,value:%s,%s.%s", key, displayValue, targetClassName, field.getName()), e);
//            }
//        }
//    }
//
//    private boolean isProxy(Object bean) {
//        return AopUtils.isAopProxy(bean) || ClassUtils.isCglibProxyClass(bean.getClass());
//    }
//
//    private Class getTargetClass(Object bean) {
//        Class<?> result = null;
//        if (bean instanceof TargetClassAware) {
//            result = ((TargetClassAware) bean).getTargetClass();
//        }
//        if (result == null) {
//            result = (ClassUtils.isCglibProxy(bean) ? bean.getClass().getSuperclass() : bean.getClass());
//        }
//        return result;
//    }
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//        if (event.getApplicationContext().getParent() == null) {
//            if (!CollectionUtils.isEmpty(getConfigDataCache())) {
//                final ApplicationContext context = event.getApplicationContext();
//
//                this.configCache.addChange(new ConfigChange() {
//                    @Override
//                    public void onChange(String key, String value) {
//                        Set<ConfigMetaData> configMetaDataSet = getConfigDataCache().get(key);
//                        if (!CollectionUtils.isEmpty(configMetaDataSet)) {
//                            for (ConfigMetaData configMetaData : configMetaDataSet) {
//                                Object member = configMetaData.getMember();
//
//                                if (configMetaData.isNeedChange()) {
//                                    Object target = context.getBean(configMetaData.getBeanName());
//                                    if (configMetaData.isField()) {
//                                        setFieldVal(configMetaData.getBean(), (Field) member, key, value, true, false);
//                                        if (target != configMetaData.getBean() && configMetaData.getBean().getClass().isInstance(target)) {
//                                            // bean被代理后,要保证成员变量都被修改
//                                            setFieldVal(target, (Field) member, key, value, true, false);
//                                        }
//                                    } else {
//                                        invokeMethod(target, (Method) member, key, value, true, false);
//                                    }
//                                }
//                            }
//                        }
//                    }
//                });
//            }
//        }
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        // nothing
//    }
//}