package pageObjectsTricentis;

import org.openqa.selenium.By;

import frameWork.BasePage;

public class ElectronicsPage extends BasePage {

	// selects a specific electronic option (sub category)
	public void selectElectronicDisplayOption(String electronic) {
		if (electronic.equalsIgnoreCase("Camera, photo")) {
			clickElement(By.cssSelector(".sub-category-grid .item-box:nth-of-type(1) .picture a"));
		} else if (electronic.equalsIgnoreCase("Cell phones")) {
			clickElement(By.cssSelector(".sub-category-grid .item-box:nth-of-type(2) .picture a"));
		}
	}

	// selects a specific cell phone option
	public void selectCellPhoneDisplayItem(String cellPhone) {
		if (cellPhone.equalsIgnoreCase("Smartphone")) {
			clickElement(By.cssSelector("[data-productid='43'] .picture a"));
		} else if (cellPhone.equalsIgnoreCase("Used phone")) {
			clickElement(By.cssSelector("[data-productid='15'] .picture a"));
		} else if (cellPhone.equalsIgnoreCase("Phone Cover")) {
			clickElement(By.cssSelector("[data-productid='80'] .picture a"));
		}

	}

}
