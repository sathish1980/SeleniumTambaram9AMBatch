package SeleniumBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Syncronizationconcepts {
	
	
	public void sync() throws InterruptedException
	{

		WebDriver browser = new EdgeDriver();
		browser.get("https://www.facebook.com/");
		browser.manage().window().maximize();
		browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		browser.findElement(By.id("email")).sendKeys("kumar.sathish189@gmail.com");
		browser.findElement(By.id("pass")).sendKeys("kumar.sathish189@gmail.com");
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("email")));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("login")));
	
		Thread.sleep(3000);
	}
	
	public void implementation() throws InterruptedException
	{
		WebDriver browser = new EdgeDriver();
		browser.get("https://www.facebook.com/");
		browser.manage().window().maximize();
		//browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		browser.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();
		//Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("firstname")));
		
		browser.findElement(By.name("firstname")).sendKeys("sathish");
		
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Syncronizationconcepts s = new Syncronizationconcepts();
		s.implementation();
	}

}
