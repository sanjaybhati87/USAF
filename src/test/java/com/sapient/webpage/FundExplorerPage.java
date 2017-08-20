/**
 * 
 */
package com.sapient.webpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sapient.core.SeleniumTestsContextManager;
import com.sapient.webelements.ImageElement;
import com.sapient.webelements.LinkElement;
import com.sapient.webelements.PageObject;

/**
 * @author ssi248
 *
 */
public class FundExplorerPage extends WebBasePage  {
	
private static final LinkElement asiaExJapanEquityFundLink = new LinkElement("Click on Asia ex Japan Equity Fund", parser.getLocator("asiaExJapanEquityFund"));
private static final LinkElement dropdownLink = new LinkElement("DropDowwn Link", parser.getLocator("dropDownArrow"));
private static final LinkElement EquityFundOption = new LinkElement("Equity Fund option from drop down", parser.getLocator("exuityOption"));
	
	public FundExplorerPage(WebDriver driver)  {
		super(driver,"FundDetailsPage");
		// TODO Auto-generated constructor stub
	}
	
	public FundDetailsPage  clickOnasiaExJapanEquityFund()
	{
		waitForElementPresent(asiaExJapanEquityFundLink);
		pauseExecutionFor(10000);
		clickByJavaScript(asiaExJapanEquityFundLink);
		return new FundDetailsPage(driver);
	}
	
	public FundDetailsPage ClickOnEquityFund()
	{
		waitForElementPresent(dropdownLink);
		clickByJavaScript(dropdownLink);
		//dropdownLink.click();
		pauseExecutionFor(1000);
		waitForElementPresent(EquityFundOption);
		clickByJavaScript(EquityFundOption);
		//EquityFundOption.click();
		pauseExecutionFor(3000);
		clickByJavaScript(asiaExJapanEquityFundLink);
		return new FundDetailsPage(driver);
		
	}

}
