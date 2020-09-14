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
		System.out.print("enter id : ");
		Integer id=scan.nextInt();
		System.out.print("enter name : ");
		String name=scan.next();
		System.out.print("enter email : ");
		String email=scan.next();
		
		User user=new User();
		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		
		SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		session.save(user);
		
		transaction.commit();
		session.close();
	}
}
