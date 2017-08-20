/**
 * 
 */
package com.sapient.webpage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sapient.webelements.ImageElement;
import com.sapient.webelements.LabelElement;
import com.sapient.webelements.LinkElement;

/**
 * @author ssi248
 *
 */
public class CapabilityPage extends WebBasePage  {
	
private static final LabelElement bannerText = new LabelElement("Text on Capability banner", parser.getLocator("capabilityBannerText"));
private static final LabelElement fixedIncomeFundLink = new LabelElement("Fixed income fund link on Capability Page", parser.getLocator("cap_fixedIncomeFunds"));
private static final  LabelElement equityfundsLink = new LabelElement("Equity funds link on Funds Page", parser.getLocator("cap_equityfunds"));
private static final LabelElement multiassetFundLink = new LabelElement("Multiasset Fund link on Capability Page", parser.getLocator("cap_multiassetFund"));
private static final  LabelElement alternativeFundsLink = new LabelElement("Alternative Funds link on Capability Page", parser.getLocator("cap_alternativeFunds"));
private static final LabelElement learnMoreLink = new LabelElement("LearnMore link on Capability Page", parser.getLocator("learnMore"));
private static  final LabelElement enquiresLink = new LabelElement("Enquires link on Capability Page", parser.getLocator("enquires"));
private static final LinkElement OurFixedIncomeCapability = new LinkElement("Our Fixed Income Capability Link", parser.getLocator("OurFixedIncomeComp"));
private static final LinkElement OurEquityCapability = new LinkElement("Our Equity Capability", parser.getLocator("OurEquityCapability"));
private static final LinkElement OurAlternativeCapability = new LinkElement("Our Alternative Capability", parser.getLocator("OurAlternativeCapability"));
private static final LinkElement OurMultiassetCapability = new LinkElement("Our Multiasset Capability", parser.getLocator("OurMultiassetCapability"));
	
	public CapabilityPage(WebDriver driver) {
		super(driver,"CapabilityPage");
		// TODO Auto-generated constructor stub
	}
	
	
	public String getTextOffixedIncomeFundLink()
	{
		waitForElementPresent(capabilitiesLink);
		mouseHover(capabilitiesLink);
		return fixedIncomeFundLink.getText();
		
	}
	
	public FixedIncomeFundsPage clickOnfixedIncomeFundLink()
	{
		waitForElementPresent(capabilitiesLink);
		mouseHoverAndClick(capabilitiesLink,fixedIncomeFundLink);
		
		return new FixedIncomeFundsPage(driver);
	}
	
	public String getTextOfequityfundsLink()
	{
		mouseHover(capabilitiesLink);
		return equityfundsLink.getText();
		
	}
	
	public EquityFundsPage clickOnequityfundsLink()
	{
		mouseHoverAndClick(capabilitiesLink,equityfundsLink);
		return new EquityFundsPage(driver);
	}
	
	public String getTextOfmultiassetFundLink()
	{
		mouseHover(capabilitiesLink);
		return multiassetFundLink.getText();
		
	}
	
	public MultiAssetsFundsPage clickOnmultiassetFundLink()
	{
		mouseHoverAndClick(capabilitiesLink,multiassetFundLink);
		
		return new MultiAssetsFundsPage(driver);
	}
	
	
	public String getTextOfalternativeFundsLink()
	{
		mouseHover(capabilitiesLink);
		return alternativeFundsLink.getText();
		
	}
	
	public AlternativeFundsPage clickOnalternativeFundsLink()
	{
		mouseHoverAndClick(capabilitiesLink,alternativeFundsLink);
		return new AlternativeFundsPage(driver);
	}
	
	public String getTextOflearnMoreLink()
	{
		mouseHover(capabilitiesLink);
		return learnMoreLink.getText();
		
	}
	
	public FundExplorerPage clickOnlearnMoreLink()
	{
		mouseHoverAndClick(capabilitiesLink,learnMoreLink);
		
		return new FundExplorerPage(driver);
	}
	
	public String getTextOfenquiresLink()
	{
		
		return enquiresLink.getText();
		
	}
	
	public FundExplorerPage clickOnenquiresLink()
	{
		mouseHoverAndClick(capabilitiesLink,enquiresLink);
		
		return new FundExplorerPage(driver);
	}
	
	
/*	public void acceptAlertWindow()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);      
		//Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	 wait.until(ExpectedConditions.alertIsPresent());
		Alert alert =new Alert;
		alert.authenticateUsing(new UserAndPassword("wellington", "n0tgni113w"));
		pauseExecutionFor(100000);
	}*/
	
	public String getCapabilityBannerText()
	{
		return bannerText.getText();
	}
	
	public boolean isLogoDisplayed()
	{
		username.type("wellingtonuat@wellingtonuat.com");
		password.type("hAZ%cLRd0tL5$b^P$Hz6^*Qo");
		//pauseExecutionFor(10000);
		submit.click();
		driver.navigate().to("http://wellington-dev.kurtosysdev.com/uk/en/intermediary/insights-landing/");
		//driver.switchTo().alert();
		driver.findElement(By.xpath("//*[@id='menu-item-480']/a")).click();
		driver.findElement(By.xpath("//a[@data-region='europe']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'United Kingdom')]")).click();
		driver.findElement(By.xpath("//a[@data-investor='intermediary']")).click();
		pauseExecutionFor(10000);
		driver.navigate().to("http://wellington-dev.kurtosysdev.com/uk/en/intermediary/capabilities/");
		waitForElementPresent(logo);
		return logo.isDisplayed();
	}
	
	public FixedIncomeFundsPage click_On_OurFixedIncomeCapability_link()
	 
	 {
		 waitForElementPresent(OurFixedIncomeCapability);
		 //pauseExecutionFor(1000);
		 clickByJavaScript(OurFixedIncomeCapability);
		 //clickByJavaScript(parser.getLocator("OurFixedIncomeComp"));
		// OurFixedIncomeCapability.click();
		 return new FixedIncomeFundsPage(driver);
	 }
		
	public EquityFundsPage click_On_OurEquityCapability_link()
	 
	 {
		 waitForElementPresent(OurEquityCapability);
		 clickByJavaScript(OurEquityCapability);
		 //OurEquityCapability.click();
		 return new EquityFundsPage(driver);
	 }

	public AlternativeFundsPage click_On_OurAlternativeCapability_link()

	{
		 waitForElementPresent(OurAlternativeCapability);
		// OurAlternativeCapability.click();
		 clickByJavaScript(OurAlternativeCapability);
		 return new AlternativeFundsPage(driver);
	}

	public MultiAssetsFundsPage click_On_OurMultiassetCapability_link()

	{
		 waitForElementPresent(OurMultiassetCapability);
		 //OurMultiassetCapability.click();
		 clickByJavaScript(OurMultiassetCapability);
		 return new MultiAssetsFundsPage(driver);
	}

}
