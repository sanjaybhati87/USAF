/**
 * 
 */
package com.sapient.webpage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sapient.core.SeleniumTestsContextManager;
import com.sapient.webelements.ButtonElement;
import com.sapient.webelements.ImageElement;
import com.sapient.webelements.LabelElement;
import com.sapient.webelements.LinkElement;
import com.sapient.webelements.PageObject;

/**
 * @author ssi248
 *
 */
public class WebBasePage extends PageObject {

	/**
	 * @param string2 
	 * @param string 
	 * @param logo2 
	 * @throws Exception
	 */
	public WebBasePage(WebDriver driver,String pagename) {
		super(driver,pagename);
		// TODO Auto-generated constructor stub
	}
	
	public static String footnote1="Past performance is no guarantee of future performance and can be misleading. Funds returns are shown net of fees. Source: Wellington Management © 2016 Morningstar. All Rights Reserved. The information contained herein: (1) is proprietary to Morningstar and/or its content providers; (2) may not be copied or distributed; and (3) is not warranted to be accurate, complete or timely. Neither Morningstar nor its content providers are responsible for any damages or losses arising from any use of this information. Past performance is no guarantee of future results.";
	public static String footnote2="*All figures shown are for Wellington Management, as at 31 March 2016";
	public static String textAboveFooter ="We seek to exceed the investment objectives and service expectations of our fund investors and their advisers worldwide.";
	public static String textBelowFooter1 ="© Copyright 2016 Wellington Management International Ltd. All rights reserved.";
	public static String textBelowFooter2= "Wellington Management ® and Wellington Management Funds ® are registered service marks of Wellington Group Holdings LLP.";
	public static String textBelowFooter3="Wellington Management International Limited. Registered in England and Wales 04283513. Registered office: Cardinal Place, 80 Victoria Street, London SW1E 5JL, United Kingdom. Authorised and regulated by the Financial Conduct Authority of the United Kingdom.";
	public static String textBelowFooter4="For professional investors and intermediaries only. Not suitable for retail investors.";
	public static String disclosureandFootnoteDiscription= footnote1+footnote2;
	


	protected static final ImageElement logo = new ImageElement("Wellington logo", parser.getLocator("Wellington_logo"));
	protected static final LinkElement fundLink = new LinkElement("Funds link on global header",parser.getLocator("header_Fund"));
	 protected static final LinkElement capabilitiesLink = new LinkElement("Capabilities link on global header",parser.getLocator("header_Capabilities"));
	 protected static final LinkElement LitratureLink = new LinkElement("Litrature link on global header",parser.getLocator("header_Litrature"));
	 protected static final LinkElement insightsLink = new LinkElement("Insight link on global header",parser.getLocator("header_Insights"));
	 protected static final LinkElement contactUsLink = new LinkElement("ContactUs link on global header",parser.getLocator("header_contact"));
	 protected static final LinkElement searchIcon = new LinkElement("Search icon on global header",parser.getLocator("header_search"));
	 protected static final ButtonElement serchbutton = new ButtonElement("Enter search button", parser.getLocator("Search_enter"));
	 protected static final LinkElement loggedinUserLink = new LinkElement("Logged in user icon",parser.getLocator("logged_in_user"));
	 protected static final LinkElement logOutLink = new LinkElement("Log Out link",parser.getLocator("logout"));
	 protected static final LabelElement footNoteAndDisclosure = new LabelElement("FootNote &DEsclosure", parser.getLocator("footNoteAndDisclosure"));
	 protected static final LabelElement footNoteAndDisclosureText = new LabelElement("FootNote &DEsclosure", parser.getLocator("DisclosureAndFootnoteText"));
	 protected static final LinkElement footerText = new LinkElement("Footer text above footer links",parser.getLocator("footer_text"));
	 protected static final LinkElement termsLink = new LinkElement("Terms link on global footer",parser.getLocator("terms_link"));
	 protected static final LinkElement privacyLink = new LinkElement("Privacy link on global Footer",parser.getLocator("privacy_link"));
	 protected static final LinkElement cookieLink = new LinkElement("Cookies link on global footer",parser.getLocator("cookie_link"));
	 protected static final LabelElement textbelowFoter = new LabelElement("Text below global footer",parser.getLocator("below_footer"));
	 protected static final LabelElement cokieText = new LabelElement("Text on coockie section",parser.getLocator("cookiPlolicy_text"));
	 protected static final LinkElement CookieLearnMore = new LinkElement("Learn more link on cookie sectionr",parser.getLocator("cookiePolicy_learnMore"));
	 protected static final LinkElement CookieCloseLink = new LinkElement("Close link on cookie sectionr",parser.getLocator("cookiePolicy_close"));
	 protected static final LinkElement visitSite = new LinkElement("Visit site link on admin page",parser.getLocator("visitSite"));
	 protected static final LinkElement fundlandingLinkOnAdminPage = new LinkElement("Fund Landing link on admin Page",parser.getLocator("wellingtonfundLanding"));
	
   
	 
	 
	 public boolean isWellingtonLogoDisplayed()
	 {
		 return logo.isDisplayed();
	 }
	 
