package com.ak.boot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ak.boot.model.ApiResponse;
import com.ak.boot.model.User;
import com.ak.boot.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;

	@PostMapping("/save")
	public ApiResponse<User> saveRecord(@RequestBody User userModel) {
		return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.", userService.saveRecord(userModel));
	}

	@GetMapping("/publish/{message}")
	public String postMessage(@PathVariable("message") final String name) {
		kafkaTemplate.send("TestTopic", new User(1, name, "ab@mail.com", "123456"));
		return "Published Successfully";
	}

	@GetMapping(value = "/get")
	public List<User> getAllRecords() {
		return userService.getAllRecords();
	}

	@GetMapping(value = "/get/{id}")
	public Optional<User> getRecordById(@PathVariable int id) {
		return userService.getRecordById(id);
	}

	@GetMapping(value = "/get/mail/{email}")
	public Optional<User> getRecordByEmailId(@PathVariable String email) {
		return userService.getRecordByEmailId(email);
	}

	@PutMapping(value = "/update/id/{id}")
	public int updateRecordById(@RequestBody User user, @PathVariable int id) {
		return userService.updateRecordById(user, id);
	}
}
