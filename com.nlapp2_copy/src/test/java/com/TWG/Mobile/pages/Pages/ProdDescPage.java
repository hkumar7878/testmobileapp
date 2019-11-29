package com.TWG.Mobile.pages.Pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.screenplay.actions.ScrollToWebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;

//import com.TWG.Mobile.pages.AppiumPageObject;

import io.appium.java_client.AppiumDriver;

public class ProdDescPage extends AppiumPageObject {

	public ProdDescPage(WebDriver driver) {
		super(driver);
	}
	
	String text = "ADD TO CART";
	
	@FindBy(accessibilityId = "ADD TO CART", timeoutInSeconds = "10")
	public WebElement btnAddToCart;
	
	@FindBy(accessibilityId = "Cart", timeoutInSeconds = "10")
	public WebElement btnGetCart;
	

//############################################################################################################
//Function Name:		addToCart 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to add an item to the cart
//Tester:				Nagajothi Kaliappan
//############################################################################################################		
	public void addToCart() {
		try {
			Boolean blnFlag = false;
			blnFlag = isElementVisible(By.name("ADD TO CART"));
			System.out.println(blnFlag);
			
			if(blnFlag) {
				clickOn(btnAddToCart);
			}
			else {
				while(!blnFlag) {
					swipeToElement();
					blnFlag = isElementVisible(By.name("ADD TO CART"));
					if(blnFlag) {
						clickOn(btnAddToCart);
						break;
					}
				}
			}		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
//############################################################################################################
//Function Name:		getCart 
//Input Parameter:		None
//Output Parameter:		None
//Description:			This function is used to skip login / registration - Continue as a guest for the actions
//Tester:				Nagajothi Kaliappan
//############################################################################################################		
	public void getCart() {
		try {
			waitFor(5000);
			waitFor(ExpectedConditions.presenceOfElementLocated(By.name("Cart")));
			clickOn(btnGetCart);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
}
