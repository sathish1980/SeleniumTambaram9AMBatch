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
import BrowserDriver.Browserdriver;
import Utils.ExcelReadData;
import Utils.PropertyReadData;
import CommonElements.*;
import Pages.SearchPage;
import Pages.SearchResultPage;

// public class SampleTestCase extends BrowserLaunch 
public class SampleTestCase extends Browserdriver
{
	CommonMethods c = new CommonMethods();
@BeforeSuite(alwaysRun = true)
public void LaunchTheBrowser()
{

}



@BeforeClass
public void deleteAdds() throws InterruptedException
{
	Thread.sleep(5000);
	//c.ClickIfElementExist(driver,"//*[@class='close']");
	c.ClickIfElementExist(getdriver(),"//*[@class='close']");
	
	test.log(LogStatus.INFO, "The first popup window closed sucessfully");

	//c.ClickOnAddClose(driver);
	c.ClickOnAddClose(getdriver());
	test.log(LogStatus.INFO, "The second popup window closed sucessfully");
}

@Test(priority=0, dataProvider = "searchCriteria", dataProviderClass=DataProviderClass.class)
public void ValidFlightSearch(String fromLocation, String toLocation, String flyDate)
{

		test.log(LogStatus.INFO, "URl Lauched sucssfully");
		//WaitForElementToBeClickable(driver,By.xpath("//*[@for='fromCity']"),60);
		// SearchPage s = new SearchPage(driver);
		SearchPage s = new SearchPage(getdriver());
		s.ClickAndSelectFromValue(fromLocation);
	  	test.log(LogStatus.INFO, "From value is slected sucessfully");
	  	s.ClickAndSelectToValue(toLocation);
		s.SelectDepatureDate(flyDate);
		// String toselection = c.takescreenshot(driver);
		String toselection = c.takescreenshot(getdriver());
		test.log(LogStatus.INFO, "fly Date is selected");
		s.ClickOnSearchButton();
		test.log(LogStatus.INFO, "Searchclicked");
		// SearchResultPage Srp = new SearchResultPage(driver);
		SearchResultPage Srp = new SearchResultPage(getdriver());
		Srp.WaitAndClickOnOKGotItPopup();
		test.log(LogStatus.INFO, "ok Got it popup is clicked suecssfully");
		String actualResult = Srp.GetSearchResultValue();
		System.out.println(actualResult);
		// String validateScreenShot= c.takescreenshot(driver);
		String validateScreenShot= c.takescreenshot(getdriver());
		test.log(LogStatus.INFO, "Search Text is validated sucessfully");
		System.out.println(s.ValidateTextForAssertion());
		Assert.assertEquals(s.ValidateTextForAssertion(), actualResult);
		test.log(LogStatus.PASS, "All the Steps are executed sucessfully", test.addScreenCapture(validateScreenShot));
		// c.ClickOnBrowserBackButton(driver);
		c.ClickOnBrowserBackButton(getdriver());
		test.log(LogStatus.PASS, "All the validation are sucessfull");
		test.log(LogStatus.PASS,test.addScreenCapture(toselection));
		
}




@AfterSuite
public void TearDown()
{
	report.flush();
	// driver.quit();
	getdriver().quit();
}
}
