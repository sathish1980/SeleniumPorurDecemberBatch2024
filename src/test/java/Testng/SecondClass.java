package Testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.*;

public class SecondClass {
	
	
	@AfterClass
	public void AfterClass()
	{
		System.out.println("After Class");
	}
	@Test
	public void fourthTEstcase()
	{
		System.out.println("FourtTestcase");
	}
	
	@AfterTest
	public void AfterTest()
	{
		System.out.println("After Test");
	}
	
	@BeforeSuite
	public void BeforeSuite()
	{
		System.out.println("Before Suite");
	}

}
