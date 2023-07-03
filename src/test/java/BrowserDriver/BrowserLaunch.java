package BrowserDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utils.PropertyReadData;

public class BrowserLaunch 
{

	public static WebDriver driver;
	
	public static ExtentReports report;
	public static ExtentTest test;
	private String reportpath=System.getProperty("user.dir")+"//Reports//";
	
	public void Launch(String browserName)
	{
		// String browserName = PropertyReadData.propreaddata().getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			//test.log(LogStatus.INFO, browserName);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("--disable-Notifications");
			//options.addArguments("--incognito");
			driver= new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			//test.log(LogStatus.INFO, browserName);
			EdgeOptions options = new EdgeOptions();
			options.addArguments("start-maximized");
			options.addArguments("--disable-Notifications");
			options.addArguments("--incognito");
			driver= new EdgeDriver(options);
		}
		else
		{
			System.out.println("Please provide the valid Browser name");
		}
		report = new ExtentReports(reportpath+"extentreport.html",false);
		test= report.startTest("Makemytrip Automation report");
		
	}
	
	@BeforeTest
	@Parameters("browser")
	public void LaunchTheApplicaton(String browser)
	{	
		Launch(browser);
		String Url = PropertyReadData.propreaddata().getProperty("url");
		driver.get(Url);
	}
}
