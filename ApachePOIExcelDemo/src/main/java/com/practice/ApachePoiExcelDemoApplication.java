package com.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practice.excelController.ExcelController;

@SpringBootApplication
public class ApachePoiExcelDemoApplication implements CommandLineRunner {

	@Autowired
	private ExcelController controller;
	
	public static void main(String[] args) {
		SpringApplication.run(ApachePoiExcelDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		controller.createExcel();
		
	}

}
