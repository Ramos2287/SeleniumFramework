package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchProductPage;
import tests.TestBase;
import utilities.Waitme;

public class E2ETests extends TestBase {
	SearchProductPage searchPpge;
	Waitme me;

	
	@Given("user is on Home Pgae")
	public void user_is_on_home_pgae() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("he search for {string}")
	public void he_search_for(String productName) {
		try {
			searchPpge = new SearchProductPage(driver);
			//searchPpge.searchProductMethod(SearchTextinput);
			searchPpge.searchProductWithList(productName);
			System.out.println(searchPpge.messageOpenMacBLink.getText());
			Assert.assertTrue(searchPpge.messageOpenMacBLink.getText().contains(productName));
			
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
	}

	

	@Then("he can view the order and download the invoice")
	public void he_can_view_the_order_and_download_the_invoice() {
	   me = new Waitme();
	   me.waitForPageLoaded();
	   Assert.assertTrue(driver.getCurrentUrl().contains("apple"));
	}
}
