package TestNgAnnotation;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class SecondClass {

	@AfterSuite
	public void AfterSuite()
	{
		System.out.println("After Suite");
	}
	
	@Test
	public void TestcaseinSecondclass()
	{
		System.out.println("TestcaseinSecondclass");
	}
}
