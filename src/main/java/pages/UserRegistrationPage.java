package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "gender-male")
	WebElement genderBtn;
	@FindBy(id = "FirstName")
	WebElement fnTxtBox;
	@FindBy(id = "LastName")
	WebElement lnTxtBox;
	@FindBy(id = "Email")
	WebElement emailTxtBox;
	@FindBy(id = "Password")
	WebElement passwordTxtBox;
	@FindBy(id = "ConfirmPassword")
	WebElement confirmPassTxtBox;
	@FindBy(id = "register-button")
	WebElement registerBtn;
	@FindBy(css = "div.result")
	public WebElement successMessage;
	@FindBy(linkText = "Log out")
	public WebElement logOutLink;

	public void userRegistrationMethod(String firstName, String lastName, String Email, String Password) {
		clickButtom(genderBtn);
		sendTxt(fnTxtBox, firstName);
		sendTxt(lnTxtBox, lastName);
		emailTxtBox.sendKeys(Email);
		passwordTxtBox.sendKeys(Password);
		confirmPassTxtBox.sendKeys(Password);
		registerBtn.click();
	}

	public void userLogout() {
		clickButtom(logOutLink);
	}

}
