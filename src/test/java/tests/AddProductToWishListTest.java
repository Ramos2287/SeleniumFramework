package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DetailsOrderPage;
import pages.SearchProductPage;
import pages.WishListPage;

public class AddProductToWishListTest extends TestBase{
	
	SearchProductPage searchPpge;
	DetailsOrderPage detailspge;
	String SearchTextinput="Apple MacBook Pro 13-inch";
	WishListPage wishListpge;
	
	@Test(priority = 1)
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
		
	}
	@Test(priority=2)
	public void addProductToWishList() throws InterruptedException
	{
		detailspge = new DetailsOrderPage(driver);
		detailspge.addWishListBtn();
		Thread.sleep(2000);
		
	}
	@Test(priority = 3, dependsOnMethods ="addProductToWishList" )
	public void removeProductFromWishList() throws InterruptedException
	{
		driver.navigate().to("https://demo.nopcommerce.com/wishlist");
		wishListpge = new WishListPage(driver);
		Assert.assertTrue(wishListpge.wishListHeader.isDisplayed());
		Assert.assertTrue(wishListpge.productCell.getText().contains(SearchTextinput));
		//Thread.sleep(1000);
		wishListpge = new WishListPage(driver);
		wishListpge.removeProduct();
		Assert.assertTrue(wishListpge.messageRemoveDone.getText().contains("empty!"));
	}

}
