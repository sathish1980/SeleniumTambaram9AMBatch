package SeleniumBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dropdown {
	
	public void singleselectdropdown()
	{

		WebDriver browser = new EdgeDriver();
		browser.get("https://www.facebook.com/");
		browser.manage().window().maximize();
		browser.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();
		//Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("firstname")));
		
		browser.findElement(By.name("firstname")).sendKeys("sathish");
	
		WebElement DayDropdown = browser.findElement(By.id("day"));
		Select DayDropdownselect = new Select(DayDropdown);
		DayDropdownselect.selectByIndex(9);
		
		WebElement monthDropdown = browser.findElement(By.id("month"));
		Select monthDropdownselect = new Select(monthDropdown);
		monthDropdownselect.selectByValue("5");
		
		
		WebElement yearDropdown = browser.findElement(By.id("year"));
		Select yearDropdownselect = new Select(yearDropdown);
		yearDropdownselect.selectByVisibleText("2010");
		
		
	}
	
	
	public void multiselectDropdown() throws InterruptedException
	{
		WebDriver browser = new EdgeDriver();
		browser.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		browser.manage().window().maximize();
		WebElement fooditemDropdown = browser.findElement(By.cssSelector("select[id=second]"));
		Select foodSelect = new Select(fooditemDropdown);
		if (foodSelect.isMultiple())
		{
			foodSelect.selectByIndex(1);
			Thread.sleep(1000);
			foodSelect.selectByVisibleText("Burger");
			Thread.sleep(1000);
			foodSelect.selectByValue("bonda");
			Thread.sleep(1000);
			foodSelect.deselectByVisibleText("Burger");
			Thread.sleep(1000);
			foodSelect.deselectByValue("bonda");
			Thread.sleep(1000);
			foodSelect.selectByVisibleText("Burger");
			Thread.sleep(1000);
			foodSelect.deselectAll();
			
		}
		
	
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Dropdown d = new Dropdown();
		//d.singleselectdropdown();
		d.multiselectDropdown();
	}

}
