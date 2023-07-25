package com.simplilearn.mavenProject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SauceDemoTestNGTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;
    private CheckoutPage checkoutPage;

    @BeforeClass
    public void setUp() {
        
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void testCheckoutFlow() {
        // Step 1: Login
        loginPage.performLogin("standard_user", "secret_sauce");

        // Step 2: Add the first product to the cart
        productPage.clickAddToCartButton();

        // Step 3: Click on the cart icon and proceed to checkout
        productPage.clickCartIcon();
        productPage.clickcheckoutButton();

        // Step 4: Enter details in the checkout page
        checkoutPage.enterFirstName("Park");
        checkoutPage.enterLastName("soe");
        checkoutPage.enterPostalCode("12345");
        checkoutPage.clickContinueButton();
        checkoutPage.clickFinishButton();

        // Step 5: Verify the 'Thank you for your order!' message
        String expectedMessage = "Thank you for your order!";
        Assert.assertTrue(driver.getPageSource().contains(expectedMessage));
    }

    @AfterClass
   public void tearDown() {
        driver.quit();
   }
}




