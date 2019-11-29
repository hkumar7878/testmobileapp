package com.TWG.Mobile.pages.Pages;



import java.io.IOException;


import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.google.common.base.Predicate;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.steps.StepEventBus;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.WebDriverFacade;
import cucumber.api.Scenario;

public class AppiumPageObject extends PageObject {
	
	public String firstName;
	public String lastName;
	public String email;
	public String password;
	public Scenario scenario;
	
	public WebDriver facade = getDriver();
	public WebDriver driver= ((WebDriverFacade) facade).getProxiedDriver();
	
	
//########################################################################################################################################################################	 
	  public AppiumPageObject(WebDriver driver) {
		  super(driver, new Predicate<PageObject>() {
			  @Override
			  public boolean apply(PageObject page) {
	
				  PageFactory
						  .initElements(new AppiumFieldDecorator(((WebDriverFacade) page.getDriver()).getProxiedDriver(),
								  page.getImplicitWaitTimeout()), page);
				  return true;
				  
			  }
	
		  });
	  }
//########################################################################################################################################################################	  
//	 public AndroidDriver<AndroidElement> androidDriver() {
//		    return (AndroidDriver<AndroidElement>)
//		            ((WebDriverFacade) getDriver()).getProxiedDriver();
//		}
//########################################################################################################################################################################	  
	  public boolean isElementPresent(WebElement we) {

		     if(we!=null) {
		    	 return true; 
		    }
		     else {
		         System.out.println("The target is null");
		         return false;
		     }
		 }  
//########################################################################################################################################################################
	  public String nameGenrator() {
		  firstName = RandomStringUtils.randomAlphabetic(5);
		  System.out.println(firstName);
		  lastName = firstName;
		  return firstName;
	  }
//########################################################################################################################################################################	  
	  public String emailGenerator() {
		  
		    int length = 3;
		    boolean useLetters = false;
		    boolean useNumbers = true;
		    String email = RandomStringUtils.random(length, useLetters, useNumbers);
		    System.out.println(email);
		    email = "testAuto"+email+"@gmail.com";
		    System.out.println(email);
			return email;
		}
//########################################################################################################################################################################
	  public String numGenerator(int length) {
		    //int length = 3;
		    boolean useLetters = false;
		    boolean useNumbers = true;
		    String num = RandomStringUtils.random(length, useLetters, useNumbers);
		    System.out.println(num);
//		    num = num + "/";
			return num;
		}
//######################################################################################################################################################################## 
	  public String passwordGenerator() {
		    String password = "Test123";
		    System.out.println(password);
			return password;
		}
//########################################################################################################################################################################
//	  public AndroidDriver androidDriver() {
//		  return (AndroidDriver)((WebDriverFacade) getDriver()).getProxiedDriver();
//	  }
//	  
//	  public AppiumDriver<WebElement> appiumDriverWeb() {
//		     AppiumDriver<WebElement> appiumDriver = ((AppiumDriver<WebElement>) ((WebDriverFacade)
//		             getDriver()).getProxiedDriver());
//		     Set<String> contextNames = appiumDriver.getContextHandles();
//		     System.out.println(contextNames);
//		     waitABit(1500);
//		     for (String contextName : contextNames) {
//		         if (contextName.contains("WEBVIEW_nz.co.thewarehouse.wow.qat")) {
//		             appiumDriver.context(contextName);
////		             return appiumDriver;
//		         }
//		     }
//		     return appiumDriver;
//		 }
//
//		 public AppiumDriver<WebElement> switchToNative() {
//		     AppiumDriver<WebElement> appiumDriver = ((AppiumDriver<WebElement>) ((WebDriverFacade)
//		             getDriver()).getProxiedDriver());
//		     Set<String> contextNames = appiumDriver.getContextHandles();
//		     System.out.println(contextNames);
//		     waitABit(1500);
//		     for (String contextName : contextNames) {
//		         if (contextName.contains("NATIVE_APP")) {
//		             appiumDriver.context(contextName);
//		             return appiumDriver;
//		         }
//		     }
//		     return appiumDriver;
//		 }
		 
//		 public AppiumDriver<WebElement> driver;
		
			
//########################################################################################################################################################################		 
		 public WebElement scrollToAnElementByText(AppiumDriver<WebElement> driver, String text) {
		        return driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
		                ".scrollIntoView(new UiSelector().text(\"" + text + "\"));"));
		}
//########################################################################################################################################################################		 
		 public WebElement scrollToAnElementByExactText(AppiumDriver<WebElement> driver, String text, String id) {
			return driver.findElement(MobileBy.AndroidUIAutomator(
						"new UiScrollable(new UiSelector().resourceId(\"" + id + "\")).scrollIntoView("
						+ "new UiSelector().text(\"" + text + "\"))"));
		}
//########################################################################################################################################################################		 
		public void scrollToElementByJS(AppiumDriver<WebElement> driver,WebElement element) {			
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		}
//########################################################################################################################################################################
		public void scrollToElement(WebElement element) {			
			TouchAction actions = new TouchAction((AppiumDriver)driver);
			actions.moveTo((PointOption) element).release().perform();
		}
//########################################################################################################################################################################
		//Generic function for Scroll
		public void scrollUsingTouchActions_ByElements(WebElement webElement, WebElement webElement2) {
			TouchAction actions = new TouchAction((AppiumDriver)driver);
			actions.press((PointOption) webElement).waitAction().moveTo((PointOption) webElement2).release().perform();
		}
//########################################################################################################################################################################
		public void swipeToElement() throws InterruptedException {
			Thread.sleep(10000);
			Dimension size = driver.manage().window().getSize();
			int starty = (int)(size.height*0.5);
			int endy = (int)(size.height *0.3);
			int startx = size.width/2;
			int endx = startx;
			TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);

		    touchAction.longPress(PointOption.point(startx, starty))
		               .moveTo(PointOption.point(endx, endy))
		               .release()
		               .perform();
		}
//########################################################################################################################################################################		
		public void waitUntilElementClickable(WebElement we, By by) {
			WebDriverWait wait = new WebDriverWait(driver,20);
			we= wait.until(ExpectedConditions.elementToBeClickable(by));
		}
//########################################################################################################################################################################
		public String appiumDriverType(){
			String appiumDriverType;
	        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
	        appiumDriverType = variables.getProperty("appium.platform");
	        return appiumDriverType;
	    }

//########################################################################################################################################################################	
		public void gettestName(Scenario scenario) throws IOException {
			this.scenario = scenario;
		}
//########################################################################################################################################################################	
		public String testName(Scenario scenario) throws IOException {
			System.out.println(scenario.getName());
			return scenario.getName();
		}
//########################################################################################################################################################################	
		public String stepName(){
			String currentStepDescr = StepEventBus.getEventBus().getCurrentStep().get().toString();
			return currentStepDescr;
		}
	}