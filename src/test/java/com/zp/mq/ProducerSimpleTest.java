package com.zp.mq;

import com.zp.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author :  pengzheng
 * create at:  2021-01-17  20:13
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ProducerSimpleTest {


    @Autowired
    private ProducerSimple producerSimple;

    //测试发送同步消息
    @Test
    public void testSendSyncMsg() {
        this.producerSimple.sendSyncMsg("my-topic", "第一条同步消息");
        System.out.println("end...");
    }


}