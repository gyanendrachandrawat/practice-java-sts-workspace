package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userServiceImpl;
	
	@PostMapping("/createuser")
	public User createUser(@RequestBody User user) {
		System.out.println("controller create user");
		return userServiceImpl.createUser(user);
	}
	
	@GetMapping("/getoneuser/{id}")
	public User getOneUser(@PathVariable("id")Integer id) {
		return userServiceImpl.getOneUser(id);
	}
	
	@GetMapping("getalluser")
	public Iterable<User> getAllUser(){
		return userServiceImpl.getAllUser();
	}
	
}
