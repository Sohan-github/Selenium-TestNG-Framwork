package myproject;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestingE2EUIPage extends Screenshot {

	
	@Test
	public static void handlingWindow() throws IOException {

		driver.get("https://www.salesforce.com/in/?ir=1");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id='globalnavbar-header-container']/div[3]/div/div/div/a/span")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();
		String parentWindow = iterator.next();
		String childWindow = iterator.next();

		driver.switchTo().window(childWindow);
		WebElement firstName = driver.findElement(By.name("UserFirstName"));
		WebElement lastName = driver.findElement(By.name("UserLastName"));
		WebElement workEmail = driver.findElement(By.name("UserEmail"));
		WebElement company = driver.findElement(By.name("CompanyName"));
		WebElement phone = driver.findElement(By.name("UserPhone"));
		firstName.sendKeys("Sohan");
		lastName.sendKeys("Dubey");
		workEmail.sendKeys("coolsohan007@gmail.com");
		company.sendKeys("Tata Consultancy services");
		phone.sendKeys("9162829542");

		WebElement jobTitle = driver.findElement(By.name("UserTitle"));
		Select jobtitlevalue = new Select(jobTitle);
		System.out.println(jobtitlevalue.getFirstSelectedOption().getText());
		jobtitlevalue.selectByValue("Marketing_PR_Manager_AP");

		WebElement employees = driver.findElement(By.xpath("//*[@name='CompanyEmployees']"));
		Actions action = new Actions(driver);
		action.moveToElement(employees);
		action.perform();
		Select companyValue = new Select(employees);
		System.out.println(companyValue.getFirstSelectedOption().getText());
		// companyValue.selectByValue("250");
		companyValue.selectByVisibleText("101 - 500 employees");

		WebElement country = driver.findElement(By.name("CompanyCountry"));
		action.moveToElement(country);
		action.perform();
		Select countryValue = new Select(country);
		countryValue.selectByValue("AS");

		WebElement statement = driver.findElement(By.xpath("//*[@id='Accept_Terms__c-ehPF-cbxLbl']"));
		action.moveToElement(statement);
		action.perform();
		Screenshot sc= new Screenshot();
		sc.getScreenshot();
		
		
		
		driver.switchTo().window(parentWindow);
		driver.close();
		

	}

}
