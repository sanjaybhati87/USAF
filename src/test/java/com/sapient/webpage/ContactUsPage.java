/**
 * 
 */
package com.sapient.webpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sapient.webelements.ButtonElement;
import com.sapient.webelements.ImageElement;
import com.sapient.webelements.LabelElement;
import com.sapient.webelements.LinkElement;

/**
 * @author ssi248
 *
 */
public class ContactUsPage extends WebBasePage {
	
	private static final LabelElement officeLocationsLink = new LabelElement("Office Locations link under flyout", parser.getLocator("officeLocations"));
	private static final LabelElement requestInformationLink = new LabelElement("Request Information link under flyout", parser.getLocator("requestInformation"));
	private static final LabelElement localContacts = new LabelElement("Request Information link under flyout", parser.getLocator("localContacts"));
	private static final LabelElement submitRequest = new LabelElement("Request Information link under flyout", parser.getLocator("submitRequest"));
	private static final LinkElement allOfficeLocation = new LinkElement("All Office Location link on Contact us page",parser.getLocator("allOfficeLocation"));

	
	
	public ContactUsPage(WebDriver driver) {
		super(driver,"ContactUsPage");
		// TODO Auto-generated constructor stub
	}
	
	public String getBackgroundClourofLocalContact()
	{
		return localContacts.getBacgroundColor();
	}
	
	public String getBackgroundClourofSubmitRequest()
	{
		return submitRequest.getBacgroundColor();
	}
	
	public ContactUsPage clickOnOfficeLocationsLinkUnderFlyout()
	{
		mouseHoverAndClick(contactUsLink, requestInformationLink);
		
		return this;
	}
	
	public ContactUsPage clickOnRequestInformationLinkLinkUnderFlyout()
	{
		mouseHoverAndClick(contactUsLink, officeLocationsLink);
		
		return this;
	}
	
	public ContactUsPage clickOnAllofficeLocationLink()
	 {
		 waitForElementPresent(allOfficeLocation);
		 //officeLocation.click();
		 clickByJavaScript(allOfficeLocation);
		 return new ContactUsPage(driver);
	 }
}
