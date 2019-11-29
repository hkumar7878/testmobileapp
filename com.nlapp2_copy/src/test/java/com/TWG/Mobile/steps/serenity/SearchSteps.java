package com.TWG.Mobile.steps.serenity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.TWG.Mobile.pages.Pages.HomePage;
import com.TWG.Mobile.pages.Pages.SearchPage;
import com.ibm.icu.impl.duration.impl.Utils;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SearchSteps extends ScenarioSteps{
	
	SearchPage searchPage;
	HomePage homePage;
	
	Logger logger = LoggerFactory.getLogger(Utils.class);

	@Step
	public void SearchClick() {
		homePage.click_Home();
		searchPage.clickSearch();
	}
	
	@Step
	public void TypeString(String text) {
		searchPage.enterValue(text);
	}
	
	@Step
	public void SearchResultClick() {
		searchPage.selectResult();
	}
}
