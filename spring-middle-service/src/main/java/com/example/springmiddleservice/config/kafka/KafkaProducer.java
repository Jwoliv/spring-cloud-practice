package com.example.springmiddleservice.config.kafka;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static final String TOPIC = "TOPIC_EXAMPLE";

    @Setter(onMethod = @__(@Autowired))
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message){
        this.kafkaTemplate.send(TOPIC,message);
    }
}
