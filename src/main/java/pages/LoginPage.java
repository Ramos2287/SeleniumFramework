package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "Email")
	public WebElement emailTxtBox;
	@FindBy(id = "Password")
	public WebElement passwordTxtBox;
	@FindBy(css = "input.button-1.login-button")
	public WebElement loginBtn;

	public void userLogin(String email1, String password1) {

		sendTxt(emailTxtBox, email1);
		sendTxt(passwordTxtBox, password1);
		clickButtom(loginBtn);
	}
}
