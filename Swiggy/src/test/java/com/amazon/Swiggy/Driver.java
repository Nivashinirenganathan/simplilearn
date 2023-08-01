package com.amazon.Swiggy;

import org.openqa.selenium.chrome.ChromeDriver;

public class Driver extends Tools {
	
	protected static LocationPage locationpage;
	protected static AddCart addcart;
	protected static SigninPage signinpage;

	public static void init() {
		 driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get("https://www.swiggy.com/");
		    
		     locationpage = new LocationPage(driver);
		     addcart = new AddCart(driver);
		     signinpage = new SigninPage(driver);
}
}
