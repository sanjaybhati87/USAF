/**
 * 
 */
package com.sapient.webpage;

import org.openqa.selenium.WebDriver;

import com.sapient.webelements.LabelElement;

/**
 * @author ssi248
 *
 */
public class MultiAssetsFundsPage extends WebBasePage {
	
	private static final LabelElement viewallAlMultiAssetFunds = new LabelElement("View all equity funds link",parser.getLocator("ViewAllMultiassetFundPage"));
	private static final LabelElement exploreallInsights = new LabelElement("View all Insights link",parser.getLocator("ExploreInsights"));


	/**
	 * @param driver
	 * @param pagename
	 */
	public MultiAssetsFundsPage(WebDriver driver) {
		super(driver, "MultiAssetsFundsPage");
		// TODO Auto-generated constructor stub
	}
	
	public FundExplorerPage clikOnviewallAllMultiAssetFundsLink()
	{
		waitForElementPresent(viewallAlMultiAssetFunds);
		//viewallFixedIncomeFunds.click();
		clickByJavaScript(viewallAlMultiAssetFunds);
		return new FundExplorerPage(driver);
	}
	
	public AllInsightPage clikOnexploreallInsightsLink()
	{
		waitForElementPresent(exploreallInsights);
		//exploreallInsights.click();
		clickByJavaScript(exploreallInsights);
		return new AllInsightPage(driver);
	}


}
