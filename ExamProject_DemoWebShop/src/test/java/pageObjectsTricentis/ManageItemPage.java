package pageObjectsTricentis;

import org.openqa.selenium.By;

import frameWork.BasePage;

public class ManageItemPage extends BasePage {

	// generic add to cart option for all cell phone items
	public void addToCart() {
		clickElement(By.cssSelector(".add-to-cart-button.button-1"));
	}

	// checks the processor to be chosen for the computer.
	public void selectSimpleComputerProcessor() {
		clickElement(By.id("product_attribute_75_5_31_96"));

	}

	// removes the interfering cart notification when an product is added.
	public void removeCartNotification() {
		clickElement(By.cssSelector("div#bar-notification > span[title='Close']"));
	}

	// adds a product to the compare list.
	public void addToCompareList() {
		clickElement(By.cssSelector("input[value='Add to compare list']"));
	}

}
