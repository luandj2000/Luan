package pageObjectsTricentis;

import org.openqa.selenium.By;

import frameWork.BasePage;

public class ManageItemPage extends BasePage {

	// generic add to cart option for all cell phone items
	public void addToCart() {
		clickElement(By.cssSelector(".add-to-cart-button.button-1"));
	}
	
	public void selectSimpleComputerProcessor() {
		clickElement(By.id("product_attribute_75_5_31_96"));
		
		
	}
	
	public void removeCartNotification() {
		clickElement(By.cssSelector("div#bar-notification > span[title='Close']"));
	}
	
	public void addToCompareList() {
		clickElement(By.cssSelector("input[value='Add to compare list']"));
	}
	
}
