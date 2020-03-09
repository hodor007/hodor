//package com.zp.zjj.kafka;
//
//import com.google.gson.Gson;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.common.serialization.IntegerDeserializer;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//import org.springframework.kafka.listener.AbstractMessageListenerContainer;
//import org.springframework.kafka.support.Acknowledgment;
//import org.springframework.stereotype.Component;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public class ConsumerMsg {
//    private Gson gson = new Gson();
//
//    //创建生产者配置map，ProducerConfig中的可配置属性比spring boot自动配置要多
//    private Map<String, Object> consumerProps() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
//        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
//        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        return props;
//    }
//
//    @Bean("listenerContainerFactory")
//    public ConcurrentKafkaListenerContainerFactory ackContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory();
//        factory.setConsumerFactory(new DefaultKafkaConsumerFactory(consumerProps()));
//        // 设置AckMode=MANUAL_IMMEDIATE
//        factory.getContainerProperties().setAckMode(AbstractMessageListenerContainer.AckMode.MANUAL_IMMEDIATE);
//        return factory;
//    }
//
//    /**
//     * 使用Kafka的Ack机制比较简单，只需简单的三步即可：
//     * <p>
//     * 设置ENABLE_AUTO_COMMIT_CONFIG=false，禁止自动提交
//     * 设置AckMode=MANUAL_IMMEDIATE
//     * 监听方法加入Acknowledgment ack 参数
//     * <p>
//     * 消费者的id,当GroupId没有被配置的时候,默认id为GroupId
//     * 一个group只又一个消费者能消费
//     * 不同group可以同时消费
//     *
//     * @param record
//     * @param ack
//     */
//
//    @KafkaListener(id = "ack", topics = "test", containerFactory = "listenerContainerFactory", groupId = "testA")
//    public void consumerAckListener(ConsumerRecord record, Acknowledgment ack) {
//        System.out.println("topic.ack.consumer receive : " + record.toString());
//        ack.acknowledge();
//    }
//
//    @KafkaListener(id = "consumer", topics = "test", groupId = "test")
//    public void consumerListener(ConsumerRecord record) {
//        System.out.println("topic.quick.consumer receive : " + record.toString());
//    }
//
//    @KafkaListener(id = "test", topics = "test", groupId = "test")
//    public void processMessage(String content) {
//        Message m = gson.fromJson(content, Message.class);
//        System.out.println("test1--消费消息:" + m.getMsg());
//    }
//}
