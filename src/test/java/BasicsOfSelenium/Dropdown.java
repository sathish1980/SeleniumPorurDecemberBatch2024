package BasicsOfSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
	
	public void Dropdownimplementation() throws InterruptedException
	{
		
			WebDriver browser = new EdgeDriver(); //open the browser
			browser.manage().window().maximize(); //maximize
			
			browser.get("https://leafground.com/select.xhtml"); //Enter url
			WebElement uiTools =browser.findElement(By.cssSelector("[class='ui-selectonemenu']"));
			Select uiToolSelection = new Select(uiTools);
			System.out.println(uiToolSelection.isMultiple());
			uiToolSelection.selectByIndex(2);
			Thread.sleep(1000);
			uiToolSelection.selectByVisibleText("Cypress");
			//uiToolSelection.selectByContainsVisibleText("")
			
			// if multiple values are selected then we can deslect by below methods
			if(uiToolSelection.isMultiple())
			{
			uiToolSelection.deselectAll();
			uiToolSelection.deselectByIndex(0);
			uiToolSelection.deselectByValue("");
			uiToolSelection.deselectByVisibleText("");
			}
			
					
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Dropdown D = new Dropdown();
		D.Dropdownimplementation();
	}

}
