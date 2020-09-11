package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest extends TestBase {
	
	HomePage homepge;
	
	@Test(alwaysRun = true)
	public void productHover() 
	{
		homepge = new HomePage(driver);
		homepge.selectNotebooksMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
				
	}

}
