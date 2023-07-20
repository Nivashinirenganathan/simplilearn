package testNG;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
public class SimplilearnTest { 
	ChromeDriver driver;
	@BeforeTest
	public void launchApplication() {
		driver = new ChromeDriver();
		//2)navigate to application
		//object.method()
		driver.get("https://www.simplilearn.com/");	
	}
	@Test
	public void Textverification() { 
		try {
			// Step 3: Hover the pointer over 'All Courses'
			WebElement allCoursesElement = driver.findElement(By.xpath("//*[@id=\"menu-button\"]/span"));
			Actions actions = new Actions(driver);
			actions.moveToElement(allCoursesElement).perform();

			// Step 4: Hover the pointer over 'Software Development'
			WebElement softwareDevElement = driver.findElement(By.linkText("Software Development"));
			actions.moveToElement(softwareDevElement).perform();

			// Step 5: Click on 'Automation Testing Masters Program'
			WebElement autoTestProgramElement = driver.findElement(By.xpath("//a[text()='Automation Testing Masters Program']"));
			autoTestProgramElement.click();
			// Step 6: Verify the text 'Automation Test Engineer' is visible on the next page
			String expectedText = "Automation Test Engineer";
			WebElement headerElement = driver.findElement(By.xpath("//h1[@class='course-title']"));  
			if (headerElement.getText().contains(expectedText)) {
				System.out.println("Test Case passed and 'Automation Test Engineer' is visible on the next page");
			} else {
				System.out.println("Test Case Failed and 'Automation Test Engineer' is not visible on the next page");
			}

		} catch (Exception e) {
			System.out.println("Test Failed! Error: " + e.getMessage());

		}
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();

	}
}


