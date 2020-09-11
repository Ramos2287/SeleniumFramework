package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;
import utilities.Waitme;

public class UserRegistration extends TestBase{
	
	HomePage homepge;
	UserRegistrationPage userpge;
	Waitme mese;

	@Given("the user in the home page")
	public void the_user_in_the_home_page() {
	    homepge = new  HomePage(driver);
	    mese = new Waitme();
		 mese.waitForPageLoaded(); 
	    homepge.openRegisterLink();
	}

	@When("Iclick on register link")
	public void iclick_on_register_link() {
	    Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}

	/*
	 * @When("I entered the user data") public void i_entered_the_user_data() {
	 * userpge = new UserRegistrationPage(driver); me = new Waitme();
	 * me.waitForPageLoaded(); userpge.userRegistrationMethod("Rami", "gh",
	 * "mgahssfdjd@gmail.com", "123456789"); }
	 */
	
	@When("^I entered \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\"$")
	public void i_entered(String firstname, String lastname, String email, String password) {
		userpge = new UserRegistrationPage(driver);
		 mese = new Waitme();
		 mese.waitForPageLoaded(); 
		 userpge.userRegistrationMethod(firstname, lastname,
		 email, password);	   

	}

	@Then("The registration page displayed successfully")
	public void the_registration_page_displayed_successfully() {
	    mese.waitForPageLoaded();
		userpge.userLogout();
	}
}
