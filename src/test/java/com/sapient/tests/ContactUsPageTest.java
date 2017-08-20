/**
 * 
 */
package com.sapient.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sapient.core.CustomAssertion;
import com.sapient.core.SeleniumTestPlan;
import com.sapient.core.SeleniumTestsContextManager;
import com.sapient.customexception.NotCurrentPageException;
import com.sapient.webpage.CapabilityPage;
import com.sapient.webpage.ContactUsPage;
import com.sapient.webpage.CookiePolicyPage;
import com.sapient.webpage.FundsLandingPage;
import com.sapient.webpage.HomePage;
import com.sapient.webpage.HomePostAttestationPage;
import com.sapient.webpage.InsightLandingPage;
import com.sapient.webpage.LiteraturePage;
import com.sapient.webpage.LoginPage;
import com.sapient.webpage.PrivacyPolicy;
import com.sapient.webpage.TermsPage;

/**
 * @author ssi248
 *
 */
public class ContactUsPageTest extends SeleniumTestPlan {
	
	String[] layoutTags ={"desktop"};
	LoginPage loginPage;
	 HomePostAttestationPage postHomePage;
	 HomePage homePage;
	 FundsLandingPage fundsLandingPage;
	 CapabilityPage capabilityPage;
	 InsightLandingPage insightPage;
	 LiteraturePage litrature;
	 ContactUsPage contactUsPage;
	 CookiePolicyPage cokkiePolicy;
	 PrivacyPolicy privacyPlocy;
	 TermsPage termsPage;
	 
	 @Test(description="Verify the UI of Post contactUs Page")
	 public void contactUs_galenUiTest() throws Exception
	 {
		 loginPage = new LoginPage(driver);
	     homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
	     postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
	     contactUsPage = postHomePage.clickOncontactUsLink();
	 	CustomAssertion.assertTrue(contactUsPage.testPageLayout(layoutTags), "[Assert Fail]:Pixel are not correct");
	 }
	 
