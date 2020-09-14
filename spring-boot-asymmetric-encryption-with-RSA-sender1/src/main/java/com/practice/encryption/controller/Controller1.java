package com.practice.encryption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.encryption.service.Service1;

@RestController
@RequestMapping("/sender1")
public class Controller1 {
	
	@Autowired
	private Service1 service1;
	
	//Not Working *
	@GetMapping("/decryptMessage")
	public ResponseEntity<String> decryptMessage(@RequestParam("message1") String message1){
		String result = service1.decryptMessage(message1);
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
	//Using Jasypt
	//Not working
	@GetMapping("/encrypt-decrypt/{smallMsg}")
	public String encryptDecrypt(@PathVariable String password, @RequestParam("message") String message) {
		System.out.println("IN CONTROLLER KEY IS : "+password);
        String response = service1.authenticateUser(password, message);
        return "RESPONSE AFTER DECRYPTION : "+response;
	}
	
	//Using password and iv based encryption
	//Return the path of file created containing encrypted text
	//localhost:8080/sender1/encryptMessageStoreInFile/{password}/{fileName}?message=message here
	@GetMapping("/encryptMessageStoreInFile/{password}/{fileName}")
	public ResponseEntity<Object> encryptMessageStoreInFile(@PathVariable String password, @PathVariable String fileName, @RequestParam("message") String message) {
		String result = service1.encryptMessageStoreInFile(password, fileName, message);
		return new ResponseEntity<Object>(result, HttpStatus.OK);
				
	}
	
	//Using password and iv based decryption
	//Return the path of file created containing decrypted text
	//localhost:8080/sender1/decryptFile/{password}/{fileNameToBeDecrypted}
	@GetMapping("/decryptFile/{password}/{fileName}")
	public ResponseEntity<Object> decryptFile(@PathVariable String password, @PathVariable String fileName) {
		String result = service1.decryptFile(password, fileName);
		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}

}