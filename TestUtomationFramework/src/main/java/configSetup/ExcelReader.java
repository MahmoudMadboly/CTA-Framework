package configSetup;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelReader extends FileBase{

private Workbook workbook;


	public 	ExcelReader(String file_Path) {

		super(file_Path);
		
		//load file once create an object
		loadFile();
	}


	@Override
	public void loadFile() {

		try {

			FileInputStream fileInput = new FileInputStream(filePath);
			
			workbook = new HSSFWorkbook(fileInput);
			
			

		}catch(Exception e) {

			e.getStackTrace();

		}
	}
	
	
	public String getCellData(String sheetName , int rowNumber , int colNumber) {
		
		
		Sheet sheet = workbook.getSheet(sheetName);
		
		Row row = sheet.getRow(rowNumber);
		
		Cell cell = row.getCell(colNumber);
		
		return cell.toString();
		
		
	}
}