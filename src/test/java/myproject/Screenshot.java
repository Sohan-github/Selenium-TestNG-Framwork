package myproject;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

@Test
public class Screenshot extends BasicTest  {
		
	
	public void getScreenshot() throws IOException {
		Date date = new Date();
		
		String screenshotName= date.toString().replace("", "-").replace(":", "-");
		
		File screenshot= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//src/screenshot_sohan/"+screenshotName+".png"));
	}

}
