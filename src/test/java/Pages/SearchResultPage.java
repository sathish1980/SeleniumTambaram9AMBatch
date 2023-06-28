package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import CommonElements.CommonMethods;

public class SearchResultPage extends CommonMethods
{
	WebDriver driver;
	
	public SearchResultPage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	public void WaitAndClickOnOKGotItPopup()
	{
		WaitForElementToBeClickable(driver,By.xpath("//*[text()='OKAY, GOT IT!']"),60);
		clickOnButton(driver.findElement(By.xpath("//*[text()='OKAY, GOT IT!']")));
		
	}
	
	public String GetSearchResultValue()
	{
		String text =GetTextOfelement(driver.findElement(By.xpath("//*[contains(@class,'journey-title')]")));
		System.out.println(text);
		return text;
	}

	
}
