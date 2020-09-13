package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;
import utilities.JavaFaker;
import utilities.Waitme2;

public class MyAccountTestGrid extends TestBase2 {
	UserRegistrationPage userpge;
	HomePage homepge;
	LoginPage loginpge;
	MyAccountPage myAccountpge;
	JavaFaker fakerpge;
	Waitme2 me;
	String NewPassword = "112233";
	

	@Test(priority = 1, alwaysRun = true)
	public void runTests() throws InterruptedException {
		homepge = new HomePage(getDriver());
		fakerpge = new JavaFaker();
		fakerpge.datafake();
		me = new Waitme2();
		me.waitForPageLoaded();
		homepge.openRegisterLink();
		me.waitForPageLoaded();
		userpge = new UserRegistrationPage(getDriver());
		me.waitForPageLoaded();
		userpge.userRegistrationMethod(fakerpge.getFirstName(), fakerpge.getLastName(), fakerpge.getEmail(), fakerpge.getPassword());
		Assert.assertTrue(userpge.successMessage.getText().contains("Your"));

		me.waitForPageLoaded();
	}
	@Test(dependsOnMethods = "runTests" )
	public void changePass()
	{
		homepge.openMyAccountLink();
		myAccountpge = new MyAccountPage(getDriver());
		myAccountpge.openChangePasswordLink();
		me.waitForPageLoaded();
		myAccountpge.changePass(fakerpge.getPassword(), NewPassword);
		Assert.assertTrue(myAccountpge.passwordChangeMessage.getText().contains("Password was changed"));
		
	}

	@Test(dependsOnMethods = "changePass")
	public void logOut() throws InterruptedException {
		me.waitForPageLoaded();
		userpge.userLogout();

	}

	@Test(dependsOnMethods = "logOut")
	public void logIn() throws InterruptedException  
	{
		me.waitForPageLoaded();
		homepge.openLoginLink();
		loginpge = new LoginPage(getDriver());
		me.waitForPageLoaded();
		loginpge.userLogin(fakerpge.getEmail(), NewPassword);
		Assert.assertTrue(userpge.logOutLink.getText().contains("Log out"));

	}

}
