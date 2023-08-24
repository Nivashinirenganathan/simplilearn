package in.amazon.CapstoneProject;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions; 
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory; 
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProductToCartPage {
	JavascriptExecutor js;
	WebDriverWait wait;
	Actions actions;
	@FindBy(xpath = "/html/body/div[4]/div/div[1]")
	private WebElement ClickFirstShoe;


	@FindBy(xpath = "(//a[contains(@class,'btn btn-primary')])[1]")
	private WebElement AddCart;

	public AddProductToCartPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}

	public void firstshoe() throws InterruptedException  {
		Thread.sleep(2000);
		ClickFirstShoe.click();

	} 

	public void addtocart() throws InterruptedException  {
		Thread.sleep(2000);
		AddCart.click();

	}

}
