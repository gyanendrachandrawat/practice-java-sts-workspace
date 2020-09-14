package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component("com.example.SendEmail")
public class SendMail {

	@Autowired
	private JavaMailSender javaMailSender;

	void sendEmail() {

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("ankitrajpootsv.ar@gmail.com");
//		msg.setTo("chandrawatpradhumn@gmail.com");

		msg.setSubject("Testing from Spring Boot using task schedular");
		msg.setText("Hello World \n Spring Boot Email");

		javaMailSender.send(msg);
		
		System.out.println("sent...............");

	}

}
