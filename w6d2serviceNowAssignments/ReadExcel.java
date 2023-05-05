package w6d2serviceNowAssignments;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
public static String[][] readExcel(String filename) throws IOException {
	
		
		XSSFWorkbook book=new XSSFWorkbook("./data1/"+filename+".xlsx");
		XSSFSheet sheet = book.getSheetAt(0);
		XSSFRow row = sheet.getRow(1);
		int rowCount= sheet.getLastRowNum();	
		int columCount = row.getLastCellNum();
		String[][] data = new String[rowCount][columCount];
		
		  for(int i=1;i<=rowCount;i++) {
			  for(int j=0;j<columCount;j++) {
		  
			  String stringCellValue = sheet.getRow(i).getCell(j).getStringCellValue();
		
			  data[i-1][j] = stringCellValue;
		  }
		  }
		 
		book.close();
		return data;
}
}
