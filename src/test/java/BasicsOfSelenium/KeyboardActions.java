package BasicsOfSelenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {
	
	public void keyboardimplementation2() throws InterruptedException, AWTException
	{
		WebDriver browser = new EdgeDriver(); //open the browser
		browser.manage().window().maximize(); //maximize
		
		browser.get("https://www.facebook.com/"); //Enter url
		
		Actions mouse = new Actions(browser);
		mouse.moveToElement(browser.findElement(By.id("email"))).sendKeys("sathish").doubleClick().contextClick().perform();
		Robot keyboard = new Robot();
		keyboard.keyPress(KeyEvent.VK_DOWN);
		keyboard.keyRelease(KeyEvent.VK_DOWN);
		keyboard.keyPress(KeyEvent.VK_DOWN);
		keyboard.keyRelease(KeyEvent.VK_DOWN);
		keyboard.keyPress(KeyEvent.VK_DOWN);
		keyboard.keyRelease(KeyEvent.VK_DOWN);
		keyboard.keyPress(KeyEvent.VK_ENTER);
		keyboard.keyRelease(KeyEvent.VK_ENTER);
		keyboard.keyPress(KeyEvent.VK_TAB);
		keyboard.keyRelease(KeyEvent.VK_TAB);
		keyboard.keyPress(KeyEvent.VK_CONTROL);
		keyboard.keyPress(KeyEvent.VK_V);
		keyboard.keyRelease(KeyEvent.VK_CONTROL);
		keyboard.keyRelease(KeyEvent.VK_V);
	}

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		KeyboardActions K = new KeyboardActions();
		K.keyboardimplementation2();
	}

}
