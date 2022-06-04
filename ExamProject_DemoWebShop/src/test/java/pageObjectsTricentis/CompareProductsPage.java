package pageObjectsTricentis;

import org.openqa.selenium.By;

import frameWork.BasePage;

public class CompareProductsPage extends BasePage {

	// clears the compare list of all products.
	public void clearCompareList() {
		boolean doClear = elementExists(By.cssSelector(".clear-list"));

		if (doClear) {
			clickElement(By.cssSelector(".clear-list"));
		}
	}

	// gets the product price of item specified.
	public String getProductPrice(int productNum) {
		String productPrice = getElementText(
				By.cssSelector(".product-price > td:nth-of-type(" + (productNum + 1) + ")"));

		return productPrice;
	}
}
