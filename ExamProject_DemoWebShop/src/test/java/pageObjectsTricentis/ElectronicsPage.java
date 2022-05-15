package pageObjectsTricentis;

import org.openqa.selenium.By;

public class ElectronicsPage extends HomePage {
	
	// selects a spesific electronic option (sub category)
	public void selectElectronicDisplayOption(String electronic) {
		if (electronic.equalsIgnoreCase("Camera, photo")) {
			clickElement(By.cssSelector(".sub-category-grid .item-box:nth-of-type(1) .picture a"));
		}else if(electronic.equalsIgnoreCase("Cell phones")) {
			clickElement(By.cssSelector(".sub-category-grid .item-box:nth-of-type(2) .picture a"));
		}
	}
}
