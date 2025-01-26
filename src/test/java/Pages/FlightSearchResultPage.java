package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import CommonElements.WebelementCommons;

public class FlightSearchResultPage extends WebelementCommons {

	WebDriver Browser;
	
	public FlightSearchResultPage(WebDriver Browser)
	{
		this.Browser=Browser;
	}
	
	public String GetsearchResult()
	{
		WebelementCommons.WaitForVisible(Browser, By.xpath("//*[@class='error-title']"));
		return WebelementCommons.GetText(Browser.findElement(By.xpath("//*[@class='error-title']")));

	}
	
}
