package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase {

	UserRegistrationPage userpge;
	HomePage homepge;
	LoginPage loginpge;
	String email = "rami144dsfxd5@gmail.com";

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

	@Test(dependsOnMethods = "runTests")
	public void logOut() throws InterruptedException {
		userpge.userLogout();
		Thread.sleep(3000);

	}

	@Test(dependsOnMethods = "logOut")
	public void logIn()  
	{
		homepge.openLoginLink();
		loginpge = new LoginPage(driver);
		loginpge.userLogin(email, "123456");
		Assert.assertTrue(userpge.logOutLink.getText().contains("Log out"));

	}

}
