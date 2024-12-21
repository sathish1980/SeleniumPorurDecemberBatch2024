package BasicsOfSelenium;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsConcepts {
	
	public void alertsimplementation() throws InterruptedException, AWTException
	{
		WebDriver browser = new EdgeDriver(); //open the browser
		browser.manage().window().maximize(); //maximize
		
		browser.get("https://leafground.com/alert.xhtml"); //Enter url
		browser.findElement(By.id("j_idt88:j_idt91")).click();
		browser.switchTo().alert().accept();
		WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("simple_result")));
		
		String name = browser.findElement(By.id("simple_result")).getText();
		System.out.println(name);
		
		browser.findElement(By.id("j_idt88:j_idt93")).click();
		browser.switchTo().alert().dismiss();
		//WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("result")));
		
		String name1 = browser.findElement(By.id("result")).getText();
		System.out.println(name1);
		
		
		browser.findElement(By.id("j_idt88:j_idt104")).click();
		Alert al = browser.switchTo().alert();
		System.out.println(al.getText());
		al.sendKeys("Besant");
		al.accept();
		//WebDriverWait wait = new WebDriverWait(browser,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("confirm_result")));
		
		String name2 = browser.findElement(By.id("confirm_result")).getText();
		System.out.println(name2);
	}

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		AlertsConcepts A = new AlertsConcepts();
		A.alertsimplementation();
	}

}
