package SeleniumBasics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakemytripFrom {
	
	public void makemytrip(String expectedfromCity) throws InterruptedException
	{

		EdgeOptions options = new EdgeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--disable-Notifications");

		WebDriver browser = new EdgeDriver(options);
		browser.get("https://www.makemytrip.com/");
		Thread.sleep(5000);
		WebElement fromButton = browser.findElement(By.xpath("//*[@for='fromCity']"));
		fromButton.click();
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='react-autowhatever-1']//li[1]")));
		List<WebElement> Fromlocation = browser.findElements(By.xpath("//*[@id='react-autowhatever-1']//li"));
		int size = Fromlocation.size();
		
		for(int i=1;i<=size;i++)
		{
			String FromCityCode = browser.findElement(By.xpath("//*[@id='react-autowhatever-1']//li["+i+"]//div[2]")).getText();
			if(expectedfromCity.equalsIgnoreCase(FromCityCode))
			{
				System.out.println(FromCityCode);
				browser.findElement(By.xpath("//*[@id='react-autowhatever-1']//li["+i+"]")).click();
				break;
			}
			
		}
	
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		MakemytripFrom M = new MakemytripFrom();
		M.makemytrip("CCU");
	}

}
