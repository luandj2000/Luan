package tricentisTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import frameWork.ReadExcel;
import pageObjectsTricentis.CompareProductsPage;
import pageObjectsTricentis.ComputersPage;
import pageObjectsTricentis.ElectronicsPage;
import pageObjectsTricentis.HomePage;
import pageObjectsTricentis.ManageItemPage;

public class TricentisWebsiteCompareProductTests {

	HomePage homePage = new HomePage();
	ElectronicsPage electPage = new ElectronicsPage();
	ComputersPage compPage = new ComputersPage();
	ManageItemPage manItemPage = new ManageItemPage();
	CompareProductsPage compareProductsPage = new CompareProductsPage();
	ReadExcel readExcel = new ReadExcel();

	@AfterMethod
	public void testCleanup() {

		homePage.goToCompareProductList();
		compareProductsPage.clearCompareList();
	}

	@Test(dataProvider = "Product and Price")
	public void GIVEN_TwoItemsSelected_WHEN_SelectedItemsAddedToCompareList_THEN_SelectedItemsWithPricesDisplayOnComparisonTable(
			String product1, String price1, String product2, String price2, String category) {
		homePage.goToHomePage();
		homePage.searchBar(product1);
		if (category.equalsIgnoreCase("Computers")) {
			compPage.selectDesktopDisplayItem(product1);
			manItemPage.addToCompareList();
			homePage.searchBar(product2);
			compPage.selectDesktopDisplayItem(product2);
			manItemPage.addToCompareList();
		} else if (category.equalsIgnoreCase("Electronics")) {
			electPage.selectCellPhoneDisplayItem(product1);
			manItemPage.addToCompareList();
			homePage.searchBar(product2);
			electPage.selectCellPhoneDisplayItem(product2);
			manItemPage.addToCompareList();
		}

		Assert.assertEquals(compareProductsPage.getProductPrice(2), price1);
		Assert.assertEquals(compareProductsPage.getProductPrice(1), price2);

	}

	@DataProvider(name = "Product and Price")
	public Object[][] getDataFromExcel() {
		String excelDirectory = readExcel.getDataConfigProperties("excelDataDir");
		Object[][] arrayObject = readExcel.getExcelData(excelDirectory + "ComparisonData.xlsx", "Products");
		return arrayObject;

	}
}
