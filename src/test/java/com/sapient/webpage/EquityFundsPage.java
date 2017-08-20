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
public class EquityFundsPage extends WebBasePage {
	
	private static final LabelElement viewallEquityFunds = new LabelElement("View all equity funds link",parser.getLocator("ViewAllEquityFunds"));
	private static final LabelElement exploreallInsights = new LabelElement("View all Insights link",parser.getLocator("ExploreInsights"));

	/**
	 * @param driver
	 * @param pagename
	 */
	public EquityFundsPage(WebDriver driver) {
		super(driver, "EquityFundsPage");
		// TODO Auto-generated constructor stub
	}
	
	public FundExplorerPage clikOnviewallEquityFundsLink()
	{
		waitForElementPresent(viewallEquityFunds);
		//viewallFixedIncomeFunds.click();
		clickByJavaScript(viewallEquityFunds);
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
