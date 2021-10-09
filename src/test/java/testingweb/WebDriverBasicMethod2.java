package testingweb;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverBasicMethod2 {
	public static String browser = "chrome";
	public static WebDriver driver;

	public static void main(String[] args) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		String currenturl = driver.getCurrentUrl();
		System.out.println("currenturl of page: " + currenturl);
		String Pagetitle = driver.getTitle();
		System.out.println("pagetitle= " + Pagetitle);
		String pagesource = driver.getPageSource();
		System.out.println("page source: " + pagesource);

		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		List<WebElement> WebElements = driver.findElements(By.xpath("//*[@class='inventory_item']"));
		System.out.println("WebElements: " + WebElements);

		driver.navigate().to("https://www.sugarcrm.com/au/");
		driver.manage().deleteAllCookies();
		String Windowhandle = driver.getWindowHandle();
		System.out.println("Windowhandle: " + Windowhandle);
		driver.findElement(By.xpath("//*[@id='mega-menu-item-44']/a/span")).click();
		driver.manage().deleteAllCookies();
		Set<String> Windowhandles = driver.getWindowHandles();
		System.out.println("Windowhandles: " + Windowhandles);
		driver.close();
	}

}
