package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelIntegration {
	
	public static String getData(int rowNum,int cellNum) throws Throwable {
		File loc=new File("E:\\Eclipse\\Practise\\testDatas\\Sample.xlsx");
		FileInputStream stream=new FileInputStream(loc);
		Workbook w=new XSSFWorkbook(stream);
		Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(rowNum);
		Cell c = r.getCell(cellNum);
		System.out.println(c);
		
		String v = null;
		
		int type = c.getCellType();
		
		if (type==1) {
			v = c.getStringCellValue();
			}
		else if (type==0) {
			if (DateUtil.isCellDateFormatted(c)) {
				Date dateCellValue = c.getDateCellValue();
				SimpleDateFormat sim=new SimpleDateFormat("dd-MMM-yyyy");
			v = sim.format(dateCellValue);	
			}
			else {
				double numericCellValue = c.getNumericCellValue();
				long l=(long)numericCellValue;
			v = String.valueOf(l);
			}
		
	
	}
		return v;
		}
}
