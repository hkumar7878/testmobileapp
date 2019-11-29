package com.TWG.Mobile.pages.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


//import com.TWG.Mobile.pages.AppiumPageObject;

public class SearchPage extends AppiumPageObject {

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "Search")
	public WebElement txtSearch;
	
	@FindBy(xpath = "//XCUIElementTypeTable[@name='Search results']/XCUIElementTypeCell")
	public List<WebElement> lstSearchResults;
	
	@FindBy(xpath = ".//*[contains(@name,'results for')]")
	public WebElement resultsFor;
	
	@FindBy(xpath = ".//*[contains(@name,'No results for')]")
	public WebElement noResult;

	public void clickSearch() {
		try {
			if(isElementPresent(txtSearch)) {
				clickOn(txtSearch);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enterValue(String text) {
		try {
			clickOn(txtSearch);
			typeInto(txtSearch, text);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectResult() {
		try {
			waitFor(150000);
			if(lstSearchResults.size()!=0) {
				waitForRenderedElementsToBePresent(By.xpath("//XCUIElementTypeTable[@name='Search results']/XCUIElementTypeCell"));
				for(WebElement searchResult : lstSearchResults) {
					element(searchResult).waitUntilVisible();
					searchResult.click();
					waitFor(150000);
					break;
				}
			}
			else if(isElementPresent(resultsFor)) {
				clickOn(resultsFor);
			}
			else if(isElementPresent(noResult)) {
				System.out.println("No Results found");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
