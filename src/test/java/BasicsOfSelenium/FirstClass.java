package BasicsOfSelenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FirstClass {
	
	public void Launch()
	{
		//WebDriver browser = new ChromeDriver();
		WebDriver browser = new EdgeDriver();
		browser.manage().window().maximize();
		//browser.manage().window().minimize();

		browser.get("https://www.facebook.com/");
		browser.navigate().to("https://www.gmail.com/");
		browser.navigate().back();
		browser.navigate().forward();
		browser.navigate().refresh();
		//browser.close();
		//browser.quit();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstClass F = new FirstClass();
		F.Launch();
	}

}
