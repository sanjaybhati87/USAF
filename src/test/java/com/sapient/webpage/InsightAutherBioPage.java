/**
 * 
 */
package com.sapient.webpage;

import org.openqa.selenium.WebDriver;

import com.sapient.webelements.ImageElement;

/**
 * @author ssi248
 *
 */
public class InsightAutherBioPage extends WebBasePage{
	
	private static final ImageElement logo = new ImageElement("Wellington logo", parser.getLocator("HomePage_logo"));
	
	public InsightAutherBioPage(WebDriver driver)  {
		super(driver,"InsightAutherBioPage");
		// TODO Auto-generated constructor stub
	}
	
	public boolean isLogoDisplayed()
	{
		waitForElementPresent(logo);
		return logo.isDisplayed();
	}

}
