package week5.day1.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DeleteIncident extends ServiceNowBase {
	@Test

	public void deleteIncident() throws InterruptedException {
		
		driver.findElement(By.xpath("//div[text() = 'Incidents']")).click();
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id = 'gsft_main']"));
		driver.switchTo().frame(frame1);
		
		driver.findElement(By.xpath("//input[@class = 'form-control']")).sendKeys("INC0010020", Keys.ENTER);
		driver.findElement(By.xpath("//tbody[@class = 'list2_body']/tr/td[3]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text() = 'Delete']")).click();
		driver.findElement(By.xpath("//button[@id = 'ok_button']")).click();
		
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id = 'gsft_main']"));
		driver.switchTo().frame(frame2);
		
		String record = driver.findElement(By.xpath("//tbody[@class = 'list2_body']/tr/td")).getText();
		
		if (record.contains("No")) {
			System.out.println("The incident has been Deleted");
		}else {
			System.out.println("The incident hasn't Deleted");
		}
	}

}
