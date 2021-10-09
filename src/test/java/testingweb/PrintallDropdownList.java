package testingweb;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintallDropdownList {
	public static String browser = "chrome";
	public static WebDriver driver;

	public static void main(String[] args) {

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		List<WebElement> dropdownList = driver.findElements(By.xpath("//*[@id=\"CompanyCountry-xSf6\"]"));
		int totaldropdownlist= dropdownList.size();
		System.out.println("Total options are: " +totaldropdownlist);
		for (int i = 0; i < totaldropdownlist; i++) {
			//System.out.println("All Links on page are(): " + dropdownList.get(i).getAttribute("name"));
			System.out.println("All Links on page are(): " + dropdownList.get(i).getText());
			driver.close();
		}

	}

}
