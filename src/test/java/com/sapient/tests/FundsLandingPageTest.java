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
public class FundsLandingPageTest extends SeleniumTestPlan {
	
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
	// String username=SeleniumTestsContextManager.getUserName();
	 //String password=SeleniumTestsContextManager.getPassword();
	 
	 @Test(description="Verify the UI of Fund Landing Page",enabled=false)
	 public void fundLandingPageUiTest() throws Exception
	 {
		 loginPage = new LoginPage(driver);
		 //System.out.println(username);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 CustomAssertion.assertTrue(homePage.isWellingtonLogoDisplayed(), "Wellington logo is not displayed on home page");
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 fundsLanding = postHomePage.clickOnFundsLink();
		// Assert.assertEquals(capabilityPage.getTitle(), "Wellington Managment Funds capabilities", "User is not navigated to Capability Page");
		 //CustomAssertion.assertTrue(fundsLanding.testPageLayout(layoutTags), "[Assert Fail]:Pixel are not correct");
	 	
	 }
	 
	 @Test(description="Verify the text of options in Funds Nav layout",enabled=true)
	 public void verifyTheFundsNavFlayoutOptionsText() throws Exception
	 {
		 loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 fundsLanding = postHomePage.clickOnFundsLink();
		 CustomAssertion.softAssertEquals(fundsLanding.getTextOfFundsAtGalanceLink(), "All funds at a glance", "All funds at a glance is shown incorrectly");
		 CustomAssertion.softAssertEquals(fundsLanding.getTextOffundPricingLink(), "Pricing", "Pricing is shown incorrectly");
		 CustomAssertion.softAssertEquals(fundsLanding.getTextOfmultiassetFundLink(), "Multi-Assets funds", "Multi-Assets funds is shown incorrectly");
		 CustomAssertion.softAssertEquals(fundsLanding.getTextOffundPerformanceLink(), "Performance", "Performance is shown incorrectly");
		 CustomAssertion.softAssertEquals(fundsLanding.getTextOffixedIncomeFundLink(), "Fixed Income funds", "Fixed Income funds is shown incorrectly");
		 CustomAssertion.softAssertEquals(fundsLanding.getTextOfequityfundsLink(), "Equity funds", "Equity funds is shown incorrectly");
		 CustomAssertion.softAssertEquals(fundsLanding.getTextOfalternativeFundsLink(), "Alternatives funds", "Alternatives funds is shown incorrectly");
		 //System.out.println(fundsLanding.getTextOfFundsAtGalanceLink());
		 //fundExplorer.clickOnFundsLink();
		 //fundExplorer=fundsLanding.clickOnFundsAtGalanceLink();
		// CustomAssertion.assertEquals(fundExplorer.getTitle(), "Fund Explorer", "User is not navigated to Fund explorer page after cliking on All funds at a glance link");
		 
		 
		 //CustomAssertion.assertEquals(fundsLanding.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing page after clicking on Funds link");
		 
		 CustomAssertion.softAssertEquals(fundsLanding.getTextOffundPricingLink(), "Pricing", "Pricing is shown incorrectly");
		
		 
	 }
	 @Test(description="Verify the navigation on clicking on the options in Funds Nav layout",enabled=true)
	 public void verifyTheNavigationOnFundsNavFlyoutOptions() throws Exception
	 {
		 loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 fundsLanding = postHomePage.clickOnFundsLink();
		 CustomAssertion.assertEquals(fundsLanding.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing page after clicking on Funds link");
		 fundExplorer=fundsLanding.clickOnFundsAtGalanceLink();
		 CustomAssertion.assertTrue(fundExplorer.getTitle().startsWith("Fund explorer"),  "User is not navigated to Fund explorer page after cliking on Pricing link");
		 fundExplorer.goBack();
		 CustomAssertion.assertEquals(fundsLanding.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing page after clicking on Funds link");
		 
		 fundExplorer=fundsLanding.clickOnfundPricingLink();
		 CustomAssertion.assertTrue(fundExplorer.getTitle().startsWith("Fund explorer"),  "User is not navigated to Fund explorer page after cliking on Pricing link");
		 fundExplorer.goBack();
		 CustomAssertion.assertEquals(fundsLanding.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing page after clicking on Funds link");
		 
		 
		 
		 fundExplorer=fundsLanding.clickOnfundPerformanceLink();
		 CustomAssertion.assertTrue(fundExplorer.getTitle().startsWith("Fund explorer"),  "User is not navigated to Fund explorer page after cliking on Performance link");
		 fundExplorer.goBack();
		 CustomAssertion.assertEquals(fundsLanding.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing page after clicking on Funds link");
		 
		
		
		 fixedIncomeFundsPage=fundsLanding.clickOnfixedIncomeFundLink();
		 CustomAssertion.assertEquals(fixedIncomeFundsPage.getTitle(),"Wellington Management Funds – Fixed income funds",  "User is not navigated to Fixed income funds page after clicking on Fixed income fund link");
		 fixedIncomeFundsPage.goBack();
		 CustomAssertion.assertEquals(fundsLanding.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing page after clicking on Funds link");
		 
		 
		 
		
		 equityFundsPage = fundsLanding.clickOnequityfundsLink();
		 CustomAssertion.assertEquals(equityFundsPage.getTitle(),"Wellington Management Funds – Equity",  "User is not navigated to Equity funds page after clicking on Equity fund link");
		 equityFundsPage.goBack();
		 CustomAssertion.assertEquals(fundsLanding.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing page after clicking on Funds link");
		 
		
		 
		 multiAssetsFundsPage=fundsLanding.clickOnmultiassetFundLink();
		 CustomAssertion.assertTrue(multiAssetsFundsPage.getTitle().startsWith("Multi-Asset"),  "User is not navigated to Multi Asset page after clicking on Multi asset fund link");
		 multiAssetsFundsPage.goBack();
		 CustomAssertion.assertEquals(fundsLanding.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing page after clicking on Funds link");
		 
		
		 
		 alternativeFundsPage=fundsLanding.clickOnalternativeFundsLink();
		 CustomAssertion.assertTrue(alternativeFundsPage.getTitle().endsWith("Alternatives funds"),  "User is not navigated to Alternative Fund page after cliking on Alternative Fund link");
		 alternativeFundsPage.goBack();
		 CustomAssertion.assertEquals(fundsLanding.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing page after clicking on Funds link");
		 
		/* fundExplorer=fundsLanding.clickOnlearnMoreLink();
		 System.out.println(fundExplorer.getTitle());
		 CustomAssertion.assertTrue(fundExplorer.getTitle().startsWith("Fund explorer"),  "User is not navigated to Fund explorer page after cliking on Learn more link");
		 fundExplorer.goBack();
		 CustomAssertion.assertEquals(fundsLanding.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing page after clicking on Funds link");
		 System.out.println(fundsLanding.getTitle());*/
		 
	 }
	 @Test(groups={"FundLandingPage","headerAndFooter"},description="VErify the navigation on cliking on header and footer link",enabled=true)
	 public void headerAndFoterTest() throws Exception
	 {
		 loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 fundsLanding = postHomePage.clickOnFundsLink();
		 fundsLanding.pauseExecutionFor(1000);
		 CustomAssertion.assertEquals(fundsLanding.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing page after clicking on Funds link");
		 CustomAssertion.assertTrue(fundsLanding.isWellingtonLogoDisplayed(), "Wellington logo is not displayed on postHomePage");
		 CustomAssertion.assertTrue(fundsLanding.isFundsLinkDisplayedOnHeader(),"Funds link is not displayed on gloabl header on postHomePage");
		 CustomAssertion.assertEquals(fundsLanding.getTextOfFundsLink(), "FUNDS", "Funds text is not displayed as FUNDS");
		 CustomAssertion.assertTrue(fundsLanding.isCapabilitiesLinkDisplayedOnHeader(), "Capability link is not diaplayed on postHomePage");
		 CustomAssertion.assertEquals(fundsLanding.getTextOfCapabilitiesLink(), "CAPABILITIES", "Capability text is not as CAPABILITIES ");
		 capabilityPage = fundsLanding.clickOnCapabilitiesLink();
		 CustomAssertion.assertEquals(capabilityPage.getTitle(), "Wellington Management Funds capabilities", "User is not navigated to Capability Page");
		 
		 capabilityPage.goBack();
		  CustomAssertion.assertEquals(fundsLanding.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing page after clicking on Funds link");
		
		
		 CustomAssertion.assertTrue(fundsLanding.isInsightsLinkDisplayedOnHeader(), "Insights link is not displayed on the Page");
		 CustomAssertion.assertEquals(fundsLanding.getTextOfInsightsLink(), "INSIGHTS", "Insights text is not displayed INSIGHTS");
		 insights = fundsLanding.clickOnInsightsLink();
		 CustomAssertion.assertEquals(insights.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights page  after clicking on Insights link on postHomePage");
		 insights.goBack();
		  CustomAssertion.assertEquals(fundsLanding.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing page after clicking on Funds link");
		

		 CustomAssertion.assertTrue(fundsLanding.isLitratureLinkDisplayedOnHeader(), "Litrature link is not displayed on the Page");
		 CustomAssertion.assertEquals(fundsLanding.getTextOfLitratureLink(), "LITERATURE", "Litrature text is not displayed LITRATURE");
		 litrature = fundsLanding.clickOnLitratureLink();
		 CustomAssertion.assertEquals(litrature.getTitle(), "Wellington Management Funds — Literature", "User is not navigated to Litrature landing page after clicking on Litrature link on postHomePage");
		 litrature.goBack();
		  CustomAssertion.assertEquals(fundsLanding.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing page after clicking on Funds link");
		
		 CustomAssertion.assertTrue(fundsLanding.iscontactUsLinkDisplayedOnHeader(), "ContactUs link is not displayed on the Page");
		 CustomAssertion.assertEquals(fundsLanding.getTextOfcontactUsLink(), "CONTACT", "Contact text is not displayed Contact");
		 contactUs = fundsLanding.clickOncontactUsLink();
		 CustomAssertion.assertEquals(contactUs.getTitle(), "Wellington Management Funds — Contact us", "User is  not navigated to contactUs page after clicking on Contact Us link on postHomePage");
		 contactUs.goBack();
		  CustomAssertion.assertEquals(fundsLanding.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing page after clicking on Funds link");
		
		 CustomAssertion.assertTrue(fundsLanding.isSearchIconDisplayed(), "Search icon is not displayed");
		 CustomAssertion.assertTrue(fundsLanding.ClickOnSearchIcon(), "Enter button is not displayed after clicking on Search icon");
		 
		
		 CustomAssertion.assertTrue(fundsLanding.isFootNoteAndDisclosureDisplayed(), "FootNote and Disclosure is not displayed");
		 CustomAssertion.assertEquals(fundsLanding.getFootNoteAndDisclosureText(), "DISCLOSURES & FOOTNOTES", "Footnote and disclosure heading is not match");
		 CustomAssertion.assertTrue(fundsLanding.isFootNoteAndDisclosureTextDisplayed(), "Footnote and disclosure text is not displayed");
		 CustomAssertion.assertEquals(fundsLanding.getfootNoteAndDisclosurediscriptionText(), homePage.disclosureandFootnoteDiscription,  "Footnote and Disclosure discription is not correct");
		 CustomAssertion.assertTrue(fundsLanding.isTextAboveFooterDisplayed(), "Text above footer note isnot displayed");
		 CustomAssertion.assertEquals(fundsLanding.getTextAboveFooter(), homePage.textAboveFooter, "Text above footer is incorrect");
		 CustomAssertion.assertTrue(fundsLanding.isCookiePolicyLinkDisplayed(), "Cookie policy link is not dispalyed in footer");
		 CustomAssertion.assertEquals(fundsLanding.getCookiePolicyLinkText().toLowerCase(), "cookies policy".toLowerCase(), "Incorrect cookie policy link tecxt");
		 cokkiePolicy = fundsLanding.clickOnCookiePolicyLink();
		 CustomAssertion.assertTrue(cokkiePolicy.isBannerTextDisplayed(), "Banner text is not displayed on Cokie page");
		 cokkiePolicy.goBack();
		  CustomAssertion.assertEquals(fundsLanding.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing page after clicking on Funds link");
		
		 CustomAssertion.assertTrue(fundsLanding.isPrivacyLinkDisplayed(), "Privacy link is not displayed on the home page");
		 CustomAssertion.assertEquals(fundsLanding.getTextOfPrivacyLink().toLowerCase(), "Privacy policy".toLowerCase(), "Privacy policy text is not displayed correct on home Page");
		privacyPlocy = fundsLanding.clickOnPrivacyLink();
		 //CustomAssertion.assertEquals(privacyPlocy.getBannerText(), "Privacy policy", "Not navigated to Privacy page");
		 CustomAssertion.assertTrue(privacyPlocy.getTitle().contains("Privacy policy"), "User is not navigated to Privacy Policy page  after clicking on Privacy link");
		 privacyPlocy.goBack();
		  CustomAssertion.assertEquals(fundsLanding.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing page after clicking on Funds link");
		
		 CustomAssertion.assertTrue(fundsLanding.isTermsOfUseLinkDisplayed(), "Terms of use link is not displayed on the home page");
		 CustomAssertion.assertEquals(fundsLanding.getTermsOfUseLinkText().toLowerCase(), "Terms of use".toLowerCase(), "Terms of use text is not displayed correct on home Page");
		 termsPage = fundsLanding.clickOnTermsOfUseLink();
		 //CustomAssertion.assertEquals(termsPage.getBannerText(), "Terms of use", "Not navigated to Terms page");
		 CustomAssertion.assertTrue(termsPage.getTitle().contains("Terms of use"), "USer is not navigated to Terms and use page after clicking on Terms of use link");
		 termsPage.goBack();
		  CustomAssertion.assertEquals(fundsLanding.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing page after clicking on Funds link");
			 }
	 
	 @Test(enabled=true)
	   public void verifyTheClickOnTilesOnFundOfferingSection() throws NotCurrentPageException
	   {
		   loginPage = new LoginPage(driver);
			 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
			  postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
			  fundsLanding= postHomePage.clickOnFundsLink();
			 fixedIncomeFundsPage=fundsLanding.clickOnFixedIncomeTile();
			 CustomAssertion.softAssertEquals(fixedIncomeFundsPage.getTitle(), "Wellington Management Funds – Fixed income funds", "User is not navigated to Fixed income funds page afer clicking on Fixed income tile on Post Home Page");
			 fixedIncomeFundsPage.goBack();
			 CustomAssertion.assertEquals(fundsLanding.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing page after clicking on BACK button");
			 equityFundsPage= fundsLanding.clickOnEquityTile();
			 CustomAssertion.softAssertEquals(equityFundsPage.getTitle(), "Wellington Management Funds – Equity", "User is not navigated to Equity funds page afer clicking on Equity tile on Post Home Page");
			 equityFundsPage.goBack();
			 CustomAssertion.assertEquals(fundsLanding.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing page after clicking on BACK button");
			 multiAssetsFundsPage =fundsLanding.clickOnmultiAssetTile();
			 CustomAssertion.assertTrue(multiAssetsFundsPage.getTitle().startsWith("Multi-Asset"),  "User is not navigated to Multi Asset page after clicking on Multi asset tile on post Home Page");
			 multiAssetsFundsPage.goBack();
			 CustomAssertion.assertEquals(fundsLanding.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing page after clicking on BACK button");
			 alternativeFundsPage= fundsLanding.clickOnalternativeTile();
			 CustomAssertion.assertTrue(alternativeFundsPage.getTitle().endsWith("Alternatives funds"),  "User is not navigated to Alternative Fund page after cliking on Alternative tile on post home Page");
			 alternativeFundsPage.goBack();
			 CustomAssertion.assertEquals(fundsLanding.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing page after clicking on BACK button");
	   }
	 
	 @Test(enabled=true)
	 public void verifyclickOnviewAllFunds() throws NotCurrentPageException
	 {
		 loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		  postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		  fundsLanding= postHomePage.clickOnFundsLink();
		  fundExplorer= fundsLanding.clickOnviewAllFunds();
		  //fundExplorer.pauseExecutionFor(10000);
		  CustomAssertion.assertTrue(fundExplorer.getTitle().startsWith("Fund explorer"),  "User is not navigated to Fund explorer page after cliking on Performance link");
			 fundExplorer.goBack();
			 CustomAssertion.assertEquals(fundsLanding.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing page after clicking on Funds link");
			 
	 }
	 
}
