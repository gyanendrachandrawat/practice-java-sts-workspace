package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.practice.service.PdfService;

@Controller
public class PdfWithMessageController {

	@Autowired
	private PdfService pdfServiceImpl;

	@PostMapping(value = "/createpdf/{pdfname}")
	public void createPdf(@PathVariable("pdfname") String pdfname) {
		pdfServiceImpl.createPdf(pdfname);
	}
	
	@PostMapping("/createpdfimage/{pdfname}")
	public void createPdfImage(@PathVariable("pdfname")String pdfname) {
		pdfServiceImpl.createPdfImage();
	}
	
}
