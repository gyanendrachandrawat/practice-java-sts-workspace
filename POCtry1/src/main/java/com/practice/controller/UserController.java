package com.practice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.beans.User;
import com.practice.service.UserService;
//import com.practice.service.UserServiceImpl;

@RestController
@RequestMapping("/pocuser")
public class UserController {
	
	@Autowired
	@Qualifier("userServiceImpl")
	UserService userServiceImpl;
	
	@PostMapping("/user/create")
	public User createUser(@RequestBody User user) {
		return userServiceImpl.createUser(user);
	}
	
	@GetMapping("/user/getAll")
	public Iterable<User> getAll(){
		return userServiceImpl.getAll();
	}
	
//	@GetMapping(value = "/user/getById/{id}")
//	public User getUserById(@PathVariable("id") Integer id) {
////	public User getUserById() {
//		System.out.println("in Controller");
//		return userServiceImpl.getUserById(id);
////		return userServiceImpl.getUserById(1);
//	}
	
	@GetMapping("/user/getById/{id}")
	public User getUserById(@PathVariable(value = "id")Integer id) {
		return userServiceImpl.getUserById(id);
	}
	
	@PutMapping("/user/update/{id}")
	public User updateUser(@PathVariable(value = "id") Integer id,@Valid @RequestBody User userDetails) {
		return userServiceImpl.updateUser(id, userDetails);
	}
	
	@DeleteMapping("/user/delete/{id}")
	public String deleteUser(@PathVariable(value = "id") Integer id) {
		return userServiceImpl.deleteUser(id);
	}
	
}
