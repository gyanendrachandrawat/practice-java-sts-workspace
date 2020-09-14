package com.ak.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ak.boot.model.User;
import com.ak.boot.repository.UserRepository;

@Service
public class UserService{

	@Autowired
	private UserRepository userRepository;

	public User saveRecord(User user) {
		return userRepository.save(user);
	}
	public List<User> getAllRecords() {
		List<User> l = userRepository.findAll();
		return l;
	}
	
	public Optional<User> getRecordById(int id) {
		return userRepository.findById(id);
	}
	
	public Optional<User> getRecordByEmailId(String email){
		return userRepository.findByusername(email);
	}
	
	public int updateRecordById(User user, int id) {
		return userRepository.updateRecordById(user.getUsername(), user.getUname(),
				user.getPassword(), id);
	}

}
