package BasicsOfSelenium;

import java.awt.AWTException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class WindowsHandling {
	
	public void windowsimplementation() throws InterruptedException, AWTException
	{
		WebDriver browser = new EdgeDriver(); //open the browser
		browser.manage().window().maximize(); //maximize
		
		browser.get("https://leafground.com/window.xhtml"); //Enter url
		
		String parentWindow= browser.getWindowHandle();
		System.out.println(parentWindow);
		browser.findElement(By.id("j_idt88:new")).click();
		Set<String> allWindows =	browser.getWindowHandles();
		for( String eachwindow : allWindows)
		{
			if(!eachwindow.equalsIgnoreCase(parentWindow))
			{
				browser.switchTo().window(eachwindow);
				List<WebElement> elementExist = browser.findElements(By.id("menuform:j_idt40"));
				if(elementExist.size()>0)
				{
					browser.findElement(By.id("menuform:j_idt40")).click();
					browser.findElement(By.id("menuform:m_input")).click();
					browser.findElement(By.id("j_idt88:name")).sendKeys("Besant");
					browser.close();
					browser.switchTo().window(parentWindow);
				}
			}
		}
		
	}

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		WindowsHandling W = new WindowsHandling();
		W.windowsimplementation();
	}

}
