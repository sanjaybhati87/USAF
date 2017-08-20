/**
 * 
 */
package com.sapient.tests;

import static java.util.Arrays.asList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sapient.core.CustomAssertion;
import com.sapient.core.SeleniumTestPlan;
import com.sapient.core.SeleniumTestsContextManager;
import com.sapient.customexception.NotCurrentPageException;
import com.sapient.webpage.AlternativeFundsPage;
import com.sapient.webpage.CapabilityPage;
import com.sapient.webpage.ContactUsPage;
import com.sapient.webpage.CookiePolicyPage;
import com.sapient.webpage.EquityFundsPage;
import com.sapient.webpage.FixedIncomeFundsPage;
import com.sapient.webpage.FundsLandingPage;
import com.sapient.webpage.HomePage;
import com.sapient.webpage.HomePostAttestationPage;
import com.sapient.webpage.InsightLandingPage;
import com.sapient.webpage.LiteraturePage;
import com.sapient.webpage.LoginPage;
import com.sapient.webpage.MultiAssetsFundsPage;
import com.sapient.webpage.PrivacyPolicy;
import com.sapient.webpage.TermsPage;

/**
 * @author ssi248
 *
 */
public class CapabilityPageTest extends SeleniumTestPlan{
	
	String[] layoutTags ={"desktop"};
	LoginPage loginPage;
	 HomePostAttestationPage postHomePage;
	 HomePage homePage;
	 FundsLandingPage fundsLanding;
	 CapabilityPage capabilityPage;
	 InsightLandingPage insights;
	 LiteraturePage litrature;
	 ContactUsPage contactUs;
	 CookiePolicyPage cokkiePolicy;
	 PrivacyPolicy privacyPlocy;
	 TermsPage termsPage;
	 FixedIncomeFundsPage fixedIncomeFundsPage;
	 EquityFundsPage equityFundsPage;
	 MultiAssetsFundsPage multiAssetsFundsPage;
	 AlternativeFundsPage alternativeFundsPage;
	
	 
	 @Test(description="Verify the UI of Capability  Page",enabled=false)
	 public void capbilityPageUiTest() throws Exception
	 {
		 loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 CustomAssertion.assertTrue(homePage.isWellingtonLogoDisplayed(), "Wellington logo is not displayed on home page");
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 capabilityPage = postHomePage.clickOnCapabilitiesLink();
		 Assert.assertEquals(capabilityPage.getTitle(), "Wellington Management Funds capabilities", "User is not navigated to Capability Page");
		 CustomAssertion.assertTrue(capabilityPage.testPageLayout(layoutTags), "[Assert Fail]:Pixel are not correct");
	 	
	 }
	 
