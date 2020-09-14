package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.bean.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
