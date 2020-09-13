package tests;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;
import utilities.JavaFaker;
import utilities.Waitme2;

public class UserRegistrationParallelTesting extends TestBase2 {
	UserRegistrationPage userpge;
	HomePage homepge;
	LoginPage loginpge;
	JavaFaker fakerpge;
	Waitme2 me;

	@Test(priority = 1)
	public void runTests() {
		int input = 0;

		while (input < 1) {
			input += 1;
			System.out.println(input);

			homepge = new HomePage(getDriver());
			me = new Waitme2();
			me.waitForPageLoaded();
			homepge.openRegisterLink();
			userpge = new UserRegistrationPage(getDriver());
			fakerpge = new JavaFaker();
			fakerpge.datafake();

			me.waitForPageLoaded();
			userpge.userRegistrationMethod(fakerpge.getFirstName(), fakerpge.getLastName(), fakerpge.getEmail(),
					fakerpge.getPassword());
			AssertJUnit.assertTrue(userpge.successMessage.getText().contains("Your"));
			System.out.println(fakerpge.getFirstName() + "\t\t" + fakerpge.getLastName() + "\t\t" + fakerpge.getEmail()
					+ "\t\t" + fakerpge.getPassword());

			me.waitForPageLoaded();
			userpge.userLogout();

			me.waitForPageLoaded();
			homepge.openLoginLink();

			me.waitForPageLoaded();
			loginpge = new LoginPage(getDriver());
			loginpge.userLogin(fakerpge.getEmail(), fakerpge.getPassword());

			me.waitForPageLoaded();
			AssertJUnit.assertTrue(userpge.logOutLink.getText().contains("Log out"));
			userpge.userLogout();
		}

	}

}
