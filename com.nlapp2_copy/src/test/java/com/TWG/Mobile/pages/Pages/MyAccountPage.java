package com.TWG.Mobile.pages.Pages;

import org.aspectj.weaver.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.TWG.Mobile.pages.AppiumPageObject;

public class MyAccountPage extends AppiumPageObject {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	Logger logger = LoggerFactory.getLogger(Utils.class);
	
	@FindBy(name = "SIGN IN")
	public WebElement btnSignIn;
	
	@FindBy(name = "REGISTER")
	public WebElement btnRegister;
	
	@FindBy(name = "Forgot password?")
	public WebElement btnForgotPwd;

	@FindBy(name = "account wishlist")
	public WebElement btnWishlist;
	
	@FindBy(name = "account store")
	public WebElement btnStore;
	
	@FindBy(name = "account feedback")
	public WebElement btnFeedBack;
}
