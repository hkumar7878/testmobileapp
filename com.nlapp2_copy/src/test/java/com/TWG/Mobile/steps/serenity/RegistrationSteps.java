package com.TWG.Mobile.steps.serenity;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.TWG.Mobile.pages.Pages.RegisterPage;
import com.ibm.icu.impl.duration.impl.Utils;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class RegistrationSteps extends ScenarioSteps {

	RegisterPage registerPage;
	Logger logger = LoggerFactory.getLogger(Utils.class);
	
	
	@Step
	public void register() {
		registerPage.click_Register();
	}
	
	@Step
	public void registrationPage() {
		String txtHeader = registerPage.verify_RegistrationHeader();
		Assert.assertEquals("Registration Page", "Registration", txtHeader);
	}
	
	@Step
	public void register_NewUser() {
		registerPage.input_text(registerPage.txtFirstName, registerPage.firstName());
		registerPage.input_text(registerPage.txtLastName, registerPage.lastName());
		registerPage.input_text(registerPage.txtEmail, registerPage.email());
		registerPage.input_text(registerPage.txtPassword, registerPage.password());
	}
	
	@Step
	public void register_Confirmation() {
		registerPage.reg_Confirmation();
	}
}
