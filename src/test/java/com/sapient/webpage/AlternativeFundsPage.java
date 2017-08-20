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
public class AlternativeFundsPage extends WebBasePage {
	
	private static final LabelElement viewallAlternativeFunds = new LabelElement("View all equity funds link",parser.getLocator("ViewAllAlternativeFund"));
	private static final LabelElement exploreallInsights = new LabelElement("View all Insights link",parser.getLocator("alternativeExploreInsight"));


	/**
	 * @param driver
	 * @param pagename
	 */
	public AlternativeFundsPage(WebDriver driver) {
		super(driver, "AlternativeFundsPage");
		// TODO Auto-generated constructor stub
	}
	
	public FundExplorerPage clikOnviewallAlternativeFundsLink()
	{
		waitForElementPresent(viewallAlternativeFunds);
		//viewallFixedIncomeFunds.click();
		clickByJavaScript(viewallAlternativeFunds);
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
