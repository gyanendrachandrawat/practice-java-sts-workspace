package com.practice.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaDoubleConsumer {
//	 CREATED FOR SECOND TOPIC
	@KafkaListener(topics = "${kafka.topic.odd-output}")
	public void consume(Long number) {
		System.out.println(String.format("Doubled Odd :: %d", number));
	}
}
