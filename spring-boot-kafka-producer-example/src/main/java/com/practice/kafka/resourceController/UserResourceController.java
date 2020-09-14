/**
 * 
 */
package com.practice.kafka.resourceController;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.kafka.model.User;

/**
 * @author ASUS
 *
 */
@RestController
@RequestMapping("kafkaProducer")
public class UserResourceController {
	
	
//	to publish a string message
//	@Autowired
//	KafkaTemplate<String, String> kafkaTemplate;
//
//	private String topic = "kafka_topic1";
//
//	@GetMapping("/publish/{message}")
//	public String postMessage(@PathVariable("message") String message) {
//		kafkaTemplate.send(topic, message);
//		return "Message Published Successfully";
//	}
	
//	to publish a JSON message
	@Autowired
	KafkaTemplate<String, User> kafkaUserTemplate;
	
	private String userTopic = "kafka_user_topic";
	
	@GetMapping("/publishUser/{name}")
	public String postUser(@PathVariable("name") String name) {
		kafkaUserTemplate.send(userTopic, new User(01, name, "IT"));
		return "user Published";
	}
	
}
