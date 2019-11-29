package com.TWG.Mobile.pages.Pages;

import org.aspectj.weaver.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.webdriver.WebDriverFacade;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.TWG.Mobile.pages.AppiumPageObject;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.appium.Eyes;

public class LoginPage extends AppiumPageObject {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	Logger logger = LoggerFactory.getLogger(Utils.class);
	
	//@FindBy(name = "login_email")
	//public WebElement txtEmail;
	
	@FindBy(xpath = "//XCUIElementTypeTextField")
	public WebElement txtEmail;
	
	@FindBy(xpath = "//XCUIElementTypeSecureTextField")
	public WebElement txtPassword;
	
	@FindBy(name = "Forgot password?")
	public WebElement btnForgotPwd;
	
	@FindBy(name = "SIGN IN")
	public WebElement btnSignIn;
	
	@FindBy(name = "Create New Account")
	public WebElement btnCreateAccount;
	
	@FindBy(name = "Login failed")//label	Login failed
	public WebElement altLoginFail;
	
	@FindBy(name = "Reset password")
	public WebElement btnResetPwd;
	
	@FindBy(name = "Try Again")
	public WebElement btnTryAgain;
	
	@FindBy(name = "account-big")
	public WebElement imgLogin;
	
	// Initialize the eyes SDK and set your private API key.
    Eyes eyes = new Eyes();
		
//############################################################################################################
//Function Name:		click_Signin 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to click the Sign in button from log in page
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	
	public void click_Signin() {
		try {
			element(btnSignIn).waitUntilClickable();
			clickOn(btnSignIn);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

//############################################################################################################
//Function Name:		enter_UserName 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to enter an email address
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	
	public void enter_UserName(String username) {
		try {
			//clickOn(txtEmail);
			typeInto(txtEmail, username);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
//############################################################################################################
//Function Name:		enter_Password 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to enter the password
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	
	public void enter_Password(String password) {
		try {
			clickOn(txtPassword);
			typeInto(txtPassword, password);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
		
		
//############################################################################################################
//Function Name:		waitForAccountPage 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to wait for a account page 
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	
	public void waitForAccountPage() {
		try {
			waitFor(5000);
			waitFor(ExpectedConditions.visibilityOf(imgLogin));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
//############################################################################################################
//Function Name:		validate_LoginFailure 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to verify the failure login
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	
	public String validate_LoginFailure() {
		String txtLoginStatus = null;
		try {
			if(isElementPresent(altLoginFail)) {
				txtLoginStatus = altLoginFail.getAttribute("label");
			}
			else {
				logger.info("Login Failure message is not available.");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return txtLoginStatus;
	}
		
//############################################################################################################
//Function Name:		validate_LoginSuccess 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to verify the successful login
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	
	public Boolean validate_LoginSuccess() {
		Boolean txtLoginStatus = false;
		try {
			waitForAccountPage();
			if(isElementPresent(imgLogin)) {
				txtLoginStatus = true;
			}
			else {
				logger.info("Email address for successful login is not validated.");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return txtLoginStatus;
	}
	

}
