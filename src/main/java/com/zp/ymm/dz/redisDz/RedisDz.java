package com.zp.ymm.dz.redisDz;

import com.zp.dao.mapper.FcDsBizOrderDetailMapper;
import com.zp.dao.mapper.FcDsBizOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author :  pengzheng
 * create at:  2020-03-05  22:05
 * @description: redis对账
 * 数据库刷很多数据
 * redis读取
 * redis比较
 */
@Component
public class RedisDz {

    @Autowired
    private FcDsBizOrderMapper fcDsBizOrderMapper;

    @Autowired
    private FcDsBizOrderDetailMapper fcDsBizOrderDetailMapper;


    @Autowired
    private JedisPool jedisPool;

    private Set<Integer> aDuoB = new HashSet<>();

    private Set<Integer> bDuoA = new HashSet<>();

    private Set<Integer> aBDiff = new HashSet<>();

    /**
     * redis对账
     * redis操作示意图 https://www.processon.com/diagraming/5e661ba2e4b0fbd1b087ba87
     * string内存大小 40+2n字节 40万数据存入redis30兆
     */
    public void redisDz() {
        Jedis jedis = jedisPool.getResource();
        // 分别读取A、B表 存入redis
        List<String> dsBizOrders = fcDsBizOrderMapper.selectDz();
        jedis.del("A", "B", "sdiffA", "sdiffB");

        long sddAStart = System.currentTimeMillis();
        jedis.sadd("A", dsBizOrders.toArray(new String[]{}));
        long sddAEnd = System.currentTimeMillis();
        System.out.println("sddA === " + (sddAEnd - sddAStart));

        dsBizOrders.clear();
        List<String> fcDsBizOrderDetails = fcDsBizOrderDetailMapper.selectDz();

        long sddBStart = System.currentTimeMillis();
        jedis.sadd("B", fcDsBizOrderDetails.toArray(new String[]{}));
        long sddBEnd = System.currentTimeMillis();
        System.out.println("sddB === " + (sddBEnd - sddBStart));
        fcDsBizOrderDetails.clear();

        long sdiffAStart = System.currentTimeMillis();
        Set<String> sdiffA = jedis.sdiff("A", "B"); // A多余B的，以及A和B不同的
        long sdiffAEnd = System.currentTimeMillis();
        System.out.println("sdiffA === " + (sdiffAEnd - sdiffAStart));   // 1m不到

        long sdiffBStart = System.currentTimeMillis();
        Set<String> sdiffB = jedis.sdiff("B", "A");// B多余A的，以及和B不同的
        long sdiffBEnd = System.currentTimeMillis();
        System.out.println("sdiffB === " + (sdiffBEnd - sdiffBStart));

        if (sdiffA.size() == 0 && sdiffB.size() == 0) {
            System.out.println("数据两边一致");
            return;
        }

        if (sdiffA.size() == 0) {
            bDuoA = sdiffB.stream().map(s -> Integer.valueOf(s.split(",")[0])).collect(Collectors.toSet());
            return;
        }

        if (sdiffB.size() == 0) {
            aDuoB = sdiffA.stream().map(s -> Integer.valueOf(s.split(",")[0])).collect(Collectors.toSet());
            return;
        }

        // 拿A,B的不同 再取交集 和 不同
        jedis.sadd("sdiffA", sdiffA.stream().map(s -> s.split(",")[0]).collect(Collectors.toSet()).toArray(new String[]{}));
        jedis.sadd("sdiffB", sdiffB.stream().map(s -> s.split(",")[0]).collect(Collectors.toSet()).toArray(new String[]{}));
        Set<String> sdiffAA = jedis.sdiff("sdiffA", "sdiffB");
        Set<String> sdiffBB = jedis.sdiff("sdiffB", "sdiffA");
        Set<String> sdiffAB = jedis.sinter("sdiffA", "sdiffB");
        aDuoB = sdiffAA.stream().map(Integer::valueOf).collect(Collectors.toSet());
        bDuoA = sdiffBB.stream().map(Integer::valueOf).collect(Collectors.toSet());
        aBDiff = sdiffAB.stream().map(Integer::valueOf).collect(Collectors.toSet());

        System.out.println(aDuoB.size() + bDuoA.size() + aBDiff.size());
    }


}