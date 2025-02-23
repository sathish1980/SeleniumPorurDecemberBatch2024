package Browsers;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utils.PropertyFileRead;

public class BrowserDriver {
	
	public static WebDriver browser;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	//helps to generate the logs in test report.
	public static ExtentTest test;
	
	String filePath = System.getProperty("user.dir")+"\\Report\\BesantSeleniumAutomation.html";
	
	public void OpenTheBrowser() throws IOException
	{
		String browerName = PropertyFileRead.GetDataFromPropFile().getProperty("browser");
		if(browerName.equalsIgnoreCase("edge")) {
			EdgeOptions option = new EdgeOptions();
			option.addArguments("--headless");
		browser = new EdgeDriver(option); //open the browser
		
		}
		else if(browerName.equalsIgnoreCase("chrome")) {
			browser = new ChromeDriver(); //open the browser

			}
		browser.manage().window().maximize(); //maximize
		CreateorStartReport();
		
	}
	
	public void CreateorStartReport()
	{
		htmlReporter = new ExtentSparkReporter(filePath);
	    extent = new ExtentReports();
	    extent.attachReporter(htmlReporter);
	}
	
	
	public void CloseReport()
	{
		extent.flush();
	}
	
	public void CloseTheBrowser()
	{
		browser.quit();
	}

}
