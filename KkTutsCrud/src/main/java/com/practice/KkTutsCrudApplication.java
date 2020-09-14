package com.practice;

//import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.practice.beans.Ticket;
import com.practice.service.MyService;

@SpringBootApplication
public class KkTutsCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(KkTutsCrudApplication.class, args);
		
//		ConfigurableApplicationContext applicationContext=SpringApplication.run(KkTutsCrudApplication.class, args);
//		MyService myService=applicationContext.getBean("myService", MyService.class);
//		Ticket ticket=new Ticket();
//		ticket.setDate(new Date());
//		ticket.setFromSt("pithampur");
//		ticket.setToSt("indore");
//		ticket.setPassengerName("passenger1");
//		
//		myService.createTicket(ticket);
		
	}

}
