package tests;

import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {
	HomePage homepge;
	ContactUsPage contactUspge ;
	UserRegistrationTest register;
	
	@Test
	public void ContactTest() throws InterruptedException
	{
		register = new UserRegistrationTest();
		register.runTests();
		register.logOut();
		register.logIn();
		homepge = new HomePage(driver);
		homepge.openHomePage();
		Thread.sleep(1000);
		homepge.scrollContactUsPage();
		homepge.openContactUsPage();
		Thread.sleep(1000);
		contactUspge = new ContactUsPage(driver);
		contactUspge.contactUsMethod("Ramos", "", "hello every one");
	}
}
