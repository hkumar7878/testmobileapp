package com.TWG.Mobile.pages.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

//import com.TWG.Mobile.pages.AppiumPageObject;

import io.appium.java_client.AppiumDriver;
import net.serenitybdd.core.annotations.findby.FindBy;

public class PaymentPage extends AppiumPageObject{

	public PaymentPage(WebDriver driver) {
		super(driver);
	}
	public String orderNum = "";

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Order Number:')]", timeoutInSeconds = "10")
	public WebElement lblOrderNumber;
	//Ratings button
	@FindBy(accessibilityId = "Not Now", timeoutInSeconds = "10")
	public WebElement btnNotNow;
	//close button on the confirmation
	@FindBy(accessibilityId = "Close", timeoutInSeconds = "10")
	public WebElement btnClose;
	
	public static final By txtCardNumber =By.xpath("//XCUIElementTypeOther[@name='Credit Card Information']/XCUIElementTypeOther[3]/XCUIElementTypeTextField");
	public static final By txtNameOnCard =By.xpath("//XCUIElementTypeOther[@name='Credit Card Information']/XCUIElementTypeOther[5]/XCUIElementTypeTextField");
//	public static final By txtSecurityCode =By.xpath("//XCUIElementTypeOther[@name='Credit Card Information']/XCUIElementTypeTextField");
	public static final By txtSecurityCode =By.xpath("(//XCUIElementTypeLink[@name='What is this?'])[1]//preceding-sibling::XCUIElementTypeTextField");
	public static final By btnPlaceOrder =By.name("Place order now");
	public static final By btnCancel =By.name("Cancel");
	public static final By lstExpiryMonth =By.xpath("//XCUIElementTypeOther[@name='Expiry date']/XCUIElementTypeOther[3]");
	public static final By lstExpiryYear =By.xpath("//XCUIElementTypeOther[@name='Expiry date']/XCUIElementTypeOther[5]");
	public static final By toogleRemember =By.className("XCUIElementTypeSwitch");// value 1 - on else value - 0 off
	
	
	//Part Pay Elements
	
	public static final By btnEditEmail =By.xpath("//XCUIElementTypeOther[@name='PartPay']/XCUIElementTypeOther[5]//following::XCUIElementTypeButton[1]");
	public static final By txtEmailAddress =By.className("XCUIElementTypeTextField");
	public static final By txtPassword =By.className("XCUIElementTypeSecureTextField");
	public static final By btnNext =By.xpath(".//XCUIElementTypeButton[@name='NEXT']");
//	public static final By lnkSeePayment =By.xpath(".//android.view.View[contains(@text,'See Payments Schedule and Dates')]");
	public static final By txtCVC =By.className("XCUIElementTypeTextField");
	public static final By chkBoxTC =By.xpath("//XCUIElementTypeOther[@name='PartPay Payment']/XCUIElementTypeOther[40]/XCUIElementTypeOther");

	
//############################################################################################################
//Function Name:		enterCardNumber 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to enter the card number during the check out journey
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	@SuppressWarnings("rawtypes")
	public void enterCardNumber(String cardNumber) {
		waitFor(20000);
		try {
			swipeToElement();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(txtCardNumber).click();
		typeInto(driver.findElement(txtCardNumber), cardNumber);
   }
	
//############################################################################################################
//Function Name:		enterNameonCard 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to enter the card name during the check out journey
//Tester:				Nagajothi Kaliappan
//############################################################################################################		
	@SuppressWarnings("rawtypes")
	public void enterNameonCard(String name) {
		waitFor(10000);
		driver.findElement(txtNameOnCard).click();
		typeInto(driver.findElement(txtNameOnCard), name);
	}

//############################################################################################################
//Function Name:		enterSecurityCode 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to enter security code during card payment
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	@SuppressWarnings("rawtypes")
	public void enterSecurityCode(String code) {
		waitFor(10000);
		System.out.println(driver.getPageSource());
		driver.findElement(txtSecurityCode).click();
		typeInto(driver.findElement(txtSecurityCode), code);
	}

//############################################################################################################
//Function Name:		clickPlaceOrder 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to click place order button
//Tester:				Nagajothi Kaliappan
//############################################################################################################		
	public void clickPlaceOrder() {
		driver.findElement(btnPlaceOrder).click();
	}
	
//############################################################################################################
//Function Name:		fetchOrderNumber 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to retrieve the order details once the order is placed successfully
//Tester:				Nagajothi Kaliappan
//############################################################################################################		
	public String fetchOrderNumber() {
		waitFor(30000);
	    waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[contains(@name,'Order Number:')]")));
		orderNum = lblOrderNumber.getText().split("Order Number: ")[1];
		return orderNum;
	}

//############################################################################################################
//Function Name:		enterPartPayEmail 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to add part pay email during checkout journey 
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	@SuppressWarnings("rawtypes")
	public void enterPartPayEmail(String email) {
		waitFor(60000);
		try {
			driver.findElement(btnEditEmail).click();
			driver.findElement(txtEmailAddress).clear();
			driver.findElement(txtEmailAddress).sendKeys(email);
			((AppiumDriver)driver).hideKeyboard();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

//############################################################################################################
//Function Name:		enterPartPayPasswrod 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to add part pay password during checkout journey 
//Tester:				Nagajothi Kaliappan
//############################################################################################################		
	@SuppressWarnings("rawtypes")
	public void enterPartPayPasswrod(String password) {
		waitFor(10000);
		try {
			swipeToElement();
			driver.findElement(txtPassword).click();
			driver.findElement(txtPassword).sendKeys(password);
			((AppiumDriver)driver).hideKeyboard();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
//############################################################################################################
//Function Name:		clickNext 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to click next after entering part pay email and password during checkout journey 
//Tester:				Nagajothi Kaliappan
//############################################################################################################		
	public void clickNext() {
		waitFor(10000);
		try {
			driver.findElement(btnNext).click();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
//############################################################################################################
//Function Name:		enterCVC 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to enter cvc during checkout journey 
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	@SuppressWarnings("rawtypes")
	public void enterCVC(String cvc) {
		waitFor(20000);
		try {

//					MobileElement elepay = (MobileElement) driver.findElement(lnkSeePayment);
//					MobileElement elecvc = (MobileElement) driver.findElement(txtCVC);	
//					scrollUsingTouchActions_ByElements(elepay, elecvc);
			
//					scrollToElementByJS((AppiumDriver<WebElement>)driver, element(txtCVC));
//					scrollToAnElementByText((AppiumDriver<WebElement>)driver, "CVC (Required)*");
			swipeToElement();
			waitFor(20000);
			swipeToElement();
			clickOn(driver.findElement(txtCVC));   
		    driver.findElement(txtCVC).sendKeys(cvc);
		    ((AppiumDriver)driver).hideKeyboard();
		}catch(Exception e) {
			e.printStackTrace();
		}
	    
	}
	
//############################################################################################################
//Function Name:		acceptTandC 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to enter cvc during checkout journey 
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	@SuppressWarnings("rawtypes")
	public void acceptTandC() {
		waitFor(10000);
		try {
			 clickOn(driver.findElement(chkBoxTC));
		}catch(Exception e) {
			e.printStackTrace();
		}
	      
	}
}
