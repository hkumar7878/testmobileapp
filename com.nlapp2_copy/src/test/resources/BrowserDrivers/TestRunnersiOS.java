package com.TWG.Mobile.testRunners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

import static com.TWG.Mobile.testRunners.AppiumServerController.startAppiumServer;
import static com.TWG.Mobile.testRunners.AppiumServerController.stopAppiumServer;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = {"src/test/resources/features/iOS/iOSCheckout.feature"},
//		glue = {"com.TWG.Mobile.Cucumber.StepDef.iOS"}
		glue = {"com.TWG.Mobile.Cucumber.StepDef"}
		)

public class TestRunnersiOS {

	@BeforeClass
	public static void startAppium() {
		startAppiumServer();
	}

	@AfterClass
	public static void stopAppium() {
		stopAppiumServer();
	}

}
