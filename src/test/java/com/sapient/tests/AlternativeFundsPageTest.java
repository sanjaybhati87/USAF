/**
 * 
 */
package com.sapient.tests;

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
public class AlternativeFundsPageTest extends SeleniumTestPlan {
	
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
	 
	 @Test(enabled=true)
		public void verifyClickOnViewAllAlternativeFundLink() throws NotCurrentPageException
		{
			loginPage = new LoginPage(driver);
			 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
			 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
			 fundsLanding = postHomePage.clickOnFundsLink();
			 alternativeFundsPage=fundsLanding.clickOnalternativeFundsLink();
			 CustomAssertion.assertTrue(alternativeFundsPage.getTitle().endsWith("Alternatives funds"),  "User is not navigated to Alternative Fund page after cliking on Alternative Fund link");
			 fundExplorer= alternativeFundsPage.clikOnviewallAlternativeFundsLink();
			 CustomAssertion.assertTrue(fundExplorer.getTitle().startsWith("Fund explorer"),  "User is not navigated to Fund explorer page after cliking on View all fixed income funds on Fixed income page");	
		}
		
		@Test(enabled=true)
		public void verifyClickOnExploreInsightLink() throws NotCurrentPageException
		{
			loginPage = new LoginPage(driver);
			 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
			 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
			 fundsLanding = postHomePage.clickOnFundsLink();
			 alternativeFundsPage=fundsLanding.clickOnalternativeFundsLink();
			 CustomAssertion.assertTrue(alternativeFundsPage.getTitle().endsWith("Alternatives funds"),  "User is not navigated to Alternative Fund page after cliking on Alternative Fund link");
			 allInsightPage= alternativeFundsPage.clikOnexploreallInsightsLink();
			 CustomAssertion.assertTrue(allInsightPage.getCurrentURL().endsWith("all-insights/"), "User is not navigated to allInsightPage page after clicking on View All Insight link");
		}



}
