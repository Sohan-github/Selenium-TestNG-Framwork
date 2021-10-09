package testingweb;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenshot {

	public static void main(String[] args) throws IOException {
		Date currentdate= new Date();
		//System.out.println(currentdate);
		String Screenshotfilename= currentdate.toString().replace(" ", "-").replace(":", "-");
		System.out.println(Screenshotfilename);
	
		
		  WebDriverManager.chromedriver().setup(); ChromeDriver driver= new
		  ChromeDriver(); driver.get("https://google.com");
		  
		  
		  File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
		  FileUtils.copyFile(screenshotFile, new File(".//Screenshot1/"+Screenshotfilename+".png"));
		 driver.close();
		

	}

}