	 @Test
	 public void headerAndFoterTest() throws Exception
	 {
		 loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 contactUsPage = postHomePage.clickOncontactUsLink();
		 CustomAssertion.assertEquals(contactUsPage.getTitle(), "Wellington Management Funds — Contact us", "User is not navigated to Contact us page after clicking on Contact us link");
		 CustomAssertion.assertEquals(contactUsPage.getBackgroundClourofLocalContact(), "rgba(28, 53, 94, 1)", "By default Local Contact tab is not highligted");
		 CustomAssertion.assertEquals(contactUsPage.getBackgroundClourofSubmitRequest(), "rgba(0, 0, 0, 0)", "Request Information tab is also highligted");
		 
		 CustomAssertion.assertTrue(contactUsPage.isWellingtonLogoDisplayed(), "Wellington logo is not displayed on Contact us Page");
		 CustomAssertion.assertTrue(contactUsPage.isFundsLinkDisplayedOnHeader(),"Funds link is not displayed on gloabl header on Contact us Page");
		 CustomAssertion.assertEquals(contactUsPage.getTextOfFundsLink(), "FUNDS", "Funds text is not displayed as FUNDS");
		 fundsLandingPage=contactUsPage.clickOnFundsLink();
		 CustomAssertion.assertEquals(fundsLandingPage.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing Page after clicking on Funds link on contactUsPage");
		 fundsLandingPage.goBack();
		 CustomAssertion.assertEquals(contactUsPage.getTitle(), "Wellington Management Funds — Contact us", "User is not navigated to Contact us Page after clicking on BACK button on Funds Page");
		
		 CustomAssertion.assertTrue(contactUsPage.isCapabilitiesLinkDisplayedOnHeader(), "Capability link is not diaplayed on postHomePage");
		 CustomAssertion.assertEquals(contactUsPage.getTextOfCapabilitiesLink(), "CAPABILITIES", "Capability text is not as CAPABILITIES ");
		 capabilityPage = contactUsPage.clickOnCapabilitiesLink();
		 Assert.assertEquals(capabilityPage.getTitle(), "Wellington Management Funds capabilities", "User is not navigated to Capability Page");
		 
		 capabilityPage.goBack();
		  CustomAssertion.assertEquals(contactUsPage.getTitle(), "Wellington Management Funds — Contact us", "User is not navigated to Contact us Page after clicking on BACK button on Capability Page");
		
		
		 CustomAssertion.assertTrue(contactUsPage.isInsightsLinkDisplayedOnHeader(), "Insights link is not displayed on the Page");
		 CustomAssertion.assertEquals(contactUsPage.getTextOfInsightsLink(), "INSIGHTS", "Insights text is not displayed INSIGHTS");
		 insightPage = contactUsPage.clickOnInsightsLink();
		 CustomAssertion.assertEquals(insightPage.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights page  after clicking on Insights link on postHomePage");
		 insightPage.goBack();
		  CustomAssertion.assertEquals(contactUsPage.getTitle(), "Wellington Management Funds — Contact us", "User is not navigated to Contact us Page after clicking on BACK button on Insights Page");
		

		 CustomAssertion.assertTrue(contactUsPage.isLitratureLinkDisplayedOnHeader(), "Litrature link is not displayed on the Page");
		 CustomAssertion.assertEquals(contactUsPage.getTextOfLitratureLink(), "LITERATURE", "Litrature text is not displayed LITRATURE");
		 litrature = contactUsPage.clickOnLitratureLink();
		 CustomAssertion.assertEquals(litrature.getTitle(), "Wellington Management Funds — Literature", "User is not navigated to Litrature landing page after clicking on Litrature link on postHomePage");
		 litrature.goBack();
		  CustomAssertion.assertEquals(contactUsPage.getTitle(), "Wellington Management Funds — Contact us", "User is not navigated to Contact us Page after clicking on BACK button on Literature Page");
		
		 CustomAssertion.assertTrue(contactUsPage.iscontactUsLinkDisplayedOnHeader(), "ContactUs link is not displayed on the Page");
		 CustomAssertion.assertEquals(contactUsPage.getTextOfcontactUsLink(), "CONTACT", "Contact text is not displayed Contact");
		 contactUsPage = contactUsPage.clickOncontactUsLink();
		 CustomAssertion.assertEquals(contactUsPage.getTitle(), "Wellington Management Funds — Contact us", "User is  not navigated to contactUs page after clicking on Contact Us link on Insights Page");
		 //contactUsPage.goBack();
		  CustomAssertion.assertEquals(contactUsPage.getTitle(), "Wellington Management Funds — Contact us", "User is not navigated to Contact us Page after clicking on BACK button on Contact Us Page");
		
		 CustomAssertion.assertTrue(contactUsPage.isSearchIconDisplayed(), "Search icon is not displayed");
		 CustomAssertion.assertTrue(contactUsPage.ClickOnSearchIcon(), "Enter button is not displayed after clicking on Search icon");
		 
		
		 CustomAssertion.assertTrue(contactUsPage.isFootNoteAndDisclosureDisplayed(), "FootNote and Disclosure is not displayed");
		CustomAssertion.assertEquals(contactUsPage.getFootNoteAndDisclosureText(), "DISCLOSURES & FOOTNOTES", "Footnote and disclosure heading is not match");
		CustomAssertion.assertTrue(contactUsPage.isFootNoteAndDisclosureTextDisplayed(), "Footnote and disclosure text is not displayed");
		CustomAssertion.assertEquals(contactUsPage.getfootNoteAndDisclosurediscriptionText(), homePage.disclosureandFootnoteDiscription,  "Footnote and Disclosure discription is not correct");
		 CustomAssertion.assertTrue(contactUsPage.isTextAboveFooterDisplayed(), "Text above footer note isnot displayed");
		 CustomAssertion.assertEquals(contactUsPage.getTextAboveFooter(), homePage.textAboveFooter, "Text above footer is incorrect");
		 CustomAssertion.assertTrue(contactUsPage.isCookiePolicyLinkDisplayed(), "Cookie policy link is not dispalyed in footer");
		 CustomAssertion.assertEquals(contactUsPage.getCookiePolicyLinkText().toLowerCase(), "Cookie policy".toLowerCase(), "Incorrect cookie policy link tecxt");
		 cokkiePolicy = contactUsPage.clickOnCookiePolicyLink();
		 CustomAssertion.assertTrue(cokkiePolicy.isBannerTextDisplayed(), "Banner text is not displayed on Cokie page");
		 cokkiePolicy.goBack();
		  CustomAssertion.assertEquals(contactUsPage.getTitle(), "Wellington Management Funds — Contact us", "User is not navigated to Contact us Page after clicking on BACK button on Cookie Page");
		
		 CustomAssertion.assertTrue(contactUsPage.isPrivacyLinkDisplayed(), "Privacy link is not displayed on the home page");
		 CustomAssertion.assertEquals(contactUsPage.getTextOfPrivacyLink().toLowerCase(), "Privacy policy".toLowerCase(), "Privacy policy text is not displayed correct on home Page");
		privacyPlocy = contactUsPage.clickOnPrivacyLink();
		 //CustomAssertion.assertEquals(privacyPlocy.getBannerText(), "Privacy policy", "Not navigated to Privacy page");
		 CustomAssertion.assertTrue(privacyPlocy.getTitle().contains("Privacy policy"), "User is not navigated to Privacy Policy page  after clicking on Privacy link");
		 privacyPlocy.goBack();
		  CustomAssertion.assertEquals(contactUsPage.getTitle(), "Wellington Management Funds — Contact us", "User is not navigated to Contact us Page after clicking on BACK button on Privacy Page");
		
		 CustomAssertion.assertTrue(contactUsPage.isTermsOfUseLinkDisplayed(), "Terms of use link is not displayed on the home page");
		 CustomAssertion.assertEquals(contactUsPage.getTermsOfUseLinkText().toLowerCase(), "Terms of use".toLowerCase(), "Terms of use text is not displayed correct on home Page");
		 termsPage = contactUsPage.clickOnTermsOfUseLink();
		 //CustomAssertion.assertEquals(termsPage.getBannerText(), "Terms of use", "Not navigated to Terms page");
		 CustomAssertion.assertTrue(termsPage.getTitle().contains("Terms of use"), "USer is not navigated to Terms and use page after clicking on Terms of use link");
		 termsPage.goBack();
		  CustomAssertion.assertEquals(contactUsPage.getTitle(), "Wellington Management Funds — Contact us", "User is not navigated to Contact us Page after clicking on BACK button on Terms Page");
		 
	 }

	 @Test
	 public void verifyClickOnOfficeLocationLinkUnderFlyout() throws NotCurrentPageException
	 {
		 loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 contactUsPage = postHomePage.clickOncontactUsLink();
		 contactUsPage.clickOnOfficeLocationsLinkUnderFlyout();
		 CustomAssertion.assertEquals(contactUsPage.getTitle(), "Wellington Management Funds — Contact us", "User is not navigated to Contact us page after clicking on Contact us link");
		 CustomAssertion.assertEquals(contactUsPage.getBackgroundClourofLocalContact(), "rgba(28, 53, 94, 1)", "By default Local Contact tab is not highligted");
		 
		 
	 }

 @Test
	 public void verifyClickOnRequestInformationLinkUnderFlyout() throws NotCurrentPageException
	 {
		 loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 contactUsPage = postHomePage.clickOncontactUsLink();
		 contactUsPage.clickOnOfficeLocationsLinkUnderFlyout();
		 CustomAssertion.assertEquals(contactUsPage.getTitle(), "Wellington Management Funds — Contact us", "User is not navigated to Contact us page after clicking on Contact us link");
		 CustomAssertion.assertEquals(contactUsPage.getBackgroundClourofSubmitRequest(), "rgba(28, 53, 94, 1)", "Request Information tab is not highligted");
		 CustomAssertion.assertEquals(contactUsPage.getBackgroundClourofLocalContact(), "rgba(0, 0, 0, 0)", "Local Contact tab is also highligted");	 
	 }
 @Test
 public void verify_Click_On_OfficeLocation_Link() throws NotCurrentPageException
 {
	   loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 contactUsPage= postHomePage.clickOncontactUsLink();
		 CustomAssertion.assertEquals(contactUsPage.getTitle(), "Wellington Management Funds — Contact us", "User is  not navigated to contactUs page after clicking on Contact Us link on postHomePage");
		 CustomAssertion.assertEquals(contactUsPage.getBackgroundClourofLocalContact(), "rgba(28, 53, 94, 1)", "By default Local Contact tab is not highligted");
		 contactUsPage.goBack();
		 CustomAssertion.assertEquals(postHomePage.getTitle(), "Wellington Management Funds — About", "Not navigated to post attested home page");   
 }

}
