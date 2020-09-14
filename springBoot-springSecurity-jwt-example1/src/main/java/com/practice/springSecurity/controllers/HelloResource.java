package com.practice.springSecurity.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.practice.springSecurity.models.AuthenticationRequest;
import com.practice.springSecurity.models.AuthenticationResponse;
import com.practice.springSecurity.services.CallService;
import com.practice.springSecurity.util.JwtUtil;

@RestController
public class HelloResource {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private CallService callService;
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/hello")
	public String hello() {
		return "Hello Workd!";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect Credentials");
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
	}
	
	@RequestMapping("/callApplication2")
	public void callSecondApi(@RequestHeader(value="Authorization") String authorizationHeader) {
		String url = "http://localhost:8081/hello2";
		HttpHeaders headers = new HttpHeaders();
//	
		String token = authorizationHeader.substring(7);
		System.out.println("token : "+token);
		headers.set("Authorization", "Bearer "+token);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, entity, Map.class);        
        System.out.println("RESPONSE "+ response.getBody());
//		ResponseEntity<Map> response = callService.callSecondApi(authorizationHeader);
//		return response;
	}

}
