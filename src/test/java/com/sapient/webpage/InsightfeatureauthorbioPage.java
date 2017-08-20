/**
 * 
 */
package com.sapient.webpage;

import org.openqa.selenium.WebDriver;

import com.sapient.webelements.ButtonElement;
import com.sapient.webelements.ImageElement;
import com.sapient.webelements.TextFieldElement;

/**
 * @author ssi248
 *
 */
public class InsightfeatureauthorbioPage extends WebBasePage {
	
private static final ImageElement logo = new ImageElement("Wellington logo", parser.getLocator("HomePage_logo"));
private static final TextFieldElement username= new TextFieldElement("User name", parser.getLocator("username"));
private static final TextFieldElement password= new TextFieldElement("User name", parser.getLocator("password"));
private static final ButtonElement submit = new ButtonElement("submit for login", parser.getLocator("sumit"));
	
	public InsightfeatureauthorbioPage(WebDriver driver) throws Exception {
		super(driver,"InsightfeatureauthorbioPage");
		// TODO Auto-generated constructor stub
	}
	
	public void doLogin()
	{
		username.type("wellingtonuat@wellingtonuat.com");
		password.type("hAZ%cLRd0tL5$b^P$Hz6^*Qo");
		submit.click();
		
	}
	public boolean isLogoDisplayed()
	{
		waitForElementPresent(logo);
		return logo.isDisplayed();
	}


}
