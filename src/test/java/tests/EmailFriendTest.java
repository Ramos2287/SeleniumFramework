package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DetailsOrderPage;
import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchProductPage;
import pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase {

	
	  /*SearchProductTest searchObject; 
	  EmailPage emailpge; 
	  DetailsOrderPage detailspge;
	  HomePage homepge;
	  UserRegistrationTest registerpge;
	 
	 @Test public void EmailSendToFriendTest() throws InterruptedException {
	 registerpge = new UserRegistrationTest(); 
	 registerpge.runTests();
	 Thread.sleep(1000);
	  searchObject = new SearchProductTest();
	 searchObject.searchProduct();
	  Thread.sleep(1000); 
	  detailspge = new DetailsOrderPage(driver); 
	  detailspge.openEmailFriend();
	  Thread.sleep(1000);
	 emailpge = new EmailPage(driver);
	 emailpge.SendEmailToFriend("asap@gmail.com", "Hello 7abiiibiiiiiiiiiiiii"); }*/
	 
	UserRegistrationPage userpge;
	HomePage homepge;
	LoginPage loginpge;
	String email = "rami1555555@gmail.com";

	SearchProductPage searchPpge;
	String SearchTextinput = "Apple MacBook Pro 13-inch";
	
	EmailPage emailpge;
	DetailsOrderPage detailsObject;

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
	public void searchProduct() throws InterruptedException {
		try {
			searchPpge = new SearchProductPage(driver);
			// searchPpge.searchProductMethod(SearchTextinput);
			searchPpge.searchProductWithList("MacB");
			System.out.println(searchPpge.messageOpenMacBLink.getText());
			Assert.assertTrue(searchPpge.messageOpenMacBLink.getText().contains(SearchTextinput));

		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}

	}
	
	@Test(priority = 3)
	public void EmailSendToFriendTest() throws InterruptedException
	{
		Thread.sleep(1000);
		detailsObject = new DetailsOrderPage(driver);
		detailsObject.openEmailFriend();
		Thread.sleep(1000);
		emailpge = new EmailPage(driver);
		emailpge.SendEmailToFriend("asasa@gmail.com", "hello bebeh");
	}

	@Test(priority = 4)
	public void logOut() throws InterruptedException {
		userpge.userLogout();
		Thread.sleep(3000);

	}

}
