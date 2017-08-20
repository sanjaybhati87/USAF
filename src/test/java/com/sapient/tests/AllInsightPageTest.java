/**
 * 
 */
package com.sapient.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sapient.core.CustomAssertion;
import com.sapient.core.SeleniumTestPlan;
import com.sapient.core.SeleniumTestsContextManager;
import com.sapient.webpage.AllInsightPage;
import com.sapient.webpage.CapabilityPage;
import com.sapient.webpage.ContactUsPage;
import com.sapient.webpage.CookiePolicyPage;
import com.sapient.webpage.DistinctiveApproachToEquityPage;
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
public class AllInsightPageTest extends SeleniumTestPlan {
	
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
	 AllInsightPage allInsightPage;
	 DistinctiveApproachToEquityPage distinctiveApproachToEquityPage;
	 
	 @Test(description="Verify the UI of AllInsight Page",enabled=false)
	 public void allInsight_galenUiTest() throws Exception
	 {
		 loginPage = new LoginPage(driver);
	     homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
	     postHomePage = homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
	    insightPage = postHomePage.clickOnInsightsLink();
	    CustomAssertion.assertEquals(insightPage.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights page after clicking on Insights link");
	    allInsightPage = insightPage.clickOnViewAllInsights();
	 	CustomAssertion.assertTrue(allInsightPage.testPageLayout(layoutTags), "[Assert Fail]:Pixel are not correct");
	 }

	 
	 @Test
	 public void headerAndFoterTest() throws Exception
	 {
		 loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage = homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 insightPage = postHomePage.clickOnInsightsLink();
		 CustomAssertion.assertEquals(insightPage.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights page after clicking on Insights link");
		 allInsightPage = insightPage.clickOnViewAllInsights();
		 CustomAssertion.assertTrue(allInsightPage.getCurrentURL().endsWith("all-insights/"), "User is not navigated to allInsightPage page after clicking on View All Insight link");
		 CustomAssertion.assertTrue(allInsightPage.isWellingtonLogoDisplayed(), "Wellington logo is not displayed on postHomePage");
		 CustomAssertion.assertTrue(allInsightPage.isFundsLinkDisplayedOnHeader(),"Funds link is not displayed on gloabl header on postHomePage");
		 CustomAssertion.assertEquals(allInsightPage.getTextOfFundsLink(), "FUNDS", "Funds text is not displayed as FUNDS");
		 fundsLandingPage=allInsightPage.clickOnFundsLink();
		 CustomAssertion.assertEquals(fundsLandingPage.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing Page after clicking on Funds link on insightPage");
		 fundsLandingPage.goBack();
		 System.out.println(allInsightPage.getCurrentURL());
		 CustomAssertion.assertTrue(allInsightPage.getCurrentURL().endsWith("all-insights/"), "User is not navigated to allInsightPage page after clicking on View All Insight link");
		 CustomAssertion.assertTrue(allInsightPage.isCapabilitiesLinkDisplayedOnHeader(), "Capability link is not diaplayed on postHomePage");
		 CustomAssertion.assertEquals(allInsightPage.getTextOfCapabilitiesLink(), "CAPABILITIES", "Capability text is not as CAPABILITIES ");
		 capabilityPage = allInsightPage.clickOnCapabilitiesLink();
		 Assert.assertEquals(capabilityPage.getTitle(), "Wellington Management Funds capabilities", "User is not navigated to Capability Page");
		 capabilityPage.goBack();
		 CustomAssertion.assertTrue(allInsightPage.getCurrentURL().endsWith("all-insights/"), "User is not navigated to allInsightPage page after clicking on View All Insight link");
		 CustomAssertion.assertTrue(allInsightPage.isInsightsLinkDisplayedOnHeader(), "Insights link is not displayed on the Page");
		 CustomAssertion.assertEquals(allInsightPage.getTextOfInsightsLink(), "INSIGHTS", "Insights text is not displayed INSIGHTS");
		 insightPage = allInsightPage.clickOnInsightsLink();
		 CustomAssertion.assertEquals(insightPage.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights page  after clicking on Insights link on postHomePage");
		 insightPage.goBack();
		  CustomAssertion.assertEquals(allInsightPage.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights Page after clicking on BACK button on Insights Page");
		 CustomAssertion.assertTrue(allInsightPage.isLitratureLinkDisplayedOnHeader(), "Litrature link is not displayed on the Page");
		 CustomAssertion.assertEquals(allInsightPage.getTextOfLitratureLink(), "LITERATURE", "Litrature text is not displayed LITRATURE");
		 litrature = allInsightPage.clickOnLitratureLink();
		 CustomAssertion.assertEquals(litrature.getTitle(), "Wellington Management Funds — Literature", "User is not navigated to Litrature landing page after clicking on Litrature link on postHomePage");
		 litrature.goBack();
		 CustomAssertion.assertTrue(allInsightPage.getCurrentURL().endsWith("all-insights/"), "User is not navigated to allInsightPage page after clicking on View All Insight link");
		 CustomAssertion.assertTrue(allInsightPage.iscontactUsLinkDisplayedOnHeader(), "ContactUs link is not displayed on the Page");
		 CustomAssertion.assertEquals(allInsightPage.getTextOfcontactUsLink(), "CONTACT", "Contact text is not displayed Contact");
		 contactUsPage = allInsightPage.clickOncontactUsLink();
		 CustomAssertion.assertEquals(contactUsPage.getTitle(), "Wellington Management Funds — Contact us", "User is  not navigated to contactUs page after clicking on Contact Us link on Insights Page");
		 contactUsPage.goBack();
		 //contactUsPage.goBack();
		 CustomAssertion.assertTrue(allInsightPage.getCurrentURL().endsWith("all-insights/"), "User is not navigated to allInsightPage page after clicking on View All Insight link");
		 CustomAssertion.assertTrue(allInsightPage.isSearchIconDisplayed(), "Search icon is not displayed");
		 CustomAssertion.assertTrue(allInsightPage.ClickOnSearchIcon(), "Enter button is not displayed after clicking on Search icon");
		 CustomAssertion.assertTrue(allInsightPage.isFootNoteAndDisclosureDisplayed(), "FootNote and Disclosure is displayed which should be displayed");
		CustomAssertion.assertEquals(allInsightPage.getFootNoteAndDisclosureText(), "DISCLOSURES & FOOTNOTES", "Footnote and disclosure heading is not match");
		 CustomAssertion.assertTrue(allInsightPage.isFootNoteAndDisclosureTextDisplayed(), "Footnote and disclosure text is not displayed");
		 CustomAssertion.assertEquals(allInsightPage.getfootNoteAndDisclosurediscriptionText(), allInsightPage.disclosureandFootnoteDiscription,  "Footnote and Disclosure discription is not correct");
		 CustomAssertion.assertTrue(allInsightPage.isTextAboveFooterDisplayed(), "Text above footer note isnot displayed");
		 CustomAssertion.assertEquals(allInsightPage.getTextAboveFooter(), allInsightPage.textAboveFooter, "Text above footer is incorrect");
		 CustomAssertion.assertTrue(allInsightPage.isCookiePolicyLinkDisplayed(), "Cookie policy link is not dispalyed in footer");
		 CustomAssertion.assertEquals(allInsightPage.getCookiePolicyLinkText().toLowerCase(), "Cookie policy".toLowerCase(), "Incorrect cookie policy link tecxt");
		 cookiePolicyPage = allInsightPage.clickOnCookiePolicyLink();
		 CustomAssertion.assertTrue(cookiePolicyPage.isBannerTextDisplayed(), "Banner text is not displayed on Cokie page");
		 cookiePolicyPage.goBack();
		 CustomAssertion.assertTrue(allInsightPage.getCurrentURL().endsWith("all-insights/"), "User is not navigated to allInsightPage page after clicking on View All Insight link");
		 CustomAssertion.assertTrue(allInsightPage.isPrivacyLinkDisplayed(), "Privacy link is not displayed on the home page");
		 CustomAssertion.assertEquals(allInsightPage.getTextOfPrivacyLink().toLowerCase(), "Privacy policy".toLowerCase(), "Privacy policy text is not displayed correct on home Page");
		 privacyPlocyPage = allInsightPage.clickOnPrivacyLink();
		 //CustomAssertion.assertEquals(privacyPlocy.getBannerText(), "Privacy policy", "Not navigated to Privacy page");
		 CustomAssertion.assertTrue(privacyPlocyPage.getTitle().contains("Privacy policy"), "User is not navigated to Privacy Policy page  after clicking on Privacy link");
		 privacyPlocyPage.goBack();
		 CustomAssertion.assertTrue(allInsightPage.getCurrentURL().endsWith("all-insights/"), "User is not navigated to allInsightPage page after clicking on View All Insight link");
		 CustomAssertion.assertTrue(allInsightPage.isTermsOfUseLinkDisplayed(), "Terms of use link is not displayed on the home page");
		 CustomAssertion.assertEquals(allInsightPage.getTermsOfUseLinkText().toLowerCase(), "Terms of use".toLowerCase(), "Terms of use text is not displayed correct on home Page");
		 termsPage = allInsightPage.clickOnTermsOfUseLink();
		 //CustomAssertion.assertEquals(termsPage.getBannerText(), "Terms of use", "Not navigated to Terms page");
		 CustomAssertion.assertTrue(termsPage.getTitle().contains("Terms of use"), "USer is not navigated to Terms and use page after clicking on Terms of use link");
		 termsPage.goBack();
		 CustomAssertion.assertTrue(allInsightPage.getCurrentURL().endsWith("all-insights/"), "User is not navigated to allInsightPage page after clicking on View All Insight link");	
		 
	 }
	 
	 @Test
	 public void verify_click_On_read_More() throws Exception
	 {
		 loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage = homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 insightPage = postHomePage.clickOnInsightsLink();
		 CustomAssertion.assertEquals(insightPage.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights page after clicking on Insights link");
		 allInsightPage = insightPage.clickOnViewAllInsights();
		 CustomAssertion.assertTrue(allInsightPage.getCurrentURL().endsWith("all-insights/"), "User is not navigated to allInsightPage page after clicking on View All Insight link");
		 distinctiveApproachToEquityPage = allInsightPage.click_On_read_More();
		 CustomAssertion.assertTrue(distinctiveApproachToEquityPage.getCurrentURL().endsWith("distinctive-approach-equity-research/"), "User is not navigated to distinctive ApproachTo Equity Page  after clicking on Read More link on view All Insight Page");
	 }


}
