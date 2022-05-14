package frameWork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public static WebDriver driver;

	public BasePage() {

		if (driver == null) {

			String browser = getDataConfigProperties("browser");
			String url = getDataConfigProperties("url");

			if (browser.equalsIgnoreCase("chrome")) {
				// Chrome setup
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get(url);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}else if (browser.equalsIgnoreCase("firefox")) {
				
				WebDriverManager.firefoxdriver().setup();
				// Firefox setup
				driver = new FirefoxDriver();
				driver.get(url);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}else if (browser.equalsIgnoreCase("edge")) {
				
				WebDriverManager.edgedriver().setup();
				// Edge setup
				driver = new EdgeDriver();
				driver.get(url);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
		}
	}

	// Read config file
	public String getDataConfigProperties(String propertyName) {

		Properties properties = new Properties();
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream("config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(propertyName);
	}
	
	//Wait for elements
		public void waitForElement(int elementWait, By pLocator) {
		WebDriverWait wait = new WebDriverWait(driver, elementWait);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(pLocator));
		}
		
		//Wait for click
		public void waitforClick(int elementWait, By pLocator) {
		WebDriverWait wait = new WebDriverWait(driver, elementWait);
		wait.until(ExpectedConditions.elementToBeClickable(pLocator));
		}
		
		//Wait for Url
		public void waitForUrl(int elementWait, String urlContainer) {
		WebDriverWait wait = new WebDriverWait(driver, elementWait);
		wait.until(ExpectedConditions.urlContains(urlContainer));
		}
		
		//Get element text
		public String getElementText(By pLocator) {
		String elementText = getElement(pLocator).getText();
		return elementText;
		}

		//Click element
		public void clickElement(By pLocator) {
			waitforClick(30, pLocator);
			getElement(pLocator).click();
			
		}
		
		//Check if element exists
		public boolean elementExists(By pLocator) {
			boolean display = getElement(pLocator).isDisplayed();
			return display;
		}
		
		//Get element
		public WebElement getElement(By pLocator) {
			waitforClick(30, pLocator);
			return driver.findElement(pLocator);
		}
		
		//Clean up
		public void cleanUp() {
			driver.quit();
			
		}
		
		//Enter text
		public void enterText(By pLocator, String searchText) {
			waitforClick(30, pLocator);
			driver.findElement(pLocator).sendKeys(searchText);
			
		}
		
		//Clear text
		public void clearText(By pLocator) {
			waitforClick(30, pLocator);
			driver.findElement(pLocator).clear();
		}
		
		//Select from drop-down
		public void selectDropDown(By pLocator, String pValue) {
			waitForElement(20,pLocator);
			Select sDropDown = new Select(getElement(pLocator));
			sDropDown.selectByVisibleText(pValue);
		}
		
		// Switch window
		public void switchToNewTab() {
			Set<String> handles = driver.getWindowHandles();													
			Iterator<String> it = handles.iterator(); 
			String parentWindowID = it.next();
			String childWindowID = it.next();
			driver.switchTo().window(childWindowID);
		}
		
		// Switch to parent window
		public void switchToParent() {
			Set<String> handles = driver.getWindowHandles();
															
			Iterator<String> it = handles.iterator(); 
			String parentWindowID = it.next();
			String childWindowID = it.next();
			driver.switchTo().window(parentWindowID); 
		}
		
		// closes child window tab
		public void closeChildBrowserTab() {
			Set<String> handles = driver.getWindowHandles();
			Iterator<String> it = handles.iterator();		
			String parentWindowID = it.next();				
			String childWindowID = it.next();
			driver.switchTo().window(childWindowID);
			driver.close();
			driver.switchTo().window(parentWindowID);
		}
		
		
}
