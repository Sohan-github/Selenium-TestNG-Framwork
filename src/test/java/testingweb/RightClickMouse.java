package testingweb;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickMouse {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/slider/#colorpicker");
		driver.manage().window().maximize();
		WebElement frmae = driver.findElement(By.xpath("//*[@id='content']/iframe"));
		driver.switchTo().frame(frmae);
		
		WebElement rightclick = driver.findElement(By.xpath("//*[@id=\"swatch\"]"));

		Actions action = new Actions(driver);
		action.contextClick(rightclick).perform();
		driver.close();
		

	}

}
