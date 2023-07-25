package com.simplilearn.mavenProject;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class ProductPage {
    private WebDriver driver;

    private By addToCartButton = By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");
    private By cartIcon = By.id("shopping_cart_container");
    private By checkoutButton = By.id("checkout");
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }

    public void clickCartIcon() {
        driver.findElement(cartIcon).click();
        
        
    }
    
    public void clickcheckoutButton() {
        driver.findElement(checkoutButton).click();
        
        
    }
}
