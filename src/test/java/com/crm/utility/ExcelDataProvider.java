package com.crm.utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	
    public ExcelDataProvider()
    {
    	File src = new File(".//TestData//Exceldata.xlsx");
    	try {
			FileInputStream fis = new FileInputStream(src);
			 wb = new XSSFWorkbook(fis);
		} 
		catch (Exception e) {
			System.out.println("Unable to load excel file "+e.getMessage());
			
		}
    	
    	
    }
    
    public String getStringdata(int Sheetindex,int row,int col)
    {
    	return wb.getSheetAt(Sheetindex).getRow(row).getCell(col).getStringCellValue();
    	
    }
    
    public String getStringdata(String sheet,int row,int col)
    {
    	return wb.getSheet(sheet).getRow(row).getCell(col).getStringCellValue();
    	
    }
    
    public int getNumericData(String sheet,int row,int col)
    {
    	return (int)wb.getSheet(sheet).getRow(row).getCell(col).getNumericCellValue();
    	
    }

}
