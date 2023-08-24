package in.amazon.CapstoneProject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	
	
	
	@FindBy(linkText = "New User? Register Here")
	private WebElement ClickRegister;
	
	@FindBy(id = "name")
	 private WebElement EnterName;
	
	@FindBy(id = "email")
	 private WebElement EnterEmail;
	
	@FindBy(id = "password")
	 private WebElement EnterPassword;
	
	@FindBy(xpath = "/html/body/div[2]/form/button")
	private WebElement ClickButton;
	
	
	public RegistrationPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void clickRegister() {
		ClickRegister.click();
		
	}
	
	public void entername(String name) {
		EnterName.sendKeys(name); 
	}
	
	public void enteremail(String email)  {
		EnterEmail.sendKeys(email);
		
	}
	
	public void enterpassword(String password) throws InterruptedException {
		EnterPassword.sendKeys(password); 
		Thread.sleep(5000);
	}
	
	
	public void clickbutton() {
		ClickButton.click();
	}
	
}
