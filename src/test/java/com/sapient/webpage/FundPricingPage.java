/**
 * 
 *//*
package com.sapient.webpage;

import com.sapient.core.SeleniumTestsContextManager;
import com.sapient.webelements.ImageElement;
import com.sapient.webelements.PageObject;

*//**
 * @author ssi248
 *
 *//*
public class FundPricingPage extends PageObject {
	
private static final ImageElement logo = new ImageElement("Wellington logo", parser.getLocator("HomePage_logo"));
	
	public FundPricingPage(final boolean openPageURL) throws Exception {
		super(logo,openPageURL ? SeleniumTestsContextManager.getThreadContext().getAppURL() : null,"FundPricingPage");
		// TODO Auto-generated constructor stub
	}
	
	public boolean isLogoDisplayed()
	{
		waitForElementPresent(logo);
		return logo.isDisplayed();
	}


}
*/