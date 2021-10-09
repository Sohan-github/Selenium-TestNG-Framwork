package readwritefile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class RWFile {

	@Test
	public static void readwriteFile() throws IOException {
		
		Properties pr= new Properties();
		FileInputStream input= new FileInputStream("D:\\Workspace\\DipuSelenium\\src\\test\\resources\\testdata.properties");
		pr.load(input);
		System.out.println(pr.getProperty("browser"));
		System.out.println(pr.getProperty("url"));
		
		FileOutputStream output= new FileOutputStream("D:\\Workspace\\DipuSelenium\\src\\test\\resources\\testdata.properties");
		pr.setProperty("CustID", "123456");
		pr.setProperty("CustName", "Sohan Dubey");
		pr.setProperty("Address", "Buxar");
		pr.store(output, "This is for testing");

	}

}
