package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileUpdate{
	public static void main(String[] args) throws IOException {
		
	File loc=new File("E:\\Eclipse\\Practise\\testDatas\\Sample.xlsx");
	FileInputStream stream =new FileInputStream(loc);
	Workbook w=new XSSFWorkbook(stream);
	Sheet s = w.getSheet("Sheet1");
	Row r = s.getRow(1);
	Cell c = r.getCell(0);
	String s1 = c.getStringCellValue();
	if (s1.equals("Chaan")) {
		
		c.setCellValue("Chaan");
	}
	FileOutputStream out=new FileOutputStream(loc);
	w.write(out);
	System.out.println("Success");
	}
	

}
