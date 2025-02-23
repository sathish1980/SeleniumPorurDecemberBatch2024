package Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.Status;

import Browsers.BrowserDriver;
import CommonElements.WebelementCommons;
import Pages.FlightSearchPage;
import Pages.FlightSearchResultPage;
import Utils.ExcelfileRead;
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
		test = extent.createTest("SearchWithValidValues Testcase");
		F.ClickFromLocationdropdown();
		test.log(Status.INFO, "From dropdown is selected");
		F.SelectFromLocation("BKK");
		test.log(Status.INFO, "From dropdown is selected as : BKK");
		F.ClickToLocationdropdown();
		test.log(Status.INFO, "To dropdown is selected");
		F.SelectToLocation("PNQ");
		test.log(Status.INFO, "To dropdown is selected as : PNQ");
		F.SelectDate("20");
		test.log(Status.INFO, "Date is selected as 20");
		F.clickOnSearchbutton();
		test.log(Status.INFO, "Search button is clicked");
		FlightSearchResultPage Fs = new FlightSearchResultPage(browser);
		String actualText =Fs.GetsearchResult();
		String expectedText ="NETWORK PROBLEM";
		Assert.assertEquals(actualText, expectedText);
		test.log(Status.INFO, "Validation sucess");
		test.log(Status.PASS, "Valid search test cases are passed");
	}

	
	@Test(priority=1)
	public void FlightSearchWithSameCityTestcase() throws InterruptedException
	{
		System.out.println("Test case 2");
		test = extent.createTest("SearchWithinValidValues Testcase");
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
		test.log(Status.INFO, "From dropdown is selected");
		F.SelectFromLocation("BKK");
		test.log(Status.INFO, "From dropdown is selected as : BKK");
		F.ClickToLocationdropdown();
		test.log(Status.INFO, "To dropdown is selected");
		F.SelectToLocation("BKK");
		test.log(Status.INFO, "to dropdown is selected as: BKK ");
		
		String actualText =F.GetSameCityError();
		String expectedText ="From & To airports cannot be the same";
		Assert.assertEquals(actualText, expectedText);
	}
	
	@Test(priority=2,dataProvider="fightSearch",dataProviderClass=DataProviderAnnotations.class)
	public void ValidFlightSearchTestcaseWithDD(String from,String to,String date) throws InterruptedException
	{
		System.out.println("Test case 3");
		test = extent.createTest("SearchWithValidValues Testcase by DD");
		/*
		 * Select From value
		 * Select to value
		 * Select date
		 * Click on search
		 * Validate the search result
		 */
		FlightSearchPage F = new FlightSearchPage(browser);
		F.ClickFromLocationdropdown();
		test.log(Status.INFO, "From dropdown is selected");
		F.SelectFromLocation(from);
		test.log(Status.INFO, "From dropdown is selected as : "+from);
		F.ClickToLocationdropdown();
		test.log(Status.INFO, "To dropdown is selected");
		F.SelectToLocation(to);
		test.log(Status.INFO, "To dropdown is selected as : "+to);
		F.SelectDate(date);
		test.log(Status.INFO, "Date is selected as : "+date);
		F.clickOnSearchbutton();
		test.log(Status.INFO, "Search Button is clicked");
		FlightSearchResultPage Fs = new FlightSearchResultPage(browser);
		String actualText =Fs.GetsearchResult();
		String expectedText ="NETWORK PROBLEM";
		Assert.assertEquals(actualText, expectedText);
		test.log(Status.INFO, "validation is passed: " +actualText);
		F.ClickOnBack(browser);
	}

	@Test(priority=3,dataProvider="GetinValidData",dataProviderClass=DataProviderAnnotations.class)
	public void FlightSearchWithSameCityTestcasewithDD(String from, String to) throws InterruptedException
	{
		System.out.println("Test case 4");
		
		/*
		 * Select From value
		 * Select to value
		 * Select date
		 * Click on search
		 * Validate the search result
		 */
		FlightSearchPage F = new FlightSearchPage(browser);
		test = extent.createTest("SearchWithinValidValues Testcase DD");
		//F.ClickOnBack(browser);
		F.ClickFromLocationdropdown();
		test.log(Status.INFO, "From dropdown is selected");
		F.SelectFromLocation(from);
		test.log(Status.INFO, "From dropdown is selected as : "+from);
		F.ClickToLocationdropdown();
		test.log(Status.INFO, "To dropdown is selected");
		F.SelectToLocation(to);
		test.log(Status.INFO, "To dropdown is selected as : "+to);
		
		String actualText =F.GetSameCityError();
		String expectedText ="From & To airports cannot be the same";
		Assert.assertEquals(actualText, expectedText);
		test.log(Status.INFO, "Same city validation passed : "+actualText);
	}
	
	@AfterSuite
	public void teardown()
	{
		CloseReport();
		CloseTheBrowser();
	}
	
	
	@AfterMethod
	public void WriteInReport(ITestResult result) throws IOException
	{
		if (result.getStatus()==ITestResult.SUCCESS) {
			String filePath = WebelementCommons.GetScreenshot(browser,result.getName());
		     test.log(Status.INFO,test.addScreenCaptureFromPath(filePath).toString());
            test.log(Status.PASS,"Test Method named as : "+ result.getName()+" is passed");

        }else if(result.getStatus()==ITestResult.FAILURE) {
            test.log(Status.PASS,"Test Method named as : "+ result.getName()+" is FAILED");
            String filePath = WebelementCommons.GetScreenshot(browser,result.getName());
            test.log(Status.INFO,test.addScreenCaptureFromPath(filePath).toString());
            test.log(Status.FAIL,"Test failure : "+ result.getThrowable());
        }
        else if(result.getStatus()==ITestResult.SKIP) {
            test.log(Status.SKIP,"Test Method named as : "+ result.getName()+" is skipped");
        }
	}
	
	
}
