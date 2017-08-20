/**
 * 
 */
package com.sapient.webpage;

import org.openqa.selenium.WebDriver;

import com.sapient.core.SeleniumTestsContextManager;
import com.sapient.webelements.ButtonElement;
import com.sapient.webelements.PageObject;
import com.sapient.webelements.TextFieldElement;




/**
 * @author ssi248
 *
 */
public class LoginPage extends WebBasePage {
	
	private static TextFieldElement userNameTextBox = new TextFieldElement("User name field on login page", parser.getLocator("login_username"));
	private static TextFieldElement passwordTextBox = new TextFieldElement("User name field on login page", parser.getLocator("login_password"));
	private static ButtonElement submitButton = new ButtonElement("Submit button on login page", parser.getLocator("login_submit"));
	
	public LoginPage(WebDriver driver)  {
		super(driver,"LoginPage");
	}
	
	public LoginPage enterUserName(final String userName) {
		waitForElementPresent(userNameTextBox);
        userNameTextBox.clearAndType(userName);

        return this;
    }

    public LoginPage enterPassword(final String password) {
    	waitForElementPresent(passwordTextBox);
    	passwordTextBox.clearAndType(password);

        return this;
    }

    public static boolean isUserNameDisplayed() {
        return userNameTextBox.isDisplayed();
    }
    
    public static boolean isPasswordDisplayed() {
        return passwordTextBox.isDisplayed();
    }
    
    public HomePage clickSubmitButton()  {
    	waitForElementPresent(submitButton);
        submitButton.click();
        pauseExecutionFor(2000);
        return new HomePage(driver);
    }
    
    public HomePage enterLoginData(String username, String password) {
        return enterUserName(username).enterPassword(password).clickSubmitButton();
    }

}
