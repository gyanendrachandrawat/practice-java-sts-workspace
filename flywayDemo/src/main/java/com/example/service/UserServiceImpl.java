package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.bean.User;
import com.example.repository.UserRepository;

@Component("userServiceImpl")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		System.out.println("user service impl");
		return userRepository.save(user); 
	}

	@Override
	public User getOneUser(Integer id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public Iterable<User> getAllUser() {
		return userRepository.findAll();
	}

}
