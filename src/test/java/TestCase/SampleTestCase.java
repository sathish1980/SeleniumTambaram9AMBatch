package TestCase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import BrowserDriver.BrowserLaunch;
import Utils.PropertyReadData;
import CommonElements.*;

public class SampleTestCase extends BrowserLaunch 
{
	CommonMethods c = new CommonMethods();
@BeforeSuite(alwaysRun = true)
public void LaunchTheBrowser()
{
	Launch();
}

@BeforeTest
public void LaunchTheApplicaton()
{
	String Url = PropertyReadData.propreaddata().getProperty("url");
	driver.get(Url);
}

@BeforeClass
public void deleteAdds() throws InterruptedException
{
	Thread.sleep(5000);
	//c.ClickIfElementExist(driver,"//*[@class='close']");
	c.ClickIfElementExist(driver,"//*[@class='close']");
	
	test.log(LogStatus.INFO, "The first popup window closed sucessfully");

	//c.ClickOnAddClose(driver);
	c.ClickOnAddClose(driver);
	test.log(LogStatus.INFO, "The second popup window closed sucessfully");
}

@Test(priority=0)
public void ValidFlightSearch()
{

	 String fromButtonByClass = "//*[@for='fromCity']";
	 String fromListFirstValue = "(//ul[@role='listbox']//li)[1]";
	 String fromListValue="//ul[@role='listbox']//li";
	test.log(LogStatus.INFO, "URl Lauched sucssfully");
		//WaitForElementToBeClickable(driver,By.xpath("//*[@for='fromCity']"),60);
		c.WaitForElementToBeClickable(driver,By.xpath(fromButtonByClass),60);
		
		//WaitForElementToBeClickable(driver,fromButtonByClass,60);
		//WebElement fromButton = driver.findElement(By.xpath("//*[@for='fromCity']"));
		c.ClickOnButton(driver.findElement(By.xpath("//*[@for='fromCity']")));
		//WaitForElementToBeVisible(driver,By.xpath("(//ul[@role='listbox']//li)[1]"),60);
		c.WaitForElementToBeVisible(driver,By.xpath(fromListFirstValue),60);
		c.SelectTheValueFromList(driver, By.xpath(fromListValue),"MAA");
		test.log(LogStatus.INFO, "From MAA value is slected sucessfully");
		//WebElement toButton = driver.findElement(By.xpath("//*[@for='toCity']"));
		c.ClickOnButton(driver.findElement(By.xpath("//*[@for='toCity']")));
		c.SelectTheValueFromList(driver, By.xpath(fromListValue),"PNQ");
		test.log(LogStatus.INFO, "From PNQ value is slected sucessfully");
		
		String toselection = c.takescreenshot(driver);
		c.SelectValueinCalender(driver,"30");
		test.log(LogStatus.INFO, "fly Date is selected");
		c.clickOnButton(driver.findElement(By.xpath("//*[@data-cy='submit']//a")));
		test.log(LogStatus.INFO, "Searchclicked");

		c.WaitForElementToBeClickable(driver,By.xpath("//*[text()='OKAY, GOT IT!']"),60);
		c.clickOnButton(driver.findElement(By.xpath("//*[text()='OKAY, GOT IT!']")));
		test.log(LogStatus.INFO, "ok Got it popup is clicked suecssfully");
		
		
		String text =c.GetTextOfelement(driver.findElement(By.xpath("//*[contains(@class,'journey-title')]")));
		System.out.println(text);
		String validateScreenShot= c.takescreenshot(driver);
		test.log(LogStatus.INFO, "Search Text is validated sucessfully");
		
		Assert.assertEquals(ValidateTextForAssertion(), "Flights from MAA to PNQ");
		test.log(LogStatus.PASS, "All the Steps are executed sucessfully", test.addScreenCapture(validateScreenShot));
		
		test.log(LogStatus.FAIL, "All the validation are sucessfull");
		test.log(LogStatus.PASS,test.addScreenCapture(toselection));
		
}

public String ValidateTextForAssertion()
{
	String text1 =  "Flights from ";
	String text2 =  " to ";
	String ActualText = text1+"MAA"+text2+"PNQ";
	return ActualText;
}

@AfterSuite
public void TearDown()
{
	report.flush();
	driver.quit();
}
}
