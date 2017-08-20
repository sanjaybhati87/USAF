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
public class FixedIncomeFundsPage extends WebBasePage {
	
	private static final LabelElement viewallFixedIncomeFunds = new LabelElement("View all fixed income funds link",parser.getLocator("ViewAllFixedIncomeFunds"));
	private static final LabelElement exploreallInsights = new LabelElement("View all Insights link",parser.getLocator("ExploreInsights"));
	/**
	 * @param driver
	 * @param pagename
	 */
	public FixedIncomeFundsPage(WebDriver driver) {
		super(driver, "FixedIncomeFundsPage");
		// TODO Auto-generated constructor stub
	}
	
	public FundExplorerPage clikOnviewallFixedIncomeFundsLink()
	{
		waitForElementPresent(viewallFixedIncomeFunds);
		//viewallFixedIncomeFunds.click();
		clickByJavaScript(viewallFixedIncomeFunds);
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
