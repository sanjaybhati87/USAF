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
import com.sapient.webpage.AlternativeFundsPage;
import com.sapient.webpage.CapabilityPage;
import com.sapient.webpage.ContactUsPage;
import com.sapient.webpage.CookiePolicyPage;
import com.sapient.webpage.EquityFundsPage;
import com.sapient.webpage.FixedIncomeFundsPage;
import com.sapient.webpage.FundDetailsPage;
import com.sapient.webpage.FundExplorerPage;
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
public class FundDetailsPageTest extends SeleniumTestPlan {
	
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
	 FundExplorerPage fundExplorer;
	 FixedIncomeFundsPage fixedIncomeFundsPage;
	 EquityFundsPage equityFundsPage;
	 MultiAssetsFundsPage multiAssetsFundsPage;
	 AlternativeFundsPage alternativeFundsPage;
	 FundDetailsPage fundDeatilsPage;
	 
	 @Test(description="Verify the UI of Fund Pricing  Page",enabled=false)
	 public void galenUiTest() throws Exception
	 {
		 loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 fundsLanding = postHomePage.clickOnFundsLink();
		 fundExplorer=fundsLanding.clickOnFundsAtGalanceLink();
		 fundExplorer.pauseExecutionFor(10000);
		 CustomAssertion.assertTrue(fundExplorer.getTitle().startsWith("Fund explorer"),  "User is not navigated to Fund explorer page after cliking on Fund at a glance link");
		 fundDeatilsPage = fundExplorer.clickOnasiaExJapanEquityFund();
		 CustomAssertion.assertTrue(fundDeatilsPage.getTitle().startsWith("Funds details"),  "User is not navigated to Fund details page after cliking on asia ExJapan Equity Fund");
	 	CustomAssertion.assertTrue(fundDeatilsPage.testPageLayout(layoutTags), "[Assert Fail]:Pixel are not correct");
	 }

