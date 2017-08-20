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
import com.sapient.webpage.InsightAutherBioPage;
import com.sapient.webpage.InsightLandingPage;
import com.sapient.webpage.LiteraturePage;
import com.sapient.webpage.LoginPage;
import com.sapient.webpage.PrivacyPolicy;
import com.sapient.webpage.TermsPage;

/**
 * @author ssi248
 *
 */
public class InsightAutherBioPageTest extends SeleniumTestPlan {
	
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
	 InsightAutherBioPage autherBioPage;
	 
	 @Test(description="Verify the UI of Auther bio Page")
	 public void contactUs_galenUiTest() throws Exception
	 {
		 loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 //loginPage.enterLoginData("sanjaysinghprod", "c%QH&LoiUZle!SCKWb@7gdUZ");
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 insightPage = postHomePage.clickOnInsightsLink();
		 CustomAssertion.assertEquals(insightPage.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights page after clicking on Insights link");
		 autherBioPage = insightPage.clickOnReadArticleLink();
		 CustomAssertion.assertTrue(autherBioPage.getTitle().startsWith("Nanette Abuhoff Jacobson"), "User is not navigated to autherBioPage page after clicking on Read Article link");
	 	CustomAssertion.assertTrue(autherBioPage.testPageLayout(layoutTags), "[Assert Fail]:Pixel are not correct");
	 }

	 @Test
	 public void headerAndFoterTest() throws Exception
	 {
		 loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 //loginPage.enterLoginData("sanjaysinghprod", "c%QH&LoiUZle!SCKWb@7gdUZ");
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 insightPage = postHomePage.clickOnInsightsLink();
		 CustomAssertion.assertEquals(insightPage.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights page after clicking on Insights link");
		 autherBioPage = insightPage.clickOnReadArticleLink();
		 CustomAssertion.assertTrue(autherBioPage.getTitle().startsWith("Nanette Abuhoff Jacobson"), "User is not navigated to autherBioPage page after clicking on Read Article link");
		 
		 CustomAssertion.assertTrue(autherBioPage.isWellingtonLogoDisplayed(), "Wellington logo is not displayed on postHomePage");
		 CustomAssertion.assertTrue(autherBioPage.isFundsLinkDisplayedOnHeader(),"Funds link is not displayed on gloabl header on postHomePage");
		 CustomAssertion.assertEquals(autherBioPage.getTextOfFundsLink(), "FUNDS", "Funds text is not displayed as FUNDS");
		 fundsLandingPage=autherBioPage.clickOnFundsLink();
		 CustomAssertion.assertEquals(fundsLandingPage.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing Page after clicking on Funds link on insightPage");
		 fundsLandingPage.goBack();
		 CustomAssertion.assertTrue(autherBioPage.getTitle().startsWith("Nanette Abuhoff Jacobson"), "User is not navigated to autherBioPage page after clicking on Read Article link");
		
		 CustomAssertion.assertTrue(autherBioPage.isCapabilitiesLinkDisplayedOnHeader(), "Capability link is not diaplayed on postHomePage");
		 CustomAssertion.assertEquals(autherBioPage.getTextOfCapabilitiesLink(), "CAPABILITIES", "Capability text is not as CAPABILITIES ");
		 capabilityPage = autherBioPage.clickOnCapabilitiesLink();
		 Assert.assertEquals(capabilityPage.getTitle(), "Wellington Management Funds capabilities", "User is not navigated to Capability Page");
		 
		 capabilityPage.goBack();
		 CustomAssertion.assertTrue(autherBioPage.getTitle().startsWith("Nanette Abuhoff Jacobson"), "User is not navigated to autherBioPage page after clicking on Read Article link");
		
		
		 CustomAssertion.assertTrue(autherBioPage.isInsightsLinkDisplayedOnHeader(), "Insights link is not displayed on the Page");
		 CustomAssertion.assertEquals(autherBioPage.getTextOfInsightsLink(), "INSIGHTS", "Insights text is not displayed INSIGHTS");
		 insightPage = autherBioPage.clickOnInsightsLink();
		 CustomAssertion.assertEquals(insightPage.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights page  after clicking on Insights link on postHomePage");
		 insightPage.goBack();
		 CustomAssertion.assertTrue(autherBioPage.getTitle().startsWith("Nanette Abuhoff Jacobson"), "User is not navigated to autherBioPage page after clicking on Read Article link");
		

		 CustomAssertion.assertTrue(autherBioPage.isLitratureLinkDisplayedOnHeader(), "Litrature link is not displayed on the Page");
		 CustomAssertion.assertEquals(autherBioPage.getTextOfLitratureLink(), "LITERATURE", "Litrature text is not displayed LITRATURE");
		 litrature = autherBioPage.clickOnLitratureLink();
		 CustomAssertion.assertEquals(litrature.getTitle(), "Wellington Management Funds — Literature", "User is not navigated to Litrature landing page after clicking on Litrature link on postHomePage");
		 litrature.goBack();
		 CustomAssertion.assertTrue(autherBioPage.getTitle().startsWith("Nanette Abuhoff Jacobson"), "User is not navigated to autherBioPage page after clicking on Read Article link");
		
		 CustomAssertion.assertTrue(autherBioPage.iscontactUsLinkDisplayedOnHeader(), "ContactUs link is not displayed on the Page");
		 CustomAssertion.assertEquals(autherBioPage.getTextOfcontactUsLink(), "CONTACT", "Contact text is not displayed Contact");
		 contactUsPage = autherBioPage.clickOncontactUsLink();
		 CustomAssertion.assertEquals(contactUsPage.getTitle(), "Wellington Management Funds — Contact us", "User is  not navigated to contactUs page after clicking on Contact Us link on Insights Page");
		 contactUsPage.goBack();
		// contactUsPage.goBack();
		 CustomAssertion.assertTrue(autherBioPage.getTitle().startsWith("Nanette Abuhoff Jacobson"), "User is not navigated to autherBioPage page after clicking on Read Article link");
		
		 CustomAssertion.assertTrue(autherBioPage.isSearchIconDisplayed(), "Search icon is not displayed");
		 CustomAssertion.assertTrue(autherBioPage.ClickOnSearchIcon(), "Enter button is not displayed after clicking on Search icon");
		 
		
		 CustomAssertion.assertFalse(autherBioPage.isFootNoteAndDisclosureDisplayed(), "FootNote and Disclosure is displayed which should be not displayed");
		// CustomAssertion.assertEquals(autherBioPage.getFootNoteAndDisclosureText(), "DISCLOSURES & FOOTNOTES", "Footnote and disclosure heading is not match");
		 //CustomAssertion.assertTrue(autherBioPage.isFootNoteAndDisclosureTextDisplayed(), "Footnote and disclosure text is not displayed");
		 //CustomAssertion.assertEquals(autherBioPage.getfootNoteAndDisclosurediscriptionText(), homePage.disclosureandFootnoteDiscription,  "Footnote and Disclosure discription is not correct");
		 CustomAssertion.assertTrue(autherBioPage.isTextAboveFooterDisplayed(), "Text above footer note isnot displayed");
		 CustomAssertion.assertEquals(autherBioPage.getTextAboveFooter(), homePage.textAboveFooter, "Text above footer is incorrect");
		 CustomAssertion.assertTrue(autherBioPage.isCookiePolicyLinkDisplayed(), "Cookie policy link is not dispalyed in footer");
		 CustomAssertion.assertEquals(autherBioPage.getCookiePolicyLinkText().toLowerCase(), "Cookie policy".toLowerCase(), "Incorrect cookie policy link tecxt");
		 cookiePolicyPage = autherBioPage.clickOnCookiePolicyLink();
		 CustomAssertion.assertTrue(cookiePolicyPage.isBannerTextDisplayed(), "Banner text is not displayed on Cokie page");
		 cookiePolicyPage.goBack();
		 CustomAssertion.assertTrue(autherBioPage.getTitle().startsWith("Nanette Abuhoff Jacobson"), "User is not navigated to autherBioPage page after clicking on Read Article link");
		
		 CustomAssertion.assertTrue(autherBioPage.isPrivacyLinkDisplayed(), "Privacy link is not displayed on the home page");
		 CustomAssertion.assertEquals(autherBioPage.getTextOfPrivacyLink().toLowerCase(), "Privacy policy".toLowerCase(), "Privacy policy text is not displayed correct on home Page");
		 privacyPlocyPage = autherBioPage.clickOnPrivacyLink();
		 //CustomAssertion.assertEquals(privacyPlocy.getBannerText(), "Privacy policy", "Not navigated to Privacy page");
		 CustomAssertion.assertTrue(privacyPlocyPage.getTitle().contains("Privacy policy"), "User is not navigated to Privacy Policy page  after clicking on Privacy link");
		 privacyPlocyPage.goBack();
		 CustomAssertion.assertTrue(autherBioPage.getTitle().startsWith("Nanette Abuhoff Jacobson"), "User is not navigated to autherBioPage page after clicking on Read Article link");
		
		 CustomAssertion.assertTrue(autherBioPage.isTermsOfUseLinkDisplayed(), "Terms of use link is not displayed on the home page");
		 CustomAssertion.assertEquals(autherBioPage.getTermsOfUseLinkText().toLowerCase(), "Terms of use".toLowerCase(), "Terms of use text is not displayed correct on home Page");
		 termsPage = autherBioPage.clickOnTermsOfUseLink();
		 //CustomAssertion.assertEquals(termsPage.getBannerText(), "Terms of use", "Not navigated to Terms page");
		 CustomAssertion.assertTrue(termsPage.getTitle().contains("Terms of use"), "USer is not navigated to Terms and use page after clicking on Terms of use link");
		 termsPage.goBack();
		 CustomAssertion.assertTrue(autherBioPage.getTitle().startsWith("Nanette Abuhoff Jacobson"), "User is not navigated to autherBioPage page after clicking on Read Article link");
		
	 	
		 
	 }


}
