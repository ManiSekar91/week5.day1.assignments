package week5.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowBase {
	
	public ChromeDriver driver;
	
	@BeforeMethod
public void preCondition() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://dev81233.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement frame = driver.findElement(By.xpath("//iframe[@id = 'gsft_main']"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//input[@id = 'user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id = 'user_password']")).sendKeys("Manisel@91");
		driver.findElement(By.id("sysverb_login")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//input[@id = 'filter']")).sendKeys("Incident", Keys.ENTER);

}
	@AfterMethod
	public void postCondition() {
		driver.close();
	}
}
