package com.zp.ymm;

import com.zp.ymm.dz.redisDz.RedisDz;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author :  pengzheng
 * create at:  2020-03-08  20:26
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
//启动Spring
@SpringBootTest
public class Test {

    @Autowired
    private RedisDz redisDz;

    @org.junit.Test
    public void test() {
        redisDz.redisDz();
    }

}


