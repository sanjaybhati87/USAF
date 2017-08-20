/**
 * 
 */
package com.sapient.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sapient.core.CustomAssertion;
import com.sapient.core.SeleniumTestPlan;
import com.sapient.core.SeleniumTestsContextManager;
import com.sapient.customexception.NotCurrentPageException;
import com.sapient.webpage.AllInsightPage;
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
public class HomePostAttestationPageTest extends SeleniumTestPlan {
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
	 AllInsightPage allInsightPage;
	 
	 
	 @Test(groups={"PostHomePage","UiTest"},description="Verify the UI of Post home  Page", enabled=false)
	 public void capbilityPageUiTest() throws Exception
	 {
		 loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 CustomAssertion.assertTrue(homePage.isWellingtonLogoDisplayed(), "Wellington logo is not displayed on home page");
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 CustomAssertion.assertEquals(postHomePage.getTitle(), "Wellington Management Funds — About", "Not navigated to post attested home page");
		 CustomAssertion.assertTrue(postHomePage.testPageLayout(layoutTags), "[Assert Fail]:Pixel are not correct");
	 	
	 }
	
	@Test(groups={"PostHomePage","CommonValidations"},description="Verify the header and footer on post attested home Page",enabled=true)
	public void verifyHeaderAndFooter() throws Exception
	{
		loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 CustomAssertion.assertEquals(postHomePage.getTitle(), "Wellington Management Funds — About", "Not navigated to post attested home page");
		 CustomAssertion.assertTrue(postHomePage.isWellingtonLogoDisplayed(), "Wellington logo is not displayed on postHomePage");
		 CustomAssertion.assertTrue(postHomePage.isFundsLinkDisplayedOnHeader(),"Funds link is not displayed on gloabl header on postHomePage");
		 CustomAssertion.assertEquals(postHomePage.getTextOfFundsLink(), "FUNDS", "Funds text is not displayed as FUNDS");
		 fundsLanding=postHomePage.clickOnFundsLink();
		 CustomAssertion.assertEquals(fundsLanding.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing page after clicking on Funds link on postHomePage");
		// postHomePage.clickOnWellingtonLogo();
		 fundsLanding.goBack();
		 CustomAssertion.assertEquals(postHomePage.getTitle(), "Wellington Management Funds — About", "User is not navigated to postHomePage  page after clicking on Wellington logo");
		
		 CustomAssertion.assertTrue(postHomePage.isCapabilitiesLinkDisplayedOnHeader(), "Capability link is not diaplayed on postHomePage");
		 CustomAssertion.assertEquals(postHomePage.getTextOfCapabilitiesLink(), "CAPABILITIES", "Capability text is not as CAPABILITIES ");
		 capabilityPage = postHomePage.clickOnCapabilitiesLink();
		 CustomAssertion.assertEquals(capabilityPage.getTitle(), "Wellington Management Funds capabilities", "User is not navigated to Capability Page");
		 
		 //postHomePage.clickOnWellingtonLogo();
		 capabilityPage.goBack();
		 CustomAssertion.assertEquals(postHomePage.getTitle(), "Wellington Management Funds — About", "User is not navigated to postHomePage  page after clicking on Wellington logo");
		
		
		 CustomAssertion.assertTrue(postHomePage.isInsightsLinkDisplayedOnHeader(), "Insights link is not displayed on the Page");
		 CustomAssertion.assertEquals(postHomePage.getTextOfInsightsLink(), "INSIGHTS", "Insights text is not displayed INSIGHTS");
		 insights = postHomePage.clickOnInsightsLink();
		 CustomAssertion.assertEquals(insights.getTitle(), "Wellington Management Funds — Insights", "User is not navigated to Insights page  after clicking on Insights link on postHomePage");
		 //postHomePage.clickOnWellingtonLogo();
		 insights.goBack();
		 CustomAssertion.assertEquals(postHomePage.getTitle(), "Wellington Management Funds — About", "User is not navigated to postHomePage  page after clicking on Wellington logo");
		

		 CustomAssertion.assertTrue(postHomePage.isLitratureLinkDisplayedOnHeader(), "Litrature link is not displayed on the Page");
		 CustomAssertion.assertEquals(postHomePage.getTextOfLitratureLink(), "LITERATURE", "Litrature text is not displayed LITRATURE");
		 litrature = postHomePage.clickOnLitratureLink();
		 CustomAssertion.assertEquals(litrature.getTitle(), "Wellington Management Funds — Literature", "User is not navigated to Litrature landing page after clicking on Litrature link on postHomePage");
		 //postHomePage.clickOnWellingtonLogo();
		 litrature.goBack();
		 CustomAssertion.assertEquals(postHomePage.getTitle(), "Wellington Management Funds — About", "User is not navigated to postHomePage  page after clicking on Wellington logo");
		
		 CustomAssertion.assertTrue(postHomePage.iscontactUsLinkDisplayedOnHeader(), "ContactUs link is not displayed on the Page");
		 CustomAssertion.assertEquals(postHomePage.getTextOfcontactUsLink(), "CONTACT", "Contact text is not displayed Contact");
		 contactUs = postHomePage.clickOncontactUsLink();
		 CustomAssertion.assertEquals(contactUs.getTitle(), "Wellington Management Funds — Contact us", "User is  not navigated to contactUs page after clicking on Contact Us link on postHomePage");
		 //postHomePage.clickOnWellingtonLogo();
		 contactUs.goBack();
		 //contactUs.goBack();
		 CustomAssertion.assertEquals(postHomePage.getTitle(), "Wellington Management Funds — About", "User is not navigated to postHomePage  page after clicking on Wellington logo");
		
		 CustomAssertion.assertTrue(postHomePage.isSearchIconDisplayed(), "Search icon is not displayed");
		 CustomAssertion.assertTrue(postHomePage.ClickOnSearchIcon(), "Enter button is not displayed after clicking on Search icon");
		 
		 //CustomAssertion.assertEquals(postHomePage.getTitle(), "Wellington Management Funds — About", "User is not navigated to postHomePage  page after clicking on Wellington logo");
		
		 CustomAssertion.assertTrue(postHomePage.isFootNoteAndDisclosureDisplayed(), "FootNote and Disclosure is not displayed");
		 CustomAssertion.assertEquals(postHomePage.getFootNoteAndDisclosureText(), "DISCLOSURES & FOOTNOTES", "Footnote and disclosure heading is not match");
		 CustomAssertion.assertTrue(postHomePage.isFootNoteAndDisclosureTextDisplayed(), "Footnote and disclosure text is not displayed");
		 CustomAssertion.assertEquals(postHomePage.getfootNoteAndDisclosurediscriptionText(), homePage.disclosureandFootnoteDiscription,  "Footnote and Disclosure discription is not correct");
		 CustomAssertion.assertTrue(postHomePage.isTextAboveFooterDisplayed(), "Text above footer note isnot displayed");
		 CustomAssertion.assertEquals(postHomePage.getTextAboveFooter(), homePage.textAboveFooter, "Text above footer is incorrect");
		 CustomAssertion.assertTrue(postHomePage.isCookiePolicyLinkDisplayed(), "Cookie policy link is not dispalyed in footer");
		 CustomAssertion.assertEquals(postHomePage.getCookiePolicyLinkText().toLowerCase(), "cookies policy".toLowerCase(), "Incorrect cookie policy link tecxt");
		 cokkiePolicy = postHomePage.clickOnCookiePolicyLink();
		 CustomAssertion.assertTrue(cokkiePolicy.isBannerTextDisplayed(), "Banner text is not displayed on Cokie page");
		 //postHomePage.clickOnWellingtonLogo();
		 cokkiePolicy.goBack();
		 CustomAssertion.assertEquals(postHomePage.getTitle(), "Wellington Management Funds — About", "User is not navigated to postHomePage  page after clicking on Wellington logo");
		
		 CustomAssertion.assertTrue(postHomePage.isPrivacyLinkDisplayed(), "Privacy link is not displayed on the home page");
		 CustomAssertion.assertEquals(postHomePage.getTextOfPrivacyLink().toLowerCase(), "Privacy policy".toLowerCase(), "Privacy policy text is not displayed correct on home Page");
		privacyPlocy = postHomePage.clickOnPrivacyLink();
		 //CustomAssertion.assertEquals(privacyPlocy.getBannerText(), "Privacy policy", "Not navigated to Privacy page");
		 CustomAssertion.assertTrue(privacyPlocy.getTitle().contains("Privacy policy"), "User is not navigated to Privacy Policy page  after clicking on Privacy link");
		 //postHomePage.clickOnWellingtonLogo();
		 privacyPlocy.goBack();
		 CustomAssertion.assertEquals(postHomePage.getTitle(), "Wellington Management Funds — About", "User is not navigated to postHomePage  page after clicking on Wellington logo");
		
		 CustomAssertion.assertTrue(postHomePage.isTermsOfUseLinkDisplayed(), "Terms of use link is not displayed on the home page");
		 CustomAssertion.assertEquals(postHomePage.getTermsOfUseLinkText().toLowerCase(), "Terms of use".toLowerCase(), "Terms of use text is not displayed correct on home Page");
		 termsPage = postHomePage.clickOnTermsOfUseLink();
		 //CustomAssertion.assertEquals(termsPage.getBannerText(), "Terms of use", "Not navigated to Terms page");
		 CustomAssertion.assertTrue(termsPage.getTitle().contains("Terms of use"), "USer is not navigated to Terms and use page after clicking on Terms of use link");
		 //postHomePage.clickOnWellingtonLogo();
		 termsPage.goBack();
		 CustomAssertion.assertEquals(postHomePage.getTitle(), "Wellington Management Funds — About", "User is not navigated to postHomePage  page after clicking on Wellington logo");
				
	}
@Test(enabled=false)
public void clickOnBannerLink() throws NotCurrentPageException
{
	loginPage = new LoginPage(driver);
	 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
	 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
	 postHomePage.clickOn_Shared_Insight_InsightLink();
	 postHomePage.pauseExecutionFor(100000);	
}

   @Test(groups={"PostHomePage"},description="Verify the navigation on clicking on tiles of funds under capability section", enabled=true)
   public void verifyTheClickOnTilesOnFundOfferingSection() throws NotCurrentPageException
   {
	   
	   loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 postHomePage.pauseExecutionFor(1000);
		 fixedIncomeFundsPage=postHomePage.clickOnFixedIncomeTile();
		 CustomAssertion.softAssertEquals(fixedIncomeFundsPage.getTitle(), "Wellington Management Funds – Fixed income funds", "User is not navigated to Fixed income funds page afer clicking on Fixed income tile on Post Home Page");
		 fixedIncomeFundsPage.goBack();
		 CustomAssertion.assertEquals(postHomePage.getTitle(), "Wellington Management Funds — About", "Not navigated to post attested home page");
		 postHomePage.pauseExecutionFor(1000);
		 equityFundsPage= postHomePage.clickOnEquityTile();
		 CustomAssertion.softAssertEquals(equityFundsPage.getTitle(), "Wellington Management Funds – Equity", "User is not navigated to Equity funds page afer clicking on Equity tile on Post Home Page");
		 equityFundsPage.goBack();
		 CustomAssertion.assertEquals(postHomePage.getTitle(), "Wellington Management Funds — About", "Not navigated to post attested home page");
		 postHomePage.pauseExecutionFor(1000);
		 multiAssetsFundsPage =postHomePage.clickOnmultiAssetTile();
		 CustomAssertion.assertTrue(multiAssetsFundsPage.getTitle().startsWith("Multi-Asset"),  "User is not navigated to Multi Asset page after clicking on Multi asset tile on post Home Page");
		 multiAssetsFundsPage.goBack();
		 CustomAssertion.assertEquals(postHomePage.getTitle(), "Wellington Management Funds — About", "Not navigated to post attested home page");
		 alternativeFundsPage= postHomePage.clickOnalternativeTile();
		 CustomAssertion.assertTrue(alternativeFundsPage.getTitle().endsWith("Alternatives funds"),  "User is not navigated to Alternative Fund page after cliking on Alternative tile on post home Page");
		 alternativeFundsPage.goBack();
		 CustomAssertion.assertEquals(postHomePage.getTitle(), "Wellington Management Funds — About", "Not navigated to post attested home page");
   }
   
@Test(groups={"PostHomePage"},description="Verify the navigation on clicking on Explore fund link", enabled=true)
   public void verifyClickOnExploreFundLink() throws NotCurrentPageException
   {
	   loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 capabilityPage= postHomePage.clickOnexploreFundsLink();
		 CustomAssertion.assertEquals(capabilityPage.getTitle(), "Wellington Management Funds capabilities", "User is not navigated to Capability Page");
		 capabilityPage.goBack();
		 CustomAssertion.assertEquals(postHomePage.getTitle(), "Wellington Management Funds — About", "Not navigated to post attested home page");
	   
   }
   
@Test(groups={"PostHomePage"},description="Verify the navigation on clicking on linl View all funds", enabled=true)
   public void verify_Click_On_ViewAllFund_Link() throws NotCurrentPageException
   {
	   loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 fundsLanding= postHomePage.clickOnviewAllFunds();
		 CustomAssertion.assertEquals(fundsLanding.getTitle(), "Wellington Management Funds list", "User is not navigated to Funds landing page after clicking on VIEW ALL Funds link on postHomePage");
		 fundsLanding.goBack();
		 CustomAssertion.assertEquals(postHomePage.getTitle(), "Wellington Management Funds — About", "Not navigated to post attested home page");
	   
   }
   
@Test(groups={"PostHomePage"},description="Verify the navigation on clicking on link Read more Insights", enabled=true)
   public void verify_Click_On_ReadMoreInsight_Link() throws NotCurrentPageException
   {
	   loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 allInsightPage= postHomePage.clickOnexploreInsight();
	    CustomAssertion.assertTrue(allInsightPage.getCurrentURL().endsWith("all-insights/"), "User is not navigated to allInsightPage page after clicking on View All Insight link");
	     allInsightPage.goBack();
		 CustomAssertion.assertEquals(postHomePage.getTitle(), "Wellington Management Funds — About", "Not navigated to post attested home page");   
   }
   
@Test(groups={"PostHomePage"},description="Verify the navigation on clicking on link Office location", enabled=true)
   public void verify_Click_On_OfficeLocation_Link() throws NotCurrentPageException
   {
	   loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 contactUs= postHomePage.clickOnofficeLocationLink();
		 contactUs.pauseExecutionFor(1000);
		 CustomAssertion.assertEquals(contactUs.getTitle(), "Wellington Management Funds — Locations", "User is  not navigated to Location page after clicking on Contact Us link on postHomePage");
		 //CustomAssertion.assertEquals(contactUs.getBackgroundClourofLocalContact(), "rgba(28, 53, 94, 1)", "By default Local Contact tab is not highligted");
		 contactUs.goBack();
		 CustomAssertion.assertEquals(postHomePage.getTitle(), "Wellington Management Funds — About", "Not navigated to post attested home page");   
   }
   
@Test(groups={"PostHomePage"},description="Verify the navigation on clicking on link Request Information", enabled=true)
   public void verify_Click_On_RequestInformation_Link() throws NotCurrentPageException
   {
	   loginPage = new LoginPage(driver);
		 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
		 contactUs= postHomePage.clickOnrequestInformationLink();
		 CustomAssertion.assertEquals(contactUs.getTitle(), "Wellington Management Funds — Contact us", "User is  not navigated to contactUs page after clicking on Contact Us link on postHomePage");
		 //CustomAssertion.assertEquals(contactUs.getBackgroundClourofSubmitRequest(), "rgba(28, 53, 94, 1)", "Request Information tab is not highligted");
		 //CustomAssertion.assertEquals(contactUs.getBackgroundClourofLocalContact(), "rgba(0, 0, 0, 0)", "Local Contact tab is also highligted");
		 contactUs.goBack();
		 CustomAssertion.assertEquals(postHomePage.getTitle(), "Wellington Management Funds — About", "Not navigated to post attested home page");   
   }

@DataProvider(name = "test1")
public static Object[][] primeNumbers() {
   return new Object[][] {{"Sanjay", "Vijay"}};
}

@Test(dataProvider = "test1")
public void tryTest(String inputNumber, String expectedResult)
{
	System.out.println(inputNumber + " " + expectedResult);
    CustomAssertion.assertEquals(inputNumber, expectedResult,"Not match");
    		
}
@Test
public void tryTest2()
{
    CustomAssertion.assertEquals("Sanjay", "Sanjay","Not match");
    		
}

   
}
