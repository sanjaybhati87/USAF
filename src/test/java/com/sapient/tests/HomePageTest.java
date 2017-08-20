/**
 * 
 */
package com.sapient.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sapient.core.CustomAssertion;
import com.sapient.core.SeleniumTestPlan;
import com.sapient.core.SeleniumTestsContextManager;
import com.sapient.core.TestLogging;
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
public class HomePageTest extends SeleniumTestPlan {
	
	 private static Logger logger = TestLogging.getLogger(HomePageTest.class);
	 String[] layoutTags ={"desktop"};
	 HomePage homePage;
	 LoginPage loginPage;
	 FundsLandingPage fundsLanding;
	 CapabilityPage capability;
	 HomePostAttestationPage postHome;
	 InsightLandingPage insights;
	 LiteraturePage litrature;
	 ContactUsPage contactUs;
	 CookiePolicyPage cokkiePolicy;
	 PrivacyPolicy privacyPlocy;
	 TermsPage termsPage;
	 
	
	 
	
	 
	 @Test(groups={"PreHomePage","UiTest"},description="Verify the UI of Pre attested Home Page")
	 public void verifyUIOfpreHomePage() 
	 {
		 loginPage = new LoginPage(driver);
		homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 homePage = new HomePage(driver);
		 homePage.clickOnVisistSite();
	 	CustomAssertion.assertTrue(homePage.testPageLayout(layoutTags), "[Assert Fail]:Pixel are not correct");
	 	
	 }
	 
