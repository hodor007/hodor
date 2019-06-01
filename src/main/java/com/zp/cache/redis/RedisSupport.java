//package com.zp.cache.redis;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisCallback;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import redis.clients.jedis.JedisCommands;
//
//import java.util.UUID;
//
///**
// * @Auther: zhengpeng
// * @Date: 2019/6/1 12:54
// * @Description:
// */
//
//@Component
//public class RedisSupport {
//
//    private final Logger logger = LoggerFactory.getLogger(RedisSupport.class);
//
//    @Autowired
//    private RedisTemplate<String, String> redisTemplate;
//
//    /**
//     * 功能描述:
//     *
//     * @param key
//     * @param expire 时间
//     * @param nxxx   nxxx的值只能取NX或者XX，如果取NX，则只有当key不存在是才进行set，如果取XX，则只有当key已经存在时才进行set
//     * @param expx   expx的值只能取EX或者PX，代表数据过期时间的单位，EX代表秒，PX代表毫秒。
//     * @return: boolean
//     * @auther: zhengpeng
//     * @date: 2019/6/1 1:24 PM
//     */
//    public boolean setLock(String key, long expire) {
//        try {
//            RedisCallback<String> callback = (connection) -> {
//                JedisCommands commands = (JedisCommands) connection.getNativeConnection();
//                String uuid = UUID.randomUUID().toString();
//                return commands.set(key, uuid, "NX", "EX", expire);
//            };
//            String result = (String) redisTemplate.execute(callback);
//
//            return !StringUtils.isEmpty(result);
//        } catch (Exception e) {
//            logger.error("set redis occured an exception,key:{}", key, e);
//        }
//        return false;
//    }
//
//    /**
//     * 删除锁
//     *
//     * @param key
//     */
//    public void deleteLock(String key) {
//        redisTemplate.delete(key);
//    }
//
//    public static void main(String[] args) {
//        new RedisSupport().setLock("aa", 120L);
//    }
//
//
//}
