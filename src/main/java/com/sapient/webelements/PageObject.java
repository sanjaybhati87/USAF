package com.sapient.webelements;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.opera.core.systems.scope.protos.CookieMngProtos.Cookie;
import com.sapient.core.CustomAssertion;
import com.sapient.core.RepositoryParser;
import com.sapient.core.SeleniumTestsContextManager;
import com.sapient.core.SeleniumTestsPageListener;
import com.sapient.core.TestLogging;
import com.sapient.customexception.CustomSeleniumTestsException;
import com.sapient.customexception.NotCurrentPageException;
import com.sapient.driver.BrowserType;
import com.sapient.driver.DriverConfig;
import com.sapient.driver.ScreenShot;
import com.sapient.driver.ScreenshotUtil;
import com.sapient.driver.WebUIDriver;
import com.sapient.driver.WebUtility;
import com.sapient.helper.WaitHelper;
import com.sapient.util.LayoutVAlidation;
import com.thoughtworks.selenium.Wait;
import com.thoughtworks.selenium.Wait.WaitTimedOutException;

import net.jsourcerer.webdriver.jserrorcollector.JavaScriptError;

public class PageObject extends BasePage implements IPage {

    private static final Logger logger = Logger.getLogger(PageObject.class);
    private static final int MAX_WAIT_TIME_FOR_REDIRECTION = 3;
    private boolean frameFlag = false;
    private HtmlElement pageIdentifierElement = null;
    private String popupWindowName = null;
    private String windowHandle = null;
    private String title = null;
    private String url = null;
    private String bodyText = null;
    private String htmlSource = null;
    private String htmlSavedToPath = null;
    private String suiteName = null;
    private String outputDirectory = null;
    private String htmlFilePath = null;
    private String imageFilePath = null;
    protected static RepositoryParser parser= new RepositoryParser();
    public String pageName;
    protected LayoutVAlidation layouttest;
    private DriverConfig config = new DriverConfig();

    /**
     * Constructor for non-entry point page. The control is supposed to have reached the page from other API call.
     *
     * @throws  Exception
     */
    public static final TextFieldElement username= new TextFieldElement("User name", parser.getLocator("username"));
    public static final TextFieldElement password= new TextFieldElement("User name", parser.getLocator("password"));
    public static final ButtonElement submit = new ButtonElement("submit for login", parser.getLocator("submit"));
  /*  public PageObject() throws Exception {
        this(null, null,null);
    }*/

    /**
     * Constructor for non-entry point page. The control is supposed to have reached the page from other API call.
     *
     * @param   pageIdentifierElement
     *
     * @throws  Exception
     */
   /* public PageObject(final HtmlElement pageIdentifierElement) throws Exception {
        this(pageIdentifierElement, null,null);
    }*/

