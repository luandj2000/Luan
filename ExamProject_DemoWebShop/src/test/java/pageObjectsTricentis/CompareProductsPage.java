package pageObjectsTricentis;

import org.openqa.selenium.By;

import frameWork.BasePage;

public class CompareProductsPage extends BasePage {

	public void clearCompareList() {
		clickElement(By.cssSelector(".clear-list"));
	}
	
	public int getProductPrice(int productNum) {
		int productPrice;
		try {
		
		productPrice =  Integer.parseInt(getElementText(By.cssSelector(".product-price > td:nth-of-type(" 
	+ (productNum+1) +")")));
		}catch(NumberFormatException nfe) {
			productPrice = -1;
		}
		return productPrice;
	}
	
	public void clearCompareProducts() {
		boolean doClear = elementExists(By.cssSelector(".clear-list"));
		if(doClear) {
			clickElement(By.cssSelector(".clear-list"));
		}
	}
}
