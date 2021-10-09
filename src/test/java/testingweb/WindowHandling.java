package testingweb;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {
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

		driver.get("https://www.salesforce.com/in/?ir=1");
		driver.manage().window().maximize();
		driver.findElement(
				By.xpath("//*[@id=\"main\"]/div[1]/div/div/div/div[2]/div[1]/div[1]/div[3]/div/div[1]/div/a/span"))
				.click();
		Thread.sleep(2000);
		Set<String> windowhandles= driver.getWindowHandles();
		System.out.println(windowhandles);
		Iterator<String> iterator= windowhandles.iterator();
		String parentsWindow= iterator.next();
		System.out.println("parentsWindow: "+parentsWindow);
		String childWindow= iterator.next();
		System.out.println("childWindow: "+childWindow);
		
		driver.switchTo().window(childWindow);
		
		
		driver.findElement(By.name("UserFirstName")).sendKeys("Sohan");
		driver.findElement(By.name("UserLastName")).sendKeys("Dubey");
		driver.switchTo().window(parentsWindow);
		Thread.sleep(2000);
		driver.close();
	}

}
