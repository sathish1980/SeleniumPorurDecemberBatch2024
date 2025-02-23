package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelfileRead {
	
static String filePath = System.getProperty("user.dir")+"\\Input\\MakemyTrip.xlsx";
	
	static Object[][] value;
	public static Object[][] ExcelRead(String sheetname) throws IOException
	{
	
		File F = new File(filePath); // inbuild class
		FileInputStream Fs = new FileInputStream(F); // inbuild class to read the file.
		XSSFWorkbook wbk = new XSSFWorkbook(Fs); //  to read XLSX file
		//HSSFWorkbook wbk =  new HSSFWorkbook(Fs); // to read xls file.
		Sheet sheet = wbk.getSheet(sheetname); // to move to a specific sheet
		// get the totatl number of rows
		int totalRows = sheet.getPhysicalNumberOfRows(); // to get the used number of rows
		Row firstrow = sheet.getRow(0);
		int totalColumns = firstrow.getLastCellNum(); // to get the used column 
		value= new String[totalRows][totalColumns];
		for(int i=0;i<totalRows;i++)
		{
			Row row = sheet.getRow(i);
			int totalColumn = row.getLastCellNum();
			for(int j=0;j<totalColumn;j++)
			{
				Cell cell = row.getCell(j);
				value[i][j]=GetCellValue(cell);
			}
		}
		Fs.close();
		return value;
		
	}
	public static Object GetCellValue(Cell cellVal)
	{
		if(cellVal.getCellType().toString()=="STRING")
		{
			return cellVal.getStringCellValue();
		}
		else
		{
			DataFormatter data =  new DataFormatter();
			return data.formatCellValue(cellVal);
			//return cellVal.getNumericCellValue();
		}
	}
}
