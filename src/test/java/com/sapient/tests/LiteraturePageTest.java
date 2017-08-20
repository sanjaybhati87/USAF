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
public class LiteraturePageTest extends SeleniumTestPlan {
	
	String[] layoutTags ={"desktop"};
	LoginPage loginPage;
	 HomePostAttestationPage postHomePage;
	 HomePage homePage;
	 FundsLandingPage fundsLanding;
	 CapabilityPage capabilityPage;
	 InsightLandingPage insights;
	 LiteraturePage literaturePage;
	 ContactUsPage contactUs;
	 CookiePolicyPage cokkiePolicy;
	 PrivacyPolicy privacyPlocy;
	 TermsPage termsPage;
	 
	 @Test(enabled=false)
	 public void litrature_galenUiTest() throws Exception
	 {
		 loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 literaturePage = postHomePage.clickOnLitratureLink();
		 CustomAssertion.assertTrue(literaturePage.testPageLayout(layoutTags), "[Assert Fail]:Pixel are not correct");
		 
		 
	 }
	 
	 @Test
	 public void verify_litratureTable_FilterBy_DocumentType() throws Exception
	 {
		 loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 literaturePage = postHomePage.clickOnLitratureLink();
		 CustomAssertion.assertTrue(literaturePage.filterByDocumnetType(),"Table data is not filter properly on the basis of selected Document type");
		 
	 }
	 
	 @Test
	 public void verify_litratureTable_FilterBy_AssetType() throws Exception
	 {
		 loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 literaturePage = postHomePage.clickOnLitratureLink();
		 CustomAssertion.assertTrue(literaturePage.filterByAssetType(),"Table data is not filter properly on the basis of selected Asset type");
		 
	 }
	
