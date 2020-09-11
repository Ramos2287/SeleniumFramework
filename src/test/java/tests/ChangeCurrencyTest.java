package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DetailsOrderPage;
import pages.HomePage;
import pages.SearchProductPage;

public class ChangeCurrencyTest extends TestBase {
	
	HomePage homepge;
	DetailsOrderPage detailspge;
	
	@Test(priority = 1)
	public void userCanChangeCurrency()
	{
		homepge = new HomePage(driver);
		homepge.currency();
	}
	
	SearchProductPage searchPpge;
	String SearchTextinput="Apple MacBook Pro 13-inch";
	
	@Test(priority = 2)
	public void searchProduct() throws InterruptedException
	{
		try {
			searchPpge = new SearchProductPage(driver);
			//searchPpge.searchProductMethod(SearchTextinput);
			searchPpge.searchProductWithList("MacB");
			System.out.println(searchPpge.messageOpenMacBLink.getText());
			Assert.assertTrue(searchPpge.messageOpenMacBLink.getText().contains(SearchTextinput));
			
			
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
		//Assert.assertTrue(detailspge.productPriceLbl.getText().contains("€"));
		//Thread.sleep(1000);

		
	}
	/*@Test(priority = 3)
	public void printx() throws InterruptedException
	{
		homepge.scrollContactUsPage();
		Thread.sleep(1000);
		System.out.println(detailspge.productPriceLbl.getText());
	}*/


}
