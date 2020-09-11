package pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

	protected WebDriver driver;
	public JavascriptExecutor jse = (JavascriptExecutor) driver; 
	public Select select;
	public Actions action;



	public PageBase(WebDriver driver) {

		PageFactory.initElements((WebDriver) driver, this);

	}
	protected static void clickButtom(WebElement Buttom)
	{
	 Buttom.click();
	}
	protected static void sendTxt(WebElement textElement, String value)
	{
		textElement.sendKeys(value);
	}
	public void scrollToBottom()
	{
		jse.executeScript("scrollBy(0,2500)");
	}
	

}
