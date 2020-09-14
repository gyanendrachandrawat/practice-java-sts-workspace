package com.ab1.service;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Value("${ab.encryptedKey}")
	private String encryptedKey;

	@Autowired
	private StandardPBEStringEncryptor decryptor;

	public String authenticateUser(String smallMsg) {
		System.out.println("IN SERVICE KEY IS : " + smallMsg);
		decryptor.setPassword(smallMsg);
		String actualKey = decryptor.decrypt(encryptedKey);
		return actualKey;
	}
}
