package com.TWG.Mobile.pages.Pages;

import org.aspectj.weaver.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.TWG.Mobile.pages.AppiumPageObject;

import net.serenitybdd.core.annotations.findby.FindBy;

public class ClickAndCollectPage extends AppiumPageObject {

	public ClickAndCollectPage(WebDriver driver) {
		super(driver);
	}
	
	Logger logger = LoggerFactory.getLogger(Utils.class);
	
	@FindBy(accessibilityId = "Choose", timeoutInSeconds="10")
	public WebElement btnChooseStore;
	public static final By chooseStore = By.name("Choose");
	
	@FindBy(accessibilityId = "Search", timeoutInSeconds="10")
	public WebElement txtSearchStore;
	public static final By searchStore = By.name("Search");
	
	@FindBy(className="XCUIElementTypeCell", timeoutInSeconds="10")
	public WebElement lstStore;
	
	@FindBy(xpath="//XCUIElementTypeTextField[@value='First Name']", timeoutInSeconds="10")
	public WebElement txtFirstName;
	public static final By firstName = By.xpath("//XCUIElementTypeTextField[@value='First Name']");
	
	@FindBy(xpath="//XCUIElementTypeTextField[@value='Last Name']", timeoutInSeconds="10")
	public WebElement txtLastName;
	public static final By lastName = By.xpath("//XCUIElementTypeTextField[@value='Last Name']");
	
	@FindBy(xpath="//XCUIElementTypeTextField[@value='Contact Number']", timeoutInSeconds="10")
	public WebElement txtContactNum;
	public static final By contactNum = By.xpath("//XCUIElementTypeTextField[@value='Contact Number']");
	
	@FindBy(xpath="//XCUIElementTypeTextField[@value='Email']", timeoutInSeconds="10")
	public WebElement txtEmail;
	public static final By email = By.xpath("//XCUIElementTypeTextField[@value='Email']");
	
	//############################################################################################################
	//Function Name:		click_ChooseStore 
	//Input Parameter:		None
	//Output Parameter:		None
	//Description:			This function is used to click "Choose a store" from the click and collect page
	//Tester:				Nagajothi Kaliappan
	//############################################################################################################	

	public void click_ChooseStore() {
		try {
			if(isElementVisible(chooseStore)) {
				clickOn(btnChooseStore);
			}
			else {
				logger.info("Choose store is not visible.");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//############################################################################################################
	//Function Name:		searchStore 
	//Input Parameter:		None
	//Output Parameter:		None
	//Description:			This function is used to pick your preferred store from the click and collect page
	//Tester:				Nagajothi Kaliappan
	//############################################################################################################	

	public void searchStore() {
		try {
			if(isElementVisible(searchStore)) {
				typeInto(txtSearchStore, "Napier");
			}
			else {
				logger.info("Search store option is not available");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//############################################################################################################
	//Function Name:		select_listedStore 
	//Input Parameter:		None
	//Output Parameter:		None
	//Description:			This function is used to select the listed store from the result
	//Tester:				Nagajothi Kaliappan
	//############################################################################################################	

	public void select_listedStore() {
		try {
			selectFromDropdown(lstStore, "Napier");
//			clickOn(lstStore);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//############################################################################################################
	//Function Name:		enter_FirstName 
	//Input Parameter:		None
	//Output Parameter:		None
	//Description:			This function is used to enter the first name at click and collect page
	//Tester:				Nagajothi Kaliappan
	//############################################################################################################	

	public void enter_FirstName() {
		try {
			if(isElementVisible(firstName)) {
				typeInto(txtFirstName, "Nagajothi");
			}
			else {
				logger.info("First Name field is not visible");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//############################################################################################################
	//Function Name:		enter_LastName 
	//Input Parameter:		None
	//Output Parameter:		None
	//Description:			This function is used to enter the last name at click and collect page
	//Tester:				Nagajothi Kaliappan
	//############################################################################################################	

	public void enter_LastName() {
		try {
			if(isElementVisible(lastName)) {
				typeInto(txtLastName, "Kaliappan");
			}
			else {
				logger.info("Last Name field is not visible");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//############################################################################################################
	//Function Name:		enter_ContactNumber 
	//Input Parameter:		None
	//Output Parameter:		None
	//Description:			This function is used to enter the contact number at click and collect page
	//Tester:				Nagajothi Kaliappan
	//############################################################################################################	

	public void enter_ContactNumber() {
		try {
			if(isElementVisible(contactNum)) {
				typeInto(txtContactNum, "028525825");
			}
			else {
				logger.info("Contact number field is not visible");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//############################################################################################################
	//Function Name:		enter_ContactNumber 
	//Input Parameter:		None
	//Output Parameter:		None
	//Description:			This function is used to enter the contact number at click and collect page
	//Tester:				Nagajothi Kaliappan
	//############################################################################################################	

	public void enter_emailAddress() {
		try {
			if(isElementVisible(email)) {
				typeInto(txtEmail, "smoketest@gmail.com");
			}
			else {
				logger.info("Email address field is not visible");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
