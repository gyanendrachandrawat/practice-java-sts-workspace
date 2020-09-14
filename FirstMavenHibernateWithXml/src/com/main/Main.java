package com.main;

import com.operations.CrudOperations;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("insert values : ");
			CrudOperations.addUser();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("main() : " + e);
		}
	}

}
