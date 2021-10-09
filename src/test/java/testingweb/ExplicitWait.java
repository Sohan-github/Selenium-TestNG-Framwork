package testingweb;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {
	

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.ebay.com.au/");
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement electronics = driver.findElement(By.xpath("//*[@id='mainContent']/div[1]/ul/li[3]/a"));

		Actions action = new Actions(driver);
		action.moveToElement(electronics).perform();
//Explicit Wait time out
		WebDriverWait wait = new WebDriverWait(driver, 10);
//WebDriverWait wait= new WebDriverWait(driver, timeOutInSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='mainContent']/div[1]/ul/li[3]/div[2]/div[1]/nav[1]/ul/li[3]/a"))).click();

		System.out.println(driver.getTitle());
		driver.close();

	}

}
