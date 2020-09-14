package com.practice.serviceImpl;

import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.practice.service.PdfService;

@Service
public class PdfServiceImpl implements PdfService {

	@Override
	public void createPdf(String pdfname) {
		System.out.println("service called");
		Document document = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfname + ".pdf"));
			System.out.println("document created");
			document.open();
			Font font = FontFactory.getFont(FontFactory.TIMES_ITALIC, 16, BaseColor.BLUE);
			Paragraph paragraph = new Paragraph("this is paragraph text", font);
			document.add(paragraph);
			System.out.println("paragraph created");
			document.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createPdfImage() {
		try {
			Path path = Paths.get(ClassLoader.getSystemResource("milkyway.jpg").toURI());

			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream("iTextImageExample.pdf"));
			document.open();
			Image img = Image.getInstance(path.toAbsolutePath().toString());
			document.add(img);

			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
