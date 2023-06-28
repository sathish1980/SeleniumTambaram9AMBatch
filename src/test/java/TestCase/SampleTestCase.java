package TestCase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import BrowserDriver.BrowserLaunch;
import Utils.ExcelReadData;
import Utils.PropertyReadData;
import CommonElements.*;
import Pages.SearchPage;
import Pages.SearchResultPage;

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

@Test(priority=0, dataProvider = "searchCriteria", dataProviderClass=DataProviderClass.class)
public void ValidFlightSearch(String fromLocation, String toLocation, String flyDate)
{

		test.log(LogStatus.INFO, "URl Lauched sucssfully");
		//WaitForElementToBeClickable(driver,By.xpath("//*[@for='fromCity']"),60);
		SearchPage s = new SearchPage(driver);
		s.ClickAndSelectFromValue(fromLocation);
	  	test.log(LogStatus.INFO, "From value is slected sucessfully");
	  	s.ClickAndSelectToValue(toLocation);
		s.SelectDepatureDate(flyDate);
		String toselection = c.takescreenshot(driver);
		test.log(LogStatus.INFO, "fly Date is selected");
		s.ClickOnSearchButton();
		test.log(LogStatus.INFO, "Searchclicked");
		SearchResultPage Srp = new SearchResultPage(driver);
		Srp.WaitAndClickOnOKGotItPopup();
		test.log(LogStatus.INFO, "ok Got it popup is clicked suecssfully");
		String actualResult = Srp.GetSearchResultValue();
		
		String validateScreenShot= c.takescreenshot(driver);
		test.log(LogStatus.INFO, "Search Text is validated sucessfully");
		System.out.println(s.ValidateTextForAssertion());
		Assert.assertEquals(s.ValidateTextForAssertion(), actualResult);
		test.log(LogStatus.PASS, "All the Steps are executed sucessfully", test.addScreenCapture(validateScreenShot));
		c.ClickOnBrowserBackButton(driver);
		test.log(LogStatus.PASS, "All the validation are sucessfull");
		test.log(LogStatus.PASS,test.addScreenCapture(toselection));
		
}




@AfterSuite
public void TearDown()
{
	report.flush();
	driver.quit();
}
}
