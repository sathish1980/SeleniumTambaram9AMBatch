package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import CommonElements.CommonMethods;

public class SearchPage extends CommonMethods
{
	@FindBy (xpath="//*[@for='fromCity']")
	WebElement fromField;
	@FindBy (xpath="//*[@for='toCity']")
	WebElement toField;
	@FindBy (xpath="//*[@data-cy='submit']//a")
	WebElement searchButton;
	@FindBy (xpath="//input[@id='fromCity']")
	WebElement getFromLocationText;
	@FindBy (xpath="//input[@id='toCity']")
	WebElement getToLocationText;
	

	
	 String fromButtonByClass = "//*[@for='fromCity']";
	 String fromListFirstValue = "(//ul[@role='listbox']//li)[1]";
	 String fromListValue="//ul[@role='listbox']//li";
	 WebDriver driver;
	 public String FromCityName =null;
	 public String ToCityName =null;
	 
	 public SearchPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	
	 public void ClickAndSelectFromValue(String fromValue)
	 {
		 	WaitForElementToBeClickable(driver,By.xpath(fromButtonByClass),60);
			
			//WaitForElementToBeClickable(driver,fromButtonByClass,60);
			//WebElement fromButton = driver.findElement(By.xpath("//*[@for='fromCity']"));
			//ClickOnButton(driver.findElement(By.xpath("//*[@for='fromCity']")));
			ClickOnButton(fromField);
			
			//WaitForElementToBeVisible(driver,By.xpath("(//ul[@role='listbox']//li)[1]"),60);
			WaitForElementToBeVisible(driver,By.xpath(fromListFirstValue),60);
			SelectTheValueFromList(driver, By.xpath(fromListValue),fromValue);
			GetTextofFromLocation();
	}
	 
	 public void ClickAndSelectToValue(String toValue)
	 {
		//WebElement toButton = driver.findElement(By.xpath("//*[@for='toCity']"));
		//ClickOnButton(driver.findElement(By.xpath("//*[@for='toCity']")));
		ClickOnButton(toField);
		
		SelectTheValueFromList(driver, By.xpath(fromListValue),toValue);
		GetTextofToLocation();
	 }
	 
	 public void SelectDepatureDate(String date)
	 {
		 SelectValueinCalender(driver,date);	
	 }

	 public void ClickOnSearchButton()
	 {
		 //clickOnButton(driver.findElement(By.xpath("//*[@data-cy='submit']//a")));
		 clickOnButton(searchButton);
				
	 }
	 
	 public void GetTextofFromLocation()
	 {
			//FromCityName=GetAttributeOfelement(driver.findElement(By.xpath("//input[@id='fromCity']")),"value");
		FromCityName=GetAttributeOfelement(getFromLocationText,"value");
			
			//FromCityName=GetTextOfelement(fromCity);
			
	}
		
		public void GetTextofToLocation()
		{
			//ToCityName=GetAttributeOfelement(driver.findElement(By.xpath("//input[@id='toCity']")),"value");
			ToCityName=GetAttributeOfelement(getToLocationText,"value");

		}
		
		public String ValidateTextForAssertion()
		{
			
			String text1 =  "Flights from ";
			String text2 =  " to ";
			String ActualText = text1+FromCityName+text2+ToCityName;
			return ActualText;
		}
}
