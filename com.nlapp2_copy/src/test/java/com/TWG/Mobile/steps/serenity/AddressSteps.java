package com.TWG.Mobile.steps.serenity;

import org.aspectj.weaver.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.TWG.Mobile.pages.Pages.AddressPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class AddressSteps extends ScenarioSteps {
	
	AddressPage addressPage;
	
	Logger logger = LoggerFactory.getLogger(Utils.class);
	
	@Step
	public void enterNewAddress() {
		addressPage.enterNewDeliveryAddress();
	}
	
	@Step
	public void selectNewAddress() {
		addressPage.selectDeliveryAddressfromList();
	}
	
	@Step
	public void updateAddressDetails() {
		addressPage.updateDeliveryAddress();
	}
	
	@Step
	public void saveAddressDetails() {
		addressPage.saveDeliveryAddress();
	}
}
