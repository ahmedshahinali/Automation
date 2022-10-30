package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExelReader {
  static FileInputStream fis = null ;
 public FileInputStream getFileInputStream()
 { 
	 String filepath = System.getProperty("user.dir")+"/src/test/java/data/Book.xlsx" ;
      File srcFile = new File(filepath);
 try {
    fis = new FileInputStream(srcFile);
  
 }
 catch (FileNotFoundException e) {
	 System.out.println("error: check file path");
	 System.exit(0);
 }
 return fis;

}
 public Object [] [] getExcelData() throws IOException  
 {
	 fis =  getFileInputStream();
 	
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet sheet = wb.getSheetAt(0);
	Row roww = sheet.getRow(1);
	int maxCell= roww.getLastCellNum();
	int TotalNunberOfRows = (sheet.getLastRowNum()+1);
	int TotalNunberOfCols = maxCell;
	
	
	String[] [] arrayExcelData = new String[TotalNunberOfRows][TotalNunberOfCols];
			for (int i = 0; i < TotalNunberOfRows; i++) 
	{
		for (int j = 0; j < TotalNunberOfCols; j++) {	
		XSSFRow row = sheet.getRow(i);
		arrayExcelData[i][j]= row.getCell(j).toString();
	}
	}	
	wb.close();
	return arrayExcelData;
	
 }
}
		


