/**
 * 
 */
package com.sapient.webpage;

import org.openqa.selenium.WebDriver;

import com.sapient.webelements.ImageElement;
import com.sapient.webelements.LabelElement;
import com.sapient.webelements.LinkElement;

/**
 * @author ssi248
 *
 */
public class FundsLandingPage extends WebBasePage {
	
private static final ImageElement logo = new ImageElement("Wellington logo", parser.getLocator("HomePage_logo"));
private static LabelElement fundsAtGlanceLink = new LabelElement("Funds at a glance link", parser.getLocator("fund_at_glance"));
private static LabelElement fundPricingLink = new LabelElement("Funds Pricing link", parser.getLocator("fund_pricing"));
private static LabelElement fundPerformanceLink = new LabelElement("Funds Performance link", parser.getLocator("fund_performance"));
private static LabelElement fixedIncomeFundLink = new LabelElement("Fixed income fund link on Funds Page", parser.getLocator("fixedIncomeFunds"));
private static LabelElement equityfundsLink = new LabelElement("Equity funds link on Funds Page", parser.getLocator("equityfunds"));
private static LabelElement multiassetFundLink = new LabelElement("Multiasset Fund link on Funds Page", parser.getLocator("multiassetFund"));
private static LabelElement alternativeFundsLink = new LabelElement("Alternative Funds link on Funds Page", parser.getLocator("alternativeFunds"));
private static LabelElement learnMoreLink = new LabelElement("LearnMore link on Funds Page", parser.getLocator("learnMore"));
private static LabelElement enquiresLink = new LabelElement("Enquires link on Funds Page", parser.getLocator("enquires"));
protected static final LabelElement FundsPagefootNoteAndDisclosure = new LabelElement("FootNote &DEsclosure", parser.getLocator("fundPageDisclosureAndFootNotes"));
protected static final LabelElement FundPagefootNoteAndDisclosureText = new LabelElement("FootNote &DEsclosure", parser.getLocator("fundDisclosureAndFootnoteText"));
private static final LinkElement fixedIncomeTile = new LinkElement("Fixed income tile under capability on Fund page",parser.getLocator("FixedIncomeTile"));
private static final LinkElement equityTile = new LinkElement("Equity tile under capability on Fund page",parser.getLocator("EquityTile"));
private static final LinkElement multiAssetTile = new LinkElement("Multi AssetTile tile under capability on Fund page",parser.getLocator("MultiAssetTile"));
private static final LinkElement alternativeTile = new LinkElement("Alternative Tile tile under capability on Fund page",parser.getLocator("AlternativeTile"));
private static final LinkElement exploreFundsLink = new LinkElement("Explore Funds link under capability on Fund page",parser.getLocator("exploreFunds"));
private static final LinkElement viewAllFunds = new LinkElement("ViewAll Funds link under focus fund on Fund page",parser.getLocator("viewAllFundLinkOnFundsLanding"));


	
	public FundsLandingPage(WebDriver driver) {
		super(driver,"FundsLandingPage");
		
	}
	
	public String getTextOfFundsAtGalanceLink()
	{
		mouseHover(fundLink);
		waitForElementPresent(fundsAtGlanceLink);
		return fundsAtGlanceLink.getText();
		
	}
	
	public FundExplorerPage clickOnFundsAtGalanceLink()
	{
		mouseHoverAndClick(fundLink, fundsAtGlanceLink);
		pauseExecutionFor(2000);
		return new FundExplorerPage(driver);
	}
	
	public String getTextOffundPerformanceLink()
	{
		return fundPerformanceLink.getText();
		
	}
	
	public FundExplorerPage clickOnfundPerformanceLink()
	{
		mouseHoverAndClick(fundLink,fundPerformanceLink);
		pauseExecutionFor(2000);
		return new FundExplorerPage(driver);
	}
	
	public String getTextOffundPricingLink()
	{
		mouseHover(fundLink);
		return fundPricingLink.getText();
		
	}
	
	public FundExplorerPage clickOnfundPricingLink()
	{
		mouseHoverAndClick(fundLink,fundPricingLink);
		pauseExecutionFor(2000);
		return new FundExplorerPage(driver);
	}

