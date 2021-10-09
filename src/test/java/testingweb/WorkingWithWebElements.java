package testingweb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithWebElements {
	public static String browser = "firefox";
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

		driver.get("https://www.sugarcrm.com/au/request-demo/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("firstname")).sendKeys("Sohan");
		driver.findElement(By.name("firstname")).clear();
		System.out.println(driver.findElement(By.name("firstname")).getAttribute("class"));
		System.out.println(driver.findElement(By.xpath("//*[@id='field1']/div/input")).getCssValue("text-transform"));
		System.out.println(driver.findElement(By.xpath("//*[@id='field1']/div/input")).getSize());
		System.out.println(driver.findElement(By.xpath("//*[@id='field1']/div/input")).getLocation());
		System.out.println(driver.findElement(By.xpath("//*[@id='main']/div[2]/div/div[3]/div/div/div[1]/h2")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@id='field1']/div/input")).getTagName());
		System.out.println(driver.findElement(By.xpath("//*[@id='field1']/div/input")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//*[@id='field1']/div/input")).isEnabled());
		System.out.println(driver.findElement(By.xpath("//*[@id='field1']/div/input")).isSelected());
		
		driver.close();
		
		

	}

}
