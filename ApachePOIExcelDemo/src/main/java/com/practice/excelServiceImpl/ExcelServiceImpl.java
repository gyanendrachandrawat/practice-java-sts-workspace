package com.practice.excelServiceImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.poi.sl.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.practice.excelService.ExcelService;

@Service
public class ExcelServiceImpl implements ExcelService {

	public void getExcelReportHeader(XSSFWorkbook workbook, XSSFSheet sheet, String reportName,
			Integer cols, String substationName1) {
		try {
//			InputStream inputStream = new FileInputStream("mppkvvcl.png");
//			byte[] imageBytes = IOUtils.toByteArray(inputStream);
//			int pictureureIdx = workbook.addPicture(imageBytes, XSSFWorkbook.PICTURE_TYPE_PNG);
//			inputStream.close();
//			CreationHelper helper = workbook.getCreationHelper();
//			Drawing drawing = sheet.createDrawingPatriarch();
//			ClientAnchor anchor = helper.createClientAnchor();
//			anchor.setCol1(1);
//			anchor.setRow1(1);
//
//			drawing.createPicture(anchor, pictureureIdx);
			
			CellRangeAddress logoCell = new CellRangeAddress(0,1,0,1);		//CellRangeAddress(int firstRow, int lastRow, int firstCol, int lastCol)
			sheet.addMergedRegion(logoCell);
			CellRangeAddress companyCell = new CellRangeAddress(0, 0, 2, cols-1);
			sheet.addMergedRegion(companyCell);
			CellRangeAddress reportCell = new CellRangeAddress(1, 1, 2, cols-1);
			sheet.addMergedRegion(reportCell);
			
			Row headerRow=sheet.createRow(0);
			Cell logo=headerRow.createCell(0);
			logo.setCellValue("logo here");
//			CellUtil.setCellStyleProperty(logo, CellUtil.ALIGNMENT, VerticalAlignment.MIDDLE);
			Cell company=headerRow.createCell(2);
			company.setCellValue("Madhya Pradesh Paschim Kshetra Vidyut Vitran Company");
			
			Row reportRow=sheet.createRow(1);
			Cell report=reportRow.createCell(2);
			report.setCellValue("Daily Feeder Reliability Repoprt");
			
			Row headingRow1=sheet.createRow(2);
			Cell substationHeading= headingRow1.createCell(0);
			substationHeading.setCellValue("Substation Name : ");
			Cell substationName=headingRow1.createCell(1);
			substationName.setCellValue(substationName1);
			Cell dateHeading=headingRow1.createCell(2);
			dateHeading.setCellValue("Report Date : ");
			Cell reportDate=headingRow1.createCell(3);
			reportDate.setCellValue(LocalDate.now().format(DateTimeFormatter.ofPattern("_dd-MM-yyyy")));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object createExcel() {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Java Books");

		getExcelReportHeader(workbook, sheet, "tempreport", 7, "tempsubstation");

//		Row row1 = sheet.createRow(1);
//
//		Cell cell1_1 = row1.createCell(1);
//		cell1_1.setCellValue("val 1");

		CellRangeAddress headerNameOfFeeder = new CellRangeAddress(3,4,0,0);
		sheet.addMergedRegion(headerNameOfFeeder);
		CellRangeAddress headerOutageTripping = new CellRangeAddress(3,3,1,2);
		sheet.addMergedRegion(headerOutageTripping);
//		CellRangeAddress headerNumber = new CellRangeAddress(4,4,1,1);
//		sheet.addMergedRegion(headerNumber);
//		CellRangeAddress headerDuration = new CellRangeAddress(4,4,2,2);
//		sheet.addMergedRegion(headerDuration);
		CellRangeAddress headerTotalOutage = new CellRangeAddress(3,4,3,3);
		sheet.addMergedRegion(headerTotalOutage);
		CellRangeAddress headerTotalSupply = new CellRangeAddress(3,4,4,4);
		sheet.addMergedRegion(headerTotalSupply);
		CellRangeAddress headerReliability = new CellRangeAddress(3,4,5,5);
		sheet.addMergedRegion(headerReliability);
		CellRangeAddress headerRemark = new CellRangeAddress(3,4,6,6);
		sheet.addMergedRegion(headerRemark);
			
		
		
		
		try {
			FileOutputStream outputStream = new FileOutputStream(new File("JavaBooks.xlsx"));
			workbook.write(outputStream);
			workbook.close();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
