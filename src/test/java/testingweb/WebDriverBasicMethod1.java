package testingweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverBasicMethod1 {
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
		driver.navigate().to("https://google.com");
		driver.close();
	}

}
