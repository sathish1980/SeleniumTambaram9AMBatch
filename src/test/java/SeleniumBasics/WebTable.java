package SeleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {
	
	WebDriver driver;
	String indentify="notdone";
	public void tableconcept(String expectedcountry) throws InterruptedException
	{
		
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		JavascriptExecutor js= (JavascriptExecutor)driver;
		driver.manage().window().maximize();
		driver.get("https://leafground.com/table.xhtml");
		String basePath = "//*[@id='form:j_idt89_data']//tr";
		List<WebElement> allRows = driver.findElements(By.xpath("basePath"));
		int size = allRows.size();
		for(int i=1;i<=size;i++)
		{
			String actualCountry = driver.findElement(By.xpath(basePath+"["+i+"]//td[2]//span[3]")).getText();
			System.out.println(actualCountry);
			if (actualCountry.equalsIgnoreCase(expectedcountry))
			{
				String actualName = driver.findElement(By.xpath(basePath+"["+i+"]")).getText();
				String representative = driver.findElement(By.xpath(basePath+"["+i+"]//td[3]//span[2]")).getText();
				String joinDate = driver.findElement(By.xpath(basePath+"["+i+"]//td[4]")).getText();
				String Status = driver.findElement(By.xpath(basePath+"["+i+"]//td[5]//span[2]")).getText();
				System.out.println(actualName);
				System.out.println(representative);
				System.out.println(joinDate);
				System.out.println(Status);
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebTable W = new WebTable();
		W.tableconcept("Italy");
	}

}
