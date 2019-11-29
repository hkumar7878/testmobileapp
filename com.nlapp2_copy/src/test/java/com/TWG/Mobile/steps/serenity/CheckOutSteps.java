package com.TWG.Mobile.steps.serenity;

import org.aspectj.weaver.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.TWG.Mobile.pages.Pages.CartPage;
import com.TWG.Mobile.pages.Pages.CheckOutPage;
import com.TWG.Mobile.pages.Pages.PaymentPage;
import com.TWG.Mobile.pages.Pages.ProdDescPage;
import com.TWG.Mobile.pages.Pages.ProdListPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CheckOutSteps extends ScenarioSteps {
	ProdListPage prodListPage;
	ProdDescPage prodDescPage;
	CartPage cartPage;
	CheckOutPage checkoutPage;
	PaymentPage paymentPage;
	
	Logger logger = LoggerFactory.getLogger(Utils.class);
	

	@Step
	public void selectProduct() {
		prodListPage.selectProductfromPLP();
	}
	
	@Step
	public void addProducToCart() {
		prodDescPage.addToCart();
	}
	
	@Step
	public void fetchCart() {
		prodDescPage.getCart();
	}
	
	@Step
	public void updateDeliveryMethod(String deliveryMethod) {
		cartPage.selectDeliveryMethod(deliveryMethod);
	}
	
	@Step
	public void checkOut() {
		cartPage.clickCheckOut();
	}
	@Step
	public void adddeliveryAddress() {
		checkoutPage.clickAddDeliveryAddress();
	}
	
	@Step
	public void deliveryInstruction() {
		checkoutPage.enterDeliveryInstruction();
	}
	@Step
	public void enableSignature() {
		checkoutPage.enableDeliverySign();
	}
	
	@Step
	public void updatePaymentMethod(String paymentMethod) {
		try {
			checkoutPage.selectPaymentMethod(paymentMethod);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Step
	public void payment() {
		checkoutPage.clickPayment();
	}

	
	@Step
	public void updateCardDetails(String cardNumber, String Name, String Code) {
		paymentPage.enterCardNumber(cardNumber);
		paymentPage.enterNameonCard(Name);
		paymentPage.enterSecurityCode(Code);
	}
	
	@Step
	public void placeAnOrder() {
		paymentPage.clickPlaceOrder();
	}
	
	@Step
	public String retrieveOrderNumber() {
		return paymentPage.fetchOrderNumber();
	}
}
