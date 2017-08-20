/**
 * 
 */
package com.sapient.tests;


import org.testng.annotations.Test;

import com.sapient.core.CustomAssertion;
import com.sapient.core.SeleniumTestPlan;
import com.sapient.webpage.HomePage;
import com.sapient.webpage.LoginPage;

/**
 * @author ssi248
 *
 */
public class LoginPageTest extends SeleniumTestPlan{

	
 @Test 
 public void doLogin() throws Exception
 {
	 LoginPage loginPage = new LoginPage(driver);
		 //HomePage homePage = new HomePage(false);
	  
	  CustomAssertion.assertTrue(loginPage.isPasswordDisplayed(), "Password field is not displayed");
	  CustomAssertion.assertTrue(loginPage.isUserNameDisplayed(), "User Name field is not displayed");
	  loginPage.enterLoginData("sanjaysinghprod", "c%QH&LoiUZle!SCKWb@7gdUZ");
	  CustomAssertion.assertEquals(loginPage.getTitle(), "1Homepage - Wellington Management Funds Landing","Not navigated to the homePage");
	  
 }
}
