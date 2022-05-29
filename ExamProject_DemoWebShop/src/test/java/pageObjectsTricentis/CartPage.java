package pageObjectsTricentis;

import org.openqa.selenium.By;

import frameWork.BasePage;

public class CartPage extends BasePage {

	// verifies if correct item was added.
	// note: this method only caters for one item
	public boolean verifyAddedItem (String item) {
		
		String cartItem = getElementText(By.cssSelector(".product-name"));
		boolean itemCorrect;
		if(cartItem.equalsIgnoreCase(item)) {
			itemCorrect = true;
		}else {
			itemCorrect = false;
		}
		
		return itemCorrect;
	}
	
	public void clearCart() {
		
		
			clickElement(By.cssSelector("input[name='removefromcart']"));
			//clickElement(By.cssSelector("tr:nth-of-type(" + i + ") > .remove-from-cart > input[name='removefromcart']"));
		
		updateCart();
	}
	
	public void updateCart() {
		clickElement(By.cssSelector("input[name='updatecart']"));
	}
	
	public void changeSingleItemQuantity(String amount) {
		clearText(By.cssSelector(".qty-input"));
		enterText(By.cssSelector(".qty-input"),amount);
		updateCart();
		
	}
	
	// retirves qunatity of item added to cart.
	// note: -1 means a numberFormatException occured.
	public int getSingleItemQuantity() {
		int quantity;
		String quantityDirty= getElementValue(By.cssSelector(".qty-input"));
		System.out.println(quantityDirty + "fail");
		quantityDirty= quantityDirty.replaceAll("[\\D]", "");
		
		try {
			quantity = Integer.parseInt(quantityDirty);
		} catch (NumberFormatException nfe) {
			quantity = -1;
		}
		return quantity;
	}
	
	public void enterShippingDetails(String country, String province,String postalCode) {
		selectDropDown(By.cssSelector("select#CountryId"),country);
		selectDropDown(By.cssSelector("select#StateProvinceId"),province);
		enterText(By.cssSelector("input#ZipPostalCode"),postalCode);
		clickElement(By.cssSelector("input[name='estimateshipping']"));
	}
	
	public String getGroundShippingCost() {
		String groundCost = getElementText(By.cssSelector("li:nth-of-type(1) > .option-name"));
		return groundCost;
	}
	
}
