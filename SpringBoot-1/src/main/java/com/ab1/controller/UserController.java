package com.ab1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ab1.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RestTemplate restTemplate;

	/*
	 * @GetMapping("/check1") public String validateAuthentication(@RequestBody
	 * String msg) { final ResponseEntity<String> responseBody =
	 * restTemplate.postForEntity("http://localhost:8080/check2", msg,
	 * String.class); return responseBody.getBody();
	 * 
	 * }
	 */
	
	@GetMapping("/encrypt-decrypt/{smallMsg}")
	public String encryptDecrypt(@PathVariable String smallMsg) {
		System.out.println("IN CONTROLLER KEY IS : "+smallMsg);
        String response = userService.authenticateUser(smallMsg);
        return "RESPONSE AFTER DECRYPTION : "+response;
	}
}