    /**
     * Base Constructor.
     *
     * @param   url
     *
     * @throws  Exception
     */
    public PageObject(WebDriver driver,String pageName) {
    	super(driver);
        Calendar start = Calendar.getInstance();
        start.setTime(new Date());
        this.pageName=pageName;

        if (SeleniumTestsContextManager.getGlobalContext() != null
                && SeleniumTestsContextManager.getGlobalContext().getTestNGContext() != null) {
            suiteName = SeleniumTestsContextManager.getGlobalContext().getTestNGContext().getSuite().getName();
            outputDirectory = SeleniumTestsContextManager.getGlobalContext().getTestNGContext().getOutputDirectory();
        }
        
        url=SeleniumTestsContextManager.getThreadContext().getAppURL();

       /// this.pageIdentifierElement = pageIdentifierElement;
        //driver = WebUIDriver.getWebDriver();

        if (this.getDriver() == null) {
            try {
				open(url);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            logger.info("Open the url"+" "+url);
        
        }
        // Wait for page load is applicable only for web test
        // When running tests on an iframe embedded site then test will fail if this command is not used
        if (SeleniumTestsContextManager.isWebTest()) {
            try {
				waitForPageToLoad();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        

      /*  try {
			assertCurrentPage(false);
		} catch (NotCurrentPageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
        try {
            this.windowHandle = driver.getWindowHandle();
        } catch (Exception ex) {
            // Ignore for OperaDriver
        }

        SeleniumTestsPageListener.informPageLoad(this);

        Calendar end = Calendar.getInstance();
        start.setTime(new Date());

        long startTime = start.getTimeInMillis();
        long endTime = end.getTimeInMillis();
        if ((endTime - startTime) / 1000 > 0) {
            TestLogging.log("Open web page in :" + (endTime - startTime) / 1000 + "seconds");
        }
        }
    

    public void assertCookiePresent(final String name) {
        TestLogging.logWebStep(null, "assert cookie " + name + " is present.", false);
        assertHTML(getCookieByName(name) != null, "Cookie: {" + name + "} not found.");
    }

    @Override
    protected void assertCurrentPage(final boolean log) throws NotCurrentPageException {

        if (pageIdentifierElement == null) { }
        else if (this.isElementPresent(pageIdentifierElement.getBy())) { }
        else {
            try {
                if (!SeleniumTestsContextManager.getThreadContext().getCaptureSnapshot()) {
                    new ScreenshotUtil(driver).capturePageSnapshotOnException();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            throw new NotCurrentPageException(getClass().getCanonicalName()
                    + " is not the current page.\nPageIdentifierElement " + pageIdentifierElement.toString()
                    + " is not found.");
        }

        if (log) {
            TestLogging.logWebStep(null,
                "assert \"" + getClass().getSimpleName() + "\" is the current page"
                    + (pageIdentifierElement != null
                        ? " (assert PageIdentifierElement " + pageIdentifierElement.toHTML() + " is present)." : "."),
                false);
        }
    }

    public void assertHtmlSource(final String text) {
        TestLogging.logWebStep(null, "assert text \"" + text + "\" is present in page source.", false);
        assertHTML(getHtmlSource().contains(text), "Text: {" + text + "} not found on page source.");
    }

    public void assertKeywordNotPresent(final String text) {
        TestLogging.logWebStep(null, "assert text \"" + text + "\" is present in page source.", false);
        Assert.assertFalse(getHtmlSource().contains(text), "Text: {" + text + "} not found on page source.");
    }

    public void assertLocation(final String urlPattern) {
        TestLogging.logWebStep(null, "assert location \"" + urlPattern + "\".", false);
        assertHTML(getLocation().contains(urlPattern), "Pattern: {" + urlPattern + "} not found on page location.");
    }

  /*  public void assertPageSectionPresent(final WebPageSection pageSection) {
        TestLogging.logWebStep(null, "assert pagesection \"" + pageSection.getName() + "\"  is present.", false);
        assertElementPresent(new HtmlElement(pageSection.getName(), pageSection.getBy()));
    }
*/
    public void assertTitle(final String text) {
        TestLogging.logWebStep(null, "assert text \"" + text + "\"  is present on title.", false);
        assertHTML(getTitle().contains(text), "Text: {" + text + "} not found on page title.");

    }

    public void capturePageSnapshot() {
        ScreenShot screenShot = new ScreenshotUtil(driver).captureWebPageSnapshot();
        this.title = screenShot.getTitle();

        if (screenShot.getHtmlSourcePath() != null) {
            htmlFilePath = screenShot.getHtmlSourcePath().replace(suiteName, outputDirectory);
            htmlSavedToPath = screenShot.getHtmlSourcePath();
        }

        if (screenShot.getImagePath() != null) {
            imageFilePath = screenShot.getImagePath().replace(suiteName, outputDirectory);
        }

        TestLogging.logWebOutput(url, title + " (" + TestLogging.buildScreenshotLog(screenShot) + ")", false);

    }

    public final void close() throws NotCurrentPageException {
        if (WebUIDriver.getWebDriver() == null) {
            return;
        }

        SeleniumTestsPageListener.informPageUnload(this);
        TestLogging.log("close web page");

        boolean isMultipleWindow = false;
        if (driver.getWindowHandles().size() > 1) {
            isMultipleWindow = true;
        }

        try {
            driver.close();
        } catch (WebDriverException ignore) { }

        if (WebUIDriver.getWebUIDriver().getMode().equalsIgnoreCase("LOCAL")) {
            try {
                Thread.sleep(1000 * 2);
            } catch (InterruptedException e) { }
        }

        try {
            if (isMultipleWindow) {
                this.selectWindow();
            } else {
                WebUIDriver.setWebDriver(null);
            }
        } catch (UnreachableBrowserException ex) {
            WebUIDriver.setWebDriver(null);

        }
    }

    /**
     * Drags an element a certain distance and then drops it.
     *
     * @param  element  to dragAndDrop
     * @param  offsetX  in pixels from the current location to which the element should be moved, e.g., 70
     * @param  offsetY  in pixels from the current location to which the element should be moved, e.g., -300
     */
    public void dragAndDrop(final HtmlElement element, final int offsetX, final int offsetY) {
        TestLogging.logWebStep(null,
            "dragAndDrop " + element.toHTML() + " to offset(x,y): (" + offsetX + "," + offsetY + ")", false);
        element.captureSnapshot("before draging");

        new Actions(driver).dragAndDropBy((WebElement) element.getElement(), offsetX, offsetY).perform();
        element.captureSnapshot("after dropping");
    }

    public String getBodyText() {
        return bodyText;
    }

    public final String getCookieByName(final String name) {
        if (driver.manage().getCookieNamed(name) == null) {
            return null;
        }

        return driver.manage().getCookieNamed(name).getValue();
    }

    public final int getElementCount(final HtmlElement element) throws CustomSeleniumTestsException {
        return driver.findElements(element.getBy()).size();
    }

    public String getEval(final String expression) {
        CustomAssertion.assertTrue(false, "focus not implemented yet");
        return null;
    }

    public String getHtmlFilePath() {
        return htmlFilePath;
    }

    public String getHtmlSavedToPath() {
        return htmlSavedToPath;
    }

    public String getHtmlSource() {
        return htmlSource;
    }

    public String getImageFilePath() {
        return imageFilePath;
    }

    /**
     * Get JS Error by JSErrorCollector which only supports Firefox browser.
     *
     * @return  jsErrors in format "line number, errorLogger message, source name; "
     */
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

    public String getLocation() {
        return driver.getCurrentUrl();
    }

    public String getPopupWindowName() {
        return popupWindowName;
    }

    public int getTimeout() {
        return SeleniumTestsContextManager.getThreadContext().getWebSessionTimeout();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getUrl() {
        return url;
    }

    public String getCanonicalURL() {
        return new LinkElement("Canonical URL", By.cssSelector("link[rel=canonical]")).getAttribute("href");
    }
    
    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public String getWindowHandle() {
        return windowHandle;
    }

    public final void goBack() {
        TestLogging.logWebStep(null, "goBack", false);
        driver.navigate().back();
        pauseExecutionFor(1000);
        frameFlag = false;
    }

    public final void goForward() {
        TestLogging.logWebStep(null, "goForward", false);
        driver.navigate().forward();
        frameFlag = false;
    }

    public final boolean isCookiePresent(final String name) {
        return getCookieByName(name) != null;
    }

    public boolean isFrame() {
        return frameFlag;
    }

    public final void maximizeWindow() {
        new WebUtility(driver).maximizeWindow();
    }

    private void open(final String url) throws Exception {

        if (this.getDriver() == null) {
            TestLogging.logWebStep(url, "Launch application", false);
            driver = webUXDriver.createWebDriver();
            setUrl(url);
            driver.navigate().to(url);
        }

        //setUrl(url);
        try {

            // Navigate to app URL for browser test
            if (SeleniumTestsContextManager.isWebTest()) {
            	if(SeleniumTestsContextManager.isIeBrowser())
            	{
                driver.navigate().to(url);
                WebDriverWait wait = new WebDriverWait(driver, 10);      
        		Alert alert = wait.until(ExpectedConditions.alertIsPresent());     
        		alert.authenticateUsing(new UserAndPassword("wellington", "n0tgni113w"));
            	}
            	else 
            	{
            		String[] s1= url.split(":");
            		driver.navigate().to(s1[0]+"://"+"wellington:n0tgni113w@"+s1[1].replaceAll("//", ""));
            		driver.navigate().to(url);
            		System.out.println(SeleniumTestsContextManager.getBrowserHeight());
            		Dimension d = new Dimension(420,600);

            		//driver.manage().window().maximize();
            		
            		System.out.println(driver.manage().window().getSize());
            	}
            	 //driver.navigate().to(url);
            	Dimension d = new Dimension(SeleniumTestsContextManager.getBrowserWidth(),SeleniumTestsContextManager.getBrowserHeight());
            	//driver.manage().window().setSize(d);
            	driver.manage().window().maximize();
            	//Cookie name = new Cookie()
            	//driver.manage().deleteAllCookies();
            
            }
           
           
        } catch (UnreachableBrowserException e) {

            // handle if the last window is closed
            TestLogging.logWebStep(url, "Launch application", false);
            driver = webUXDriver.createWebDriver();
            maximizeWindow();
            driver.navigate().to(url);
        } catch (UnsupportedCommandException e) {
            TestLogging.log("get UnsupportedCommandException, retry");
            driver = webUXDriver.createWebDriver();
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

        // switchToDefaultContent();
    }

    private void populateAndCapturePageSnapshot() {
        try {
            setTitle(driver.getTitle());
            htmlSource = driver.getPageSource();
            try {
                bodyText = driver.findElement(By.tagName("body")).getText();
            } catch (StaleElementReferenceException ignore) {
                logger.warn("StaleElementReferenceException got in populateAndCapturePageSnapshot");
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

    public final void refresh() throws NotCurrentPageException {
        TestLogging.logWebStep(null, "refresh", false);
        logger.info("Refresh the page");
        try {
            driver.navigate().refresh();
        } catch (org.openqa.selenium.TimeoutException ex) {
            TestLogging.log("got time out customexception, ignore");
        }
    }

    public final void resizeTo(final int width, final int height) {
        new WebUtility(driver).resizeWindow(width, height);
    }

    public final void selectFrame(final int index) {
        TestLogging.logWebStep(null, "select frame using index" + index, false);
        driver.switchTo().frame(index);
        frameFlag = true;
    }

    public final void selectFrame(final By by) {
        TestLogging.logWebStep(null, "select frame, locator={\"" + by.toString() + "\"}", false);
        driver.switchTo().frame(driver.findElement(by));
        frameFlag = true;
    }

    public final void selectFrame(final String locator) {
        TestLogging.logWebStep(null, "select frame, locator={\"" + locator + "\"}", false);
        driver.switchTo().frame(locator);
        frameFlag = true;
    }

    public final void selectWindow() throws NotCurrentPageException {
        TestLogging.logWebStep(null, "select window, locator={\"" + getPopupWindowName() + "\"}", false);

        // selectWindow(getPopupWindowName());
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
        waitForSeconds(1);

        // Check whether it's the expected page.
        assertCurrentPage(true);
    }

    public final void selectWindow(final int index) throws NotCurrentPageException {
        TestLogging.logWebStep(null, "select window, locator={\"" + index + "\"}", false);
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[index]);
    }

    public final void selectNewWindow() throws NotCurrentPageException {
        TestLogging.logWebStep(null, "select new window", false);
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
        waitForSeconds(1);
    }

    protected void setHtmlSavedToPath(final String htmlSavedToPath) {
        this.htmlSavedToPath = htmlSavedToPath;
    }

    protected void setTitle(final String title) {
        this.title = title;
    }

    protected void setUrl(final String openUrl) {
        this.url = openUrl;
    }

    public void switchToDefaultContent() {
        try {
            driver.switchTo().defaultContent();
        } catch (UnhandledAlertException e) { }
    }

    @SuppressWarnings("deprecation")
	private void waitForPageToLoad() throws Exception {
        try {
            new Wait() {
                @Override
                public boolean until() {
                    try {
                        driver.switchTo().defaultContent();
                        return true;
                    } catch (UnhandledAlertException ex) {
                        WaitHelper.waitForSeconds(5);
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
    }

    public WebElement getElement(final By by, final String elementName) {
        WebElement element = null;
        try {
            element = driver.findElement(by);
        } catch (ElementNotFoundException e) {
            TestLogging.errorLogger(elementName + " is not found with locator - " + by.toString());
            throw e;
        }

        return element;
    }

    public String getElementUrl(final By by, final String name) {
        return getElement(by, name).getAttribute("href");
    }

    public String getElementText(final By by, final String name) {
        return getElement(by, name).getText();
    }

    public String getElementSrc(final By by, final String name) {
        return getElement(by, name).getAttribute("src");
    }
    
    //Method for galen test
    public boolean testPageLayout(List<String> tagsToBeTested)
    {
    	return layouttest.checklayout(tagsToBeTested);
    	
    }
    
    public void testPageLayout(List<String> browserSizes,List<String> tagsToBeTested)
    {
    	layouttest.checklayout(browserSizes, tagsToBeTested);
    }
    
    public boolean testPageLayout(String... tagsToBeTested)
    {
    	layouttest = new LayoutVAlidation(pageName);
    	return testPageLayout(Arrays.asList(tagsToBeTested));
    	
    }
}
