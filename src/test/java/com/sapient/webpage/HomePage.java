/**
 * 
 */
package com.sapient.webpage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sapient.core.SeleniumTestsContextManager;
import com.sapient.customexception.NotCurrentPageException;
import com.sapient.webelements.ButtonElement;
import com.sapient.webelements.ImageElement;
import com.sapient.webelements.LabelElement;
import com.sapient.webelements.LinkElement;
import com.sapient.webelements.PageObject;


/**
 * @author ssi248
 *
 */
public class HomePage extends WebBasePage {
	
	  private static final LabelElement featuredVedio = new  LabelElement("Featured video", parser.getLocator("Home_Page_featuredVedio"));
	  private static final LinkElement langauge = new LinkElement("Language link",parser.getLocator("Home_Page_langaugeLink"));
	 // private static final ImageElement logo = new ImageElement("Wellington logo", parser.getLocator("HomePage_logo"));
	  private static final ButtonElement galen= new ButtonElement("Galen logo", parser.getLocator("login_galen"));
	  private static final LinkElement aboutUs = new LinkElement("About Us", parser.getLocator("aboutUs"));
	  private static final LinkElement selectCountryLink = new LinkElement("Select Country link on pre homePage", parser.getLocator("pre_home_Select_Contry"));
	  private static final LinkElement selectEurope = new LinkElement("Select Region Europe", parser.getLocator("select_europe"));
	  private static final LinkElement selectAsia = new LinkElement("Select Region Asia", parser.getLocator("select_asia"));
	  private static final LinkElement selectCountry_UK = new LinkElement("Select Country UK", parser.getLocator("select_country_UK"));
	  private static final LinkElement selectCountry_switzerland = new LinkElement("Select Country switzerland", parser.getLocator("select_country_switzerland"));
	  private static final ButtonElement intermeiaryClient = new ButtonElement("Select Inermediary client", parser.getLocator("Intermediary_client"));
	  private static final ButtonElement institutionalClient = new ButtonElement("Select Inermediary client", parser.getLocator("Institutional_clinet"));
	  private static final ButtonElement AcceptTerms = new ButtonElement("Accept terms and conditions", parser.getLocator("acceptDelimer"));
	  private static final LinkElement fixedIncomeTile = new LinkElement("Fixed income tile under capability on pre home page",parser.getLocator("FixedIncomeTile"));
	   private static final LinkElement equityTile = new LinkElement("Equity tile under capability on pre home page",parser.getLocator("EquityTile"));
		private static final LinkElement multiAssetTile = new LinkElement("Multi AssetTile tile under capability on pre home page",parser.getLocator("MultiAssetTile"));
		private static final LinkElement alternativeTile = new LinkElement("Alternative Tile tile under capability on pre home page",parser.getLocator("AlternativeTile"));
		private static final LinkElement exploreFundsLink = new LinkElement("Explore Funds link under capability on pre home page",parser.getLocator("preHome_fundExplore"));
	  
	  
	  
	  
	  
	  private static final LinkElement linktoHome = new LinkElement("Posted home Page", parser.getLocator("LinkToHome"));
	  
	
	/**
	 * @throws Exception
	 */
	public HomePage(WebDriver driver)  {
		super(driver,"HomePage");
		// TODO Auto-generated constructor stub
	}
	
	public HomePage selectRegion() {
	if(SeleniumTestsContextManager.getRegion().equalsIgnoreCase("Europe"))
	{
		waitForElementPresent(selectEurope);
		clickByJavaScript(selectEurope);
	}
		else
		{
			waitForElementPresent(selectAsia);
			clickByJavaScript(selectAsia);
		
		}
	pauseExecutionFor(1000);
	return this;
	}
	
	public HomePage clickOnSelectCountryLink()
	{
		waitForElementPresent(selectCountryLink);
		clickByJavaScript(selectCountryLink);
		pauseExecutionFor(1000);
		return this;
		
	}
	public HomePage selectCountry()
	{
		if(SeleniumTestsContextManager.getCountry().toLowerCase().equalsIgnoreCase("United Kingdom"))
		{
			waitForElementPresent(selectCountry_UK);
		clickByJavaScript(selectCountry_UK);
		pauseExecutionFor(1000);
		}
			
		else if (SeleniumTestsContextManager.getCountry().toLowerCase().equalsIgnoreCase("switzerland"))
		{
			waitForElementPresent(selectCountry_switzerland);
			clickByJavaScript(selectCountry_switzerland);
		//selectCountry_switzerland.click();
		}
		
		return this;		
	}
	
