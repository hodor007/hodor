package com.zp.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author :  pengzheng
 * create at:  2020-03-08  21:13
 * @description:
 */
@Configuration
@Slf4j
public class RedisConfig extends CachingConfigurerSupport {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.jedis.pool.max-wait}")
    private long maxWaitMillis;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.block-when-exhausted}")
    private boolean blockWhenExhausted;

    /*  为现有的redis创建密码或修改密码的方法：

        1.进入redis的容器 docker exec -it 容器ID bash

        2.进入redis目录 /usr/local/bin

        3.运行命令：redis-cli

        4.查看现有的redis密码：config get requirepass

        5.设置redis密码config set requirepass ****（****为你要设置的密码）

        auth (password)
     */

    @Bean
    public JedisPool redisPoolFactory() throws Exception {
//        log.info("JedisPool注入成功！！");
//        log.info("redis地址：" + host + ":" + port);
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        // 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
        jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
        // 是否启用pool的jmx管理功能, 默认true
        jedisPoolConfig.setJmxEnabled(true);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password);
        return jedisPool;
    }


    // 自定义缓存异常处理   默认SimpleCacheErrorHandler 抛异常
    @Override
    public CacheErrorHandler errorHandler() {
        return new CacheErrorHandler(){

            @Override
            public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
//                log.error("获取缓存失败",exception);
            }

            @Override
            public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {
//                log.error("存入缓存失败",exception);
            }

            @Override
            public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {

            }

            @Override
            public void handleCacheClearError(RuntimeException exception, Cache cache) {

            }
        };
    }
}