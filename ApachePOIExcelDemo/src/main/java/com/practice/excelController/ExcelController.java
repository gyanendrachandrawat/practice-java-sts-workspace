package com.practice.excelController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.excelService.ExcelService;

@RestController
public class ExcelController {
	
	@Autowired
	private ExcelService excelService;
	
	@GetMapping("/createExcel")
	public void createExcel() {
		excelService.createExcel();
	}
	
}
