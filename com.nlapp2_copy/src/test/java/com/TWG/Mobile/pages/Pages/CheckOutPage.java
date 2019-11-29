package com.TWG.Mobile.pages.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

//import com.TWG.Mobile.pages.AddressPage;
//import com.TWG.Mobile.pages.AppiumPageObject;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

public class CheckOutPage extends AppiumPageObject {

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(accessibilityId = "Credit Card", timeoutInSeconds="10")
	public WebElement radioCC;
	
	@FindBy(accessibilityId = "Warehouse Money Card", timeoutInSeconds="10")
	public WebElement radioWMC;
	
	@FindBy(accessibilityId  = "PartPay", timeoutInSeconds="10")
	public WebElement radioPP;

	@FindBy(name = "PAYMENT", timeoutInSeconds="10")
	public WebElement btnPayment;
	
	@FindBy(name = "Add", timeoutInSeconds="10")
	public WebElement btnAddDeliAddress;
	
	@FindBy(xpath = "//XCUIElementTypeImage[@name='checkout-instructions']//following-sibling::XCUIElementTypeTextField", timeoutInSeconds="10")
	public WebElement txtDeliInstruction;
	
	@FindBy(className = "XCUIElementTypeSwitch", timeoutInSeconds="10")
	public WebElement toggleDeliSign;
	
	@FindBy(xpath = "//XCUIElementTypeTextField[@value='Add Promo Code']", timeoutInSeconds="10")
	public WebElement txtPromoCode;
	
	
	
	
//############################################################################################################
//Function Name:		selectPaymentMethod 
//Input Parameter:		paymentMethod
//Output Parameter:		None
//Description:			This function is used to select the different payment method on check out page
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
			
	public void selectPaymentMethod(String paymentMethod) throws InterruptedException {
		try {
			waitFor(3000);
			switch(paymentMethod){
				case "Credit Card":
					Boolean blnFlag = false;
					blnFlag = isElementVisible(By.name("Credit Card"));
					System.out.println(blnFlag);
					if (!blnFlag) {
						swipeToElement();
						waitFor(5000);
						waitFor(ExpectedConditions.presenceOfElementLocated(By.name("Credit Card")));
						radioCC.click();
						break;
					}
					else {
						waitFor(5000);
						waitFor(ExpectedConditions.presenceOfElementLocated(By.name("Credit Card")));
						radioCC.click();
						break;
					}
				case "Warehouse Money Card":
					Boolean blnFlag1 = false;
					blnFlag1 = isElementVisible(By.name("Warehouse Money Card"));
					System.out.println(blnFlag1);
					if (!blnFlag1) {
						swipeToElement();
						waitFor(5000);
						waitFor(ExpectedConditions.elementToBeClickable(radioWMC));
						radioWMC.click();
						break;
					}
					else {
						waitFor(5000);
						waitFor(ExpectedConditions.elementToBeClickable(radioWMC));
						radioWMC.click();
						break;
					}
				case "PartPay":
					Boolean blnFlag11 = false;
					blnFlag11 = isElementVisible(By.name("Part Pay"));
					System.out.println(blnFlag11);
					if (!blnFlag11) {
						swipeToElement();
						waitFor(5000);
						waitFor(ExpectedConditions.elementToBeClickable(radioPP));
						radioPP.click();
						break;
					}
					else {
						waitFor(5000);
						waitFor(ExpectedConditions.elementToBeClickable(radioPP));
						radioPP.click();
						break;
					}
				default:
					break;
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
//############################################################################################################
//Function Name:		clickPayment 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to click the payment button on check out page
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	
	public void clickPayment() {
		try {
			waitFor(10000);
			waitFor(ExpectedConditions.presenceOfElementLocated(By.name("PAYMENT")));
			clickOn(btnPayment);
			waitFor(50000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
//############################################################################################################
//Function Name:		clickAddDeliveryAddress 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to click the Add button to add new delivery addresses
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	
	public void clickAddDeliveryAddress() {
		try {
			if(isElementPresent(btnAddDeliAddress)) {
				clickOn(btnAddDeliAddress);
				waitFor(AddressPage.txtAddressSearch);
			}
			waitFor(5000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

//############################################################################################################
//Function Name:		enableDeliverySign 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to enable the delivery signature required
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	
	public void enableDeliverySign() {
		try {
			if(isElementPresent(toggleDeliSign)) {
				clickOn(toggleDeliSign);
			}
			waitFor(5000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}	
	

//############################################################################################################
//Function Name:		enterDeliveryInstruction 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to enter the delivery instructions
//Tester:				Nagajothi Kaliappan
//############################################################################################################	
	
	public void enterDeliveryInstruction() {
		try {
			if(isElementPresent(txtDeliInstruction)) {
				typeInto(txtDeliInstruction, "Ring the bell");
			}
			waitFor(15000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}	
}
