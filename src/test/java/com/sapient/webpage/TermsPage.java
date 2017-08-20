/**
 * 
 */
package com.sapient.webpage;

import org.openqa.selenium.WebDriver;

import com.sapient.webelements.LabelElement;

/**
 * @author ssi248
 *
 */
public class TermsPage extends WebBasePage {
	
private static final LabelElement bannerTex= new LabelElement("Text on banner", parser.getLocator("termstextOnBanner"));

	/**
	 * @param driver
	 * @param pagename
	 */
	public TermsPage(WebDriver driver) {
		super(driver, "TermsPage");
		// TODO Auto-generated constructor stub
	}
	public String getBannerText()
	{
		return bannerTex.getText();
	}
}
