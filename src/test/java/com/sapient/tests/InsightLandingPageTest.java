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
import com.sapient.webpage.AllInsightPage;
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
public class InsightLandingPageTest extends SeleniumTestPlan{
	
	String[] layoutTags ={"desktop"};
	LoginPage loginPage;
	 HomePostAttestationPage postHomePage;
	 HomePage homePage;
	 FundsLandingPage fundsLandingPage;
	 CapabilityPage capabilityPage;
	 InsightLandingPage insightPage;
	 LiteraturePage litrature;
	 ContactUsPage contactUs;
	 CookiePolicyPage cokkiePolicy;
	 PrivacyPolicy privacyPlocy;
	 TermsPage termsPage;
	 AllInsightPage allInsightPage;
	 InsightAutherBioPage autherBioPage;

	 
	 @Test(description="Verify the UI of Insight Landing Page",enabled=false)
	 public void galenUiTest() throws Exception
	 { loginPage = new LoginPage(driver);
	 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
	 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
	 insightPage = postHomePage.clickOnInsightsLink();
	 	CustomAssertion.assertTrue(insightPage.testPageLayout(layoutTags), "[Assert Fail]:Pixel are not correct");
	 }

	 @Test
	 public void headerAndFoterTest() throws Exception
	 {
		 loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 postHomePage.refresh();
		 insightPage = postHomePage.clickOnInsightsLink();
		 
		 
		 CustomAssertion.assertEquals(insightPage.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights page after clicking on Insights link");
		 
		 CustomAssertion.assertTrue(insightPage.isWellingtonLogoDisplayed(), "Wellington logo is not displayed on postHomePage");
		 CustomAssertion.assertTrue(insightPage.isFundsLinkDisplayedOnHeader(),"Funds link is not displayed on gloabl header on postHomePage");
		 CustomAssertion.assertEquals(insightPage.getTextOfFundsLink(), "FUNDS", "Funds text is not displayed as FUNDS");
		 fundsLandingPage=insightPage.clickOnFundsLink();
		 CustomAssertion.assertEquals(fundsLandingPage.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing Page after clicking on Funds link on insightPage");
		 fundsLandingPage.goBack();
		 CustomAssertion.assertEquals(insightPage.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights Page after clicking on BACK button on Funds Page");
		
		 CustomAssertion.assertTrue(insightPage.isCapabilitiesLinkDisplayedOnHeader(), "Capability link is not diaplayed on postHomePage");
		 CustomAssertion.assertEquals(insightPage.getTextOfCapabilitiesLink(), "CAPABILITIES", "Capability text is not as CAPABILITIES ");
		 capabilityPage = insightPage.clickOnCapabilitiesLink();
		 CustomAssertion.assertEquals(capabilityPage.getTitle(), "Wellington Management Funds capabilities", "User is not navigated to Capability Page");
		 
		 capabilityPage.goBack();
		  CustomAssertion.assertEquals(insightPage.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights Page after clicking on BACK button on Capability Page");
		
		
		 CustomAssertion.assertTrue(insightPage.isInsightsLinkDisplayedOnHeader(), "Insights link is not displayed on the Page");
		 CustomAssertion.assertEquals(insightPage.getTextOfInsightsLink(), "INSIGHTS", "Insights text is not displayed INSIGHTS");
		 insightPage = insightPage.clickOnInsightsLink();
		 CustomAssertion.assertEquals(insightPage.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights page  after clicking on Insights link on postHomePage");
		 //insightPage.goBack();
		  CustomAssertion.assertEquals(insightPage.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights Page after clicking on BACK button on Insights Page");
		

		 CustomAssertion.assertTrue(insightPage.isLitratureLinkDisplayedOnHeader(), "Litrature link is not displayed on the Page");
		 CustomAssertion.assertEquals(insightPage.getTextOfLitratureLink(), "LITERATURE", "Litrature text is not displayed LITRATURE");
		 litrature = insightPage.clickOnLitratureLink();
		 CustomAssertion.assertEquals(litrature.getTitle(), "Wellington Management Funds — Literature", "User is not navigated to Litrature landing page after clicking on Litrature link on postHomePage");
		 litrature.goBack();
		  CustomAssertion.assertEquals(insightPage.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights Page after clicking on BACK button on Literature Page");
		
		 CustomAssertion.assertTrue(insightPage.iscontactUsLinkDisplayedOnHeader(), "ContactUs link is not displayed on the Page");
		 CustomAssertion.assertEquals(insightPage.getTextOfcontactUsLink(), "CONTACT", "Contact text is not displayed Contact");
		 contactUs = insightPage.clickOncontactUsLink();
		 CustomAssertion.assertEquals(contactUs.getTitle(), "Wellington Management Funds — Contact us", "User is  not navigated to contactUs page after clicking on Contact Us link on Insights Page");
		 contactUs.goBack();
		 //contactUs.goBack();
		  CustomAssertion.assertEquals(insightPage.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights Page after clicking on BACK button on Contact Us Page");
		
		 CustomAssertion.assertTrue(insightPage.isSearchIconDisplayed(), "Search icon is not displayed");
		 CustomAssertion.assertTrue(insightPage.ClickOnSearchIcon(), "Enter button is not displayed after clicking on Search icon");
		 
		
		 CustomAssertion.assertFalse(insightPage.isFootNoteAndDisclosureDisplayed(), "FootNote and Disclosure is displayed which should be not displayed");
		// CustomAssertion.assertEquals(insightPage.getFootNoteAndDisclosureText(), "DISCLOSURES & FOOTNOTES", "Footnote and disclosure heading is not match");
		 //CustomAssertion.assertTrue(insightPage.isFootNoteAndDisclosureTextDisplayed(), "Footnote and disclosure text is not displayed");
		 //CustomAssertion.assertEquals(insightPage.getfootNoteAndDisclosurediscriptionText(), homePage.disclosureandFootnoteDiscription,  "Footnote and Disclosure discription is not correct");
		 CustomAssertion.assertTrue(insightPage.isTextAboveFooterDisplayed(), "Text above footer note isnot displayed");
		 CustomAssertion.assertEquals(insightPage.getTextAboveFooter(), homePage.textAboveFooter, "Text above footer is incorrect");
		 CustomAssertion.assertTrue(insightPage.isCookiePolicyLinkDisplayed(), "Cookie policy link is not dispalyed in footer");
		 CustomAssertion.assertEquals(insightPage.getCookiePolicyLinkText().toLowerCase(), "Cookie policy".toLowerCase(), "Incorrect cookie policy link tecxt");
		 cokkiePolicy = insightPage.clickOnCookiePolicyLink();
		 CustomAssertion.assertTrue(cokkiePolicy.isBannerTextDisplayed(), "Banner text is not displayed on Cokie page");
		 cokkiePolicy.goBack();
		  CustomAssertion.assertEquals(insightPage.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights Page after clicking on BACK button on Cookie Page");
		
		 CustomAssertion.assertTrue(insightPage.isPrivacyLinkDisplayed(), "Privacy link is not displayed on the home page");
		 CustomAssertion.assertEquals(insightPage.getTextOfPrivacyLink().toLowerCase(), "Privacy policy".toLowerCase(), "Privacy policy text is not displayed correct on home Page");
		privacyPlocy = insightPage.clickOnPrivacyLink();
		 //CustomAssertion.assertEquals(privacyPlocy.getBannerText(), "Privacy policy", "Not navigated to Privacy page");
		 CustomAssertion.assertTrue(privacyPlocy.getTitle().contains("Privacy policy"), "User is not navigated to Privacy Policy page  after clicking on Privacy link");
		 privacyPlocy.goBack();
		  CustomAssertion.assertEquals(insightPage.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights Page after clicking on BACK button on Privacy Page");
		
		 CustomAssertion.assertTrue(insightPage.isTermsOfUseLinkDisplayed(), "Terms of use link is not displayed on the home page");
		 CustomAssertion.assertEquals(insightPage.getTermsOfUseLinkText().toLowerCase(), "Terms of use".toLowerCase(), "Terms of use text is not displayed correct on home Page");
		 termsPage = insightPage.clickOnTermsOfUseLink();
		 //CustomAssertion.assertEquals(termsPage.getBannerText(), "Terms of use", "Not navigated to Terms page");
		 CustomAssertion.assertTrue(termsPage.getTitle().contains("Terms of use"), "USer is not navigated to Terms and use page after clicking on Terms of use link");
		 termsPage.goBack();
		  CustomAssertion.assertEquals(insightPage.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights Page after clicking on BACK button on Terms Page"); 	
		 
	 }
	 
	 @Test
	 public void verify_click_on_Explore_Insight_Link() throws Exception
	 {
		 loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 postHomePage.refresh();
		 insightPage = postHomePage.clickOnInsightsLink();
		 allInsightPage= insightPage.clickOnexoloreInsightsLink();
		 CustomAssertion.assertTrue(allInsightPage.getCurrentURL().endsWith("all-insights/"), "User is not navigated to allInsightPage page after clicking on View All Insight link");
		 allInsightPage.goBack();
		 CustomAssertion.assertEquals(insightPage.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights Page after clicking on BACK button on Terms Page"); 		 
	 }
	 
	 @Test
	 public void verify_click_on_View_All_Insight_Link() throws Exception
	 {
		 loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 postHomePage.refresh();
		 insightPage = postHomePage.clickOnInsightsLink();
		 allInsightPage= insightPage.clickOnviewAllInsightsLink();
		 CustomAssertion.assertTrue(allInsightPage.getCurrentURL().endsWith("all-insights/"), "User is not navigated to allInsightPage page after clicking on View All Insight link");
		 allInsightPage.goBack();
		 CustomAssertion.assertEquals(insightPage.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights Page after clicking on BACK button on Terms Page"); 		 
	 }
	 
	 @Test
	 public void click_On_Read_Article_Link() throws Exception
	 {
		 loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 insightPage = postHomePage.clickOnInsightsLink();
		 CustomAssertion.assertEquals(insightPage.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights page after clicking on Insights link");
		 autherBioPage = insightPage.clickOnReadArticleLink();
		 CustomAssertion.assertTrue(autherBioPage.getTitle().startsWith("Nanette Abuhoff Jacobson"), "User is not navigated to autherBioPage page after clicking on Read Article link");
		 
	 }
	 
	 @Test
	 public void click_On_View_AllInsight_Link() throws Exception
	 {
		 loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 insightPage = postHomePage.clickOnInsightsLink();
		 CustomAssertion.assertEquals(insightPage.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights page after clicking on Insights link");
		 allInsightPage = insightPage.clickOnViewAllInsights();
		 CustomAssertion.assertTrue(allInsightPage.getCurrentURL().endsWith("all-insights/"), "User is not navigated to allInsightPage page after clicking on View All Insight link");
		 
	 }

}
