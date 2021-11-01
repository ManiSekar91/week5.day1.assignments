package week5.day1.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AssignIncident extends ServiceNowBase {
@Test
	
		public void assignIncident() throws InterruptedException {
			
			
			driver.findElement(By.xpath("//div[text() = 'Open']")).click();
			WebElement frame1 = driver.findElement(By.xpath("//iframe[@id = 'gsft_main']"));
			driver.switchTo().frame(frame1);
			
			driver.findElement(By.xpath("//input[@class = 'form-control']")).sendKeys("INC0010019", Keys.ENTER);
			driver.findElement(By.xpath("//tbody[@class = 'list2_body']/tr/td[3]/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@id = 'lookup.incident.assignment_group']")).click();
			
			Set<String> winset = driver.getWindowHandles();
			List<String> winlist = new ArrayList<String>(winset);
			driver.switchTo().window(winlist.get(1));
			
			Thread.sleep(2000);
			WebElement search = driver.findElement(By.xpath("//input[@class = 'form-control']"));
			search.sendKeys("Software", Keys.ENTER);
			driver.findElement(By.xpath("//a[text()='Software']")).click();
			
			Set<String> winset1 = driver.getWindowHandles();
			List<String> winlist1 = new ArrayList<String>(winset1);
			driver.switchTo().window(winlist1.get(0));
			
			driver.switchTo().frame(frame1);
			
			driver.findElement(By.xpath("//button[@id = 'sysverb_update']")).click();
		
			String str = driver.findElement(By.xpath("(//td[@class = 'vt']/a)[3]")).getText();
			
			if (str.contains("Software")) {
				System.out.println("Assignment group has been created Successfully");
				
			}else {
				System.out.println("Assignment group hasn't created");
			}
		}

}
