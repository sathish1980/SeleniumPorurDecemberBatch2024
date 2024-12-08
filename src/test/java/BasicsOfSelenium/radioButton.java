package BasicsOfSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class radioButton {
	
	
	public void radioButtonimplementation() throws InterruptedException
	{
		
			WebDriver browser = new EdgeDriver(); //open the browser
			browser.manage().window().maximize(); //maximize
			
			browser.get("https://leafground.com/radio.xhtml"); //Enter url
			browser.findElement(By.xpath("(//*[@id='j_idt87:console1']//*[starts-with(@class,'ui-radiobutton-icon')])[4]")).click();
			
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		radioButton C = new radioButton();
		C.radioButtonimplementation();
	}

}
