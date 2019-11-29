package com.nlapp.Mobile.Cucumber.StepDef;

import org.openqa.selenium.WebDriver;

import com.TWG.Mobile.steps.serenity.HomeSteps;
import com.TWG.Mobile.steps.serenity.RegistrationSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

public class RegistrationStepDef {
	@Managed(driver = "appium")
	WebDriver driver;

	
	@Steps
	RegistrationSteps registrationSteps;
	@Steps
	HomeSteps homeSteps;
	
	

	

	@When("^I click Register button on Account Page$")
	public void i_click_Register_button_on_Account_Page() {
		registrationSteps.register();
	}

	@Then("^I landed on the registration page$")
	public void i_landed_on_the_registration_page() {
		registrationSteps.registrationPage();
	}

	@Then("^I enter mandatory details for the registration$")
	public void i_enter_mandatory_details_for_the_registration() {
		registrationSteps.register_NewUser();
	}

	@Then("^I click REGISTER button$")
	public void i_click_REGISTER_button() {
		registrationSteps.register();
	}

	@Then("^I see the user is logged in$")
	public void i_see_the_user_is_logged_in() {
		registrationSteps.register_Confirmation();
	}
}
