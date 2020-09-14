package com.operations;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.beans.User;

public class CrudOperations {
	static Scanner scan=new Scanner(System.in);
	public static void addUser() throws Exception{
		System.out.println("insert user.......");
		System.out.println("enter id : ");
		Integer id=scan.nextInt();
		System.out.println("enter name : ");
		String name=scan.next();
		System.out.println("enter email : ");
		String email=scan.next();
		
		User user=new User();
		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		System.out.println("dto.........");
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		System.out.println("session factory.........");
		Session session=sessionFactory.openSession();
		System.out.println("session.........");
		Transaction transaction=session.beginTransaction();
		System.out.println("transacion............");
		session.save(user);
		System.out.println("user session save............");
		transaction.commit();
		session.close();
		scan.close();
	}
}