	public HomePage selectClintType()
	{
		if(SeleniumTestsContextManager.getClientType().equalsIgnoreCase("Institutional"))
		{
			waitForElementPresent(institutionalClient);
		clickByJavaScript(institutionalClient);
			//institutionalClient.click();
		}
		else
		{
			waitForElementPresent(intermeiaryClient);
		clickByJavaScript(intermeiaryClient);
			//intermeiaryClient.click();
		}
		pauseExecutionFor(1000);
		return this;
	}
	
	public HomePage clickOnVisistSite()
	{
		waitForElementPresent(visitSite);
		clickByJavaScript(visitSite);
		pauseExecutionFor(1000);
		return this;
	}
	
	public HomePostAttestationPage acceptDeclaimer()
	{
		movetToElementJavascript(parser.getLocator("acceptDelimer"));
		pauseExecutionFor(1000);
		clickByJavaScript(parser.getLocator("acceptDelimer"));
		pauseExecutionFor(1000);
		return new HomePostAttestationPage(driver);
	}
	
	public HomePostAttestationPage selectRegionAndCountry() throws NotCurrentPageException 
	{
		pauseExecutionFor(3000);
		waitForElementPresent(visitSite);
		//mouseHoverAndClick(fundlandingLinkOnAdminPage, visitSite);
		//fundlandingLink.click();
		//waitForElementPresent(visitSite);
		clickByJavaScript(visitSite);
		System.out.println(SeleniumTestsContextManager.getRegion());
		//visitSite.click();
		//pauseExecutionFor(10000);
		//driver.findElement(By.xpath("//*[@id='wp-admin-bar-site-name']/a")).click();
		pauseExecutionFor(10000);
		waitForElementPresent(selectCountryLink);
		clickByJavaScript(selectCountryLink);
		//selectCountryLink.click();
		//waitForElementPresent(selectRegion);
		//selectRegion.click();
		selectRegion();
		waitForElementPresent(selectCountry_UK);
		System.out.println(selectCountry_UK.isDisplayed());
		selectCountry_UK.click();
		//pauseExecutionFor(10000);
		waitForElementPresent(parser.getLocator("selectInstituteIntermediatery"));
		System.out.println(intermeiaryClient.isDisplayed());
		
		//driver.findElement(parser.getLocator("selectInstituteIntermediatery")).click();
		
		intermeiaryClient.click();
		waitForElementPresent(parser.getLocator("acceptDelimer"));
		pauseExecutionFor(1000);
		//acceptAlert();
		movetToElementJavascript(parser.getLocator("acceptDelimer"));
		pauseExecutionFor(1000);
		clickByJavaScript(parser.getLocator("acceptDelimer"));
		//AcceptTerms.click();
		
		//document.getElementsByClassName("wpg-disclaimer-decline")[0].click();
		pauseExecutionFor(10000);
		//System.out.println(System.currentTimeMillis());
		return new HomePostAttestationPage(driver);
		
		 	
	}
	
	
	/**
	 * @param b
	 * @return
	 */
	
	public boolean isLogoDisplayed()
	{
		username.type("wellingtonuat@wellingtonuat.com");
		password.type("hAZ%cLRd0tL5$b^P$Hz6^*Qo");
		//pauseExecutionFor(10000);
		submit.click();
		//pauseExecutionFor(10000);
		driver.navigate().to("http://wellington-dev.kurtosysdev.com/");
		waitForElementPresent(logo);
		return logo.isDisplayed();
	}
	public HomePage clickOnHomePageLink() throws Exception
	{
		waitForElementPresent(linktoHome);
		linktoHome.click();
		return this;
		
	}
	public String getDefaultLangauge()
	{
		return langauge.getText();
	}
	
	 public HomePage clickOnFixedIncomeTile()
	 
	 {
		 waitForElementPresent(fixedIncomeTile);
		 pauseExecutionFor(1000);
		 fixedIncomeTile.click();
		 return this;
	 }
		
	public HomePage clickOnEquityTile()
	 
	 {
		 waitForElementPresent(equityTile);
		 equityTile.click();
		 return this;
	 }

	public HomePage clickOnmultiAssetTile()

	{
		 waitForElementPresent(multiAssetTile);
		 multiAssetTile.click();
		 return this;
	}

	public HomePage clickOnalternativeTile()

	{
		 waitForElementPresent(alternativeTile);
		 alternativeTile.click();
		 return this;
	}
	 public HomePage clickOnexploreFundsLink()
	 {
		 waitForElementPresent(exploreFundsLink);
		 pauseExecutionFor(10000);
		 //exploreFundsLink.click();
		 clickByJavaScript(parser.getLocator("exploreFunds"));
		return this;
	 }
	
	

}
