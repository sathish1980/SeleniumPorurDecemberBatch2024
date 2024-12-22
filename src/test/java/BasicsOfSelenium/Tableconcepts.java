package BasicsOfSelenium;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Tableconcepts {
	
	public void wtableimplementation(String expectedCountry) throws InterruptedException, AWTException
	{
		WebDriver browser = new EdgeDriver(); //open the browser
		browser.manage().window().maximize(); //maximize
		
		browser.get("https://leafground.com/table.xhtml"); //Enter url
		
		//pagination
		//List<WebElement> allpages= browser.findElements(By.xpath("//*[@class='ui-paginator-pages']//a"));
		
		String allpages= browser.findElement(By.xpath("//*[@class='ui-paginator-pages']//a[last()]")).getText();
		int totalPagination = Integer.parseInt(allpages);
		//for(int j=1;j<=allpages.size();j++)
		for(int j=1;j<=totalPagination;j++)
		{
			//browser.findElement(By.xpath("//*[@class='ui-paginator-pages']//a["+j+"]")).click();
			browser.findElement(By.xpath("//*[@aria-label='Next Page']")).click();
			Thread.sleep(2000);
			
		
		//total rows
		List<WebElement> allrows = browser.findElements(By.xpath("//table//tbody[@id='form:j_idt89_data']//tr"));
		for(int i=1;i<=allrows.size();i++)
		{
			// fetch each country in that page
			String actualCountry = browser.findElement(By.xpath("//table//tbody[@id='form:j_idt89_data']//tr["+i+"]//td[2]//span[starts-with(@style,'vertical-align')]")).getText();
			
			//compate actual country vs expected country
			if(expectedCountry.equalsIgnoreCase(actualCountry))
			{
				// perform operation
				String name = browser.findElement(By.xpath("//table//tbody[@id='form:j_idt89_data']//tr["+i+"]//td[3]//span[starts-with(@style,'vertical-align')]")).getText();
				System.out.println(name);
			}
		}
		}
	}

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		Tableconcepts T = new Tableconcepts();
		T.wtableimplementation("India");
	}

}
