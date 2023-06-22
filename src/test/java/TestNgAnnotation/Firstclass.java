package TestNgAnnotation;
import org.testng.annotations.*;

public class Firstclass {
	
	@BeforeSuite(alwaysRun=true)
	public void BeforeSuite()
	{
		System.out.println("Before Suite");
	}
	
	@BeforeTest(alwaysRun=true)
	public void BeforeTest()
	{
		System.out.println("Before Test");
	}
	
	@AfterTest(alwaysRun=true)
	public void AfterTest()
	{
		System.out.println("After Test");
	}
	
	@BeforeClass(alwaysRun=true)
	public void Beforeclass()
	{
		System.out.println("Before class");
	}
	
	@AfterClass(alwaysRun=true)
	public void Before()
	{
		System.out.println("After class");
	}
	
	@BeforeMethod(alwaysRun=true)
	public void BeforeMethod()
	{
		System.out.println("Before method");
	}
	
	@AfterMethod
	public void AfterMethod()
	{
		System.out.println("After method");
	}
	
	@Test(priority=0,dependsOnMethods="Testcase1",groups="sanity")
	public void Testcase2()
	{
		System.out.println("Testcase2");
	}
	
	@Test(priority=2,enabled=true,description="username",invocationCount=4,invocationTimeOut=60,timeOut=6,groups= {"sanity","sit"})
	public void Testcase1()
	{
		System.out.println("Testcase1");
	}
	
	@Test(priority=1,groups="sit")
	public void Testcase3()
	{
		System.out.println("Testcase3");
	}

}
