package TestNgAnnotation;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class SecondClass {

	@AfterSuite(alwaysRun=true)
	public void AfterSuite()
	{
		System.out.println("After Suite");
	}
	
	@Test(groups="sanity")
	public void TestcaseinSecondclass()
	{
		System.out.println("TestcaseinSecondclass");
	}
}
