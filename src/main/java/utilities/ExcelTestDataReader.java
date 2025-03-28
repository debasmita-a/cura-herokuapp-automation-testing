package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class ExcelTestDataReader {

	private ExcelTestDataReader() {}
	
	public static Object[] getData(FileInputStream excelFilePath, String excelPath, String sheetName) throws IOException {
		excelFilePath = new FileInputStream(excelPath);
		try (XSSFWorkbook workbook = new XSSFWorkbook(excelFilePath)) {
			XSSFSheet worksheet = workbook.getSheet(sheetName);
			
			int rowNum = worksheet.getLastRowNum();
			int columnNum = worksheet.getRow(0).getLastCellNum();
			
			Object[] data= new Object[rowNum];
			Map<String, String> map;
			
			for(int i=1; i<=rowNum; i++) {
				map = new HashMap<>();
				for(int j=0; j<=columnNum; j++) {
					String key = worksheet.getRow(0).getCell(j).getStringCellValue();
					String value = worksheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
					data[i-1] = map;
				}
			}	
			
			return data;
		}
	}
}
