package com.TWG.Mobile.steps.serenity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.TWG.Mobile.pages.Pages.HomePage;
import com.ibm.icu.impl.duration.impl.Utils;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class HomeSteps extends ScenarioSteps{
		
	HomePage homePage;
	Logger logger = LoggerFactory.getLogger(Utils.class);
	
	@Step
	public void click_accountTab() {
		homePage.click_Account();
	}
	
}
