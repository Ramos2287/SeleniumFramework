package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SearchProductPage;

public class SearchProductTest extends TestBase {
	
	SearchProductPage searchPpge;
	String SearchTextinput="Apple MacBook Pro 13-inch";
	
	@Test
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

}
