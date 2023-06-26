package sel.SeleniumTambaram9AMBatch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	// String filepath = "C:\\Users\\sathishkumar\\eclipse-workspace\\SeleniumTambaram9AMBatch\\Input\\Sample.xls";
	String filepath = System.getProperty("User.dir")+"\\Input\\Sample.xls";
	public void ReadData(String sheetName) throws IOException
	{
		FileInputStream FI = new FileInputStream(filepath);
		//XSSFWorkbook inputworkbook = new XSSFWorkbook(FI);
		HSSFWorkbook inputworkbook = new HSSFWorkbook(FI);
		
		Sheet inputSheet = inputworkbook.getSheet(sheetName);
		int totalUsedRow= inputSheet.getPhysicalNumberOfRows();
		for(int i=0;i<totalUsedRow;i++)
		{
			Row eachRow = inputSheet.getRow(i);
			int totalcolumns = eachRow.getLastCellNum();
			for(int j=0;j<totalcolumns;j++)
			{
				Cell eachCell =eachRow.getCell(j);
				//String s = eachCell.getStringCellValue();
				System.out.print(CellTypeandReturn(eachCell));
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
	
	public Object CellTypeandReturn(Cell cellvalue)
	{
		if(cellvalue.getCellType().equals(CellType.STRING))
		{
			return cellvalue.getStringCellValue();
		}
		else if(cellvalue.getCellType().equals(CellType.NUMERIC))
		{
			DataFormatter dataFormatter = new DataFormatter();
			 return dataFormatter.formatCellValue(cellvalue);
		}
		return null;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExcelRead E = new ExcelRead();
		E.ReadData("inputs");
	}

}
