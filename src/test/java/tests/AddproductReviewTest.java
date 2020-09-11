package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddproductReviewPage;
import pages.DetailsOrderPage;
import pages.HomePage;
import pages.SearchProductPage;
import pages.UserRegistrationPage;

public class AddproductReviewTest extends TestBase {
	
	AddproductReviewPage revpge;
	UserRegistrationPage userpge;
	HomePage homepge;
	String email = "rami14ff5@gmail.com";
	SearchProductPage searchPpge;
	String SearchTextinput="Apple MacBook Pro 13-inch";
	DetailsOrderPage detailspge;


	@Test(priority = 1, alwaysRun = true)
	public void runTests() throws InterruptedException {
		homepge = new HomePage(driver);
		homepge.openRegisterLink();
		userpge = new UserRegistrationPage(driver);
		Thread.sleep(1000);
		userpge.userRegistrationMethod("Ramos", "Uzumaki mahmoudi jilani touhami", email, "123456");
		Assert.assertTrue(userpge.successMessage.getText().contains("Your"));

		Thread.sleep(3000);
	}
	@Test(priority = 2)
	public void searchProduct() throws InterruptedException
	{
		try {
			searchPpge = new SearchProductPage(driver);
			searchPpge.searchProductWithList("MacB");
			System.out.println(searchPpge.messageOpenMacBLink.getText());
			Assert.assertTrue(searchPpge.messageOpenMacBLink.getText().contains(SearchTextinput));
			
			
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
		
		
	}
	
	@Test(priority = 3)
	public void userCanAddProdRev()
	{
		detailspge = new DetailsOrderPage(driver);
		detailspge.openAddRev();
		revpge = new AddproductReviewPage(driver);
		revpge.addProductRev("ahlin", "hello ya jma3a");
	}

}
