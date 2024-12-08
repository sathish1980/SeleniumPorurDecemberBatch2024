package BasicsOfSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkbox {
	
	
	public void checkboximplementation() throws InterruptedException
	{
		
			WebDriver browser = new EdgeDriver(); //open the browser
			browser.manage().window().maximize(); //maximize
			
			browser.get("https://leafground.com/checkbox.xhtml"); //Enter url
			browser.findElement(By.xpath("//*[@id='j_idt87:j_idt89']//*[starts-with(@class,'ui-chkbox-box')]")).click();
			Thread.sleep(1000);
			String checkboxcclassname = browser.findElement(By.xpath("//*[@id='j_idt87:j_idt89']//*[starts-with(@class,'ui-chkbox-box')]")).getAttribute("class");
			System.out.println(checkboxcclassname);
			if(checkboxcclassname.contains("ui-state-active"))
			{
			browser.findElement(By.xpath("//*[@id='j_idt87:j_idt89']//*[starts-with(@class,'ui-chkbox-box')]")).click();
			}
			
			browser.findElement(By.className("ui-toggleswitch-slider")).click();
			WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-growl-message")));
			
			//Thread.sleep(1000);
			String name = browser.findElement(By.className("ui-growl-message")).getText();
			System.out.println(name);
			//WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
			//wait.until(ExpectedConditions.invisibilityOf(""));
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("")));
			
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Checkbox C = new Checkbox();
		C.checkboximplementation();
	}

}
