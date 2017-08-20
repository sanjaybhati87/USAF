/**
 * 
 */
package com.sapient.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sapient.core.CustomAssertion;
import com.sapient.core.SeleniumTestPlan;
import com.sapient.core.SeleniumTestsContextManager;
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
public class PrivacyPolicyPageTest extends SeleniumTestPlan {
	
	String[] layoutTags ={"desktop"};
	LoginPage loginPage;
	 HomePostAttestationPage postHomePage;
	 HomePage homePage;
	 FundsLandingPage fundsLandingPage;
	 CapabilityPage capabilityPage;
	 InsightLandingPage insightPage;
	 LiteraturePage litrature;
	 ContactUsPage contactUsPage;
	 CookiePolicyPage cookiePolicyPage;
	 PrivacyPolicy privacyPlocyPage;
	 TermsPage termsPage;
	 
/*	 @Test(description="Verify the UI of PrivacyPolicy Page")
	 public void galenUiTest() throws Exception
	 {

		 PrivacyPolicy privacyPolicy= new PrivacyPolicy(true);
	 	CustomAssertion.assertTrue(privacyPolicy.testPageLayout(layoutTags), "[Assert Fail]:Pixel are not correct");
	 }*/
	 
	 @Test
	 public void headerAndFoterTest() throws Exception
	 {
	 loginPage = new LoginPage(driver);
	 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
	postHomePage =   homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
	 privacyPlocyPage = postHomePage.clickOnPrivacyLink();
	 CustomAssertion.assertTrue(privacyPlocyPage.getTitle().contains("Privacy policy"), "User is not navigated to Privacy Policy page  after clicking on Privacy link");
	 
	 CustomAssertion.assertTrue(privacyPlocyPage.isWellingtonLogoDisplayed(), "Wellington logo is not displayed on postHomePage");
	 CustomAssertion.assertTrue(privacyPlocyPage.isFundsLinkDisplayedOnHeader(),"Funds link is not displayed on gloabl header on postHomePage");
	 CustomAssertion.assertEquals(privacyPlocyPage.getTextOfFundsLink(), "FUNDS", "Funds text is not displayed as FUNDS");
	 fundsLandingPage=privacyPlocyPage.clickOnFundsLink();
	 CustomAssertion.assertEquals(fundsLandingPage.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing Page after clicking on Funds link on insightPage");
	 fundsLandingPage.goBack();
	 CustomAssertion.assertTrue(privacyPlocyPage.getTitle().contains("Privacy policy"), "User is not navigated to Privacy Policy page  after clicking on BACK button on Funds landing Page");
	
	 CustomAssertion.assertTrue(privacyPlocyPage.isCapabilitiesLinkDisplayedOnHeader(), "Capability link is not diaplayed on postHomePage");
	 CustomAssertion.assertEquals(privacyPlocyPage.getTextOfCapabilitiesLink(), "CAPABILITIES", "Capability text is not as CAPABILITIES ");
	 capabilityPage = privacyPlocyPage.clickOnCapabilitiesLink();
	 Assert.assertEquals(capabilityPage.getTitle(), "Wellington Management Funds capabilities", "User is not navigated to Capability Page");
	 
	 capabilityPage.goBack();
	 CustomAssertion.assertTrue(privacyPlocyPage.getTitle().contains("Privacy policy"), "User is not navigated to Privacy Policy page  after clicking on  BACK button");
	
	 CustomAssertion.assertTrue(privacyPlocyPage.isInsightsLinkDisplayedOnHeader(), "Insights link is not displayed on the Page");
	 CustomAssertion.assertEquals(privacyPlocyPage.getTextOfInsightsLink(), "INSIGHTS", "Insights text is not displayed INSIGHTS");
	 insightPage = privacyPlocyPage.clickOnInsightsLink();
	 CustomAssertion.assertEquals(insightPage.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights page  after clicking on Insights link on Privacy Page");
	 insightPage.goBack();
	 CustomAssertion.assertTrue(privacyPlocyPage.getTitle().contains("Privacy policy"), "User is not navigated to Privacy Policy page  after clicking on  BACK button");

	 CustomAssertion.assertTrue(privacyPlocyPage.isLitratureLinkDisplayedOnHeader(), "Litrature link is not displayed on the Page");
	 CustomAssertion.assertEquals(privacyPlocyPage.getTextOfLitratureLink(), "LITERATURE", "Litrature text is not displayed LITRATURE");
	 litrature = privacyPlocyPage.clickOnLitratureLink();
	 CustomAssertion.assertEquals(litrature.getTitle(), "Wellington Management Funds — Literature", "User is not navigated to Litrature landing page after clicking on Litrature link on postHomePage");
	 litrature.goBack();
	 CustomAssertion.assertTrue(privacyPlocyPage.getTitle().contains("Privacy policy"), "User is not navigated to Privacy Policy page  after clicking on BACK button");
	 CustomAssertion.assertTrue(privacyPlocyPage.iscontactUsLinkDisplayedOnHeader(), "ContactUs link is not displayed on the Page");
	 CustomAssertion.assertEquals(privacyPlocyPage.getTextOfcontactUsLink(), "CONTACT", "Contact text is not displayed Contact");
	 contactUsPage = privacyPlocyPage.clickOncontactUsLink();
	 CustomAssertion.assertEquals(contactUsPage.getTitle(), "Wellington Management Funds — Contact us", "User is  not navigated to contactUs page after clicking on Contact Us link on Insights Page");
	 contactUsPage.goBack();
	 //contactUsPage.goBack();
	 CustomAssertion.assertTrue(privacyPlocyPage.getTitle().contains("Privacy policy"), "User is not navigated to Privacy Policy page  after clicking on  BACK button");
	 CustomAssertion.assertTrue(privacyPlocyPage.isSearchIconDisplayed(), "Search icon is not displayed");
	 CustomAssertion.assertTrue(privacyPlocyPage.ClickOnSearchIcon(), "Enter button is not displayed after clicking on Search icon");
	 
	
	 CustomAssertion.assertFalse(insightPage.isFootNoteAndDisclosureDisplayed(), "FootNote and Disclosure is displayed,It should be not displayed");

	 CustomAssertion.assertTrue(privacyPlocyPage.isTextAboveFooterDisplayed(), "Text above footer note isnot displayed");
	 CustomAssertion.assertEquals(privacyPlocyPage.getTextAboveFooter(), homePage.textAboveFooter, "Text above footer is incorrect");
	 CustomAssertion.assertTrue(privacyPlocyPage.isCookiePolicyLinkDisplayed(), "Cookie policy link is not dispalyed in footer");
	 CustomAssertion.assertEquals(privacyPlocyPage.getCookiePolicyLinkText(), "Cookie policy", "Incorrect cookie policy link tecxt");
	 cookiePolicyPage = privacyPlocyPage.clickOnCookiePolicyLink();
	 CustomAssertion.assertTrue(cookiePolicyPage.isBannerTextDisplayed(), "Banner text is not displayed on Cokie page");
	 cookiePolicyPage.goBack();
	 CustomAssertion.assertTrue(privacyPlocyPage.getTitle().contains("Privacy policy"), "User is not navigated to Privacy Policy page  after clicking on Privacy link");
	
	 CustomAssertion.assertTrue(privacyPlocyPage.isPrivacyLinkDisplayed(), "Privacy link is not displayed on the home page");
	 CustomAssertion.assertEquals(privacyPlocyPage.getTextOfPrivacyLink(), "Privacy policy", "Privacy policy text is not displayed correct on home Page");
	privacyPlocyPage = privacyPlocyPage.clickOnPrivacyLink();
	 //CustomAssertion.assertEquals(privacyPlocy.getBannerText(), "Privacy policy", "Not navigated to Privacy page");
	 CustomAssertion.assertTrue(privacyPlocyPage.getTitle().contains("Privacy policy"), "User is not navigated to Privacy Policy page  after clicking on Privacy link");
	 privacyPlocyPage.goBack();
	 CustomAssertion.assertTrue(privacyPlocyPage.getTitle().contains("Privacy policy"), "User is not navigated to Privacy Policy page  after clicking on BACK button");
	
	 CustomAssertion.assertTrue(privacyPlocyPage.isTermsOfUseLinkDisplayed(), "Terms of use link is not displayed on the home page");
	 CustomAssertion.assertEquals(privacyPlocyPage.getTermsOfUseLinkText(), "Terms of use", "Terms of use text is not displayed correct on home Page");
	 termsPage = privacyPlocyPage.clickOnTermsOfUseLink();
	 //CustomAssertion.assertEquals(termsPage.getBannerText(), "Terms of use", "Not navigated to Terms page");
	 CustomAssertion.assertTrue(termsPage.getTitle().contains("Terms of use"), "USer is not navigated to Terms and use page after clicking on Terms of use link");
	 termsPage.goBack();
	 CustomAssertion.assertTrue(privacyPlocyPage.getTitle().contains("Privacy policy"), "User is not navigated to Privacy Policy page  after clicking on BACK button");
	
	 	System.out.println("Rajni Bhati");
	 	System.out.println("Sanjay Singh bhati");
	 	System.out.println("Rajni Bhati2");
	 	System.out.println("Sanjay Singh bhati2");
		 
	 }


}
