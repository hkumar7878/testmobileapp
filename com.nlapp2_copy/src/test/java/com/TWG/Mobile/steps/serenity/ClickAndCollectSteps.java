package com.TWG.Mobile.steps.serenity;

import org.aspectj.weaver.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.TWG.Mobile.pages.Pages.ClickAndCollectPage;

import net.thucydides.core.steps.ScenarioSteps;

public class ClickAndCollectSteps extends ScenarioSteps{
	
	ClickAndCollectPage ccPage;
	
	Logger logger = LoggerFactory.getLogger(Utils.class);
	
	public void pickYourStore() {
		try {
			ccPage.click_ChooseStore();
			ccPage.searchStore();
			ccPage.select_listedStore();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateContactDetails() {
		try {
			ccPage.enter_FirstName();
			ccPage.enter_LastName();
			ccPage.enter_ContactNumber();
			ccPage.enter_emailAddress();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
