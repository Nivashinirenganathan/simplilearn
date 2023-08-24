package in.amazon.CapstoneProject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class BuySportyShoesTest extends BaseTest{

	@Test
 
	public void buyshoes() throws InterruptedException {

		RegistrationPage ClickRegister = new RegistrationPage(driver);
		ClickRegister.clickRegister();
		ClickRegister.entername("Nivashini");
		ClickRegister.enteremail("nivashini987@gmail.com");
		ClickRegister.enterpassword("12389");
		ClickRegister.clickbutton();

		LoginPage ClickLogout = new LoginPage(driver);
		ClickLogout.clicklogout();
		ClickLogout.enteremail("nivashini987@gmail.com");
		ClickLogout.enterpassword("12389");
		ClickLogout.clickloginbtn();


		AddProductToCartPage ClickFirstShoe = new AddProductToCartPage(driver);
		Thread.sleep(2000);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,1000)", ""); 
		ClickFirstShoe.firstshoe(); 
		Thread.sleep(4000);
		ClickFirstShoe.addtocart();

		PlaceOrderPage ClickHome = new PlaceOrderPage(driver);
		ClickHome.clickhome();
		ClickHome.clickcart();

		Thread.sleep(2000);
		js2.executeScript("window.scrollBy(0,800)", "");
		ClickHome.clickplaceorder();

		String expectedmsg = "Success!\r\n"
				+ "Message:Order Placed Successfully with ID: 7";
		String actualmsg = PlaceOrderPage.verifymsg();
		Assert.assertEquals(actualmsg, expectedmsg); 
    }
}
