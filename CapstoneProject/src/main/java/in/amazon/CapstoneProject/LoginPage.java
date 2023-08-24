package in.amazon.CapstoneProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(linkText = "Logout")
	private WebElement ClickLogout;

	@FindBy(id = "email")
	private WebElement Enteremail;

	@FindBy(id = "password")
	private WebElement Enterpassword;

	@FindBy(xpath = "/html/body/div[2]/form/button")
	private WebElement ClickLogin;


	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public void clicklogout() {
		ClickLogout.click();

	}

	public void enteremail(String email) {
		Enteremail.sendKeys(email); 
	}

	public void enterpassword(String password) {
		Enterpassword.sendKeys(password); 
	}

	public void clickloginbtn() throws InterruptedException {
		ClickLogin.click(); 
		Thread.sleep(5000);
	}

}
