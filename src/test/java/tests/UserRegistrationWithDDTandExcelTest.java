package tests;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTandExcelTest extends TestBase {
	UserRegistrationPage userpge;
	HomePage homepge;
	LoginPage loginpge;
	
	public void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}
	
	@DataProvider(name ="ExcelData")
	public Object[][] userRegisterData() throws IOException
	{
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData();
		
	}
	
	@Test(priority = 1, dataProvider = "ExcelData")
	public void runTests(String fname, String lname, String email, String password) throws InterruptedException {
		homepge = new HomePage(driver);
		homepge.openRegisterLink();
		userpge = new UserRegistrationPage(driver);

		waitForPageLoaded();
		userpge.userRegistrationMethod(fname, lname, email, password);
		AssertJUnit.assertTrue(userpge.successMessage.getText().contains("Your"));

		waitForPageLoaded();
		userpge.userLogout();

		waitForPageLoaded();
		homepge.openLoginLink();

		waitForPageLoaded();
		loginpge = new LoginPage(driver);
		loginpge.userLogin(email, password);

		waitForPageLoaded();
		AssertJUnit.assertTrue(userpge.logOutLink.getText().contains("Log out"));
		userpge.userLogout();

	}

}
