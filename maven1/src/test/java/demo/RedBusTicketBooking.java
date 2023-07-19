package demo;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RedBusTicketBooking {
	WebDriver driver;

	@BeforeTest
	public void launchApplication() throws  MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);

		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		driver.get("https://www.redbus.in/");


	}

	@Test
	public void Booking() throws InterruptedException {
		// Find and interact with the source and destination input fields
		WebElement sourceElement = driver.findElement(By.id("src"));
		sourceElement.clear();
		sourceElement.sendKeys("Source City");

		WebElement destinationElement = driver.findElement(By.id("dest"));
		destinationElement.clear();
		destinationElement.sendKeys("Destination City");

		// Select a date using the date picker
		WebElement dateElement = driver.findElement(By.id("onward_cal"));
		dateElement.click();

		WebElement datePicker = driver.findElement(By.id("rb-calendar_onward_cal"));
		WebElement dateCell = datePicker.findElement(By.xpath("//*[@id=\"onwardCal\"]/div/div/text[2]"));
		dateCell.click();

		// Search for available buses
		WebElement searchButton = driver.findElement(By.id("search_btn"));
		searchButton.click();

		// Wait for the search results to load (you may need to adjust the time according to the website's response)
		
		    Thread.sleep(5000);
		
		 // Select a bus from the search results
	        WebElement selectBusButton = driver.findElement(By.xpath("//*[@id=\"search_button\"]"));
	        selectBusButton.click();

	        // Wait for the seat selection page to load
	        Thread.sleep(2000);

	        // Select seats (customize as per the structure of the seat selection page)
	        WebElement seatElement = driver.findElement(By.xpath("//div[@class='seat-layout-container']//div[@class='seat-layout-row'][1]//div[@class='seat available'][1]"));
	        seatElement.click();
	        
	     // Proceed with the booking process (customize as per the structure of the booking page)
	        WebElement proceedButton = driver.findElement(By.id("proceedButton"));
	        proceedButton.click();


	}
		@AfterTest
		public void closeBrowser() {
			driver.quit();

    	}
    }

         
        




