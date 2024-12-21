package BasicsOfSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseActions {
	
	/*
	 * Actions
	 * Movetoelement
	 * click
	 * doubleclick
	 * sendkeys
	 * contectclick
	 * draganddrop
	 * draganddropby
	 * clickandhold
	 * release
	 */
	
	public void mouseimplementation1() throws InterruptedException
	{
		WebDriver browser = new EdgeDriver(); //open the browser
		browser.manage().window().maximize(); //maximize
		
		browser.get("https://www.ebay.com/"); //Enter url
		
		Actions mouse = new Actions(browser);
		//mouse.m
		mouse.moveToElement(browser.findElement(By.xpath("//*[@class='vl-flyout-nav__js-tab']//a[text()='Electronics']"))).perform();
		//Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Computers and tablets']")));
		
		mouse.moveToElement(browser.findElement(By.xpath("//a[text()='Computers and tablets']"))).click().perform();
		
	}
	
	public void mouseimplementation2() throws InterruptedException
	{
		WebDriver browser = new EdgeDriver(); //open the browser
		browser.manage().window().maximize(); //maximize
		
		browser.get("https://www.facebook.com/"); //Enter url
		
		Actions mouse = new Actions(browser);
		mouse.moveToElement(browser.findElement(By.id("email"))).sendKeys("sathish").doubleClick().contextClick().perform();
	}

	
	public void mouseimplementation3() throws InterruptedException
	{
		WebDriver browser = new EdgeDriver(); //open the browser
		browser.manage().window().maximize(); //maximize
		
		browser.get("https://leafground.com/drag.xhtml"); //Enter url
		
		Actions mouse = new Actions(browser);
		mouse.moveToElement(browser.findElement(By.id("form:drag_content"))).dragAndDrop(browser.findElement(By.id("form:drag_content")), browser.findElement(By.id("form:drop_content"))).perform();
	}

	public void mouseimplementation4() throws InterruptedException
	{
		WebDriver browser = new EdgeDriver(); //open the browser
		browser.manage().window().maximize(); //maximize
		
		browser.get("https://leafground.com/drag.xhtml"); //Enter url
		
		Actions mouse = new Actions(browser);
		mouse.moveToElement(browser.findElement(By.id("form:conpnl_content"))).dragAndDropBy(browser.findElement(By.id("form:conpnl_content")),250,0).perform();
		mouse.moveToElement(browser.findElement(By.id("form:conpnl_content"))).dragAndDropBy(browser.findElement(By.id("form:conpnl_content")),-100,0).perform();
	}
	
	public void keyboardactions()
	{

		WebDriver browser = new EdgeDriver(); //open the browser
		browser.manage().window().maximize(); //maximize
		
		browser.get("https://www.facebook.com/"); //Enter url
		
		Actions mouse = new Actions(browser);
		mouse.moveToElement(browser.findElement(By.id("email"))).sendKeys("sathish").perform();
		mouse.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		mouse.keyDown(Keys.SHIFT).keyDown(Keys.TAB).keyUp(Keys.SHIFT).keyUp(Keys.TAB).perform();
		mouse.keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).perform();
	
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		MouseActions M = new MouseActions();
		M.keyboardactions();
	}

}
