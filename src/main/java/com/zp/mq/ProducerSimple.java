package com.zp.mq;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author :  pengzheng
 * create at:  2021-01-17  20:28
 * @description:
 */
@Component
public class ProducerSimple {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public void sendSyncMsg(String topic, String msg) {
        rocketMQTemplate.syncSend(topic, msg);
    }

}