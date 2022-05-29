package pageObjectsTricentis;

import org.openqa.selenium.By;

import frameWork.BasePage;

public class HomePage extends BasePage {

	public void goToHomePage() {
		driver.get("http://demowebshop.tricentis.com/");
		waitForUrl(30, "tricentis");
	}

	// searches on any top menu bar item
	public void searchByTopMenuBarItem(String item) {
		clickElement(By.linkText(item));
	}
	
	public void searchBar(String item) {
		enterText(By.cssSelector("input#small-searchterms"),item);
		clickElement(By.cssSelector("form[method='get'] > .button-1.search-box-button"));
	}
	
	// Navigates to the cart Page
	public void goToCart() {
		clickElement(By.cssSelector("li#topcartlink > .ico-cart"));
	}

	public void searchByCategoryMenu(String category) {
		System.out.println(category);
		if(category.equalsIgnoreCase("Books")) {
			clickElement(By.cssSelector(".block-category-navigation [href='\\/books']"));
		}else if(category.equalsIgnoreCase("Computers")) {
			clickElement(By.cssSelector(".block-category-navigation [href='\\/computers']"));
			System.out.println("Desktop passed");
		}else if (category.equalsIgnoreCase("Electronics")) {
			clickElement(By.cssSelector(".block-category-navigation [href='\\/electronics']"));
		}else if(category.equalsIgnoreCase("Apparel $ Shoes")){
			clickElement(By.cssSelector(".block-category-navigation [href='\\/apparel-shoes']"));
		}else if(category.equalsIgnoreCase("Digital downloads")) {
			clickElement(By.cssSelector(".block-category-navigation [href='\\/digital-downloads']"));
		}else if(category.equalsIgnoreCase("Jewelry")) {
			clickElement(By.cssSelector(".block-category-navigation [href='\\/jewelry']"));
		}else if(category.equalsIgnoreCase("Gift Cards")) {
			clickElement(By.cssSelector(".block-category-navigation [href='\\/gift-cards']"));
		}
	}
	
	
// retreives amount of items added to cart.
// note: -1 means a numberFormatException occured.
	public int cartItemsAmount() {
		int cartAmount;
		String cartAmountDirty = getElementText(By.cssSelector(".cart-qty"));
		cartAmountDirty = cartAmountDirty.replaceAll("[\\D]", "");
		try {
			cartAmount = Integer.parseInt(cartAmountDirty);
		} catch (NumberFormatException nfe) {
			cartAmount = -1;
		}
		return cartAmount;
	}
	

}
