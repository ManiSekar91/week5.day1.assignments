package week5.day1.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateIncident extends ServiceNowBase {
	@Test

	public void createIncident() throws InterruptedException {
		
		driver.findElement(By.xpath("//div[text()='Create New']")).click();
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id = 'gsft_main']"));
		driver.switchTo().frame(frame2);
		String incidentnum = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println(incidentnum);
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		
		Set<String> winset = driver.getWindowHandles();
		List<String> winlist = new ArrayList<String>(winset);
		driver.switchTo().window(winlist.get(1));
		
		driver.findElement(By.xpath("//a[@class = 'glide_ref_item_link']")).click();
		
		Set<String> winset1 = driver.getWindowHandles();
		List<String> winlist1 = new ArrayList<String>(winset1);
		driver.switchTo().window(winlist1.get(0));
		
		driver.switchTo().frame(frame2);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id = 'incident.short_description']")).sendKeys("Selenium Learning");
		driver.findElement(By.xpath("//button[@class = 'form_action_button  action_context btn btn-default']")).click();
		
		driver.findElement(By.xpath("//input[@class = 'form-control']")).sendKeys(incidentnum, Keys.ENTER);
	 String incidentnum2 = driver.findElement(By.xpath("//tbody[@class = 'list2_body']/tr/td[3]/a")).getText();
		System.out.println(incidentnum2);
		if (incidentnum.equals(incidentnum2)) {
			System.out.println("The Incident has been Created");
		
	}else {
		
	System.out.println("The Incident hasn't Created");
	
	} driver.close();
	}
}
