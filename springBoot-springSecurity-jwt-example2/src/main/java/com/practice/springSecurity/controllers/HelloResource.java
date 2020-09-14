package com.practice.springSecurity.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {

//	@Autowired
//	private AuthenticationManager authenticationManager;
//	
//	@Autowired
//	private UserDetailsService userDetailsService;
	
//	@Autowired
//	private JwtUtil jwtUtil;

	@GetMapping("/hello2")
	public ResponseEntity<Map> hello() {
		HashMap<String, String> responseMap = new HashMap<>();
		responseMap.put("response", "HelloFrom2nd");
		
	}

//	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
//	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
//			throws Exception {
//		try {
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
//		} catch (BadCredentialsException e) {
//			throw new Exception("Incorrect Credentials");
//		}
//		
//		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//		final String jwt = jwtUtil.generateToken(userDetails);
//		
//		return ResponseEntity.ok(new AuthenticationResponse(jwt));
//		
//	}

}
