package BasicsOfSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Listconcepts {
	
	public void Listconceptsimplementation(String expectedCountry) throws InterruptedException
	{
		
			WebDriver browser = new EdgeDriver(); //open the browser
			browser.manage().window().maximize(); //maximize
			
			browser.get("https://leafground.com/select.xhtml"); //Enter url
			browser.findElement(By.xpath("//*[@id='j_idt87:country']//*[starts-with(@class,'ui-selectonemenu-trigger')]")).click();
			WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j_idt87:country_items']//li[last()]")));
			
			List<WebElement> allCountry = browser.findElements(By.cssSelector("[id='j_idt87:country_items']>li"));
			for(WebElement eachCountry : allCountry)
			{
				String actualCountry = eachCountry.getText();
				System.out.println(actualCountry);
				if(expectedCountry.equalsIgnoreCase(actualCountry))
				{
					eachCountry.click();
					break;
				}
			}
					
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Listconcepts D = new Listconcepts();
		D.Listconceptsimplementation("USA");
	}

}
