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
public class EquityFundsPageTest extends SeleniumTestPlan {
	
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
	 
	 @Test
		public void verifyClickOnViewAllFixedIncomeFundLink() throws NotCurrentPageException
		{
			loginPage = new LoginPage(driver);
			 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
			 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
			 fundsLanding = postHomePage.clickOnFundsLink();
			 equityFundsPage = fundsLanding.clickOnequityfundsLink();
			 CustomAssertion.assertEquals(equityFundsPage.getTitle(),"Wellington Management Funds – Equity",  "User is not navigated to Equity funds page after clicking on Equity fund link");
			 fundExplorer= equityFundsPage.clikOnviewallEquityFundsLink();
			 CustomAssertion.assertTrue(fundExplorer.getTitle().startsWith("Fund explorer"),  "User is not navigated to Fund explorer page after cliking on View all fixed income funds on Fixed income page");	
		}
		
		@Test(enabled=true)
		public void verifyClickOnExploreInsightLink() throws NotCurrentPageException
		{
			loginPage = new LoginPage(driver);
			 homePage = loginPage.enterLoginData(SeleniumTestsContextManager.getUserName(),SeleniumTestsContextManager.getPassword());
			 postHomePage =  homePage.clickOnVisistSite().clickOnSelectCountryLink().selectRegion().selectCountry().selectClintType().acceptDeclaimer();
			 fundsLanding = postHomePage.clickOnFundsLink();
			 equityFundsPage = fundsLanding.clickOnequityfundsLink();
			 CustomAssertion.assertEquals(equityFundsPage.getTitle(),"Wellington Management Funds – Equity",  "User is not navigated to Equity funds page after clicking on Equity fund link");
			 allInsightPage= equityFundsPage.clikOnexploreallInsightsLink();
			 CustomAssertion.assertTrue(allInsightPage.getCurrentURL().endsWith("all-insights/"), "User is not navigated to allInsightPage page after clicking on View All Insight link");
		}


}
