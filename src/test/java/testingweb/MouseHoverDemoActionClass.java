package testingweb;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverDemoActionClass {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.ebay.com.au/");
		driver.manage().window().maximize();
		WebElement electronics = driver.findElement(By.xpath("//*[@id='mainContent']/div[1]/ul/li[3]/a"));

		Actions action = new Actions(driver);
		action.moveToElement(electronics).perform();

		driver.findElement(By.xpath("//*[@id='mainContent']/div[1]/ul/li[3]/div[2]/div[1]/nav[1]/ul/li[3]/a")).click();
		System.out.println(driver.getTitle());

	}

}
