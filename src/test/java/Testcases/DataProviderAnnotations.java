package Testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import Utils.ExcelfileRead;

public class DataProviderAnnotations {
	@DataProvider(name="fightSearch")
	public Object[][] GetValidData() throws IOException
	{
		return ExcelfileRead.ExcelRead("validData");
	}
	
	@DataProvider
	public Object[][] GetinValidData() throws IOException
	{
		return ExcelfileRead.ExcelRead("invalidData");
	}
}
