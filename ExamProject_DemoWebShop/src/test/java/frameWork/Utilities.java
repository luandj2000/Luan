package frameWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

public class Utilities extends BasePage {
	public void takeSnapShot(String fileWithPath) throws IOException {
		// convert web driver object to TakeScreenshot
		TakesScreenshot screenShot = ((TakesScreenshot)driver);
		
		//call get Screenshot as a method to create image file
		File scrFile = screenShot.getScreenshotAs(OutputType.FILE);
		// move the image file to the new destination
		File destFile = new File("target//" + "surefire-reports-" 
		+ getAppConfigProperties("build.timestamp") + "//image//" + fileWithPath);
		
		// copy file
		FileUtils.copyFile(scrFile,  destFile);
		
		// update the pdf report with the screenshot
		Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='"
		+ destFile.getAbsolutePath() +"'height='200' width='200'/> </a>" );
		
	}

	// Method to return the time now
public String timereturn() {
	LocalDateTime now = LocalDateTime.now();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HHmmss");
	return dtf.format(now);
	}
	
	// get the property values from the app.properties

	public String getAppConfigProperties(String propertyName) {
		// Property set
		//System.out.println("in config")
		Properties p = new Properties();
		InputStream is = null;
		try {
			is = new FileInputStream(".\\target\\app.properties");
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			p.load(is);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return p.getProperty(propertyName);
	}
	
	//method to create an output file for
	
	public void resetOutPutFile(String outputFileName) {
		try {
			FileWriter myObj = new FileWriter(outputFileName,false);
		
		}catch(IOException e) {
			System.out.println("An error occured");
			e.printStackTrace();
			
		}
	}
}
