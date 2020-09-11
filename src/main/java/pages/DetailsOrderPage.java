package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetailsOrderPage extends PageBase {

	public DetailsOrderPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="input.button-2.email-a-friend-button")
	WebElement emailFriendBtn;
	public void openEmailFriend()
	{
		clickButtom(emailFriendBtn);
	}
	@FindBy(xpath ="//*[@id=\"price-value-4\"]")
	public WebElement productPriceLbl;
	@FindBy(linkText = "Add your review")
	WebElement addRevBtn;
	public void openAddRev()
	{
		clickButtom(addRevBtn);
	}
	@FindBy(id="add-to-wishlist-button-4")
	WebElement addToWishListBtn;
	
	public void addWishListBtn()
	{
		clickButtom(addToWishListBtn);
	}
	

}