	 @Test(description="Verify the UI of Capability  Page",enabled=true)
	 public void headerAndFoterTest() throws Exception
	 {
		 loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 //CustomAssertion.assertTrue(homePage.isWellingtonLogoDisplayed(), "Wellington logo is not displayed on home page");
		 postHomePage = homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 capabilityPage = postHomePage.clickOnCapabilitiesLink();
		 capabilityPage.pauseExecutionFor(1000);
		 CustomAssertion.assertEquals(capabilityPage.getTitle(), "Wellington Management Funds capabilities", "User is not navigated to Capability Page");
		 CustomAssertion.assertTrue(capabilityPage.isWellingtonLogoDisplayed(), "Wellington logo is not displayed on capabilityPage page");
		 CustomAssertion.assertTrue(capabilityPage.isFundsLinkDisplayedOnHeader(),"Funds link is not displayed on gloabl header on capabilityPage");
		 CustomAssertion.assertEquals(capabilityPage.getTextOfFundsLink(), "FUNDS", "Funds text is not displayed as FUNDS");
		 fundsLanding=capabilityPage.clickOnFundsLink();
		 CustomAssertion.assertEquals(fundsLanding.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing page after clicking on Funds link on Capabilty Page");
		 fundsLanding.goBack();
		 CustomAssertion.assertEquals(capabilityPage.getTitle(), "Wellington Management Funds capabilities", "User is not navigated to Capability Page");
		 CustomAssertion.assertEquals(capabilityPage.getTextOfCapabilitiesLink(), "CAPABILITIES", "Capability text is not as CAPABILITIES ");
		 CustomAssertion.assertTrue(capabilityPage.isCapabilitiesLinkDisplayedOnHeader(), "Capability link is not diaplayed on capabilityPage");
		 CustomAssertion.assertTrue(capabilityPage.isInsightsLinkDisplayedOnHeader(), "Insights link is not displayed on the Page");
		 CustomAssertion.assertEquals(capabilityPage.getTextOfInsightsLink(), "INSIGHTS", "Insights text is not displayed INSIGHTS");
		 insights = capabilityPage.clickOnInsightsLink();
		 CustomAssertion.assertEquals(insights.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights page  after clicking on Insights link on Capabilty Page");
		 capabilityPage.clickOnCapabilitiesLink();

		 CustomAssertion.assertTrue(capabilityPage.isLitratureLinkDisplayedOnHeader(), "Litrature link is not displayed on the Page");
		 CustomAssertion.assertEquals(capabilityPage.getTextOfLitratureLink(), "LITERATURE", "Litrature text is not displayed LITRATURE");
		 litrature = capabilityPage.clickOnLitratureLink();
		 CustomAssertion.assertEquals(litrature.getTitle(), "Wellington Management Funds — Literature", "User is not navigated to Litrature landing page after clicking on Litrature link on Capability Page");
		 capabilityPage.clickOnCapabilitiesLink();
		 CustomAssertion.assertEquals(capabilityPage.getTitle(), "Wellington Management Funds capabilities", "User is not navigated to Capability  page after clicking on Capability link");
		 CustomAssertion.assertTrue(capabilityPage.iscontactUsLinkDisplayedOnHeader(), "ContactUs link is not displayed on the Page");
		 CustomAssertion.assertEquals(capabilityPage.getTextOfcontactUsLink(), "CONTACT", "Contact text is not displayed Contact");
		 contactUs = capabilityPage.clickOncontactUsLink();
		 CustomAssertion.assertEquals(contactUs.getTitle(), "Wellington Management Funds — Contact us", "User is  not navigated to contactUs page after clicking on Contact Us link on Capability Page");
		 capabilityPage.clickOnCapabilitiesLink();
		 CustomAssertion.assertEquals(capabilityPage.getTitle(), "Wellington Management Funds capabilities", "User is not navigated to Capability  page after clicking on Capability link");
		 CustomAssertion.assertTrue(capabilityPage.isSearchIconDisplayed(), "Search icon is not displayed");
		 CustomAssertion.assertTrue(capabilityPage.ClickOnSearchIcon(), "Enter button is not displayed after clicking on Search icon");
		 capabilityPage.clickOnCapabilitiesLink();
		 CustomAssertion.assertEquals(capabilityPage.getTitle(), "Wellington Management Funds capabilities", "User is not navigated to Capability  page after clicking on Capability link");
		 System.out.println(capabilityPage.isFootNoteAndDisclosureDisplayed());
		 CustomAssertion.assertTrue(capabilityPage.isFootNoteAndDisclosureDisplayed(), "FootNote and Disclosure is not displayed");
		 CustomAssertion.assertEquals(capabilityPage.getFootNoteAndDisclosureText(), "DISCLOSURES & FOOTNOTES", "Footnote and disclosure heading is not match");
		 CustomAssertion.assertTrue(capabilityPage.isFootNoteAndDisclosureTextDisplayed(), "Footnote and disclosure text is not displayed");
		 CustomAssertion.assertEquals(capabilityPage.getfootNoteAndDisclosurediscriptionText(), homePage.disclosureandFootnoteDiscription,  "Footnote and Disclosure discription is not correct");
		 CustomAssertion.assertTrue(capabilityPage.isTextAboveFooterDisplayed(), "Text above footer note isnot displayed");
		 CustomAssertion.assertEquals(capabilityPage.getTextAboveFooter(), homePage.textAboveFooter, "Text above footer is incorrect");
		 CustomAssertion.assertTrue(capabilityPage.isCookiePolicyLinkDisplayed(), "Cookie policy link is not dispalyed in footer");
		 CustomAssertion.assertEquals(capabilityPage.getCookiePolicyLinkText().toLowerCase(), "Cookies policy".toLowerCase(), "Incorrect cookie policy link tecxt");
		 cokkiePolicy = capabilityPage.clickOnCookiePolicyLink();
		 System.out.println(cokkiePolicy.getTitle());
		 CustomAssertion.assertTrue(cokkiePolicy.isBannerTextDisplayed(), "Banner text is not displayed on Cokie page");
		 capabilityPage.clickOnCapabilitiesLink();
		 CustomAssertion.assertEquals(capabilityPage.getTitle(), "Wellington Management Funds capabilities", "User is not navigated to Capability  page after clicking on Capability link");
		 CustomAssertion.assertTrue(capabilityPage.isPrivacyLinkDisplayed(), "Privacy link is not displayed on the home page");
		 CustomAssertion.assertEquals(capabilityPage.getTextOfPrivacyLink().toLowerCase(), "Privacy policy".toLowerCase(), "Privacy policy text is not displayed correct on home Page");
		privacyPlocy = capabilityPage.clickOnPrivacyLink();
		System.out.println(privacyPlocy.getTitle());
		 //CustomAssertion.assertEquals(privacyPlocy.getBannerText(), "Privacy policy", "Not navigated to Privacy page");
		 CustomAssertion.assertTrue(privacyPlocy.getTitle().contains("Privacy policy"), "User is not navigated to Privacy Policy page  after clicking on Privacy link");
		 capabilityPage.clickOnCapabilitiesLink();
		 CustomAssertion.assertEquals(capabilityPage.getTitle(), "Wellington Management Funds capabilities", "User is not navigated to Capability  page after clicking on Capability link");
		 CustomAssertion.assertTrue(capabilityPage.isTermsOfUseLinkDisplayed(), "Terms of use link is not displayed on the home page");
		 CustomAssertion.assertEquals(capabilityPage.getTermsOfUseLinkText().toLowerCase(), "Terms of use".toLowerCase(), "Terms of use text is not displayed correct on home Page");
		 System.out.println(capabilityPage.getTermsOfUseLinkText());
		 termsPage = capabilityPage.clickOnTermsOfUseLink();
		 System.out.println(termsPage.getTitle());
		 //CustomAssertion.assertEquals(termsPage.getBannerText(), "Terms of use", "Not navigated to Terms page");
		 CustomAssertion.assertTrue(termsPage.getTitle().contains("Terms of use"), "USer is not navigated to Terms and use page after clicking on Terms of use link");
		 capabilityPage.clickOnCapabilitiesLink();
		 CustomAssertion.assertEquals(capabilityPage.getTitle(), "Wellington Management Funds capabilities", "User is not navigated to Capability  page after clicking on Capability link on Terms of use page");
	 	
	 }
	 
	 @Test(enabled=true)
	 public void verifyTheCapabilityNavFlayoutOptionsText() throws Exception
	 {
		 loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 capabilityPage = postHomePage.clickOnCapabilitiesLink();
		 CustomAssertion.softAssertEquals(capabilityPage.getTextOffixedIncomeFundLink(), "Fixed Income", "Fixed Income funds is shown incorrectly");
		 CustomAssertion.softAssertEquals(capabilityPage.getTextOfequityfundsLink(), "Equity", "Equity funds is shown incorrectly");
		 CustomAssertion.softAssertEquals(capabilityPage.getTextOfalternativeFundsLink(), "Alternatives", "Alternatives funds is shown incorrectly");
		 CustomAssertion.softAssertEquals(capabilityPage.getTextOfmultiassetFundLink(), "Multi-Asset", "Alternatives funds is shown incorrectly");	 
	 }
	 
	 @Test(enabled=true)
	 public void verifyTheNavigationOnCapabilityNavFlyoutOptions() throws Exception
	 {
		 loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage = homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 System.out.println(System.currentTimeMillis());
		 capabilityPage = postHomePage.clickOnCapabilitiesLink();
		 capabilityPage.pauseExecutionFor(10000);
		 fixedIncomeFundsPage=capabilityPage.clickOnfixedIncomeFundLink();
		 fixedIncomeFundsPage.waitForPageLoadByMe();
		 CustomAssertion.assertEquals(fixedIncomeFundsPage.getTitle(),"Wellington Management Funds – Fixed income funds",  "User is not navigated to Fixed income funds page after clicking on Fixed income fund link");
		 fixedIncomeFundsPage.goBack();
		 fixedIncomeFundsPage.waitForPageLoadByMe();
		 CustomAssertion.assertEquals(capabilityPage.getTitle(), "Wellington Management Funds capabilities", "User is not navigated to Capability page after clicking on Funds link");
		 equityFundsPage = capabilityPage.clickOnequityfundsLink();
		 CustomAssertion.assertEquals(equityFundsPage.getTitle(),"Wellington Management Funds – Equity",  "User is not navigated to Equity funds page after clicking on Equity fund link");
		 equityFundsPage.goBack();
		 CustomAssertion.assertEquals(capabilityPage.getTitle(), "Wellington Management Funds capabilities", "User is not navigated toCapability page after clicking on Funds link");
		 multiAssetsFundsPage=capabilityPage.clickOnmultiassetFundLink();
		 CustomAssertion.assertTrue(multiAssetsFundsPage.getTitle().startsWith("Multi-Asset"),  "User is not navigated to Multi Asset page after clicking on Multi asset fund link");
		 multiAssetsFundsPage.goBack();
		 CustomAssertion.assertEquals(capabilityPage.getTitle(), "Wellington Management Funds capabilities", "User is not navigated to Capability page after clicking on Funds link");
		 alternativeFundsPage=capabilityPage.clickOnalternativeFundsLink();
		 CustomAssertion.assertTrue(alternativeFundsPage.getTitle().endsWith("Alternatives funds"),  "User is not navigated to Alternative Fund page after cliking on Alternative Fund link");
		 alternativeFundsPage.goBack();
		 CustomAssertion.assertEquals(capabilityPage.getTitle(), "Wellington Management Funds capabilities", "User is not navigated to Capability page after clicking on Funds link");
	 }
	 
	 @Test(enabled=true)
	   public void verify_Click_On_Capability_links() throws Exception
	   {
		 loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 capabilityPage = postHomePage.clickOnCapabilitiesLink();
			 fixedIncomeFundsPage=capabilityPage.click_On_OurFixedIncomeCapability_link();
			 CustomAssertion.softAssertEquals(fixedIncomeFundsPage.getTitle(), "Wellington Management Funds – Fixed income funds", "User is not navigated to Fixed income funds page afer clicking on Fixed income tile on Post Home Page");
			 fixedIncomeFundsPage.goBack();
			 CustomAssertion.assertEquals(capabilityPage.getTitle(), "Wellington Management Funds capabilities", "User is not navigated to Capability  page after clicking on Capability link");
			 equityFundsPage= capabilityPage.click_On_OurEquityCapability_link();
			 CustomAssertion.softAssertEquals(equityFundsPage.getTitle(), "Wellington Management Funds – Equity", "User is not navigated to Equity funds page afer clicking on Equity tile on Post Home Page");
			 equityFundsPage.goBack();
			 CustomAssertion.assertEquals(capabilityPage.getTitle(), "Wellington Management Funds capabilities", "User is not navigated to Capability  page after clicking on Capability link");
			 multiAssetsFundsPage =capabilityPage.click_On_OurMultiassetCapability_link();
			 CustomAssertion.assertTrue(multiAssetsFundsPage.getTitle().startsWith("Multi-Asset"),  "User is not navigated to Multi Asset page after clicking on Multi asset tile on post Home Page");
			 multiAssetsFundsPage.goBack();
			 CustomAssertion.assertEquals(capabilityPage.getTitle(), "Wellington Management Funds capabilities", "User is not navigated to Capability  page after clicking on Capability link");
			 alternativeFundsPage= capabilityPage.click_On_OurAlternativeCapability_link();
			 CustomAssertion.assertTrue(alternativeFundsPage.getTitle().endsWith("Alternatives funds"),  "User is not navigated to Alternative Fund page after cliking on Alternative tile on post home Page");
			 alternativeFundsPage.goBack();
			 CustomAssertion.assertEquals(capabilityPage.getTitle(), "Wellington Management Funds capabilities", "User is not navigated to Capability  page after clicking on Capability link");
	   }


}
