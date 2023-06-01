package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SecondClass {
	public void launch()
	{
		WebDriver browser = new EdgeDriver();
		browser.get("https://www.facebook.com/");
		browser.manage().window().maximize();
		//browser.findElement(By.linkText("Forgotten password?")).click();
		
		browser.findElement(By.partialLinkText("gotten")).click();

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SecondClass F = new SecondClass();
		F.launch();
	}


}
