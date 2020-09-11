package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductToComparePage extends PageBase {

	public AddProductToComparePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "input.button-2.add-to-compare-list-button")
	WebElement addToCompareListBtn;

	public void clickAddToCompare() {
		clickButtom(addToCompareListBtn);
	}

	@FindBy(css = "a.clear-list")
	WebElement clearListBtn;

	public void clickToClearList() {
		clickButtom(clearListBtn);
	}

	@FindBy(tagName = "td")
	List<WebElement> Rows;
	@FindBy(tagName = "tr")
	List<WebElement> Colls;

	public void compareProdcutsList() {
		int cp = 0;
		ArrayList<String> title = new ArrayList<String>();
		ArrayList<String> element1 = new ArrayList<String>();
		ArrayList<String> element2 = new ArrayList<String>();
		String el;
		for (WebElement row : Rows) {
			cp++;
			if (cp <= 6)
				continue;
			el=row.getText();
			if (el.equalsIgnoreCase(" "))
				el="N/A";
			if (cp % 3 == 1)
				title.add(el);
			else if (cp % 3 == 2)
				element1.add(el);
			else if (cp % 3 == 0)
				element2.add(el);
		}
		System.out.print("\t\t\t");
		for (String t : title)
			System.out.print(t+"\t\t");
		System.out.println();
		for (String t : element1)
			System.out.print(t+"\t\t");
		System.out.println();
		for (String t : element2)
			System.out.print(t+"\t\t");
		System.out.println();

		/*
		 * for (WebElement coll : Colls) { System.out.println(coll.getText());
		 * 
		 * }
		 */

	}
}
