package com.TWG.Mobile.steps.serenity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.TWG.Mobile.pages.Pages.LoginPage;
import com.ibm.icu.impl.duration.impl.Utils;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class LoginSteps extends ScenarioSteps{
	
	LoginPage loginPage;
	Logger logger = LoggerFactory.getLogger(Utils.class);
	
	@Step
	public void signin_Btn() {
		loginPage.click_Signin();
	}
	
	@Step
	public void enterCredentials(String username, String password) throws Throwable{
		loginPage.enter_UserName(username);
		loginPage.enter_Password(password);
	}
	
	@Step
	public void failedLoginStatus() {
		try {
			String strStatus = loginPage.validate_LoginFailure();
			assertEquals("Successful Login", strStatus, "Login failed");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Step
	public void successLoginStatus() {
		try {
			Boolean strStatus = loginPage.validate_LoginSuccess();
			assertTrue(strStatus);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
