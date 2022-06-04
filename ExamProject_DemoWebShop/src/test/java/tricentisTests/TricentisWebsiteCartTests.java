package tricentisTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pageObjectsTricentis.CartPage;
import pageObjectsTricentis.CompareProductsPage;
import pageObjectsTricentis.ComputersPage;
import pageObjectsTricentis.ElectronicsPage;
import pageObjectsTricentis.HomePage;
import pageObjectsTricentis.ManageItemPage;

public class TricentisWebsiteCartTests {
	HomePage homePage = new HomePage();
	ElectronicsPage electPage = new ElectronicsPage();
	CartPage cartPage = new CartPage();
	ComputersPage compPage = new ComputersPage();
	ManageItemPage manItemPage = new ManageItemPage();
	CompareProductsPage compareProductsPage = new CompareProductsPage();

	@AfterMethod
	public void testCleanup() {
		int cartItems = homePage.cartItemsAmount();
		homePage.goToCart();
		while (cartItems > 0) {
			cartPage.clearCart();
			cartItems = homePage.cartItemsAmount();
		}
	}

	@Test
	public void GIVEN_ShopperOnHomePage_WHEN_TopMenuBarUsed_AND_Electronics_OptionCellPhones_ItemSmartPhoneSelected_AND_ItemAddedToCart_THEN_SmartPhoneDisplaysOnCartPage() {
		String menuBarOption = "ELECTRONICS";
		String electOption = "Cell phones";
		String cellPhoneItem = "Smartphone";
		boolean verifyCartItem;
		
		homePage.goToHomePage();
		homePage.searchByTopMenuBarItem(menuBarOption);
		electPage.selectElectronicDisplayOption(electOption);
		electPage.selectCellPhoneDisplayItem(cellPhoneItem);
		manItemPage.addToCart();
		manItemPage.removeCartNotification();
		homePage.goToCart();
		
		verifyCartItem = cartPage.verifyAddedItem(cellPhoneItem);
		Assert.assertEquals(true, verifyCartItem);

	}

	@Test
	public void GIVEN_ShopperOnHomePage_WHEN_CategoriesNavigationUsed_AND_Computers_OptionDesktops_ItemSimpleComputerSelected_AND_ItemAddedToCart_THEN_SimpleComputerDisplaysOnCartPage() {
		String categoryOption = "Computers";
		String computerOption = "Desktops";
		String desktopsItem = "Simple Computer";
		boolean verifyCartItem;

		homePage.goToHomePage();
		homePage.searchByCategoryMenu(categoryOption);
		compPage.selectComputerOptionByCategoryMenu(computerOption);
		compPage.selectDesktopDisplayItem(desktopsItem);
		manItemPage.selectSimpleComputerProcessor();
		manItemPage.addToCart();
		manItemPage.removeCartNotification();
		homePage.goToCart();

		verifyCartItem = cartPage.verifyAddedItem(desktopsItem);
		Assert.assertEquals(true, verifyCartItem);
	}

	@Test
	public void GIVEN_ShopperOnCartPage_AND_OneItemAdded_WHEN_ItemQuantityChangeToTwo_THEN_ItemQuantityDisplaysAsTwo() {
		String menuBarOption = "ELECTRONICS";
		String electOption = "Cell phones";
		String cellPhoneItem = "Phone Cover";
		int quantityExpected = 2;
		int quantityActual;
		homePage.goToHomePage();
		homePage.searchByTopMenuBarItem(menuBarOption);
		electPage.selectElectronicDisplayOption(electOption);
		electPage.selectCellPhoneDisplayItem(cellPhoneItem);
		manItemPage.addToCart();
		manItemPage.removeCartNotification();
		homePage.goToCart();
		cartPage.changeSingleItemQuantity(quantityExpected + "");
		
		quantityActual = cartPage.getSingleItemQuantity();
		Assert.assertEquals(quantityActual, quantityExpected);

	}

	@Test
	public void GIVEN_ShopperOnCartPage_AND_OneItemAdded_WHEN_RemoveChecked_AND_UpdateShoppingCartClicked_THEN_ItemRemovedFromCart() {
		String categoryOption = "Computers";
		String computerOption = "Desktops";
		String desktopsItem = "Build your own cheap computer";

		homePage.goToHomePage();
		homePage.searchByCategoryMenu(categoryOption);
		compPage.selectComputerOptionByCategoryMenu(computerOption);
		compPage.selectDesktopDisplayItem(desktopsItem);
		manItemPage.addToCart();
		manItemPage.removeCartNotification();
		homePage.goToCart();
		cartPage.clearCart();
		
		Assert.assertEquals(homePage.cartItemsAmount(), 0);

	}

	@Test
	public void GIVEN_OneItemAddedToCart_WHEN_NavigateToCart_AND_ShippingDetailsUnitedStatesAlaska99501Entered_AND_EstimateShippingButtonClicked_THEN_GroundEstimateZero() {
		String menuBarOption = "ELECTRONICS";
		String electOption = "Cell phones";
		String cellPhoneItem = "Smartphone";
		String country = "United States";
		String province = "Alaska";
		String postalCode = "99501";
		homePage.goToHomePage();
		homePage.searchByTopMenuBarItem(menuBarOption);
		electPage.selectElectronicDisplayOption(electOption);
		electPage.selectCellPhoneDisplayItem(cellPhoneItem);
		manItemPage.addToCart();
		manItemPage.removeCartNotification();
		homePage.goToCart();
		cartPage.enterShippingDetails(country, province, postalCode);
		
		Assert.assertEquals(cartPage.getGroundShippingCost(), "Ground (0.00)");

	}

}
