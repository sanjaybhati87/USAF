/**
 * 
 *//*
package com.sapient.webpage;

import org.openqa.selenium.By;

import com.sapient.core.SeleniumTestsContextManager;
import com.sapient.webelements.ImageElement;
import com.sapient.webelements.PageObject;

*//**
 * @author ssi248
 *
 *//*
public class SearchResultPage extends PageObject{
	
	private static final ImageElement logo = new ImageElement("Wellington logo", parser.getLocator("HomePage_logo"));
	
	public SearchResultPage(final boolean openPageURL) throws Exception {
		super(username,openPageURL ? SeleniumTestsContextManager.getThreadContext().getAppURL() : null,"SearchResultPage");
		// TODO Auto-generated constructor stub
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
		driver.navigate().to("http://wellington-dev.kurtosysdev.com/uk/en/intermediary/search-results/");
		waitForElementPresent(logo);
		return logo.isDisplayed();
	}

}
*/