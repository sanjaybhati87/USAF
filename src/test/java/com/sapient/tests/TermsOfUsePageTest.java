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
public class TermsOfUsePageTest extends SeleniumTestPlan {
	
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
	 
	 @Test
	 public void headerAndFoterTest() throws Exception
	 {
	 loginPage = new LoginPage(driver);
	 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
	 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
	 termsPage = postHomePage.clickOnTermsOfUseLink();

	 CustomAssertion.assertTrue(termsPage.getTitle().contains("Terms of use"), "USer is not navigated to Terms and use page after clicking on Terms of use link");
	 
	 CustomAssertion.assertTrue(termsPage.isWellingtonLogoDisplayed(), "Wellington logo is not displayed on postHomePage");
	 CustomAssertion.assertTrue(termsPage.isFundsLinkDisplayedOnHeader(),"Funds link is not displayed on gloabl header on postHomePage");
	 CustomAssertion.assertEquals(termsPage.getTextOfFundsLink(), "FUNDS", "Funds text is not displayed as FUNDS");
	 fundsLandingPage=termsPage.clickOnFundsLink();
	 CustomAssertion.assertEquals(fundsLandingPage.getTitle(), "Wellington Management Funds", "User is not navigated to Funds landing Page after clicking on Funds link on insightPage");
	 fundsLandingPage.goBack();
	 CustomAssertion.assertTrue(termsPage.getTitle().contains("Terms of usey"), "User is not navigated to Privacy Policy page  after clicking on BACK button on Funds landing Page");
	
	 CustomAssertion.assertTrue(termsPage.isCapabilitiesLinkDisplayedOnHeader(), "Capability link is not diaplayed on postHomePage");
	 CustomAssertion.assertEquals(termsPage.getTextOfCapabilitiesLink(), "CAPABILITIES", "Capability text is not as CAPABILITIES ");
	 capabilityPage = termsPage.clickOnCapabilitiesLink();
	 Assert.assertEquals(capabilityPage.getTitle(), "Wellington Management Funds capabilities", "User is not navigated to Capability Page");
	 
	 capabilityPage.goBack();
	 CustomAssertion.assertTrue(termsPage.getTitle().contains("Terms of use"), "User is not navigated to Terms of use page  after clicking on  BACK button");
	
	 CustomAssertion.assertTrue(termsPage.isInsightsLinkDisplayedOnHeader(), "Insights link is not displayed on the Page");
	 CustomAssertion.assertEquals(termsPage.getTextOfInsightsLink(), "INSIGHTS", "Insights text is not displayed INSIGHTS");
	 insightPage = termsPage.clickOnInsightsLink();
	 CustomAssertion.assertEquals(insightPage.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights page  after clicking on Insights link on Privacy Page");
	 insightPage.goBack();
	 CustomAssertion.assertTrue(termsPage.getTitle().contains("Terms of use"), "User is not navigated to Terms of use page  after clicking on  BACK button");

	 CustomAssertion.assertTrue(termsPage.isLitratureLinkDisplayedOnHeader(), "Litrature link is not displayed on the Page");
	 CustomAssertion.assertEquals(termsPage.getTextOfLitratureLink(), "LITERATURE", "Litrature text is not displayed LITRATURE");
	 litrature = termsPage.clickOnLitratureLink();
	 CustomAssertion.assertEquals(litrature.getTitle(), "Wellington Management Funds — Literature", "User is not navigated to Litrature landing page after clicking on Litrature link on postHomePage");
	 litrature.goBack();
	 CustomAssertion.assertTrue(termsPage.getTitle().contains("Terms of use"), "User is not navigated to Terms of use page  after clicking on BACK button");
	 CustomAssertion.assertTrue(termsPage.iscontactUsLinkDisplayedOnHeader(), "ContactUs link is not displayed on the Page");
	 CustomAssertion.assertEquals(termsPage.getTextOfcontactUsLink(), "CONTACT", "Contact text is not displayed Contact");
	 contactUsPage = termsPage.clickOncontactUsLink();
	 CustomAssertion.assertEquals(contactUsPage.getTitle(), "Wellington Management Funds — Contact us", "User is  not navigated to contactUs page after clicking on Contact Us link on Insights Page");
	 contactUsPage.goBack();
	 CustomAssertion.assertTrue(termsPage.getTitle().contains("Terms of use"), "User is not navigated to Terms of use page  after clicking on  BACK button");
	 CustomAssertion.assertTrue(termsPage.isSearchIconDisplayed(), "Search icon is not displayed");
	 CustomAssertion.assertTrue(termsPage.ClickOnSearchIcon(), "Enter button is not displayed after clicking on Search icon");
	 
	
	 CustomAssertion.assertFalse(termsPage.isFootNoteAndDisclosureDisplayed(), "FootNote and Disclosure is displayed,It should be not displayed");

	 CustomAssertion.assertTrue(termsPage.isTextAboveFooterDisplayed(), "Text above footer note isnot displayed");
	 CustomAssertion.assertEquals(termsPage.getTextAboveFooter(), homePage.textAboveFooter, "Text above footer is incorrect");
	 CustomAssertion.assertTrue(termsPage.isCookiePolicyLinkDisplayed(), "Cookie policy link is not dispalyed in footer");
	 CustomAssertion.assertEquals(termsPage.getCookiePolicyLinkText(), "Cookie policy", "Incorrect cookie policy link tecxt");
	 cookiePolicyPage = termsPage.clickOnCookiePolicyLink();
	 CustomAssertion.assertTrue(cookiePolicyPage.isBannerTextDisplayed(), "Banner text is not displayed on Cokie page");
	 cookiePolicyPage.goBack();
	 CustomAssertion.assertTrue(termsPage.getTitle().contains("Terms of use"), "User is not navigated to Terms of use page  after clicking on Privacy link");
	
	 CustomAssertion.assertTrue(termsPage.isPrivacyLinkDisplayed(), "Privacy link is not displayed on the home page");
	 CustomAssertion.assertEquals(termsPage.getTextOfPrivacyLink(), "Privacy policy", "Privacy policy text is not displayed correct on home Page");
	privacyPlocyPage = termsPage.clickOnPrivacyLink();
	 //CustomAssertion.assertEquals(privacyPlocy.getBannerText(), "Privacy policy", "Not navigated to Privacy page");
	 CustomAssertion.assertTrue(privacyPlocyPage.getTitle().contains("Privacy policy"), "User is not navigated to Privacy Policy page  after clicking on Privacy link");
	 privacyPlocyPage.goBack();
	 CustomAssertion.assertTrue(termsPage.getTitle().contains("Terms of use"), "User is not navigated to Terms of use page  after clicking on BACK button");
	
	 CustomAssertion.assertTrue(termsPage.isTermsOfUseLinkDisplayed(), "Terms of use link is not displayed on the home page");
	 CustomAssertion.assertEquals(termsPage.getTermsOfUseLinkText(), "Terms of use", "Terms of use text is not displayed correct on home Page");
	 termsPage = termsPage.clickOnTermsOfUseLink();
	 //CustomAssertion.assertEquals(termsPage.getBannerText(), "Terms of use", "Not navigated to Terms page");
	 CustomAssertion.assertTrue(termsPage.getTitle().contains("Terms of use"), "USer is not navigated to Terms and use page after clicking on Terms of use link");
	 termsPage.goBack();
	 CustomAssertion.assertTrue(privacyPlocyPage.getTitle().contains("Terms of use"), "User is not navigated to Terms of use page  after clicking on BACK button");
	
	 	
		 
	 }

}
