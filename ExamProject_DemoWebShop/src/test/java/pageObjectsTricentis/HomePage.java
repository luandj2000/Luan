package pageObjectsTricentis;

import org.openqa.selenium.By;

import frameWork.BasePage;

public class HomePage extends BasePage {

	// searches on any top menu bar item
	public void searchByTopMenuBarItem(String item){
		clickElement(By.linkText(item));
	}
	

	
}
