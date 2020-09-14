package com.practice.springSecurity.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CallService {
	
	@Autowired
	private RestTemplate restTemplate;

	public ResponseEntity<Map> callSecondApi(String authorizationHeader) {
		String jwt = authorizationHeader.substring(7);
		String url = "http://localhost:8081/hello2";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer "+jwt);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, entity, Map.class);        
        System.out.println("RESPONSE "+ response.getBody());
		return response;
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