	 @Test(enabled=true)
	 public void verifyHeaderAndFooterOnFundDetailPage() throws Exception
	 {
		 loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 fundsLanding = postHomePage.clickOnFundsLink();
		 fundExplorer=fundsLanding.clickOnFundsAtGalanceLink();
		 fundExplorer.pauseExecutionFor(10000);
		 CustomAssertion.assertTrue(fundExplorer.getTitle().startsWith("Fund explorer"),  "User is not navigated to Fund explorer page after cliking on Fund at a glance link");
		 fundDeatilsPage = fundExplorer.clickOnasiaExJapanEquityFund();
		 System.out.println(fundDeatilsPage.getTitle());
		 CustomAssertion.assertTrue(fundDeatilsPage.getTitle().startsWith("Funds details"),  "User is not navigated to Fund details page after cliking on asia ExJapan Equity Fund");
		 CustomAssertion.assertTrue(fundDeatilsPage.isWellingtonLogoDisplayed(), "Wellington logo is not displayed on postHomePage");
		 CustomAssertion.assertTrue(fundDeatilsPage.isFundsLinkDisplayedOnHeader(),"Funds link is not displayed on gloabl header on postHomePage");
		 CustomAssertion.assertEquals(fundDeatilsPage.getTextOfFundsLink(), "FUNDS", "Funds text is not displayed as FUNDS");
		 fundsLanding=fundDeatilsPage.clickOnFundsLink();
		 CustomAssertion.assertEquals(fundsLanding.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing page after clicking on Funds link on postHomePage");
		 fundsLanding.goBack();
		 fundsLanding.pauseExecutionFor(10000);
		 CustomAssertion.assertTrue(fundDeatilsPage.getTitle().startsWith("Funds details"),  "User is not navigated to Fund details page after cliking on BACK button");
		 CustomAssertion.assertTrue(fundDeatilsPage.isCapabilitiesLinkDisplayedOnHeader(), "Capability link is not diaplayed on postHomePage");
		 CustomAssertion.assertEquals(fundDeatilsPage.getTextOfCapabilitiesLink(), "CAPABILITIES", "Capability text is not as CAPABILITIES ");
		 capabilityPage = fundDeatilsPage.clickOnCapabilitiesLink();
		 Assert.assertEquals(capabilityPage.getTitle(), "Wellington Management Funds capabilities", "User is not navigated to Capability Page");
		 
		 capabilityPage.goBack();
		 capabilityPage.pauseExecutionFor(10000);
		 CustomAssertion.assertTrue(fundDeatilsPage.getTitle().startsWith("Funds details"),  "User is not navigated to Fund details page after cliking on BACK button");
		 CustomAssertion.assertTrue(fundDeatilsPage.isInsightsLinkDisplayedOnHeader(), "Insights link is not displayed on the Page");
		 CustomAssertion.assertEquals(fundDeatilsPage.getTextOfInsightsLink(), "INSIGHTS", "Insights text is not displayed INSIGHTS");
		 insights = fundDeatilsPage.clickOnInsightsLink();
		 CustomAssertion.assertEquals(insights.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights page  after clicking on Insights link on postHomePage");
		 insights.goBack();
		 insights.pauseExecutionFor(1000);
		 CustomAssertion.assertTrue(fundDeatilsPage.getTitle().startsWith("Funds details"),  "User is not navigated to Fund details page after cliking on BACK button");
			

		 CustomAssertion.assertTrue(fundDeatilsPage.isLitratureLinkDisplayedOnHeader(), "Litrature link is not displayed on the Page");
		 CustomAssertion.assertEquals(fundDeatilsPage.getTextOfLitratureLink(), "LITERATURE", "Litrature text is not displayed LITRATURE");
		 litrature = fundDeatilsPage.clickOnLitratureLink();
		 CustomAssertion.assertEquals(litrature.getTitle(), "Wellington Management Funds — Literature", "User is not navigated to Litrature landing page after clicking on Litrature link on postHomePage");
		 litrature.goBack();
		 litrature.pauseExecutionFor(1000);
		 CustomAssertion.assertTrue(fundDeatilsPage.getTitle().startsWith("Funds details"),  "User is not navigated to Fund details page after cliking on BACK button");
			
		 CustomAssertion.assertTrue(fundDeatilsPage.iscontactUsLinkDisplayedOnHeader(), "ContactUs link is not displayed on the Page");
		 CustomAssertion.assertEquals(fundDeatilsPage.getTextOfcontactUsLink(), "CONTACT", "Contact text is not displayed Contact");
		 contactUs = fundDeatilsPage.clickOncontactUsLink();
		 CustomAssertion.assertEquals(contactUs.getTitle(), "Wellington Management Funds — Contact us", "User is  not navigated to contactUs page after clicking on Contact Us link on postHomePage");
		 contactUs.goBack();
		 contactUs.pauseExecutionFor(1000);
		 CustomAssertion.assertTrue(fundDeatilsPage.getTitle().startsWith("Funds details"),  "User is not navigated to Fund details page after cliking on BACK button");
			
		 CustomAssertion.assertTrue(fundDeatilsPage.isSearchIconDisplayed(), "Search icon is not displayed");
		 CustomAssertion.assertTrue(fundDeatilsPage.ClickOnSearchIcon(), "Enter button is not displayed after clicking on Search icon");
		 
		
		 CustomAssertion.assertTrue(fundDeatilsPage.isFootNoteAndDisclosureDisplayed(), "FootNote and Disclosure is not displayed");
		 CustomAssertion.assertEquals(fundDeatilsPage.getFootNoteAndDisclosureText(), "DISCLOSURES & FOOTNOTES", "Footnote and disclosure heading is not match");
		 CustomAssertion.assertTrue(fundDeatilsPage.isFootNoteAndDisclosureTextDisplayed(), "Footnote and disclosure text is not displayed");
		 CustomAssertion.assertEquals(fundDeatilsPage.getfootNoteAndDisclosurediscriptionText(), homePage.disclosureandFootnoteDiscription,  "Footnote and Disclosure discription is not correct");
		 CustomAssertion.assertTrue(fundDeatilsPage.isTextAboveFooterDisplayed(), "Text above footer note isnot displayed");
		 CustomAssertion.assertEquals(fundDeatilsPage.getTextAboveFooter(), homePage.textAboveFooter, "Text above footer is incorrect");
		 CustomAssertion.assertTrue(fundDeatilsPage.isCookiePolicyLinkDisplayed(), "Cookie policy link is not dispalyed in footer");
		 CustomAssertion.assertEquals(fundDeatilsPage.getCookiePolicyLinkText().toLowerCase(), "Cookie policy".toLowerCase(), "Incorrect cookie policy link tecxt");
		 cokkiePolicy = fundDeatilsPage.clickOnCookiePolicyLink();
		 CustomAssertion.assertTrue(cokkiePolicy.isBannerTextDisplayed(), "Banner text is not displayed on Cokie page");
		 cokkiePolicy.goBack();
		 cokkiePolicy.pauseExecutionFor(1000);
		 
		 CustomAssertion.assertTrue(fundDeatilsPage.getTitle().startsWith("Funds details"),  "User is not navigated to Fund details page after cliking on BACK button");
			
		 CustomAssertion.assertTrue(fundDeatilsPage.isPrivacyLinkDisplayed(), "Privacy link is not displayed on the home page");
		 CustomAssertion.assertEquals(fundDeatilsPage.getTextOfPrivacyLink().toLowerCase(), "Privacy policy".toLowerCase(), "Privacy policy text is not displayed correct on home Page");
		privacyPlocy = fundDeatilsPage.clickOnPrivacyLink();
		 //CustomAssertion.assertEquals(privacyPlocy.getBannerText(), "Privacy policy", "Not navigated to Privacy page");
		 CustomAssertion.assertTrue(privacyPlocy.getTitle().contains("Privacy policy"), "User is not navigated to Privacy Policy page  after clicking on Privacy link");
		 privacyPlocy.goBack();
		 privacyPlocy.pauseExecutionFor(1000);
		 
		 CustomAssertion.assertTrue(fundDeatilsPage.getTitle().startsWith("Funds details"),  "User is not navigated to Fund details page after cliking on BACK button");
			
		 CustomAssertion.assertTrue(fundDeatilsPage.isTermsOfUseLinkDisplayed(), "Terms of use link is not displayed on the home page");
		 CustomAssertion.assertEquals(fundDeatilsPage.getTermsOfUseLinkText().toLowerCase(), "Terms of use".toLowerCase(), "Terms of use text is not displayed correct on home Page");
		 termsPage = fundDeatilsPage.clickOnTermsOfUseLink();
		 //CustomAssertion.assertEquals(termsPage.getBannerText(), "Terms of use", "Not navigated to Terms page");
		 CustomAssertion.assertTrue(termsPage.getTitle().contains("Terms of use"), "USer is not navigated to Terms and use page after clicking on Terms of use link");
		 termsPage.goBack();
		 termsPage.pauseExecutionFor(1000);
		 CustomAssertion.assertTrue(fundDeatilsPage.getTitle().startsWith("Funds details"),  "User is not navigated to Fund details page after cliking on BACK button");
			
	 }
	 
	 @Test(enabled=true)
	 public void NavigateToFundDetailPage_Asia_ex_Japan()
	 {
		 loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage = homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 fundsLanding = postHomePage.clickOnFundsLink();
		 fundExplorer=fundsLanding.clickOnFundsAtGalanceLink();
		 fundExplorer.pauseExecutionFor(4000);
		 fundDeatilsPage =fundExplorer.ClickOnEquityFund();
		 CustomAssertion.assertTrue(fundDeatilsPage.getTitle().startsWith("Funds details"),  "User is not navigated to Fund details page after cliking on asia ExJapan Equity Fund");
		 
	 }

}
