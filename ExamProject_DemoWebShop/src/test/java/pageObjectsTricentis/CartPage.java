package pageObjectsTricentis;

import org.openqa.selenium.By;

import frameWork.BasePage;

public class CartPage extends BasePage {

	// verifies if correct item was added.
	// note: this method only caters for one item
	public boolean verifyAddedItem(String item) {

		String cartItem = getElementText(By.cssSelector(".product-name"));
		boolean itemCorrect;
		if (cartItem.equalsIgnoreCase(item)) {
			itemCorrect = true;
		} else {
			itemCorrect = false;
		}

		return itemCorrect;
	}

	// clears the cart page.
	// note: only removes one item per call.
	public void clearCart() {

		clickElement(By.cssSelector("input[name='removefromcart']"));

		updateCart();
	}

	// this updates the cart page information with any changes.
	public void updateCart() {
		clickElement(By.cssSelector("input[name='updatecart']"));
	}

	// changes the quantity of an item in the cart.
	// note: only supports 1 item.
	public void changeSingleItemQuantity(String amount) {
		clearText(By.cssSelector(".qty-input"));
		enterText(By.cssSelector(".qty-input"), amount);
		updateCart();

	}

	// retrieves quantity of item added to cart.
	// note: -1 means a numberFormatException occurred.
	// only supports 1 item.
	public int getSingleItemQuantity() {
		int quantity;
		String quantityDirty = getElementValue(By.cssSelector(".qty-input"));
		quantityDirty = quantityDirty.replaceAll("[\\D]", "");

		try {
			quantity = Integer.parseInt(quantityDirty);
		} catch (NumberFormatException nfe) {
			quantity = -1;
		}
		return quantity;
	}

	// enters shipping details for an order and triggers shipping estimation.
	public void enterShippingDetails(String country, String province, String postalCode) {
		selectDropDown(By.cssSelector("select#CountryId"), country);
		selectDropDown(By.cssSelector("select#StateProvinceId"), province);
		enterText(By.cssSelector("input#ZipPostalCode"), postalCode);
		clickElement(By.cssSelector("input[name='estimateshipping']"));
	}

	// gets the ground shipping cost of an order.
	public String getGroundShippingCost() {
		String groundCost = getElementText(By.cssSelector("li:nth-of-type(1) > .option-name"));
		return groundCost;
	}
	
	public void scrollToShippingDetails() {
		try {
		scrollToElement(By.cssSelector("h1"));
		}catch(Exception ex) {
			System.out.println("Scrolling failed.");
		}
	}

}
