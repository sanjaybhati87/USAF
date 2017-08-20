/**
 * 
 */
package com.sapient.core;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

import com.sapient.driver.DriverConfig;

/**
 * @author ssi248
 *
 */
public class  RepositoryParser {

		private FileInputStream stream;
		private Properties propertyFile = new Properties();
		private By locater;
		 

		public RepositoryParser() 
		{
			try {
				
				
				if(SeleniumTestsContextManager.getThreadContext().getTestType().equalsIgnoreCase("web"))
				{
				stream = new FileInputStream("src\\test\\resources\\objectRepository\\desktop\\desktop.properties");
				}
				else
				{
					stream = new FileInputStream("src\\test\\resources\\objectRepository\\mobile\\mobile.properties");
				}
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				propertyFile.load(stream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


public By getLocator(String strElement)  {
         
        // retrieve the specified object from the object list
        String locator = propertyFile.getProperty(strElement);
         
        // extract the locator type and value from the object
        String locatorType = locator.split(":")[0];
        String locatorValue = locator.split(":")[1];
         
        // for testing and debugging purposes
        //System.out.println("Retrieving object of type '" + locatorType + "' and value '" + locatorValue + "' from the object map");
         
        // return a instance of the By class based on the type of the locator
        // this By can be used by the browser object in the actual test
        if(locatorType.toLowerCase().equals("id"))
             locater=By.id(locatorValue);
        else if(locatorType.toLowerCase().equals("name"))
        	locater= By.name(locatorValue);
        else if((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
        	locater= By.className(locatorValue);
        else if((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
        	locater= By.className(locatorValue);
        else if((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
        	locater= By.linkText(locatorValue);
        else if(locatorType.toLowerCase().equals("partiallinktext"))
        	locater= By.partialLinkText(locatorValue);
        else if((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
        	locater= By.cssSelector(locatorValue);
        else if (locatorType.toLowerCase().equals("xpath"))
        	locater= By.xpath(locatorValue);
		return locater;
        
    }
}


