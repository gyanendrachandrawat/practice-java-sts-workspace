package com.practice.encryption.service;

public interface Service1 {

	//not working
	String decryptMessage(String message1);

	//not working
	String authenticateUser(String password, String message);

	//Using password and iv based encryption
	String encryptMessageStoreInFile(String password, String fileName, String message);

	//Using password and iv based decryption
	String decryptFile(String password, String fileName);

}

	
