package SeleniumBasics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListConcepts {
	
	public void ListImplementations(String expectedCountry) {
		WebDriver browser = new EdgeDriver();
		browser.get("https://leafground.com/select.xhtml;");
		browser.manage().window().maximize();
		browser.findElement(By.xpath("//*[@id='j_idt87:country']//*[contains(@class,'ui-selectonemenu-trigger')]")).click();
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='j_idt87:country_items']//li[1]")));
		List<WebElement> allCountries = browser.findElements(By.xpath("//*[@id='j_idt87:country_items']//li"));
		for (WebElement eachValue :allCountries)
		{
			String actualCountry = eachValue.getText();
			if(actualCountry.equalsIgnoreCase(expectedCountry))
			{
				eachValue.click();
				break;
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListConcepts L = new ListConcepts();
		L.ListImplementations("USA");
	}

}
