package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase {
	UserRegistrationPage userpge;
	HomePage homepge;
	LoginPage loginpge;
	MyAccountPage myAccountpge;
	String OldPassword = "123456";
	String NewPassword = "112233";
	

	@Test(priority = 1, alwaysRun = true)
	public void runTests() throws InterruptedException {
		homepge = new HomePage(driver);
		homepge.openRegisterLink();
		userpge = new UserRegistrationPage(driver);
		Thread.sleep(2000);
		userpge.userRegistrationMethod("Ramooos", "Uzumaki", "rami1@gmail.com", OldPassword);
		Assert.assertTrue(userpge.successMessage.getText().contains("Your"));

		Thread.sleep(3000);
	}
	@Test(dependsOnMethods = "runTests" )
	public void changePass()
	{
		homepge.openMyAccountLink();
		myAccountpge = new MyAccountPage(driver);
		myAccountpge.openChangePasswordLink();
		myAccountpge.changePass(OldPassword, NewPassword);
		Assert.assertTrue(myAccountpge.passwordChangeMessage.getText().contains("Password was changed"));
		
	}

	@Test(dependsOnMethods = "changePass")
	public void logOut() throws InterruptedException {
		userpge.userLogout();
		Thread.sleep(3000);

	}

	@Test(dependsOnMethods = "logOut")
	public void logIn() throws InterruptedException  
	{
		homepge.openLoginLink();
		loginpge = new LoginPage(driver);
		Thread.sleep(2000);
		loginpge.userLogin("rami1@gmail.com", NewPassword);
		Assert.assertTrue(userpge.logOutLink.getText().contains("Log out"));

	}

}
