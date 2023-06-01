package SeleniumBasics;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FirstClass {
	
	public void launch()
	{
		WebDriver browser = new EdgeDriver();
		browser.get("https://www.facebook.com/");
		browser.manage().window().maximize();
		/*browser.navigate().to("https://www.gmail.com/");
		// browser.manage().window().setPosition(200);
		/*WebDriver browser1 = new ChromeDriver();
		browser1.navigate().to("https://www.gmail.com/");*/
		/*browser.navigate().back();
		browser.navigate().forward();
		browser.navigate().refresh();
		browser.close();
		browser.quit();*/
		
		WebElement username =browser.findElement(By.id("email"));
		username.sendKeys("sathish");
		// username.clear();
		//or
		browser.findElement(By.id("email")).sendKeys("kumar");
		// browser.findElement(By.id("email")).clear();
		
		browser.findElement(By.name("email")).sendKeys("kumar");
		
		browser.findElement(By.linkText("Forgotten password?")).click();)
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstClass F = new FirstClass();
		F.launch();
	}

}
