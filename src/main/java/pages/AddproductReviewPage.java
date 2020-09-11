package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddproductReviewPage extends PageBase{

	public AddproductReviewPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(id="AddProductReview_Title")
	WebElement titleAddProdRevTxt;
	@FindBy(id="AddProductReview_ReviewText")
	WebElement RevTextAddProdRevTxt;
	@FindBy(css="input.button-1.write-product-review-button")
	WebElement submitRevBtn;
	@FindBy(id="addproductrating_4")
	WebElement ratingBtn;
	
	public void addProductRev(String title, String text )
	{
		
		sendTxt(titleAddProdRevTxt, title);
		sendTxt(RevTextAddProdRevTxt, text);
		clickButtom(ratingBtn);
		clickButtom(submitRevBtn);
	}

}
