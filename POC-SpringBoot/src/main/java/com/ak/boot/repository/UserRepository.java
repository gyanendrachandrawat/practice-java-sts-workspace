package com.ak.boot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ak.boot.model.User;

@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByusername(String email);
	
	@Modifying
	@Query(value = "update user set uname = ?, umail = ?, upassword = ? where uid = ?", nativeQuery = true)
	int updateRecordById(String uname, String umail, String password, int id);

}
