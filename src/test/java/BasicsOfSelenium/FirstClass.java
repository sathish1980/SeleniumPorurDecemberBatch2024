package BasicsOfSelenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FirstClass {
	
	public void Launch()
	{
		//WebDriver browser = new ChromeDriver();
		WebDriver browser = new EdgeDriver(); //open the browser
		browser.manage().window().maximize(); //maximize
		//browser.manage().window().minimize(); //minimize
		
		browser.get("https://www.facebook.com/"); //Enter url
		/*browser.navigate().to("https://www.gmail.com/"); //Enter url
		browser.navigate().back();
		browser.navigate().forward();
		browser.navigate().refresh();*/
		//browser.close();
		//browser.quit();
		
		/*
		 * locators
		 */
		WebElement username = browser.findElement(By.id("email"));
		username.sendKeys("sathish");
		username.clear();
		
		browser.findElement(By.name("email")).sendKeys("Besant");
		
		//browser.findElement(By.className("inputtext _55r1 _6luy")).sendKeys("Besant");
	
		//browser.findElement(By.name("login")).click();
		
		//browser.findElement(By.linkText("Forgotten password?")).click();
		
		//browser.findElement(By.partialLinkText("n pass")).click();
		
		browser.findElement(By.cssSelector("input#pass")).sendKeys("test");
		
		browser.findElement(By.cssSelector("input.inputtext _55r1 _6luy _9npi")).sendKeys("test");
		
		
		browser.findElement(By.cssSelector("input[data-testid='royal_email']")).sendKeys("test");
		
		browser.findElement(By.cssSelector("input.inputtext _55r1 _6luy _9npi[data-testid='royal_email']")).sendKeys("test");
		
	
		/*
		 * startswith --tagname[attribute^='staring value']  or [attribute^='staring value']
		 * endswith ----tagname[attribute$='end value']
		 * contains ----tagname[attribute*='any where value']
		 */
	
		/*
		 * Xpath
		 * 2 types
		 * Absolut xpath =/
		 * relative xpath = //
		 * 5 type
		 * 1.Basic xpath
		 * 2.and or
		 * 3.starts-with
		 * 4.contains
		 * 5.text
		 * 
		 */
		
		browser.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/div/form/div/div/input")).sendKeys("test");
		
		browser.findElement(By.xpath("//input[@type='text']")).sendKeys("test");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstClass F = new FirstClass();
		F.Launch();
	}

}
