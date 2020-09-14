package com.example.service;

import com.example.bean.User;

public interface UserService {

	User createUser(User user);

	User getOneUser(Integer id);

	Iterable<User> getAllUser();

}