	@Test
	 public void headerAndFoterTest() throws Exception
	 {
		 loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 literaturePage = postHomePage.clickOnLitratureLink();
		 CustomAssertion.assertEquals(literaturePage.getTitle(), "Wellington Management Funds — Literature", "User is not navigated to Literature page after clicking on Literature link");
		 
		 CustomAssertion.assertTrue(literaturePage.isWellingtonLogoDisplayed(), "Wellington logo is not displayed on literaturePage");
		 CustomAssertion.assertTrue(literaturePage.isFundsLinkDisplayedOnHeader(),"Funds link is not displayed on gloabl header on literaturePage");
		 CustomAssertion.assertEquals(literaturePage.getTextOfFundsLink(), "FUNDS", "Funds text is not displayed as FUNDS");
		 fundsLanding=literaturePage.clickOnFundsLink();
		 CustomAssertion.assertEquals(fundsLanding.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing page after clicking on Funds link on literaturePage");
		 fundsLanding.goBack();
		 CustomAssertion.assertEquals(literaturePage.getTitle(), "Wellington Management Funds — Literature", "User is not navigated to Literature page after clicking back button of funds page");
		
		 CustomAssertion.assertTrue(literaturePage.isCapabilitiesLinkDisplayedOnHeader(), "Capability link is not diaplayed on literaturePage");
		 CustomAssertion.assertEquals(literaturePage.getTextOfCapabilitiesLink(), "CAPABILITIES", "Capability text is not as CAPABILITIES ");
		 capabilityPage = literaturePage.clickOnCapabilitiesLink();
		 Assert.assertEquals(capabilityPage.getTitle(), "Wellington Management Funds capabilities", "User is not navigated to Capability Page");
		 
		 capabilityPage.goBack();
		  CustomAssertion.assertEquals(literaturePage.getTitle(), "Wellington Management Funds — Literature", "User is not navigated to Literature page after clicking on BACK button on Capability Page");
		
		
		 CustomAssertion.assertTrue(literaturePage.isInsightsLinkDisplayedOnHeader(), "Insights link is not displayed on the Page");
		 CustomAssertion.assertEquals(literaturePage.getTextOfInsightsLink(), "INSIGHTS", "Insights text is not displayed INSIGHTS");
		 insights = literaturePage.clickOnInsightsLink();
		 CustomAssertion.assertEquals(insights.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights page  after clicking on Insights link on literaturePage");
		 insights.goBack();
		  CustomAssertion.assertEquals(literaturePage.getTitle(), "Wellington Management Funds — Literature", "User is not navigated to literature Page after clicking on BACK button on Insights Page");
		

		 
		
		 CustomAssertion.assertTrue(literaturePage.iscontactUsLinkDisplayedOnHeader(), "ContactUs link is not displayed on the Page");
		 CustomAssertion.assertEquals(literaturePage.getTextOfcontactUsLink(), "CONTACT", "Contact text is not displayed Contact");
		 contactUs = literaturePage.clickOncontactUsLink();
		 CustomAssertion.assertEquals(contactUs.getTitle(), "Wellington Management Funds — Contact us", "User is  not navigated to contactUs page after clicking on Contact Us link on postHomePage");
		 contactUs.goBack();
		 //contactUs.goBack();
		  CustomAssertion.assertEquals(literaturePage.getTitle(), "Wellington Management Funds — Literature", "User is not navigated to Literature page after clicking BACK button on Contact us page");
		
		 CustomAssertion.assertTrue(literaturePage.isSearchIconDisplayed(), "Search icon is not displayed");
		 CustomAssertion.assertTrue(literaturePage.ClickOnSearchIcon(), "Enter button is not displayed after clicking on Search icon");
		 
		
		 CustomAssertion.assertTrue(literaturePage.isFootNoteAndDisclosureDisplayed(), "FootNote and Disclosure is not displayed");
		 CustomAssertion.assertEquals(literaturePage.getFootNoteAndDisclosureText(), "DISCLOSURES & FOOTNOTES", "Footnote and disclosure heading is not match");
		 CustomAssertion.assertTrue(literaturePage.isFootNoteAndDisclosureTextDisplayed(), "Footnote and disclosure text is not displayed");
		 CustomAssertion.assertEquals(literaturePage.getfootNoteAndDisclosurediscriptionText(), homePage.disclosureandFootnoteDiscription,  "Footnote and Disclosure discription is not correct");
		 CustomAssertion.assertTrue(literaturePage.isTextAboveFooterDisplayed(), "Text above footer note isnot displayed");
		 CustomAssertion.assertEquals(literaturePage.getTextAboveFooter(), homePage.textAboveFooter, "Text above footer is incorrect");
		 CustomAssertion.assertTrue(literaturePage.isCookiePolicyLinkDisplayed(), "Cookie policy link is not dispalyed in footer");
		 CustomAssertion.assertEquals(literaturePage.getCookiePolicyLinkText().toLowerCase(), "Cookie policy".toLowerCase(), "Incorrect cookie policy link tecxt");
		 cokkiePolicy = literaturePage.clickOnCookiePolicyLink();
		 CustomAssertion.assertTrue(cokkiePolicy.isBannerTextDisplayed(), "Banner text is not displayed on Cokie page");
		 cokkiePolicy.goBack();
		  CustomAssertion.assertEquals(literaturePage.getTitle(), "Wellington Management Funds — Literature", "User is not navigated to Literature page after clicking on BACK on Cookie page");
		
		 CustomAssertion.assertTrue(literaturePage.isPrivacyLinkDisplayed(), "Privacy link is not displayed on the home page");
		 CustomAssertion.assertEquals(literaturePage.getTextOfPrivacyLink().toLowerCase(), "Privacy policy".toLowerCase(), "Privacy policy text is not displayed correct on home Page");
		privacyPlocy = literaturePage.clickOnPrivacyLink();
		 //CustomAssertion.assertEquals(privacyPlocy.getBannerText(), "Privacy policy", "Not navigated to Privacy page");
		 CustomAssertion.assertTrue(privacyPlocy.getTitle().contains("Privacy policy"), "User is not navigated to Privacy Policy page  after clicking on Privacy link");
		 privacyPlocy.goBack();
		  CustomAssertion.assertEquals(literaturePage.getTitle(), "Wellington Management Funds — Literature", "User is not navigated to Literature page after clicking on BACK on Privacy page");
		
		 CustomAssertion.assertTrue(literaturePage.isTermsOfUseLinkDisplayed(), "Terms of use link is not displayed on the home page");
		 CustomAssertion.assertEquals(literaturePage.getTermsOfUseLinkText().toLowerCase(), "Terms of use".toLowerCase(), "Terms of use text is not displayed correct on home Page");
		 termsPage = literaturePage.clickOnTermsOfUseLink();
		 //CustomAssertion.assertEquals(termsPage.getBannerText(), "Terms of use", "Not navigated to Terms page");
		 CustomAssertion.assertTrue(termsPage.getTitle().contains("Terms of use"), "USer is not navigated to Terms and use page after clicking on Terms of use link");
		 termsPage.goBack();
		  CustomAssertion.assertEquals(literaturePage.getTitle(), "Wellington Management Funds — Literature", "User is not navigated to Literature page after clicking on BACK on Terms page");	 
		 
	 }
	
	@Test
	public void verifyViewAllLitratureLinkNavigation() throws Exception
	{
		 loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 literaturePage = postHomePage.clickOnLitratureLink();
		 literaturePage.clickOnAllLitratureLink();
		 CustomAssertion.assertEquals(literaturePage.getTitle(), "Wellington Management Funds — Literature", "User is not navigated to Literature page after clicking on Literature link");
		
	}

}
