package com.example.springcoreservice.config.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "TOPIC_EXAMPLE", groupId = "group_id")
    public void consumeMessage(String message){
        System.out.println(message);
    }
}
