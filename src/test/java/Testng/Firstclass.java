package Testng;

import java.io.IOException;

import org.testng.annotations.*;

public class Firstclass {

	@Test(priority=2,invocationCount=5,invocationTimeOut=60,dependsOnMethods="thirdTestcase",groups="Sanity")
	public void firstTestcase() throws IOException
	{
		System.out.println("first Class");
		throw new IOException("Error");
	}
	
	@Test(priority=0,enabled=false,groups="SIT")
	public void secondTestcase() throws IOException
	{
		System.out.println("second Class");

	}
	

	@Test(priority=1,timeOut=60,groups="SIT")
	public void thirdTestcase() throws IOException
	{
		System.out.println("Third Class");
		throw new IOException("Error");
	}
	
	@Test(priority=3,timeOut=60,groups={"Sanity","SIT"})
	public void fifthTestcase() throws IOException
	{
		System.out.println("Fifth Class");
		//throw new IOException("Error");
	}
	
	@BeforeMethod
	public void BeforeMethod()
	{
		System.out.println("Before Method");
	}
	
	@AfterMethod
	public void AfterMethod()
	{
		System.out.println("After Method");
	}
	
	
	@BeforeClass(alwaysRun=true)
	public void BeforeClass()
	{
		System.out.println("Before Class");
	}
	
	@AfterClass
	public void AfterClass()
	{
		System.out.println("After Class");
	}
	
	@BeforeTest
	public void BeforeTest()
	{
		System.out.println("Before Test");
	}
	
	@AfterSuite
	public void AfterSuite()
	{
		System.out.println("After Suite");
	}
}
