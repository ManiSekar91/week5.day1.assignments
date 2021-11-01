package week5.day1.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UpdateIncident extends ServiceNowBase {
	@Test

	public void updateIncident() throws InterruptedException {
		
		driver.findElement(By.xpath("//tbody[@class = 'list2_body']/tr/td[3]/a")).click();
	WebElement urgency = driver.findElement(By.xpath("//select[@id = 'incident.urgency']"));
	Select sel = new Select(urgency);
	sel.selectByVisibleText("1 - High");
	
	WebElement state = driver.findElement(By.xpath("//select[@id = 'incident.state']"));
	Select sel1 = new Select(state);
	sel1.selectByVisibleText("In Progress");
	driver.findElement(By.xpath("//button[@value = 'sysverb_update']")).click();
	}

}
