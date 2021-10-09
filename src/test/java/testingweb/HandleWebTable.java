package testingweb;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleWebTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.cricbuzz.com/cricket-stats/icc-rankings/men/batting");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> rowlist = driver
				.findElements(By.xpath("//*[@id='page-wrapper']/div[3]/div[2]/div/div/div[1]/div"));
		System.out.println("Total Players: " + rowlist.size());
		// int rowsize = rowlist.size();
		int rowsize = 10;

		List<WebElement> columnlist = driver
				.findElements(By.xpath("//*[@id='page-wrapper']/div[3]/div[2]/div/div/div[1]/div[1]/div"));
		System.out.println("Total Columns: " + columnlist.size());
		int columnsize = columnlist.size();

		for (int i = 1; i <= rowsize; i++) {
			for (int j = 1; j <= columnsize; j++) {
				System.out.print(driver
						.findElement(By.xpath(
								"//*[@id=\"page-wrapper\"]/div[3]/div[2]/div/div/div[1]/div["+i+"]/div["+j+"]"))
						.getText() + " ");
			}
			System.out.println();
		}

		driver.close();

	}

}
