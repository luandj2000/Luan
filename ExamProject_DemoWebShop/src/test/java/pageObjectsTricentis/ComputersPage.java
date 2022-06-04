package pageObjectsTricentis;

import org.openqa.selenium.By;

import frameWork.BasePage;

public class ComputersPage extends BasePage {

	// selects a computer option through the category navigation menu.
	public void selectComputerOptionByCategoryMenu(String computerOption) {
		if (computerOption.equalsIgnoreCase("Desktops")) {
			clickElement(By.cssSelector(".block-category-navigation [href='\\/desktops']"));
		} else if (computerOption.equalsIgnoreCase("NoteBooks")) {
			clickElement(By.cssSelector(".block-category-navigation [href='\\/notebooks']"));
		} else if (computerOption.equalsIgnoreCase("Accessories")) {
			clickElement(By.cssSelector(".block-category-navigation [href='\\/accessories']"));
		}
	}

	// selects the requested desktop item.
	public void selectDesktopDisplayItem(String desktop) {
		clickElement(By.linkText(desktop));
	}

}
