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
public class FundExplorerPageTest extends SeleniumTestPlan {

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
	 
	 @Test(description="Verify the UI of fund explorer page",enabled=false)
	 public void fundExlorer_uiGalenTest() throws NotCurrentPageException
	 {
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage = homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 postHomePage =  homePage.selectRegionAndCountry();
		 fundsLanding = postHomePage.clickOnFundsLink();
		 fundExplorer=fundsLanding.clickOnFundsAtGalanceLink();
		 //privacyPlocy = fundExplorer.clickOnPrivacyLink();
		 CustomAssertion.assertTrue(fundExplorer.testPageLayout(layoutTags), "[Assert Fail]:Pixel are not correct");
		 
	 }
	 
	 @Test(description="Verify the links on header and footer",enabled=false)
	 public void verifyHeaderAndFooter() throws Exception
	 {
	 loginPage = new LoginPage(driver);
	 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
	 postHomePage = homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
	 fundsLanding = postHomePage.clickOnFundsLink();
	 fundExplorer=fundsLanding.clickOnFundsAtGalanceLink();
	 CustomAssertion.assertTrue(fundExplorer.getTitle().startsWith("Fund explorer"),  "User is not navigated to Fund explorer page after cliking on Fund at a glance link");
	 CustomAssertion.assertTrue(fundExplorer.isWellingtonLogoDisplayed(), "Wellington logo is not displayed on postHomePage");
	 CustomAssertion.assertTrue(fundExplorer.isFundsLinkDisplayedOnHeader(),"Funds link is not displayed on gloabl header on postHomePage");
	 CustomAssertion.assertEquals(fundExplorer.getTextOfFundsLink(), "FUNDS", "Funds text is not displayed as FUNDS");
	 fundsLanding=fundExplorer.clickOnFundsLink();
	 CustomAssertion.assertEquals(fundsLanding.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing page after clicking on Funds link on postHomePage");
	 fundsLanding.goBack();
	 CustomAssertion.assertTrue(fundExplorer.getTitle().startsWith("Fund explorer"),  "User is not navigated to Fund explorer page after cliking on BACK button");
	
	 CustomAssertion.assertTrue(fundExplorer.isCapabilitiesLinkDisplayedOnHeader(), "Capability link is not diaplayed on postHomePage");
	 CustomAssertion.assertEquals(fundExplorer.getTextOfCapabilitiesLink(), "CAPABILITIES", "Capability text is not as CAPABILITIES ");
	 capabilityPage = fundExplorer.clickOnCapabilitiesLink();
	 Assert.assertEquals(capabilityPage.getTitle(), "Wellington Management Funds capabilities", "User is not navigated to Capability Page");
	 
	 capabilityPage.goBack();
	 CustomAssertion.assertTrue(fundExplorer.getTitle().startsWith("Fund explorer"),  "User is not navigated to Fund explorer page after cliking on BACK button");
	 CustomAssertion.assertTrue(fundExplorer.isInsightsLinkDisplayedOnHeader(), "Insights link is not displayed on the Page");
	 CustomAssertion.assertEquals(fundExplorer.getTextOfInsightsLink(), "INSIGHTS", "Insights text is not displayed INSIGHTS");
	 insights = fundExplorer.clickOnInsightsLink();
	 CustomAssertion.assertEquals(insights.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights page  after clicking on Insights link on postHomePage");
	 insights.goBack();
	 CustomAssertion.assertTrue(fundExplorer.getTitle().startsWith("Fund explorer"),  "User is not navigated to Fund explorer page after cliking on BACK button");
		

	 CustomAssertion.assertTrue(fundExplorer.isLitratureLinkDisplayedOnHeader(), "Litrature link is not displayed on the Page");
	 CustomAssertion.assertEquals(fundExplorer.getTextOfLitratureLink(), "LITERATURE", "Litrature text is not displayed LITRATURE");
	 litrature = fundExplorer.clickOnLitratureLink();
	 CustomAssertion.assertEquals(litrature.getTitle(), "Wellington Management Funds — Literature", "User is not navigated to Litrature landing page after clicking on Litrature link on postHomePage");
	 litrature.goBack();
	 CustomAssertion.assertTrue(fundExplorer.getTitle().startsWith("Fund explorer"),  "User is not navigated to Fund explorer page after cliking on BACK button");
		
	 CustomAssertion.assertTrue(fundExplorer.iscontactUsLinkDisplayedOnHeader(), "ContactUs link is not displayed on the Page");
	 CustomAssertion.assertEquals(fundExplorer.getTextOfcontactUsLink(), "CONTACT", "Contact text is not displayed Contact");
	 contactUs = fundExplorer.clickOncontactUsLink();
	 CustomAssertion.assertEquals(contactUs.getTitle(), "Wellington Management Funds — Contact us", "User is  not navigated to contactUs page after clicking on Contact Us link on postHomePage");
	 contactUs.goBack();
	 CustomAssertion.assertTrue(fundExplorer.getTitle().startsWith("Fund explorer"),  "User is not navigated to Fund explorer page after cliking on BACK button");
		
	 CustomAssertion.assertTrue(fundExplorer.isSearchIconDisplayed(), "Search icon is not displayed");
	 CustomAssertion.assertTrue(fundExplorer.ClickOnSearchIcon(), "Enter button is not displayed after clicking on Search icon");
	 
	
	 CustomAssertion.assertTrue(fundExplorer.isFootNoteAndDisclosureDisplayed(), "FootNote and Disclosure is not displayed");
	 CustomAssertion.assertEquals(fundExplorer.getFootNoteAndDisclosureText(), "DISCLOSURES & FOOTNOTES", "Footnote and disclosure heading is not match");
	 CustomAssertion.assertTrue(fundExplorer.isFootNoteAndDisclosureTextDisplayed(), "Footnote and disclosure text is not displayed");
	 CustomAssertion.assertEquals(fundExplorer.getfootNoteAndDisclosurediscriptionText(), homePage.disclosureandFootnoteDiscription,  "Footnote and Disclosure discription is not correct");
	 CustomAssertion.assertTrue(fundExplorer.isTextAboveFooterDisplayed(), "Text above footer note isnot displayed");
	 CustomAssertion.assertEquals(fundExplorer.getTextAboveFooter(), homePage.textAboveFooter, "Text above footer is incorrect");
	 CustomAssertion.assertTrue(fundExplorer.isCookiePolicyLinkDisplayed(), "Cookie policy link is not dispalyed in footer");
	 CustomAssertion.assertEquals(fundExplorer.getCookiePolicyLinkText().toLowerCase(), "Cookies policy".toLowerCase(), "Incorrect cookie policy link tecxt");
	 cokkiePolicy = fundExplorer.clickOnCookiePolicyLink();
	 CustomAssertion.assertTrue(cokkiePolicy.isBannerTextDisplayed(), "Banner text is not displayed on Cokie page");
	 cokkiePolicy.goBack();
	 CustomAssertion.assertTrue(fundExplorer.getTitle().startsWith("Fund explorer"),  "User is not navigated to Fund explorer page after cliking on BACK button");
		
	 CustomAssertion.assertTrue(fundExplorer.isPrivacyLinkDisplayed(), "Privacy link is not displayed on the home page");
	 CustomAssertion.assertEquals(fundExplorer.getTextOfPrivacyLink().toLowerCase(), "Privacy policy".toLowerCase(), "Privacy policy text is not displayed correct on home Page");
	privacyPlocy = fundExplorer.clickOnPrivacyLink();
	 //CustomAssertion.assertEquals(privacyPlocy.getBannerText(), "Privacy policy", "Not navigated to Privacy page");
	 CustomAssertion.assertTrue(privacyPlocy.getTitle().contains("Privacy policy"), "User is not navigated to Privacy Policy page  after clicking on Privacy link");
	 privacyPlocy.goBack();
	 CustomAssertion.assertTrue(fundExplorer.getTitle().startsWith("Fund explorer"),  "User is not navigated to Fund explorer page after cliking on BACK button");
		
	 CustomAssertion.assertTrue(fundExplorer.isTermsOfUseLinkDisplayed(), "Terms of use link is not displayed on the home page");
	 CustomAssertion.assertEquals(fundExplorer.getTermsOfUseLinkText().toLowerCase(), "Terms of use".toLowerCase(), "Terms of use text is not displayed correct on home Page");
	 termsPage = fundExplorer.clickOnTermsOfUseLink();
	 //CustomAssertion.assertEquals(termsPage.getBannerText(), "Terms of use", "Not navigated to Terms page");
	 CustomAssertion.assertTrue(termsPage.getTitle().contains("Terms of use"), "USer is not navigated to Terms and use page after clicking on Terms of use link");
	 termsPage.goBack();
	 CustomAssertion.assertTrue(fundExplorer.getTitle().startsWith("Fund explorer"),  "User is not navigated to Fund explorer page after cliking on BACK button");
		
	 }
	 
	

}
