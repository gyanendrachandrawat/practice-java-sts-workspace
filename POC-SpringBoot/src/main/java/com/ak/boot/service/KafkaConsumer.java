package com.ak.boot.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ak.boot.model.MyUser;

@Service
public class KafkaConsumer {

	@KafkaListener(topics = "TestTopic", groupId = "group_id")
	public void consume(String message) {
		System.out.println("Consumed message: " + message);
	}
	
	@KafkaListener(topics = "TestTopicTwo", groupId = "group_json",
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(MyUser user) {
        System.out.println("Consumed JSON Message: " + user.toString());
    }
}
