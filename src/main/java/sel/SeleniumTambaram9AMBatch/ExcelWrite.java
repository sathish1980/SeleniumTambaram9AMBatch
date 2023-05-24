package sel.SeleniumTambaram9AMBatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ExcelWrite 
{
	String filepath = "C:\\Users\\sathishkumar\\eclipse-workspace\\SeleniumTambaram9AMBatch\\Input\\outputFile.xls";
	

	public void excelWriteoperations() throws IOException
	{
		String[] name = {"Sathish","Kumar.R","Besant","Technology"};
		File F = new File(filepath);
		FileOutputStream FS = new FileOutputStream(F);
		HSSFWorkbook workbook = new HSSFWorkbook();
		Sheet outputSheet = workbook.createSheet("output");
		// Sheet outputSheet1 = workbook.createSheet("output2");
		Row eachRow =outputSheet.createRow(0);
		for(int i=0;i<4;i++)
		{
		Cell eachCell = eachRow.createCell(i);
		eachCell.setCellValue(name[i]);
		}
		workbook.write(FS);
		workbook.close();
		FS.close();
		System.out.println("this is done");
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExcelWrite E = new ExcelWrite();
		E.excelWriteoperations();
	}

}
