package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReader {
	
	
	String TestDataPath;
	String s3;
	String s;
	String data;
	String dataFromCell;
	FileInputStream file;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	Row HeaderRow;
	
		public HashMap<String, String> hm1 = new HashMap<>();
		ArrayList<String> headersList = new ArrayList<String>();
		
		public static void main(String [] args) {
			
			
		}
//==========================================================================================================================================
		@Test
		public XSSFSheet getSheet(String excelPath) {
			TestDataPath = System.getProperty("user.dir") + excelPath;
			try {
				file = new FileInputStream(TestDataPath);
				workbook = new XSSFWorkbook(file);
				sheet = workbook.getSheet("Sheet1");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return sheet;
		}
//==========================================================================================================================================

		public ArrayList<String> getColumnNames(String excelPath) {
			XSSFSheet sheet1 = getSheet(excelPath);
			HeaderRow = sheet1.getRow(0);
			for (int k = 0; k < HeaderRow.getPhysicalNumberOfCells(); k++) {
				headersList.add(HeaderRow.getCell(k).toString());
			}
//	 				System.out.println("headersList"+ headersList);
			return headersList;
		}
//==========================================================================================================================================

		public Map returnMap(ArrayList al, String excelPath, int rowNum) {

//	 				Iterator<String> iterator = al.iterator();  
//	 		        while (iterator.hasNext())  
//	 		        {  
//	 			        String i = iterator.next();  
//	 			        String returnedData = getData(excelPath, rowNum, i);
//	 			    	hm1.put(i, returnedData);
//	 		        }

			for (int i = 1; i < al.size(); i++) {
				String returnedData = getData(excelPath, rowNum, al.get(i).toString());
				hm1.put(al.get(i).toString(), returnedData);
			}

			return hm1;
		}
//==========================================================================================================================================

		public String getData(String excelPath, int rowNum, String colName) {
//						FileInputStream file = new FileInputStream(TestDataPath);
//						XSSFWorkbook workbook = new XSSFWorkbook(file);
//						XSSFSheet sheet = workbook.getSheet("Sheet1");
//			return getCellData(sheet, s1, rowNumber);
			getSheet(excelPath);
			data = getRowInfo(sheet, colName, (int) rowNum);
//					System.out.println( "Leaving getData()");
//					System.out.println(data);
			return data;
		}
//==========================================================================================================================================

		public String getRowInfo(XSSFSheet sheet, String colName, int rowNum) {

//					System.out.println("Inside getRowInfo()");
			HashMap<String, String> currentHash = new HashMap<String, String>();
			for (int k = 0; k < HeaderRow.getPhysicalNumberOfCells(); k++) {
				if (HeaderRow.getCell(k).toString().equalsIgnoreCase(colName)) {
//								System.out.println(HeaderRow.getCell(k));
					s = getCellData(sheet, HeaderRow, k, rowNum);
//								break;
				}

			}
//						System.out.println( "Leaving getRowInfo()");
//						System.out.println(s);
			return s;
		}
//==========================================================================================================================================
		public String getCellData(XSSFSheet sheet, Row HeaderRow, int cellNum, int rowNum) {
//					System.out.println("Inside getCellData()");
//					System.out.println(cellNum);
//					for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row currentRow = sheet.getRow(rowNum);
//						HashMap<String, String> currentHash = new HashMap<String, String>();
//						if(rowNum.getCell(0).toString().equalsIgnoreCase(String.valueOf(rowNum))) {
			for (int j = 0; j < currentRow.getPhysicalNumberOfCells(); j++) {

				Cell currentCell1 = currentRow.getCell(cellNum);
				switch (currentCell1.getCellType()) {
				case STRING:
					s3 = currentCell1.getStringCellValue();
					break;
				case NUMERIC:
					int a = (int) currentCell1.getNumericCellValue();
					s3 = String.valueOf(a);
					break;
				}
			}
//						System.out.println("&&&&&&&&&");
//						System.out.println(s3);
//						System.out.println("Leaving getCellData()");
			return s3;
		}
//==========================================================================================================================================
}
