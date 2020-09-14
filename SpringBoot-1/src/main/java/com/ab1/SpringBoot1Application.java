package com.ab1;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBoot1Application {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public StandardPBEStringEncryptor standardPBEStringEncryptor() {
		return new StandardPBEStringEncryptor();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot1Application.class, args);
	}

}
