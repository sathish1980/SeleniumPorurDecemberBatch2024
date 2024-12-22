package BasicsOfSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;


public class Frames {

	
	public void launch() throws InterruptedException
	{
	
		WebDriver browser = new EdgeDriver();
		browser.manage().window().maximize();
		browser.get("https://www.leafground.com/frame.xhtml");
		//Thread.sleep(2000);
		List<WebElement> totalFrames = browser.findElements(By.tagName("iframe"));
		for(int i=0;i<totalFrames.size();i++)
		{
			browser.switchTo().frame(i);
			List<WebElement> elementExist = browser.findElements(By.xpath("//*[@id='Click' and contains(@style,'fe875d')]"));
			if(elementExist.size()>0)
			{
				browser.findElement(By.xpath("//*[@id='Click' and contains(@style,'fe875d')]")).click();	
			}
			
			browser.switchTo().defaultContent();
			
		}
		

	}
}