	 public void clickOnSiteLink()
	 {
		 waitForElementPresent(visitSite);
		 visitSite.click();
	 }
	 
	 public void clickOnWellingtonLogo() 
	 {
		 waitForElementPresent(logo);
		 logo.click();
		 
	 }
	 
	 public boolean isFundsLinkDisplayedOnHeader()
	 {
		 waitForElementPresent(fundLink);
		 return fundLink.isDisplayed();
	 }
	 
	 public String getTextOfFundsLink()
	 {
		 waitForElementPresent(fundLink);
		 return fundLink.getText();
	 }
	 
	 public FundsLandingPage clickOnFundsLink() 
	 {
		 waitForElementPresent(fundLink);
		 pauseExecutionFor(1000);
		 clickByJavaScript(fundLink);
		// fundLink.click();
		 pauseExecutionFor(3000);
		 return new FundsLandingPage(driver);
		 
	 }
	 
	 
	 
	 public boolean isCapabilitiesLinkDisplayedOnHeader()
	 {
		 waitForElementPresent(capabilitiesLink);
		 return capabilitiesLink.isDisplayed();
	 }
	 
	 public String getTextOfCapabilitiesLink()
	 {
		 waitForElementPresent(capabilitiesLink);
		 return capabilitiesLink.getText();
	 }
	
	 public CapabilityPage clickOnCapabilitiesLink() throws Exception
	 {
		 waitForElementPresent(capabilitiesLink);
		 pauseExecutionFor(2000);
		 clickByJavaScript(capabilitiesLink);
		 pauseExecutionFor(1000);
		 return new CapabilityPage(driver);
	 }
	 
	 public boolean isLitratureLinkDisplayedOnHeader()
	 {
		 waitForElementPresent(LitratureLink);
		 return LitratureLink.isDisplayed();
	 }
	 
	 public String getTextOfLitratureLink()
	 {
		 waitForElementPresent(LitratureLink);
		 return LitratureLink.getText();
	 }
	 
	 public LiteraturePage clickOnLitratureLink() throws Exception
	 {
		 waitForElementPresent(LitratureLink);
		 clickByJavaScript(LitratureLink);
		 return new LiteraturePage(driver);
	 }
	 
	 public boolean isInsightsLinkDisplayedOnHeader()
	 {
		 waitForElementPresent(insightsLink);
		 return insightsLink.isDisplayed();
	 }
	 
	 public String getTextOfInsightsLink()
	 {
		 waitForElementPresent(insightsLink);
		 return insightsLink.getText();
	 }
	 
	 public InsightLandingPage clickOnInsightsLink() throws Exception
	 {
		 waitForElementPresent(insightsLink);
		 clickByJavaScript(insightsLink);
		 return new InsightLandingPage(driver);
	 }
	 
	 public boolean iscontactUsLinkDisplayedOnHeader()
	 {
		 waitForElementPresent(contactUsLink);
		 return contactUsLink.isDisplayed();
	 }
	 
	 public String getTextOfcontactUsLink()
	 {
		 waitForElementPresent(contactUsLink);
		 return contactUsLink.getText();
	 }
	 
	 public ContactUsPage clickOncontactUsLink() 
	 {
		 waitForElementPresent(contactUsLink);
		 clickByJavaScript(contactUsLink);
		 return new ContactUsPage(driver);
	 }
	 
