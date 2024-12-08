package BasicsOfSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.*;

public class Syncronization {
	
	public void Launch()
	{
		//WebDriver browser = new ChromeDriver();
		WebDriver browser = new EdgeDriver(); //open the browser
		browser.manage().window().maximize(); //maximize
		//browser.manage().window().minimize(); //minimize
		
		browser.get("https://www.facebook.com/"); //Enter url
		
		browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		
		WebElement username = browser.findElement(By.id("email"));
		username.sendKeys("sathish");
		username.clear();

		
		// explicit wait
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("email")));
		browser.findElement(By.name("email")).sendKeys("Besant");
		wait.until(ExpectedConditions.elementToBeClickable(By.name("pass")));
		
	}

}
