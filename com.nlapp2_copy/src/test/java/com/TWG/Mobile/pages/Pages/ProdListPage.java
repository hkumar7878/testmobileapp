package com.TWG.Mobile.pages.Pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

//import com.TWG.Mobile.pages.AppiumPageObject;

public class ProdListPage extends AppiumPageObject{

	public ProdListPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "Sort by")
	public WebElement btnSortBy;
	
	@FindBy(name = "Filter")
	public WebElement btnFilter;
	
	@FindBy(name = "backIndicator")
	public WebElement btnBack;
	
	@FindBy(name = "search icon bar item")
	public WebElement btnSearch;
	
	@FindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell")
	public List<WebElement> lstProducts;
	
	@FindBy(name = "add to wishlist card")
	public List<WebElement> lstWishLists;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='ONLINE ONLY']")
	public List<WebElement> lblOnlineOnly;
	
	
	public void selectProductfromPLP() {
		try {
			Boolean blnFlag = false;
			waitFor(5000);
			waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//XCUIElementTypeCollectionView/XCUIElementTypeCell")));
			Random random = new Random();
		    int result = random.nextInt(lstProducts.size());
		    blnFlag = lstProducts.get(result).isDisplayed();
		    if(blnFlag) {
		    	clickOn(lstProducts.get(result));
		    }
		    else {
		    	while(!blnFlag) {
					swipeToElement();
					blnFlag = lstProducts.get(result).isDisplayed();
					if(blnFlag) {
						clickOn(lstProducts.get(result));
						break;
					}
		    	}
		    }
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
	}
}

