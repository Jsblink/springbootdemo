package com.smz.springbootdemo.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class MessageProducer {
    @Autowired
    KafkaTemplate kafkaTemplate;

    //public void sendMessage
}
