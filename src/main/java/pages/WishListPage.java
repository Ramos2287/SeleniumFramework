package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase {

	public WishListPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="h1")
	public WebElement wishListHeader;
	@FindBy(css="a.product-name")
	public WebElement productCell;
	@FindBy(name = "removefromcart")
	WebElement removeProductBtn;
	@FindBy(css="input.button-2.update-wishlist-button")
	WebElement updateWishListBtn;
	@FindBy(css="div.no-data")
	public WebElement messageRemoveDone;
	
	public void removeProduct()
	{
		clickButtom(removeProductBtn);
		clickButtom(updateWishListBtn);
	}

}