	public String getTextOffixedIncomeFundLink()
	{
		mouseHover(fundLink);
		return fixedIncomeFundLink.getText();
		
	}
	
	public FixedIncomeFundsPage clickOnfixedIncomeFundLink()
	{
		mouseHoverAndClick(fundLink,fixedIncomeFundLink);
		pauseExecutionFor(2000);
		return new FixedIncomeFundsPage(driver);
	}
	
	public String getTextOfequityfundsLink()
	{
		mouseHover(fundLink);
		return equityfundsLink.getText();
		
	}
	
	public EquityFundsPage clickOnequityfundsLink()
	{
		mouseHoverAndClick(fundLink,equityfundsLink);
		pauseExecutionFor(2000);
		return new EquityFundsPage(driver);
	}
	
	public String getTextOfmultiassetFundLink()
	{
		mouseHover(fundLink);
		return multiassetFundLink.getText();
		
	}
	
	public MultiAssetsFundsPage clickOnmultiassetFundLink()
	{
		mouseHoverAndClick(fundLink,multiassetFundLink);
		pauseExecutionFor(2000);
		return new MultiAssetsFundsPage(driver);
	}
	
	
	public String getTextOfalternativeFundsLink()
	{
		
		return alternativeFundsLink.getText();
		
	}
	
	public AlternativeFundsPage clickOnalternativeFundsLink()
	{
		mouseHoverAndClick(fundLink,alternativeFundsLink);
		pauseExecutionFor(2000);
		return new AlternativeFundsPage(driver);
	}
	
	public String getTextOflearnMoreLink()
	{
		
		return learnMoreLink.getText();
		
	}
	
	public FundExplorerPage clickOnlearnMoreLink()
	{
		mouseHoverAndClick(fundLink,learnMoreLink);
		pauseExecutionFor(2000);
		return new FundExplorerPage(driver);
	}
	
	public String getTextOfenquiresLink()
	{
		
		return enquiresLink.getText();
		
	}
	
	public FundExplorerPage clickOnenquiresLink()
	{
		mouseHoverAndClick(fundLink,enquiresLink);
		pauseExecutionFor(2000);
		return new FundExplorerPage(driver);
	}
	
	 public boolean isFootNoteAndDisclosureDisplayed()
	 {
		 return FundsPagefootNoteAndDisclosure.isDisplayed();
	 }
	 
	 public String getFootNoteAndDisclosureText()
	 {
		 return FundsPagefootNoteAndDisclosure.getText();
	 }
	 
	 public boolean isFootNoteAndDisclosureTextDisplayed()
	 {
		 return FundPagefootNoteAndDisclosureText.isDisplayed();
	 }
	 
	 public String getfootNoteAndDisclosurediscriptionText()
	 {
		 return FundPagefootNoteAndDisclosureText.getText();
	 }
	 
	 public FixedIncomeFundsPage clickOnFixedIncomeTile()
	 
	 {
		 waitForElementPresent(fixedIncomeTile);
		 pauseExecutionFor(2000);
		 //fixedIncomeTile.click();
		 clickByJavaScript(fixedIncomeTile);
		 return new FixedIncomeFundsPage(driver);
	 }
		
	public EquityFundsPage clickOnEquityTile()
	 {
		 waitForElementPresent(equityTile);
		 clickByJavaScript(equityTile);
		 pauseExecutionFor(1000);
		 return new EquityFundsPage(driver);
	 }

	public MultiAssetsFundsPage clickOnmultiAssetTile()

	{
		 waitForElementPresent(multiAssetTile);
		 clickByJavaScript(multiAssetTile);
		 pauseExecutionFor(1000);
		 return new MultiAssetsFundsPage(driver);
	}

	public AlternativeFundsPage clickOnalternativeTile()

	{
		 waitForElementPresent(alternativeTile);
		 clickByJavaScript(alternativeTile);
		 pauseExecutionFor(1000);
		 return new AlternativeFundsPage(driver);
	}
	
	public FundExplorerPage clickOnviewAllFunds()
	{
		 clickByJavaScript(parser.getLocator("viewAllFundLinkOnFundsLanding"));
		 pauseExecutionFor(1000);
		return new FundExplorerPage(driver);
	}
	
	

}
