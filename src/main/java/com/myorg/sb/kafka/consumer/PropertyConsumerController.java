package com.myorg.sb.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class PropertyConsumerController {

    private final PropertyConsumerService service;

    public PropertyConsumerController(PropertyConsumerService service) {
        this.service = service;
    }

    @KafkaListener(topics = "${spring.kafka.consumer.topic-name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeMessage(String message) throws IOException {
        service.consumeMessage(message);
    }

}
