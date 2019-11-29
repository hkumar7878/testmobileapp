package com.nlapp.Mobile.Cucumber.StepDef;
//package com.TWG.Mobile.Cucumber.StepDef.iOS;
//
//import org.openqa.selenium.WebDriver;
//
//import com.TWG.Mobile.steps.serenity.iOS.iOSSearchSteps;
//
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import net.thucydides.core.annotations.Managed;
//import net.thucydides.core.annotations.Steps;
//
//public class iOSSearchStepDef {
//
//	@Managed(driver = "appium")
//	WebDriver driver;
//	
//	@Steps
//	iOSSearchSteps searchSteps;
//	
//	
//	@When("^I click Search textbox$")
//	public void i_click_Search_textbox() {
//		searchSteps.SearchClick();
//	}
//
//	@Then("^I enter the term \"([^\"]*)\"$")
//	public void i_enter_the_term(String text) {
//		searchSteps.TypeString(text);
//	}
//
//	@Then("^I click the results to view the products$")
//	public void i_click_the_results_to_view_the_products() {
//		searchSteps.SearchResultClick();
//	}
//}
