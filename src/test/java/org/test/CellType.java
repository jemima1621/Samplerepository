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

public class CellType {
	public static void main(String[] args) throws IOException {
		File loc=new File("E:\\Eclipse\\Practise\\testDatas\\Sample.xlsx");
		FileInputStream stream =new FileInputStream(loc);
		Workbook w=new XSSFWorkbook(stream);
		Sheet s = w.getSheet("Sheet1");	
		/*Row r = s.getRow(1);
		Cell c = r.getCell(0);
		int type = c.getCellType();
		System.out.println(type);*/

		//To get all the cell Values
	for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
		Row r = s.getRow(i);
		for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
			Cell c = r.getCell(j);
	   //To get type of cell
			int type = c.getCellType();
	   //For "String" type=1	
			if (type==1) {   
				
				String stringCellValue = c.getStringCellValue();
				System.out.println(stringCellValue);
				}
	  //For "Date" and "Mobile num" type=0
			else if (type==0) 
			{
		//For get Date type		
				if (DateUtil.isCellDateFormatted(c)) {
					
					Date dateCellValue = c.getDateCellValue();
					SimpleDateFormat sim=new SimpleDateFormat("dd-MMM-yyy");			
					String format = sim.format(dateCellValue);
					System.out.println(format);
				}
		//For get Mobile num type		
				else {
					double numericCellValue = c.getNumericCellValue();
					
		//Type 	Casting		
					long l=(long)numericCellValue;
					String valueOf = String.valueOf(l);
					System.out.println(valueOf);
					
				}
				
			}
			
		}
		
	}
	
	
	}

}
