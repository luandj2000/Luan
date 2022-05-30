package pageObjectsTricentis;

import org.openqa.selenium.By;

import frameWork.BasePage;

public class CompareProductsPage extends BasePage {

	public void clearCompareList() {
		boolean doClear = elementExists(By.cssSelector(".clear-list"));
		
		if(doClear) {
			clickElement(By.cssSelector(".clear-list"));
		}
	}
	
	public String getProductPrice(int productNum) {
		String productPrice =  getElementText(By.cssSelector(".product-price > td:nth-of-type(" + (productNum+1) +")"));
		
		return productPrice;
	}
}