	 public boolean isSearchIconDisplayed()
	 {
		 waitForElementPresent(searchIcon);
		 return searchIcon.isDisplayed();
	 }
	 
	 public boolean ClickOnSearchIcon()
	 {
		 waitForElementPresent(searchIcon);
		searchIcon.click();
		return serchbutton.isDisplayed();
		
		
	 }
	 
	 public boolean isTextAboveFooterDisplayed()
	 {
		 waitForElementPresent(footerText);
		 return footerText.isDisplayed();
	 }
	 
	 public String getTextAboveFooter()
	 {
		 waitForElementPresent(footerText);
		 return footerText.getText();
	 }
	 
	 public boolean isCookieTextDisplayed()
	 {
		 waitForElementPresent(cokieText);
		 return cokieText.isDisplayed();
	 }
	 
	 public String getCookieText()
	 {
		 waitForElementPresent(cokieText);
		return cokieText.getText(); 
	 }
	 
	 public CookiePolicyPage clickOnLearnMoreOnCookie()
	 {
		 waitForElementPresent(cokieText);
		 CookieLearnMore.click();
		 return new CookiePolicyPage(driver);
	 }
	 
	 public boolean closeCookie()
	 {
		 waitForElementPresent(CookieCloseLink);
		 CookieCloseLink.click();
		 return cokieText.isDisplayed();
	 }
	 
	 public boolean isFootNoteAndDisclosureDisplayed()
	 {
		
		 return footNoteAndDisclosure.isDisplayed();
	 }
	 
	 public String getFootNoteAndDisclosureText()
	 {
		 return footNoteAndDisclosure.getText();
	 }
	 
	 public boolean isFootNoteAndDisclosureTextDisplayed()
	 {
		 return footNoteAndDisclosureText.isDisplayed();
	 }
	 
	 public String getfootNoteAndDisclosurediscriptionText()
	 {
		 return footNoteAndDisclosureText.getText();
	 }
	 
	 public boolean isfooterTextDisplayed()
	 {
		 return footerText.isDisplayed();
	 }
	 
	 public String footerText()
	 {
		 return footerText.getText();
	 }
	 
	 public boolean isTextBelowFooterDisplayed()
	 {
		return  textbelowFoter.isDisplayed();
	 }
	 
	 public String TextBelowFooter()
	 {
		 return textbelowFoter.getText();
	 }
	 
	 public boolean isPrivacyLinkDisplayed()
	 {
		 waitForElementPresent(privacyLink);
		 return privacyLink.isDisplayed();
	 }
	 
	 public String getTextOfPrivacyLink()
	 {
		 waitForElementPresent(privacyLink);
		 return privacyLink.getText();
	 }
	 
	 public PrivacyPolicy clickOnPrivacyLink()
	 {
		 waitForElementPresent(privacyLink);
		 clickByJavaScript(privacyLink);
		 return new PrivacyPolicy(driver);
	 }
	 
	
	 
	 public boolean isCookiePolicyLinkDisplayed()
	 {
		 //waitForElementPresent(cookieLink);
		 return cookieLink.isDisplayed();
	 }
	 
	 public String getCookiePolicyLinkText()
	 {
		 waitForElementPresent(cookieLink);
		 return cookieLink.getText();
	 }
	 
	 public CookiePolicyPage clickOnCookiePolicyLink()
	 {
		 waitForElementPresent(cookieLink);
		// cookieLink.click();
		 
		 clickByJavaScript(cookieLink);
		 
		 return new CookiePolicyPage(driver);
	 }
	 
	 
	 public boolean isTermsOfUseLinkDisplayed()
	 {
		 waitForElementPresent(termsLink);
		 return termsLink.isDisplayed();
	 }
	 
	 public String getTermsOfUseLinkText()
	 {
		 waitForElementPresent(termsLink);
		 return termsLink.getText();
	 }
	 
	 public TermsPage clickOnTermsOfUseLink()
	 {
		 waitForElementPresent(termsLink);
		 clickByJavaScript(termsLink);
		 return new TermsPage(driver);
	 }
	 
	 
}
