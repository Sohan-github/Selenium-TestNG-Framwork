package testingweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropdown {
	public static String browser = "chrome";
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

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

		driver.get("https://www.sugarcrm.com/au/request-demo/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// driver.findElement(By.xpath("//*[@id='user-form-template-230']/div/div[9]")).click();

		WebElement dropdown = driver.findElement(By.name("employees_c"));
		Select s = new Select(dropdown);
		WebElement firstoption = s.getFirstSelectedOption();

		System.out.println(firstoption.getText());

		s.selectByValue("level1");
		Thread.sleep(2000);
		s.selectByVisibleText("51 - 100 employees");
		Thread.sleep(2000);
		s.selectByIndex(5);
		driver.close();

	}

}
