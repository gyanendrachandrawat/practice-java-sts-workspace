package com.practice.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.practice.kafka.models.User;

@Service
public class KafkaConsumer {

//	@KafkaListener(topics = "kafka_topic1", groupId = "group_id")
//	public void consume(String message) {
//		System.out.println("Consumed Message : "+message);
//	}
	
	@KafkaListener(topics = "kafka_user_topic", groupId = "group_json", containerFactory = "userKafkaListenerFactory")
	public void consumeJson(User user) {
		System.out.println("User Consumed"+ user);
	}
	
}
