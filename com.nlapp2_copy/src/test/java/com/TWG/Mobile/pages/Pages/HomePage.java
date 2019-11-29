package com.TWG.Mobile.pages.Pages;

import org.aspectj.weaver.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.TWG.Mobile.pages.AppiumPageObject;

import com.applitools.eyes.appium.Eyes;



public class HomePage extends AppiumPageObject {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	Logger logger = LoggerFactory.getLogger(Utils.class);

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Home']")
	public WebElement btnHome;
	
	@FindBy(name = "Browse")
	public WebElement btnBrowse;
	
	@FindBy(name = "Cart")
	public WebElement btnCart;
	
	@FindBy(name = "Wishlist")
	public WebElement btnWishlist;
	
	@FindBy(name = "Account")
	public WebElement btnAccount;
	
	@FindBy(name = "scan search")
	public WebElement btnScan;
	
	@FindBy(name = "Help")
	public WebElement btnHelp;
	
	@FindBy(name = "Search")
	public WebElement txtSearch;
	
	@FindBy(name = "outlineCamera")
	public WebElement btnCamera;
	
	// Initialize the eyes SDK and set your private API key.
   // Eyes eyes = new Eyes();
	
//############################################################################################################
//Function Name:		click_Account 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to click the Account tab from the bottom section of the app
//Tester:				Nagajothi Kaliappan
//############################################################################################################
	public void click_Account() {
		try {
			element(btnAccount).waitUntilClickable();
			clickOn(btnAccount);
		
            
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
//############################################################################################################
//Function Name:		click_Home 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to click the Home tab from the bottom section of the app
//Tester:				Nagajothi Kaliappan
//############################################################################################################
	public void click_Home() {
		try {
			element(btnHome).waitUntilClickable();
			clickOn(btnHome);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
