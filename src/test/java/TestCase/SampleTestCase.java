package TestCase;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BrowserDriver.BrowserLaunch;
import Utils.PropertyReadData;

public class SampleTestCase extends BrowserLaunch 
{

@BeforeSuite
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

@Test
public void FirstTestCase()
{
	
}

@AfterSuite
public void TearDown()
{
	driver.quit();
}
}
