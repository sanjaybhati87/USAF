/**
 * 
 */
package com.sapient.webpage;

import org.openqa.selenium.WebDriver;

import com.sapient.webelements.ImageElement;
import com.sapient.webelements.LabelElement;

/**
 * @author ssi248
 *
 */
public class PrivacyPolicy  extends WebBasePage {
	
private static final ImageElement logo = new ImageElement("Wellington logo", parser.getLocator("HomePage_logo"));
private static final LabelElement bannerTex= new LabelElement("Text on banner", parser.getLocator("privacyTextOnBanner"));
	
	
	public PrivacyPolicy(WebDriver driver)  {
		super(driver,"PrivacyPolicy");
		// TODO Auto-generated constructor stub
	}
	
	public String getBannerText()
	{
		return bannerTex.getText();
	}
	
	public boolean isLogoDisplayed()
	{
		waitForElementPresent(logo);
		return logo.isDisplayed();
	}


}
