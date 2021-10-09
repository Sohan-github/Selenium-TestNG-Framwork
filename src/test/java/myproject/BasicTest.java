package myproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BasicTest {

	public static WebDriver driver = null;
	//public static String browser = "chrome";

	@Parameters({"browser"})
	@BeforeSuite
	public void loginbrowser(String browser) {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.acceptInsecureCerts();
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();

			ChromeOptions cOption = new ChromeOptions();
			cOption.merge(dc);
			driver = new ChromeDriver(cOption);

		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions fOption = new FirefoxOptions();
			fOption.merge(dc);
			driver = new FirefoxDriver(fOption);
		}
	}

	@AfterSuite
	public void closeBrowser() {
		driver.close();
	}

}
