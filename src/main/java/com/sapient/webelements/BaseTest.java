/**
 * 
 */
package com.sapient.webelements;




import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.UnreachableBrowserException;

import com.sapient.core.SeleniumTestsContextManager;
import com.sapient.core.SeleniumTestsPageListener;
import com.sapient.core.TestLogging;
import com.sapient.customexception.CustomSeleniumTestsException;
import com.sapient.driver.WebUIDriver;
import com.sapient.driver.WebUtility;

import net.jsourcerer.webdriver.jserrorcollector.JavaScriptError;



/**
 * @author ssi248
 *
 */
public abstract class BaseTest implements IPage {
	
	 //protected final WebUIDriver webUXDriver = WebUIDriver.getWebUIDriver();
	 protected static WebDriver driver;
	 protected  WebUIDriver webUXDriver;
	 public String url=null;
	 protected String suiteName = null;
	    protected String outputDirectory = null;
	    protected String title = null;
	    protected String htmlSource = null;
	    protected String bodyText = null;
	    protected String htmlFilePath = null;
	    protected String imageFilePath = null;
	    protected String htmlSavedToPath = null;
	    protected String windowHandle = null;
	 
	 public WebDriver getDriver() {
	        this.driver = WebUIDriver.getWebDriver();
	        return this.driver;
	    }
	 
	 public final void maximizeWindow() {
	        new WebUtility(this.driver).maximizeWindow();
	    }
	 
	 protected void setUrl(String openUrl) {
	        this.url = openUrl;
	    }
	    
	 
	 /**
	 * @param url
	 * @return
	 * @throws Exception
	 */
	protected WebDriver loadApplication() throws Exception
	    {
		 webUXDriver = WebUIDriver.getWebUIDriver();
		
		if (SeleniumTestsContextManager.getGlobalContext() != null
                && SeleniumTestsContextManager.getGlobalContext().getTestNGContext() != null) {
            suiteName = SeleniumTestsContextManager.getGlobalContext().getTestNGContext().getSuite().getName();
            outputDirectory = SeleniumTestsContextManager.getGlobalContext().getTestNGContext().getOutputDirectory();
        }
		//Get the current driver session 
	    	 this.driver = WebUIDriver.getWebDriver();
	    	 //Check if driver session is null and create new webdriver session if session is null
	    	 //if (this.getDriver() == null)
	    	// {
	    	  driver = webUXDriver.createFinalDriver();
	    			  //createWebDriver();
	    	 
	    	// }
	    	 
	    	 url=SeleniumTestsContextManager.getThreadContext().getAppURL();
	    	 if (url != null) {
	    		 open(url,driver);
	    	 }
	    	 
	    		 if (SeleniumTestsContextManager.isWebTest()) {
	 	            //waitForPageToLoad();
	 	        }
	 		   try {
	 	            this.windowHandle = driver.getWindowHandle();
	 	        } catch (Exception ex) {
	 	            // Ignore for OperaDriver
	 	        }

	 	        SeleniumTestsPageListener.informPageLoad(this);
	 	       Calendar start = Calendar.getInstance();

		        Calendar end = Calendar.getInstance();
		        start.setTime(new Date());

	 	        long startTime = start.getTimeInMillis();
	 	        long endTime = end.getTimeInMillis();
	 	        if ((endTime - startTime) / 1000 > 0) {
	 	            TestLogging.log("Open web page in :" + (endTime - startTime) / 1000 + "seconds");
	    }
			return driver;
	    	 
	    }
	
	public void open(final String url, WebDriver driver) throws Exception {
	        setUrl(url);
	        try {

	            // Navigate to app URL for browser test
	            if (SeleniumTestsContextManager.isWebTest()) {
	                driver.navigate().to(url);
	            }
	        } catch (UnreachableBrowserException e) {
	        	this.driver = WebUIDriver.getWebUIDriver().createWebDriver();
	             this.maximizeWindow();
	             this.driver.navigate().to(url);
	        } catch (UnsupportedCommandException e) {
	            TestLogging.log("get UnsupportedCommandException, retry");
	            this.driver = WebUIDriver.getWebUIDriver().createWebDriver();
	            maximizeWindow();
	            driver.navigate().to(url);
	        } catch (org.openqa.selenium.TimeoutException ex) {
	            TestLogging.log("got time out when loading " + url + ", ignored");
	        } catch (org.openqa.selenium.UnhandledAlertException ex) {
	            TestLogging.log("got UnhandledAlertException, retry");
	            driver.navigate().to(url);
	        } catch (Throwable e) {
	            e.printStackTrace();
	            throw new CustomSeleniumTestsException(e);
	        }
	}

	    
	    
	/* @SuppressWarnings("deprecation")
		private void waitForPageToLoad() throws Exception {
	        try {
	            new Wait() {
	                @Override
	                public boolean until() {
	                    try {
	                        driver.switchTo().defaultContent();
	                        return true;
	                    } catch (UnhandledAlertException ex) {
	                        WaitHelper.waitForSeconds(2);
	                    } catch (WebDriverException e) { }

	                    return false;
	                }
	            }.wait(String.format("Timed out waiting for page to load"),
	                WebUIDriver.getWebUIDriver().getWebSessionTimeout());
	        } catch (WaitTimedOutException ex) { }

	        // populate page info
	        try {
	            populateAndCapturePageSnapshot();
	        } catch (Exception ex) {

	            // ex.printStackTrace();
	            throw ex;
	        }
	    }*/
	    
	    private void populateAndCapturePageSnapshot() {
	        try {
	            setTitle(driver.getTitle());
	            htmlSource = driver.getPageSource();
	            try {
	                bodyText = driver.findElement(By.tagName("body")).getText();
	            } catch (StaleElementReferenceException ignore) {
	                //logger.warn("StaleElementReferenceException got in populateAndCapturePageSnapshot");
	                bodyText = driver.findElement(By.tagName("body")).getText();
	            }

	        } catch (UnreachableBrowserException e) { // throw

	            // UnreachableBrowserException
	            throw new WebDriverException(e);
	        } catch (WebDriverException e) {
	            throw e;
	        }

	        capturePageSnapshot();
	    }
	    
	    protected void setTitle(final String title) {
	        this.title = title;
	    }
	    @Override
	    public String getHtmlSource() {
	        return htmlSource;
	    }
	    @Override
	    public String getBodyText() {
	        return bodyText;
	    }
	    
	    protected abstract void capturePageSnapshot();
	    
	    
	    @Override
		public String getJSErrors() {
			  if (WebUIDriver.getWebUIDriver().isAddJSErrorCollectorExtension()) {
		            List<JavaScriptError> jsErrorList = JavaScriptError.readErrors(driver);
		            if (!jsErrorList.isEmpty()) {
		                String jsErrors = "";
		                for (JavaScriptError aJsErrorList : jsErrorList) {
		                    jsErrors += aJsErrorList.getLineNumber() + ", " + aJsErrorList.getErrorMessage() + ", "
		                            + aJsErrorList.getSourceName() + "; ";
		                }

		                return jsErrors;
		            }
		        }

		        return null;
		}

		/* (non-Javadoc)
		 * @see com.sapient.webelements.IPage#getLocation()
		 */
		@Override
		public String getLocation() {
			return driver.getCurrentUrl();
		}

		/* (non-Javadoc)
		 * @see com.sapient.webelements.IPage#getTitle()
		 */
		@Override
		public String getTitle() {
			  return driver.getTitle();
		}
		@Override
		public String getHtmlSavedToPath() {
			 return htmlSavedToPath;
		}
}
	
	
	





	
	    
	    

