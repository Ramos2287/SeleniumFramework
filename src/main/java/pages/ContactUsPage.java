package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {

	public ContactUsPage(WebDriver driver) {
		super(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;  
		jse.executeScript("scrollBy(0,2500)");
	}

	@FindBy(id = "FullName")
	WebElement fullNameTxt;
	@FindBy(id = "Email")
	WebElement emailTxt;
	@FindBy(id = "Enquiry")
	WebElement enquiryTxt;
	@FindBy(css = "input.button-1.contact-us-button")
	WebElement submitBtn;



	public void contactUsMethod(String name, String email, String enquiry)
	{
		sendTxt(fullNameTxt, name);
		sendTxt(emailTxt, email);
		sendTxt(enquiryTxt, enquiry);
		clickButtom(submitBtn);

	}
}