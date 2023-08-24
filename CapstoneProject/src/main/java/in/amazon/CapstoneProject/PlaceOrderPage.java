package in.amazon.CapstoneProject;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaceOrderPage {
	WebDriverWait wait;
	@FindBy(linkText = "Home")
	private WebElement ClickHome;
	
	@FindBy(linkText = "Cart")
	private WebElement ClickCart;
	
	@FindBy(linkText = "Place Order")
	private WebElement ClickPlaceOrder;
	 
	@FindBy(xpath = "/html/body/div[3]/div") 
	private static WebElement Verifymsg;
	
	
	public PlaceOrderPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}
	
	public void clickhome() {
		ClickHome.click();
	} 
	
	public void clickcart() {
		ClickCart.click();
	}
	
	public void clickplaceorder() throws InterruptedException {
		Thread.sleep(2000);
		ClickPlaceOrder.click();
	}
	
	public static String verifymsg() {
		String msg = Verifymsg.getText();
		return msg;
	}
	
}
