package testingweb;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlingsDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/in/?ir=1");
		driver.manage().window().maximize();

		driver.findElement(
				By.xpath("//*[@id='main']/div[1]/div/div/div/div[2]/div[1]/div[1]/div[3]/div/div[1]/div/a/span"))
				.click();

		Set<String> windowhandles = driver.getWindowHandles();
		System.out.println(windowhandles);
		Iterator<String> iterator = windowhandles.iterator();
		String parentwindow = iterator.next();
		System.out.println("parentwindow: "+parentwindow);
		String childwindow = iterator.next();
		System.out.println("childwindow: "+childwindow);

		driver.switchTo().window(childwindow);

		driver.findElement(By.name("UserFirstName")).sendKeys("Mohan");
		driver.findElement(By.name("UserLastName")).sendKeys("Dubey");
		Thread.sleep(2000);

		driver.switchTo().window(parentwindow);

		driver.close();

	}

}