	 @Test(groups={"PreHomePage","CommonValidations"},description="Verify the header and footer on pre attested home Page")
	 public void VerifytheGloablaHeaderAndFooter() throws Exception
	 {
		 //loginPage = new LoginPage(driver);
		 //homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 homePage = new HomePage(driver);
		 homePage.clickOnVisistSite();
		 Assert.assertEquals(homePage.getTitle(),"Homepage - Wellington Management Funds Landing","Not navigated to pre home Page after login");
		 CustomAssertion.assertTrue(homePage.isWellingtonLogoDisplayed(), "Wellington logo is not displayed on home page");
		 CustomAssertion.assertTrue(homePage.isFundsLinkDisplayedOnHeader(),"Funds link is not displayed on gloabl header");
		 CustomAssertion.assertTrue(homePage.isCapabilitiesLinkDisplayedOnHeader(), "Capability link is not diaplayed on home page");
		 CustomAssertion.assertEquals(homePage.getTextOfFundsLink(), "FUNDS", "Funds text is not displayed as FUNDS");
		 fundsLanding=homePage.clickOnFundsLink();
		 CustomAssertion.assertEquals(fundsLanding.getTitle(), "Homepage - Wellington Management Funds Landing", "User is  navigated to Funds landing page without selecting the country and region");
		 homePage.clickOnWellingtonLogo();
		 CustomAssertion.assertEquals(homePage.getTitle(), "Homepage - Wellington Management Funds Landing", "User is not navigated to Home page after clicking on Wellington logo");
		 CustomAssertion.assertTrue(homePage.isCapabilitiesLinkDisplayedOnHeader(), "Capability link is not displayed on home Page");
		 CustomAssertion.assertEquals(homePage.getTextOfCapabilitiesLink(), "CAPABILITIES", "Capability text is not as CAPABILITIES ");
		 capability = homePage.clickOnCapabilitiesLink();
		 CustomAssertion.assertEquals(capability.getTitle(), "Homepage - Wellington Management Funds Landing", "User is  navigated to Capability landing page without selecting the country and region");
		 homePage.clickOnWellingtonLogo();
		 CustomAssertion.assertEquals(homePage.getTitle(), "Homepage - Wellington Management Funds Landing", "User is not navigated to Home page after clicking on Wellington logo");
		 CustomAssertion.assertTrue(homePage.isInsightsLinkDisplayedOnHeader(), "Insights link is not displayed on the Page");
		 CustomAssertion.assertEquals(homePage.getTextOfInsightsLink(), "INSIGHTS", "Insights text is not displayed INSIGHTS");
		 insights = homePage.clickOnInsightsLink();
		 CustomAssertion.assertEquals(insights.getTitle(), "Homepage - Wellington Management Funds Landing", "User is  navigated to Capability landing page without selecting the country and region");
		 homePage.clickOnWellingtonLogo();
		 CustomAssertion.assertEquals(homePage.getTitle(), "Homepage - Wellington Management Funds Landing", "User is not navigated to Home page after clicking on Wellington logo");
		 CustomAssertion.assertTrue(homePage.isLitratureLinkDisplayedOnHeader(), "Litrature link is not displayed on the Page");
		 CustomAssertion.assertEquals(homePage.getTextOfLitratureLink(), "LITERATURE", "Litrature text is not displayed LITRATURE");
		 litrature = homePage.clickOnLitratureLink();
		 CustomAssertion.assertEquals(litrature.getTitle(), "Homepage - Wellington Management Funds Landing", "User is  navigated to Litrature landing page without selecting the country and region");
		 homePage.clickOnWellingtonLogo();
		 CustomAssertion.assertEquals(homePage.getTitle(), "Homepage - Wellington Management Funds Landing", "User is not navigated to Home page after clicking on Wellington logo");
		 CustomAssertion.assertTrue(homePage.iscontactUsLinkDisplayedOnHeader(), "ContactUs link is not displayed on the Page");
		 CustomAssertion.assertEquals(homePage.getTextOfcontactUsLink(), "CONTACT", "Contact text is not displayed Contact");
		 contactUs = homePage.clickOncontactUsLink();
		 CustomAssertion.assertEquals(contactUs.getTitle(), "Homepage - Wellington Management Funds Landing", "User is  navigated to contactUs page without selecting the country and region");
		 homePage.clickOnWellingtonLogo();
		 CustomAssertion.assertEquals(homePage.getTitle(), "Homepage - Wellington Management Funds Landing", "User is not navigated to Home page after clicking on Wellington logo");
		 CustomAssertion.assertTrue(homePage.isSearchIconDisplayed(), "Search icon is not displayed");
		 CustomAssertion.assertFalse(homePage.ClickOnSearchIcon(), "Enter button is  displayed after clicking on Search icon on pre home Page");
		 homePage.clickOnWellingtonLogo();
		 CustomAssertion.assertEquals(homePage.getTitle(), "Homepage - Wellington Management Funds Landing", "User is not navigated to Home page after clicking on Wellington logo");
		 CustomAssertion.assertTrue(homePage.isFootNoteAndDisclosureDisplayed(), "FootNote and Disclosure is not displayed");
		 CustomAssertion.assertEquals(homePage.getFootNoteAndDisclosureText(), "DISCLOSURES & FOOTNOTES", "Footnote and disclosure heading is not match");
		 CustomAssertion.assertTrue(homePage.isFootNoteAndDisclosureTextDisplayed(), "Footnote and disclosure text is not displayed");
		 CustomAssertion.assertEquals(homePage.getfootNoteAndDisclosurediscriptionText(), homePage.disclosureandFootnoteDiscription,  "Footnote and Disclosure discription is not correct");
		 CustomAssertion.assertTrue(homePage.isTextAboveFooterDisplayed(), "Text above footer note isnot displayed");
		 CustomAssertion.assertEquals(homePage.getTextAboveFooter(), homePage.textAboveFooter, "Text above footer is incorrect");
		 CustomAssertion.assertTrue(homePage.isCookiePolicyLinkDisplayed(), "Cookie policy link is not dispalyed in footer");
		 CustomAssertion.assertEquals(homePage.getCookiePolicyLinkText().toLowerCase(), "Cookie policy".toLowerCase(), "Incorrect cookie policy link tecxt");
		 cokkiePolicy = homePage.clickOnCookiePolicyLink();
		 CustomAssertion.assertTrue(cokkiePolicy.isBannerTextDisplayed(), "Banner text is not displayed on Cokie page");
		 homePage.goBack();
		 CustomAssertion.assertEquals(homePage.getTitle(), "Homepage - Wellington Management Funds Landing", "User is not navigated to Home page after clicking on Wellington logo");
	
		
		 
	 }
	 
	 @Test(description="Verify that click on fund offering options, system will not navigate inside the system on pre hoem Page",groups={"PreHomePage"})
	   public void verifyTheClickOnTilesOnFundOfferingSection() throws NotCurrentPageException
	   {
		        //loginPage = new LoginPage(driver);
		        //homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
		 homePage = new HomePage(driver);
		        homePage.clickOnVisistSite();
		      Assert.assertEquals(homePage.getTitle(),"Homepage - Wellington Management Funds Landing","User is navigated inside the system without selecting the region and country");
			 homePage.clickOnFixedIncomeTile();
			 Assert.assertEquals(homePage.getTitle(),"Homepage - Wellington Management Funds Landing","User is navigated inside the system without selecting the region and country");
			 homePage.clickOnEquityTile();
			 Assert.assertEquals(homePage.getTitle(),"Homepage - Wellington Management Funds Landing","User is navigated inside the system without selecting the region and country");
			 homePage.clickOnmultiAssetTile();
			 Assert.assertEquals(homePage.getTitle(),"Homepage - Wellington Management Funds Landing","User is navigated inside the system without selecting the region and country");
			 homePage.clickOnalternativeTile();
			 Assert.assertEquals(homePage.getTitle(),"Homepage - Wellington Management Funds Landing","User is navigated inside the system without selecting the region and country");
			
	   }
	 
	
}
