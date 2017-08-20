/**
 * 
 */
package com.sapient.webpage;

import org.openqa.selenium.WebDriver;

import com.sapient.webelements.ImageElement;
import com.sapient.webelements.LabelElement;

/**
 * @author ssi248
 *
 */
public class AllInsightPage extends WebBasePage {

	private static final LabelElement readMoreOnAllInsight = new LabelElement("Read more link on banner", parser.getLocator("allInsight_readMore"));
	

	
	public AllInsightPage(WebDriver driver)  {
		super(driver,"AllInsightPage");
		// TODO Auto-generated constructor stub
	}
	
	public DistinctiveApproachToEquityPage click_On_read_More()
	{
		waitForElementPresent(readMoreOnAllInsight);
		readMoreOnAllInsight.click();
		return new DistinctiveApproachToEquityPage(driver);
	}
	

}
