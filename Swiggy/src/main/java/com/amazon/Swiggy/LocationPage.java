package com.amazon.Swiggy;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class LocationPage {
	private Actions actions;
	private WebDriverWait wait;
	public LocationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}

	@FindBy(id = "location")
	private WebElement location;

	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[1]/div/div[1]/div[1]/div/div[2]/div/div[2]")
	private WebElement autoCompleteBox;

	public void searchItem(String item) {
		location.sendKeys(item);
		wait.until(ExpectedConditions.visibilityOfAllElements(autoCompleteBox));
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	}


}
