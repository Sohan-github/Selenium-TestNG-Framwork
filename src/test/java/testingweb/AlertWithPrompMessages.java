package testingweb;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertWithPrompMessages {
	
	@Test
	public void alertMessage() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();

		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().window().maximize();
		WebElement frame1 = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("/html/body/button")).click();
		// Java Script alert
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("SOHAN");
		alert.accept();
		WebElement message= driver.findElement(By.xpath("//*[@id='demo']"));
		System.out.println(message.getAttribute("demo%"));
		// Switching Parent Frame
		driver.switchTo().parentFrame();
		System.out.println(driver.getTitle());
		driver.close();

	}

}
