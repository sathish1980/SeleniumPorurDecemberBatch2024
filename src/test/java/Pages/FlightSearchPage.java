package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonElements.WebelementCommons;

public class FlightSearchPage extends WebelementCommons {
	
	WebDriver Browser;
	public FlightSearchPage(WebDriver Browser)
	{
		this.Browser=Browser;
	}
	
	public void ClosePopup() throws InterruptedException
	{
		try
		{
		WaitForClickable(Browser,By.xpath("//*[@data-cy='closeModal']"));
		ClickOnButton(Browser.findElement(By.xpath("//*[@data-cy='closeModal']")));
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void SelectFromLocation(String from)
	{
		//ClickFromLocationdropdown();
		SelectValueFromList(from);
	}
	
	public void SelectToLocation(String to)
	{
		//ClickToLocationdropdown();
		SelectValueFromList(to);
	}
	
	public void SelectDate(String expectedDate) throws InterruptedException
	{
		Thread.sleep(2000);
		List<WebElement> allWeeks = Browser.findElements(By.xpath("(//*[@class='DayPicker-Months']//div[@class='DayPicker-Month'])[last()]//div[@class='DayPicker-Week']"));
		for(WebElement eachWeek : allWeeks)
		{
			List<WebElement> allDaysInaWeek=	eachWeek.findElements(By.cssSelector("div[class^='DayPicker-Day']"));
			for (WebElement eachday : allDaysInaWeek)
			{
				
				String className = WebelementCommons.GetAttribute(eachday,"class");
				if(!(className.contains("outside")||className.contains("disabled")||className.contains("selected")))
				{
					String actualDate =WebelementCommons.GetText(eachday.findElement(By.tagName("p")));
					System.out.println(actualDate);
					if(actualDate.equalsIgnoreCase(expectedDate))
					{
						System.out.println(actualDate);
						
						WebelementCommons.ClickOnButton(eachday);
						return ;
					}
				}
			}
		}
	}
	
	public void clickOnSearchbutton() throws InterruptedException
	{
		WebelementCommons.WaitForClickable(Browser, By.xpath("//a[text()='Search']"));
		WebelementCommons.ClickOnButton(Browser.findElement(By.xpath("//a[text()='Search']")));

	}
	public void ClickFromLocationdropdown() throws InterruptedException
	{
		WebelementCommons.WaitForClickable(Browser, By.cssSelector("[for='fromCity']"));
		WebElement from = Browser.findElement(By.cssSelector("[for='fromCity']"));
		WebelementCommons.ClickOnButton(from);

	}
	
	public void ClickToLocationdropdown() throws InterruptedException
	{
		WebelementCommons.WaitForClickable(Browser, By.cssSelector("[for='toCity']"));
		WebElement to = Browser.findElement(By.cssSelector("[for='toCity']"));
		
		WebelementCommons.ClickOnButton(to);
	}
	
	public void SelectValueFromList(String selectValue)
	{
		WebDriverWait wait = new WebDriverWait(Browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id='react-autowhatever-1']//li)[last()]")));
		
		List<WebElement> allcountry =Browser.findElements(By.xpath("//*[@id='react-autowhatever-1']//li"));
	
		for (WebElement eachElement : allcountry)
		{
			String Code = eachElement.findElement(By.cssSelector("div[class^='font14']")).getText();
			System.out.println(Code);
			if(Code.equalsIgnoreCase(selectValue))
			{
				eachElement.click();
				break;
			}
		}
	}
	
	public String GetSameCityError()
	{
		return WebelementCommons.GetText(Browser.findElement(By.xpath("//*[@data-cy='sameCityError']")));
		
	}
	


}
