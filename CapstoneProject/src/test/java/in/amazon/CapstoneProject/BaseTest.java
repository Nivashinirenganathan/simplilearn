package in.amazon.CapstoneProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	WebDriver driver;
	@BeforeTest
	public void launchApplication() {
	//1.Open the browser
		driver = new ChromeDriver();
	//2.Maximize it
		driver.manage().window().maximize();
	//3.Navigate to http://localhost:9010/
		driver.get("http://localhost:9010/");
		
	}
	
	@AfterTest
	public void closeBrowser() {
	//Close the browser.
		driver.quit();
	} 

}
