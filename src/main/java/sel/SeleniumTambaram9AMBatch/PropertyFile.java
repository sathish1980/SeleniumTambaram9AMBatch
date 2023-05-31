package sel.SeleniumTambaram9AMBatch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
	
	String fielpath ="C:\\Users\\sathishkumar\\eclipse-workspace\\SeleniumTambaram9AMBatch\\Input\\environment.properties";
	public void proprtyFileHandling() throws IOException
	{
		File F = new File(fielpath);
		FileInputStream FI = new FileInputStream(F);
		Properties p = new Properties();
		p.load(FI);
		String name = p.getProperty("name");
		System.out.println(name);
		String age = p.getProperty("age");
		System.out.println(age);
		String edu = p.getProperty("Edu");
		System.out.println(edu);
		p.setProperty("address", "chennai");
		String  address= p.getProperty("address");
		System.out.println(address);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PropertyFile P = new PropertyFile();
		P.proprtyFileHandling();
	}

}
