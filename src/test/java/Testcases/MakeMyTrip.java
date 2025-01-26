package Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import Browsers.BrowserDriver;
import Pages.FlightSearchPage;
import Pages.FlightSearchResultPage;
import Utils.PropertyFileRead;

public class MakeMyTrip extends BrowserDriver {
	
	
	@BeforeSuite
	public void LaunchTheBrowser() throws IOException
	{
		OpenTheBrowser();
	}
	
	@BeforeTest
	public void LauchTheApplication() throws IOException
	{
		String url = PropertyFileRead.GetDataFromPropFile().getProperty("url");
		browser.get(url);
	}
	
	@BeforeClass
	public void CloseLoginPopup() throws InterruptedException
	{
		
		FlightSearchPage F = new FlightSearchPage(browser);
		F.ClosePopup();
	}
	
	
	@Test(priority=0)
	public void ValidFlightSearchTestcase() throws InterruptedException
	{
		System.out.println("Test case 1");
		
		/*
		 * Select From value
		 * Select to value
		 * Select date
		 * Click on search
		 * Validate the search result
		 */
		FlightSearchPage F = new FlightSearchPage(browser);
		F.ClickFromLocationdropdown();
		F.SelectFromLocation("BKK");
		F.ClickToLocationdropdown();
		F.SelectToLocation("PNQ");
		F.SelectDate("20");
		F.clickOnSearchbutton();
		FlightSearchResultPage Fs = new FlightSearchResultPage(browser);
		String actualText =Fs.GetsearchResult();
		String expectedText ="NETWORK PROBLEM";
		Assert.assertEquals(actualText, expectedText);
	}

	
	@Test(priority=1)
	public void FlightSearchWithSameCityTestcase() throws InterruptedException
	{
		System.out.println("Test case 2");
		
		/*
		 * Select From value
		 * Select to value
		 * Select date
		 * Click on search
		 * Validate the search result
		 */
		FlightSearchPage F = new FlightSearchPage(browser);
		F.ClickOnBack(browser);
		F.ClickFromLocationdropdown();
		F.SelectFromLocation("BKK");
		F.ClickToLocationdropdown();
		F.SelectToLocation("BKK");
		
		String actualText =F.GetSameCityError();
		String expectedText ="From & To airports cannot be the same";
		Assert.assertEquals(actualText, expectedText);
	}

	
	@AfterSuite
	public void teardown()
	{
		CloseTheBrowser();
	}
}
