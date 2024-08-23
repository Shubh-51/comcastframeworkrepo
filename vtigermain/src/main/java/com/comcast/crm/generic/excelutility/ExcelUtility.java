package com.comcast.crm.generic.excelutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcelFile(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./TestScriptData/testScriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String data=wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).toString();
		wb.close();
		return data;
	}
	public int getRowCount(String sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./TestScriptData/testScriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int lastrow=wb.getSheet(sheetname).getLastRowNum();
		wb.close();
		return lastrow;
	}
	public void SetDataIntoExcel(String sheetname,int rownum,int cellnum,String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./TestScriptData/testScriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetname).getRow(rownum).createCell(cellnum);
		
		FileOutputStream fos=new FileOutputStream("./TestScriptData/testScriptdata.xlsx");
		wb.write(fos);
		wb.close();
		
	}
}
