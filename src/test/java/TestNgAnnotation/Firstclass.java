package TestNgAnnotation;
import org.testng.annotations.*;

public class Firstclass {
	
	@BeforeSuite
	public void BeforeSuite()
	{
		System.out.println("Before Suite");
	}
	
	@BeforeTest
	public void BeforeTest()
	{
		System.out.println("Before Test");
	}
	
	@AfterTest
	public void AfterTest()
	{
		System.out.println("After Test");
	}
	
	@BeforeClass
	public void Beforeclass()
	{
		System.out.println("Before class");
	}
	
	@AfterClass
	public void Before()
	{
		System.out.println("After class");
	}
	
	@BeforeMethod
	public void BeforeMethod()
	{
		System.out.println("Before method");
	}
	
	@AfterMethod
	public void AfterMethod()
	{
		System.out.println("After method");
	}
	
	@Test(priority=0)
	public void Testcase2()
	{
		System.out.println("Testcase2");
	}
	
	@Test(priority=1,enabled=true,description="username",invocationCount=4,invocationTimeOut=60,timeOut=60)
	public void Testcase1()
	{
		System.out.println("Testcase1");
	}
	
	@Test(priority=2)
	public void Testcase3()
	{
		System.out.println("Testcase3");
	}

}
