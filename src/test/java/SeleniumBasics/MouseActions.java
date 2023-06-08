package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
	
	public void mouseimplementation() throws InterruptedException
	{
		EdgeOptions options = new EdgeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--disable-Notifications");

		WebDriver browser = new EdgeDriver(options);
		browser.get("https://www.ebay.com/");
		Actions mouseactions = new Actions(browser);
		mouseactions.moveToElement(browser.findElement(By.xpath("(//*[text()='Electronics'])[2]"))).clickAndHold().perform();
		Thread.sleep(1000);
		mouseactions.moveToElement(browser.findElement(By.xpath("//*[text()='Cameras and photos']"))).click().perform();
	}
	
	public void RightandDoubleclick()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--disable-Notifications");

		WebDriver browser = new ChromeDriver(options);
		browser.get("https://www.facebook.com/");
		Actions mouseActions = new Actions(browser);
		mouseActions.moveToElement(browser.findElement(By.id("email"))).sendKeys("sathish").doubleClick().contextClick().perform();
		
	}
	
	public void DragAndDrop()
	{
		ChromeDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.navigate().to("https://leafground.com/drag.xhtml");
		Actions mouseaction= new Actions(browser);
		mouseaction.moveToElement(browser.findElement(By.id("form:drag_content"))).dragAndDrop(browser.findElement(By.id("form:drag_content")), browser.findElement(By.id("form:drop_header"))).perform();
	
	}
	
	public void Slider()
	{
		ChromeDriver browser = new ChromeDriver();
		browser.manage().window().maximize();
		browser.navigate().to("https://leafground.com/drag.xhtml");
		JavascriptExecutor js= (JavascriptExecutor)browser;
		WebElement startbutton=browser.findElement(By.xpath("//*[text()='Start']//parent::button"));
		js.executeScript("arguments[0].scrollIntoView();", startbutton);
		Actions mouse= new Actions(browser);
		mouse.moveToElement(browser.findElement(By.xpath("//*[@id='form:j_idt125']//span[1]"))).dragAndDropBy(browser.findElement(By.xpath("//*[@id='form:j_idt125']//span[1]")), 100, -50).perform();
		mouse.moveToElement(browser.findElement(By.xpath("//*[@id='form:j_idt125']//span[2]"))).dragAndDropBy(browser.findElement(By.xpath("//*[@id='form:j_idt125']//span[2]")), -80, 0).perform();
	
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		MouseActions M = new MouseActions();
		M.Slider();
	}

}
