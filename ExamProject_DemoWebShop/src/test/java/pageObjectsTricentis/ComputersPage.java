package pageObjectsTricentis;

import org.openqa.selenium.By;

import frameWork.BasePage;

public class ComputersPage extends BasePage {

	public void selectComputerOptionByCategoryMenu(String computerOption) {
		if(computerOption.equalsIgnoreCase("Desktops")) {
			clickElement(By.cssSelector(".block-category-navigation [href='\\/desktops']"));
		}else if(computerOption.equalsIgnoreCase("NoteBooks")) {
			clickElement(By.cssSelector(".block-category-navigation [href='\\/notebooks']"));
		}else if(computerOption.equalsIgnoreCase("Accessories")) {
			clickElement(By.cssSelector(".block-category-navigation [href='\\/accessories']"));
		}
	}
	public void selectDesktopDisplayItem(String desktop) {
		clickElement(By.linkText(desktop));
	}
	
	
}
