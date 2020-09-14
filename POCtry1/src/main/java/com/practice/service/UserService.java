package com.practice.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.practice.beans.User;

@Service
public interface UserService {

	User createUser(User user);

	Iterable<User> getAll();

	User getUserById(Integer id);

	String deleteUser(Integer id);

	User updateUser(Integer id, @Valid User userDetails);

}
