package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddProductToComparePage;
import pages.SearchProductPage;
import utilities.Waitme;

public class AddProductToCompareTest extends TestBase {

	SearchProductPage searchPpge;
	AddProductToComparePage comparepge;
	Waitme me;
	String SearchTextOutputMac = "Apple MacBook Pro 13-inch";
	String SearchTextOuputAsus = "Asus N551JK-XO076H Laptop";

	@Test(priority = 1)
	public void searchProduct() throws InterruptedException {
		try {
			searchPpge = new SearchProductPage(driver);
			comparepge = new AddProductToComparePage(driver);

			// searchPpge.searchProductMethod(SearchTextinput);

			searchPpge.searchProductWithList("MacB");
			System.out.println(searchPpge.messageOpenMacBLink.getText());
			Assert.assertTrue(searchPpge.messageOpenMacBLink.getText().contains(SearchTextOutputMac));
			me = new Waitme();
			me.waitForPageLoaded();
			comparepge.clickAddToCompare();
			
			me.waitForPageLoaded();
			searchPpge.searchProductWithList("asus");
			System.out.println(searchPpge.messageOpenMacBLink.getText());
			Assert.assertTrue(searchPpge.messageOpenMacBLink.getText().contains(SearchTextOuputAsus));
			me.waitForPageLoaded();
			comparepge.clickAddToCompare();

		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
		Thread.sleep(2000);
		driver.navigate().to("https://demo.nopcommerce.com/compareproducts");

	}

	@Test(priority = 2)
	public void compareProducts() {
		me.waitForPageLoaded();
		comparepge.compareProdcutsList();
	}

	@Test(priority = 3)
	public void clearList() {
		me.waitForPageLoaded();
		comparepge.clickToClearList();
	}

}
