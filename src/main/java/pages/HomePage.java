package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);

	}

	@FindBy(linkText = "Register")
	WebElement registerLink;

	public void openRegisterLink() {
		registerLink.click();
	}

	@FindBy(linkText = "Log in")
	public WebElement loginLink;

	public void openLoginLink() {
		clickButtom(loginLink);
	}

	@FindBy(linkText = "My account")
	WebElement myAccountLink;

	public void openMyAccountLink() {
		clickButtom(myAccountLink);
	}

	@FindBy(linkText = "Contact us")
	WebElement contactUsBtn;

	public void scrollContactUsPage() {
		scrollToBottom();
	}

	public void openContactUsPage() {
		clickButtom(contactUsBtn);
	}

	@FindBy(css = "a[href='/']")
	WebElement imageHome;

	public void openHomePage() {
		clickButtom(imageHome);
	}

	@FindBy(id = "customerCurrency")
	WebElement currencyDropList;

	public void currency()
	{
		select = new Select(currencyDropList);
		select.selectByIndex(1);
	
	}
	@FindBy(linkText = "Computers")
	WebElement computerMenu;
	@FindBy(linkText = "Notebooks")
	WebElement notebooksMenu;
	
	public void selectNotebooksMenu()
	{
		action.moveToElement(computerMenu).perform();
		action.moveToElement(notebooksMenu).click().build().perform();
	}

}
