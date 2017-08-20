/**
 * 
 */
package com.sapient.webpage;

import org.openqa.selenium.WebDriver;

import com.sapient.webelements.LabelElement;
import com.sapient.webelements.LinkElement;



/**
 * @author ssi248
 *
 */
public class HomePostAttestationPage extends WebBasePage {
	
	private static final LinkElement fixedIncomeTile = new LinkElement("Fixed income tile under capability on home page",parser.getLocator("FixedIncomeTile"));
	private static final LinkElement equityTile = new LinkElement("Equity tile under capability on home page",parser.getLocator("EquityTile"));
	private static final LinkElement multiAssetTile = new LinkElement("Multi AssetTile tile under capability on home page",parser.getLocator("MultiAssetTile"));
	private static final LinkElement alternativeTile = new LinkElement("Alternative Tile tile under capability on home page",parser.getLocator("AlternativeTile"));
	private static final LinkElement exploreFundsLink = new LinkElement("Explore Funds link under capability on home page",parser.getLocator("exploreFunds"));
	private static final LinkElement viewAllFunds = new LinkElement("ViewAll Funds link under focus fund on home page",parser.getLocator("viewAllFunds"));
	private static final LinkElement exploreInsightOnHomePage = new LinkElement("Explore Insight under Insight on home page",parser.getLocator("readMoreInsightOnHomePage"));
	private static final LinkElement emailUs = new LinkElement("Email Us link on home page",parser.getLocator("emailUs"));
	private static final LinkElement officeLocation = new LinkElement("Office Location link on home page",parser.getLocator("post_officeLocation"));
	private static final LinkElement requestInformation = new LinkElement("Request Information link on home page",parser.getLocator("requestInformation"));
	private static final LabelElement ShareInsight = new LabelElement("Shared Insight text on banner", parser.getLocator("ShareInsight"));
	private static final LabelElement WhyWilington = new LabelElement("Why wilington Managment text on banner", parser.getLocator("WhyWilington"));
	private static final LabelElement willingtonStragicFunds = new LabelElement("Wellington strgic european fund text on banner", parser.getLocator("willingtonStragicFunds"));
	private static final LabelElement rightArrow = new LabelElement("Shared Insight text on banner", parser.getLocator("rightArrow"));
	private static final LabelElement InsightLink = new LabelElement("Insight Link on banner", parser.getLocator("InsightLink"));
	
	

	
	public HomePostAttestationPage(WebDriver driver)  {
		super(driver,"HomePostAttestationPage");
		
	}
	
 public FixedIncomeFundsPage clickOnFixedIncomeTile()
 
 {
	 waitForElementPresent(fixedIncomeTile);
	 pauseExecutionFor(10000);
	 //fixedIncomeTile.click();
	 clickByJavaScript(fixedIncomeTile);
	 pauseExecutionFor(10000);
	 return new FixedIncomeFundsPage(driver);
 }
	
public EquityFundsPage clickOnEquityTile()
 
 {
	 waitForElementPresent(equityTile);
	// equityTile.click();
	 clickByJavaScript(equityTile);
	 pauseExecutionFor(10000);
	 return new EquityFundsPage(driver);
 }

public MultiAssetsFundsPage clickOnmultiAssetTile()

{
	 waitForElementPresent(multiAssetTile);
	// multiAssetTile.click();
	 clickByJavaScript(multiAssetTile);
	 pauseExecutionFor(10000);
	 return new MultiAssetsFundsPage(driver);
}

public AlternativeFundsPage clickOnalternativeTile()

{
	 waitForElementPresent(alternativeTile);
	 pauseExecutionFor(10000);
	 clickByJavaScript(alternativeTile);
	 pauseExecutionFor(10000);
	 return new AlternativeFundsPage(driver);
}
 public CapabilityPage clickOnexploreFundsLink()
 {
	 waitForElementPresent(exploreFundsLink);
	 pauseExecutionFor(10000);
	 //exploreFundsLink.click();
	 clickByJavaScript(parser.getLocator("exploreFunds"));
	return new CapabilityPage(driver);
 }
 
 public FundsLandingPage clickOnviewAllFunds()
 {
	 waitForElementPresent(viewAllFunds);
	 //viewAllFunds.click();
	 clickByJavaScript(parser.getLocator("viewAllFunds"));
	return new FundsLandingPage(driver);
	
 }
 
 public AllInsightPage clickOnexploreInsight()
 {
	 waitForElementPresent(exploreInsightOnHomePage);
	 //scrollToElement(parser.getLocator("readMoreInsightOnHomePage"));
	 //exploreInsightOnHomePage.click();
	 clickByJavaScript(parser.getLocator("readMoreInsightOnHomePage"));
	return new AllInsightPage(driver);
	
 }
 
 
 public ContactUsPage clickOnofficeLocationLink()
 {
	 waitForElementPresent(officeLocation);
	 pauseExecutionFor(1000);
	 clickByJavaScript(officeLocation);
	 pauseExecutionFor(1000);
	 return new ContactUsPage(driver);
 }

 public ContactUsPage clickOnrequestInformationLink()
 {
	 waitForElementPresent(requestInformation);
	 //requestInformation.click();
	 clickByJavaScript(parser.getLocator("requestInformation"));
	 return new ContactUsPage(driver);
 }
 
 public void clickOn_Shared_Insight_InsightLink()
 {
	 System.out.println(ShareInsight.isDisplayed());
	 while(ShareInsight.isDisplayed()==false);
	 {
		 rightArrow.click();
		 System.out.println("***********Click on Right arrow********************");
	 }
	 
	 InsightLink.click();
 }

}
