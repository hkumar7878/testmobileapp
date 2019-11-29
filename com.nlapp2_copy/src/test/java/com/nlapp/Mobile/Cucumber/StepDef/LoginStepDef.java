package com.nlapp.Mobile.Cucumber.StepDef;

import org.openqa.selenium.WebDriver;

import com.TWG.Mobile.steps.serenity.HomeSteps;
import com.TWG.Mobile.steps.serenity.LoginSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

public class LoginStepDef {
	
	@Managed(driver = "appium")
	WebDriver driver;
	
	
	@Steps
	LoginSteps loginSteps;
	
	@Steps
	HomeSteps homeSteps;
	
	
	@Given("^I open the App$")
	public void i_open_the_App() {
	   System.out.println("App launched successfully.");
	}
	
	@When("^I click Account tab$")
	public void i_click_Account_tab() {
		homeSteps.click_accountTab();
	}
	@When("^I click SIGN IN Button on Account Page$")
	public void i_click_SIGN_IN() {
		loginSteps.signin_Btn();
	}

	@Then("^I enter email \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void i_enter_email_and_password(String username, String password) {
		try {
			loginSteps.enterCredentials(username, password);
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}
	@When("^I click SIGN IN on Sign IN Page$")
	public void i_click_SIGN1_IN() {
		loginSteps.signin_Btn();
	}
	

	@Then("^I see the logged in email on Account page$")
	public void i_see_the_logged_in_email_on_Account_page() {
		loginSteps.successLoginStatus();

	}

	@Then("^I see the Login failed pop up$")
	public void i_see_the_Login_failed_pop_up() {
		loginSteps.failedLoginStatus();
	}
}
