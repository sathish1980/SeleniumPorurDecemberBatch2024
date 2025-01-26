package Browsers;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Utils.PropertyFileRead;

public class BrowserDriver {
	
	public static WebDriver browser;
	
	public void OpenTheBrowser() throws IOException
	{
		String browerName = PropertyFileRead.GetDataFromPropFile().getProperty("browser");
		if(browerName.equalsIgnoreCase("edge")) {
		browser = new EdgeDriver(); //open the browser
		
		}
		else if(browerName.equalsIgnoreCase("chrome")) {
			browser = new ChromeDriver(); //open the browser

			}
		browser.manage().window().maximize(); //maximize
		
		
	}
	
	public void CloseTheBrowser()
	{
		browser.quit();
	}

}
