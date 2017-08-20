/**
 * 
 */
package com.sapient.webpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sapient.webelements.ImageElement;
import com.sapient.webelements.LabelElement;

/**
 * @author ssi248
 *
 */
public class InsightLandingPage extends WebBasePage {
	
	private static final ImageElement logo = new ImageElement("Wellington logo", parser.getLocator("HomePage_logo"));
	
	private static final LabelElement viewAllInsighitsLink = new LabelElement("View All Insights link under flyout", parser.getLocator("viewAllInsighits"));
	private static final LabelElement viewOurProspectiveLink = new LabelElement("View Our Prospective link under flyout", parser.getLocator("viewOurProspective"));
	private static final LabelElement readArticleLink = new LabelElement("Read Article link under flyout", parser.getLocator("readArticle"));
	private static final LabelElement exoloreInsightsLink = new LabelElement("Exolore Insights link on banner", parser.getLocator("exoloreInsights"));
	private static final LabelElement viewAllInsightsLink = new LabelElement("View AllInsights link", parser.getLocator("viewAllInsights"));
	
	
	
	public InsightLandingPage(WebDriver driver)  {
		super(driver,"InsightLandingPage");
		// TODO Auto-generated constructor stub
	}
	
	
	public InsightAutherBioPage clickOnReadArticleLink()
	{
		mouseHoverAndClick(insightsLink, readArticleLink);
		return new InsightAutherBioPage(driver);
	}
	
	public AllInsightPage clickOnViewAllInsights()
	{
		mouseHoverAndClick(insightsLink, viewAllInsighitsLink);
		
		return new AllInsightPage(driver);
	}
	
	public AllInsightPage clickOnViewOurProspectiveLink()
	{
		mouseHoverAndClick(insightsLink, viewOurProspectiveLink);
		
		return new AllInsightPage(driver);
	}
	
	public AllInsightPage clickOnexoloreInsightsLink()
	{
		waitForElementPresent(exoloreInsightsLink);
		exoloreInsightsLink.click();
		return new AllInsightPage(driver);
	}
	
	public AllInsightPage clickOnviewAllInsightsLink()
	{
		waitForElementPresent(viewAllInsightsLink);
		clickByJavaScript(viewAllInsightsLink);
		return new AllInsightPage(driver);
	}
	

}
