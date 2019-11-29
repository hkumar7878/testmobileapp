package com.TWG.Mobile.testRunners;
import java.util.HashMap;
import java.util.Map;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.saucelabs.saucerest.SauceREST;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;


public class SauceLabsWatcher extends TestWatcher {

	    private boolean sauceLabsOn = false;

	    private SauceREST sauceRestClient;

	    @Override
	    protected void succeeded(Description description) {
	        if(sauceLabsOn){
	            sauceRestClient.jobPassed(Serenity.getCurrentSessionID());
	        }
	    }

	    @Override
	    protected void failed(Throwable e, Description description) {
	        if(sauceLabsOn) {
	            sauceRestClient.jobFailed(Serenity.getCurrentSessionID());
	        }
	    }

	    @Override
	    protected void finished(Description description) {
	        if(sauceLabsOn) {
	            updateSauceLabsTestName(description);
	        }
	    }

	    private void updateSauceLabsTestName(Description description) {
	        Map<String, Object> sauceJob = new HashMap<>();
	        sauceJob.put("name", prepareTestName(description));
	        sauceRestClient.updateJobInfo(Serenity.getCurrentSessionID(), sauceJob);
	    }

	    private String prepareTestName(Description description) {
	        String methodName = description.getMethodName().replace("_", " ");
	        return methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
	    }

	    @Override
	    protected void starting(Description description) {
	        super.starting(description);
	        initialiseSauceRestClient();
	    }

	    private void initialiseSauceRestClient() {
	        EnvironmentVariables loadedEnvironmentVariables = Injectors.getInjector().getProvider(EnvironmentVariables.class).get();

	          if (isSauceLabsUrlProvided(loadedEnvironmentVariables)){
	            sauceLabsOn = true;
	            setupSauceRestClient(loadedEnvironmentVariables);
	        }
	    }

	    private void setupSauceRestClient(EnvironmentVariables loadedEnvironmentVariables) {
	        String userID = getSauceLabsUserFrom(loadedEnvironmentVariables);
	        String key = getSauceLabsKeyFrom(loadedEnvironmentVariables);
	        sauceRestClient = new SauceREST(userID, key);
	    }

	    private boolean isSauceLabsUrlProvided(EnvironmentVariables loadedEnvironmentVariables) {
	        String url = loadedEnvironmentVariables.getProperty(ThucydidesSystemProperty.SAUCELABS_URL);
	        return isNotEmpty(url);
	    }

	    private boolean isNotEmpty(String url) {
	    	boolean blnFlag = false;
			if(url != null) {
				return blnFlag;
			}
			return blnFlag;
			
		}

		private String getSauceLabsKeyFrom(EnvironmentVariables loadedEnvironmentVariables) {
	        return loadedEnvironmentVariables.getProperty(ThucydidesSystemProperty.SAUCELABS_ACCESS_KEY);
	    }

	    private String getSauceLabsUserFrom(EnvironmentVariables loadedEnvironmentVariables) {
	        return loadedEnvironmentVariables.getProperty(ThucydidesSystemProperty.SAUCELABS_USER_ID);
	    }
}
