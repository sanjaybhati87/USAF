package com.sapient.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.sapient.core.SeleniumTestsContextManager;
import com.sapient.customexception.WebSessionEndedException;


/**
 * @author ssi248
 *
 */
public class DriverExceptionListener implements WebDriverEventListener {

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#beforeNavigateTo(java.lang.String, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#afterNavigateTo(java.lang.String, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#beforeNavigateBack(org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#afterNavigateBack(org.openqa.selenium.WebDriver)
	 */
	@Override
	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#beforeNavigateForward(org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#afterNavigateForward(org.openqa.selenium.WebDriver)
	 */
	@Override
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#beforeNavigateRefresh(org.openqa.selenium.WebDriver)
	 */
	
	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#beforeFindBy(org.openqa.selenium.By, org.openqa.selenium.WebElement, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#afterFindBy(org.openqa.selenium.By, org.openqa.selenium.WebElement, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#beforeClickOn(org.openqa.selenium.WebElement, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#afterClickOn(org.openqa.selenium.WebElement, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#beforeChangeValueOf(org.openqa.selenium.WebElement, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#afterChangeValueOf(org.openqa.selenium.WebElement, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#beforeScript(java.lang.String, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#afterScript(java.lang.String, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#onException(java.lang.Throwable, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void onException(Throwable ex, WebDriver arg1) {
        if (ex.getMessage() == null) {
            return;
        } else if (ex.getMessage().contains("Element must be user-editable in order to clear it")) {
            return;
        } else if (ex.getMessage().contains("Element is not clickable at point")) {
            return;
        } else if (ex instanceof UnsupportedCommandException) {
            return;
        } else if (ex.getMessage().contains(" read-only")) {
            return;
        } else if (ex.getMessage().contains("No response on ECMAScript evaluation command")) { // Opera

            // customexception
            for (int i = 0; i < ex.getStackTrace().length; i++) {
                String method = ex.getStackTrace()[i].getMethodName();
                if (method.contains("getTitle") || method.contains("getWindowHandle") || method.contains("click")
                        || method.contains("getPageSource")) {
                    return;
                }
            }

            ex.printStackTrace();
            // return;
        } else if (ex.getMessage().contains("Error communicating with the remote browser. It may have died.")) {

            // Session has lost connection, remove it then ignore quit() method.
            if (WebUIDriver.getWebUIDriver().getConfig().getMode() == DriverMode.ExistingGrid) {
                WebUIDriver.setWebDriver(null);
                throw new WebSessionEndedException(ex);
            }

            return;
        } else if (ex instanceof org.openqa.selenium.remote.UnreachableBrowserException) {
            return;
        } else if (ex instanceof org.openqa.selenium.UnsupportedCommandException) {
            return;
        } else {
            String message = ex.getMessage().split("\\n")[0];
            System.out.println("Got customexception:" + message);
            if (message.matches("Session (/S*) was terminated due to(.|\\n)*")
                    || message.matches("cannot forward the request Connection to(.|\\n)*")) {
                WebUIDriver.setWebDriver(null); // can't quit anymore, save time.

                // since the session was
                // terminated.
                throw new WebSessionEndedException(ex);
            }
        }

        for (int i = 0; i < ex.getStackTrace().length; i++) // avoid dead loop
        {
            String method = ex.getStackTrace()[i].getMethodName();
            if (method.contains("getScreenshotAs") || method.contains("captureWebPageSnapshot")) {
                return;
            }
        }

        if (arg1 != null) {

            try {
                System.out.println("Got customexception" + ex.getMessage());
                if (SeleniumTestsContextManager.getThreadContext().getTestType().equalsIgnoreCase(
                            TestType.WEB.toString())) {
                    new ScreenshotUtil(arg1).capturePageSnapshotOnException();
                } else {
                    System.out.println("Capture screenshot is not available for appium");
                }
            } catch (Exception e) {

                // Ignore all exceptions
                e.printStackTrace();
            }
        }
    }

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#beforeNavigateRefresh(org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#afterNavigateRefresh(org.openqa.selenium.WebDriver)
	 */
	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#beforeNavigateRefresh(org.openqa.selenium.WebDriver)
	 */
/*	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	 (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#afterNavigateRefresh(org.openqa.selenium.WebDriver)
	 
	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}*/

		
	}
   
	

	

