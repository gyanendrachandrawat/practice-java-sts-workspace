package com.practice.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.beans.User;
import com.practice.repository.UserRepository;

@Component("userServiceImpl")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public Iterable<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Integer id) {
		return userRepository.getOne(id);
	}

	@Override
	public String deleteUser(Integer id) {
		String deletId=userRepository.getOne(id).getId().toString();
		userRepository.deleteById(id);
		return deletId;
	}

	@Override
	public User updateUser(Integer id, @Valid User userDetails) {
		User user=userRepository.getOne(id);
		user.setPassword(userDetails.getPassword());
		User newUser=userRepository.save(user);
		return newUser;
	}
	
}
