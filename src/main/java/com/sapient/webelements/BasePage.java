package com.sapient.webelements;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sapient.core.CustomAssertion;
import com.sapient.core.TestLogging;
import com.sapient.customexception.NotCurrentPageException;
import com.sapient.driver.BrowserType;
import com.sapient.driver.WebUIDriver;
import com.sapient.helper.WaitHelper;
import com.thoughtworks.selenium.SeleniumException;
import com.thoughtworks.selenium.Wait;
import com.thoughtworks.selenium.webdriven.JavascriptLibrary;
import com.thoughtworks.selenium.webdriven.Windows;

import net.sourceforge.htmlunit.corejs.javascript.Function;


/**
 * Base html page abstraction. Used by PageObject and WebPageSection
 */
public abstract class BasePage {

	private static Logger logger = TestLogging.getLogger(BasePage.class);
  // protected static WebDriver driver = WebUIDriver.getWebDriver();
	protected static WebDriver driver;
    protected final static WebUIDriver webUXDriver = WebUIDriver.getWebUIDriver();
    private int explictWaitTimeout = WebUIDriver.getWebUIDriver()
        .getExplicitWait();
    private int sessionTimeout = WebUIDriver.getWebUIDriver()
        .getWebSessionTimeout();
  

    public BasePage(WebDriver driver) {
    	this.driver=driver;
    	
    }

    public void acceptAlert() throws NotCurrentPageException {
    	 TestLogging.logWebStep(null, "accept alert present.", false);

         try {
             driver.switchTo().alert().accept();
             driver.switchTo().defaultContent();
         } catch (Exception ex) {
             assertAlertHTML(false, "accept alert present.");
         }
        
        
    }

    public void assertAlertPresent() {
        TestLogging.logWebStep(null, "assert alert present.", false);

        try {
            driver.switchTo().alert();
        } catch (Exception ex) {
            assertAlertHTML(false, "assert alert present.");
        }
    }

    public void assertAlertText(final String text) {
        TestLogging.logWebStep(null, "assert alert text.", false);

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assertAlertHTML(alertText.contains(text), "assert alert text.");
    }

    /**
     * @param  element
     * @param  attributeName
     * @param  value
     */
    public void assertAttribute(final HtmlElement element,
        final String attributeName, final String value) {
    	 TestLogging.logWebStep(null,
    	            "assert " + element.toHTML() + " attribute = " + attributeName +
    	            ", expectedValue ={" + value + "}.", false);
        logger.info( "assert " + element.toHTML() + " attribute = " + attributeName +
                ", expectedValue ={" + value + "}");
        String attributeValue = element.getAttribute(attributeName);

        assertHTML((value != null) && value.equals(attributeValue),
            element.toString() + " attribute = " + attributeName +
            ", expectedValue = {" + value + "}" + ", attributeValue = {" +
            attributeValue + "}");
    }

    public void assertAttributeContains(final HtmlElement element,
        final String attributeName, final String keyword) {
        TestLogging.logWebStep(null,
            "assert " + element.toHTML() + " attribute=" + attributeName +
            ", contains keyword = {" + keyword + "}.", false);
        logger.info("assert " + element.toHTML() + " attribute=" + attributeName +
            ", contains keyword = {" + keyword + "}.");

        String attributeValue = element.getAttribute(attributeName);

        assertHTML((attributeValue != null) && (keyword != null) &&
            attributeValue.contains(keyword),
            element.toString() + " attribute=" + attributeName +
            ", expected to contains keyword {" + keyword + "}" +
            ", attributeValue = {" + attributeValue + "}");
    }

    public void assertAttributeMatches(final HtmlElement element,
        final String attributeName, final String regex) {
        TestLogging.logWebStep(null,
            "assert " + element.toHTML() + " attribute=" + attributeName +
            ", matches regex = {" + regex + "}.", false);
        logger.info("assert " + element.toHTML() + " attribute=" + attributeName +
            ", matches regex = {" + regex + "}.");

        String attributeValue = element.getAttribute(attributeName);

        assertHTML((attributeValue != null) && (regex != null) &&
            attributeValue.matches(regex),
            element.toString() + " attribute=" + attributeName +
            " expected to match regex {" + regex + "}" +
            ", attributeValue = {" + attributeValue + "}");
    }

    public void assertConfirmationText(final String text) {
        TestLogging.logWebStep(null, "assert confirmation text.", false);

        Alert alert = driver.switchTo().alert();
        String seenText = alert.getText();

        assertAlertHTML(seenText.contains(text), "assert confirmation text.");
    }

    protected void assertCurrentPage(final boolean log)
        throws NotCurrentPageException {
    }

    public void assertElementNotPresent(final HtmlElement element) {
        TestLogging.logWebStep(null,
            "assert " + element.toHTML() + " is not present.", false);
        logger.info("assert " + element.toHTML() + " is not present.");
        assertHTML(!element.isElementPresent(), element.toString() + " found.");
        
    }

    public void assertElementPresent(final HtmlElement element) {
        TestLogging.logWebStep(null,
            "assert " + element.toHTML() + " is present.", false);
        logger.info("assert " + element.toHTML() + " is present.");
        assertHTML(element.isElementPresent(),
            element.toString() + " not found.");
    }

    public void assertElementEnabled(final HtmlElement element) {
        TestLogging.logWebStep(null,
            "assert " + element.toHTML() + " is enabled.", false);
        logger.info("assert " + element.toHTML() + " is enabled.");
        assertHTML(element.isEnabled(), element.toString() + " not found.");
    }

    public void assertElementNotEnabled(final HtmlElement element) {
        TestLogging.logWebStep(null,
            "assert " + element.toHTML() + " is not enabled.", false);
        logger.info("assert " + element.toHTML() + " is not enabled.");
        assertHTML(!element.isEnabled(), element.toString() + " not found.");
    }

    public void assertElementDisplayed(final HtmlElement element) {
        TestLogging.logWebStep(null,
            "assert " + element.toHTML() + " is displayed.", false);
        logger.info("assert " + element.toHTML() + " is displayed.");
        assertHTML(element.isDisplayed(), element.toString() + " not found.");
    }

    public void assertElementSelected(final HtmlElement element) {
        TestLogging.logWebStep(null,
            "assert " + element.toHTML() + " is selected.", false);
        logger.info("assert " + element.toHTML() + " is selected.");
        assertHTML(element.isSelected(), element.toString() + " not found.");
    }

    public void assertElementNotSelected(final HtmlElement element) {
        TestLogging.logWebStep(null,
            "assert " + element.toHTML() + " is NOT selected.", false);
        logger.info("assert " + element.toHTML() + " is NOT selected.");
        assertHTML(!element.isSelected(), element.toString() + " not found.");
    }

    public void assertCondition(final boolean condition, final String message) {
        TestLogging.logWebStep(null, "assert that " + message, false);
        assert condition;
    }

    void assertHTML(final boolean condition, final String message) {

        if (!condition) {
            capturePageSnapshot();
            CustomAssertion.assertTrue(condition, message);
        }
    }

    void assertAlertHTML(final boolean condition, final String message) {

        if (!condition) {
            CustomAssertion.assertTrue(condition, message);
        }
    }

    public void assertPromptText(final String text) {
        TestLogging.logWebStep(null, "assert prompt text.", false);
         logger.info( "assert prompt text.");
        Alert alert = driver.switchTo().alert();
        String seenText = alert.getText();
        assertAlertHTML(seenText.contains(text), "assert prompt text.");
    }

    public void assertTable(final Table table, final int row, final int col,
        final String text) {
        TestLogging.logWebStep(null,
            "assert text \"" + text + "\" equals " + table.toHTML() +
            " at (row, col) = (" + row + ", " + col + ").", false);
logger.info("assert text \"" + text + "\" equals " + table.toHTML() +
            " at (row, col) = (" + row + ", " + col + ").");
        String content = table.getContent(row, col);
        assertHTML((content != null) && content.equals(text),
            "Text= {" + text + "} not found on " + table.toString() +
            " at cell(row, col) = {" + row + "," + col + "}");
    }

    public void assertTableContains(final Table table, final int row,
        final int col, final String text) {
        TestLogging.logWebStep(null,
            "assert text \"" + text + "\" contains " + table.toHTML() +
            " at (row, col) = (" + row + ", " + col + ").", false);
logger.info("assert text \"" + text + "\" contains " + table.toHTML() +
            " at (row, col) = (" + row + ", " + col + ").");
        String content = table.getContent(row, col);
        assertHTML((content != null) && content.contains(text),
            "Text= {" + text + "} not found on " + table.toString() +
            " at cell(row, col) = {" + row + "," + col + "}");
    }

    public void assertTableMatches(final Table table, final int row,
        final int col, final String text) {
        TestLogging.logWebStep(null,
            "assert text \"" + text + "\" matches " + table.toHTML() +
            " at (row, col) = (" + row + ", " + col + ").", false);
        logger.info("assert text \"" + text + "\" matches " + table.toHTML() +
            " at (row, col) = (" + row + ", " + col + ").");

        String content = table.getContent(row, col);
        assertHTML((content != null) && content.matches(text),
            "Text= {" + text + "} not found on " + table.toString() +
            " at cell(row, col) = {" + row + "," + col + "}");
    }

    public void assertTextNotPresent(final String text) {
        TestLogging.logWebStep(null,
            "assert text \"" + text + "\" is not present.", false);
        logger.info("assert text \"" + text + "\" is not present.");
        assertHTML(!isTextPresent(text), "Text= {" + text + "} found.");
    }

    public void assertTextNotPresentIgnoreCase(final String text) {
        TestLogging.logWebStep(null,
            "assert text \"" + text + "\" is not present.(ignore case)", false);
        logger.info("assert text \"" + text + "\" is not present.(ignore case)");
        assertHTML(!getBodyText().toLowerCase().contains(text.toLowerCase()),
            "Text= {" + text + "} found.");
    }

    public void assertTextPresent(final String text) {
        TestLogging.logWebStep(null, "assert text \"" + text + "\" is present.",
            false);
        logger.info( "assert text \"" + text + "\" is present.");
        assertHTML(isTextPresent(text), "Text= {" + text + "} not found.");
    }

    public void assertTextPresentIgnoreCase(final String text) {
        TestLogging.logWebStep(null,
            "assert text \"" + text + "\" is present.(ignore case)", false);
        logger.info("assert text \"" + text + "\" is present.(ignore case)");
        assertHTML(getBodyText().toLowerCase().contains(text.toLowerCase()),
            "Text= {" + text + "} not found.");
    }

    public String cancelConfirmation() throws NotCurrentPageException {
        Alert alert = driver.switchTo().alert();
        String seenText = alert.getText();
        alert.dismiss();
        driver.switchTo().defaultContent();

        return seenText;
    }

    protected abstract void capturePageSnapshot();

    public Alert getAlert() {
        Alert alert = driver.switchTo().alert();

        return alert;
    }

    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        String seenText = alert.getText();

        return seenText;
    }

    private String getBodyText() {
        WebElement body = driver.findElement(By.tagName("body"));

        return body.getText();
    }

    public String getConfirmation() {
        Alert alert = driver.switchTo().alert();
        String seenText = alert.getText();

        return seenText;
    }

    public WebDriver getDriver() {
        driver = WebUIDriver.getWebDriver();

        return driver;

    }

    public String getPrompt() {
        Alert alert = driver.switchTo().alert();
        String seenText = alert.getText();

        return seenText;
    }

    public boolean isElementPresent(final By by) {
        int count = 0;

        try {
            count = WebUIDriver.getWebDriver().findElements(by).size();
        } catch (RuntimeException e) {

            if ((e instanceof InvalidSelectorException) ||
                    ((e.getMessage() != null) &&
                        e.getMessage().contains(
                            "TransformedEntriesMap cannot be cast to java.util.List"))) {
                TestLogging.log(
                    "InvalidSelectorException or CastException got, retry");
                WaitHelper.waitForSeconds(2);
                count = WebUIDriver.getWebDriver().findElements(by).size();
            } else {
                throw e;
            }
        }

        if (count == 0) {
            return false;
        }

        return true;

    }

    public boolean isFrame() {
        return false;
    }

    public boolean isTextPresent(final String text) {
        CustomAssertion.assertNotNull(text,
            "isTextPresent: text should not be null!");
        driver = WebUIDriver.getWebDriver();

        WebElement body = driver.findElement(By.tagName("body"));

        if (WebUIDriver.getWebUIDriver().getBrowser().equalsIgnoreCase(
                    BrowserType.HtmlUnit.getBrowserType())) {
            return body.getText().contains(text);
        }

        Boolean result = false;

        if (body.getText().contains(text)) {
            return true;
        }

        JavascriptLibrary js = new JavascriptLibrary();
        String script = js.getSeleniumScript("isTextPresent.js");

        result = (Boolean) ((JavascriptExecutor) driver).executeScript(
                "return (" + script + ")(arguments[0]);", text);

        // Handle the null case
        return Boolean.TRUE == result;
    }

    public void selectFrame(final By by) {
        TestLogging.logWebStep(null,
            "select frame, locator={\"" + by.toString() + "\"}", false);
        driver.switchTo().frame(driver.findElement(by));
    }

    /**
     * If current window is closed then use driver.switchTo.window(handle).
     *
     * @param   windowName
     *
     * @throws  com.seleniumtests.customexception.NotCurrentPageException
     */
    public final void selectWindow(final String windowName)
        throws NotCurrentPageException {

        if (windowName == null) {
            Windows windows = new Windows(driver);

            try {
                windows.selectBlankWindow(driver);
            } catch (SeleniumException e) {
                driver.switchTo().defaultContent();
            }

        } else {
            Windows windows = new Windows(driver);
            windows.selectWindow(driver, "name=" + windowName);
        }
    }

    public void waitForElementChecked(final HtmlElement element) {
        Assert.assertNotNull(element, "Element can't be null");
        TestLogging.logWebStep(null,
        		"Waiting for "+" " + element.toString() + " to be checked.", false);
        logger.info("Wait for " + element.toString() + " to be checked.");

        WebDriverWait wait = new WebDriverWait(driver, explictWaitTimeout);
        wait.until(ExpectedConditions.elementToBeSelected(element.getBy()));
    }

    public void waitForElementEditable(final HtmlElement element) {
        Assert.assertNotNull(element, "Element can't be null");
        TestLogging.logWebStep(null,
        		"Waiting for "+" " + element.toString() + " to be editable.", false);
        logger.info("wait for " + element.toString() + " to be editable.");

        WebDriverWait wait = new WebDriverWait(driver, explictWaitTimeout);
        wait.until(ExpectedConditions.elementToBeClickable(element.getBy()));
    }

    public void waitForElementPresent(final By by) {
        TestLogging.logWebStep(null,
        		"Waiting for "+" " + by.toString() + " to be present.", false);
        logger.info("wait for " + by.toString() + " to be present.");

        WebDriverWait wait = new WebDriverWait(driver, explictWaitTimeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForElementPresent(final By by, final int timeout) {
        TestLogging.logWebStep(null,
        		"Waiting for"+" " + by.toString() + " to be present.", false);
        logger.info("wait for " + by.toString() + " to be present.");
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForElementPresent(final HtmlElement element) {
        Assert.assertNotNull(element, "Element can't be null");
        TestLogging.logWebStep(null,
            "Waiting for "+" " + element.toString() + " to be present.", false);
logger.info("wait for " + element.toString() + " to be present.");
        WebDriverWait wait = new WebDriverWait(driver, explictWaitTimeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(
                element.getBy()));
    }

    public void waitForElementToBeVisible(final HtmlElement element) {
        Assert.assertNotNull(element, "Element can't be null");
        TestLogging.logWebStep(null,
            "Waiting  for "+" " + element.toString() + " to be visible.", false);
        logger.info("wait for " + element.toString() + " to be visible.");

        WebDriverWait wait = new WebDriverWait(driver, explictWaitTimeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                element.getBy()));
    }

    public void waitForElementToDisappear(final HtmlElement element) {
        Assert.assertNotNull(element, "Element can't be null");
        TestLogging.logWebStep(null,
        		"Waiting for "+" " + element.toString() + " to disappear.", false);
        logger.info("wait for " + element.toString() + " to disappear.");

        WebDriverWait wait = new WebDriverWait(driver, explictWaitTimeout);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                element.getBy()));
    }

    public void waitForPopup(final String locator) throws Exception {
        waitForPopUp(locator, sessionTimeout + "");
    }

    public void waitForPopUp(final String windowID, final String timeout) {
        final long millis = Long.parseLong(timeout);
        final String current = driver.getWindowHandle();
        final Windows windows = new Windows(driver);

        if (webUXDriver.getConfig().getBrowser() ==
                BrowserType.InternetExplore) {
            waitForSeconds(3);
        }

        new Wait() {
                @Override public boolean until() {

                    try {

                        if ("_blank".equals(windowID)) {
                            windows.selectBlankWindow(driver);
                        } else {
                            driver.switchTo().window(windowID);
                        }

                        return !"about:blank".equals(driver.getCurrentUrl());
                    } catch (SeleniumException e) {
                    } catch (NoSuchWindowException e) {
                    }

                    return false;
                }
            }.wait(String.format("Timed out waiting for %s. Waited %s",
                windowID, timeout), millis);

        driver.switchTo().window(current);

    }

    /**
     * Wait For seconds. Provide a value less than WebSessionTimeout i.e. 180 Seconds
     *
     * @param  seconds
     */
    protected void waitForSeconds(final int seconds) {
        WaitHelper.waitForSeconds(seconds);
    }

    public void waitForTextPresent(final HtmlElement element,
        final String text) {
        Assert.assertNotNull(text, "Text can't be null");
        TestLogging.logWebStep(null,
            "Waiting for text \"" + text + "\" to be present.", false);

        WebDriverWait wait = new WebDriverWait(driver, explictWaitTimeout);
        wait.until(ExpectedConditions.textToBePresentInElement(element.getBy(),
                text));
    }

    public void waitForTextPresent(final String text) {
        Assert.assertNotNull(text, "Text can't be null");
        TestLogging.logWebStep(null,
            "Wait for text \"" + text + "\" to be present.", false);

        boolean b = false;

        for (int millisec = 0; millisec < (explictWaitTimeout * 1000);
                millisec += 1000) {

            try {

                if ((isTextPresent(text))) {
                    b = true;

                    break;
                }
            } catch (Exception ignore) {
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        assertHTML(b,
            "Timed out waiting for text \"" + text + "\" to be there.");
    }

    public void waitForTextToDisappear(final String text) {
        Assert.assertNotNull(text, "Text can't be null");
        TestLogging.logWebStep(null,
            "Wait for text \"" + text + "\" to disappear.", false);
logger.info("wait for text \"" + text + "\" to disappear.");
        boolean textPresent = true;

        for (int millisec = 0; millisec < (explictWaitTimeout * 1000);
                millisec += 1000) {

            try {

                if (!(isTextPresent(text))) {
                    textPresent = false;

                    break;
                }
            } catch (Exception ignore) {
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        assertHTML(!textPresent,
            "Timed out waiting for text \"" + text + "\" to be gone.");
    }

    public void waitForTextToDisappear(final String text,
        int explicitWaitTimeout) {
        Assert.assertNotNull(text, "Text can't be null");
        TestLogging.logWebStep(null,
            "Wait for text \"" + text + "\" to disappear.", false);
        logger.info("wait for text \"" + text + "\" to disappear.");

        boolean textPresent = true;

        for (int millisec = 0; millisec < (explicitWaitTimeout * 1000);
                millisec += 1000) {

            try {

                if (!(isTextPresent(text))) {
                    textPresent = false;

                    break;
                }
            } catch (Exception ignore) {
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        assertHTML(!textPresent,
            "Timed out waiting for text \"" + text + "\" to be gone.");
    }
    

	public void scrollToBottomJS() throws InterruptedException {
		((JavascriptExecutor) driver)
		.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
	}
	public void movetToElementJavascript(By locator) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);",
				driver.findElement(locator));
	}
	
	public void pauseExecutionFor(long lTimeInMilliSeconds) {
		try {
			Thread.sleep(lTimeInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void fnDragAndDrop(By by) throws InterruptedException {
		WebElement Slider = driver.findElement(by);
		Actions moveSlider = new Actions(driver);
		moveSlider.clickAndHold(Slider);
		moveSlider.dragAndDropBy(Slider, 150, 0).build().perform();
	}
	
	public void mouseHover(By by)
	{
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(by);
		action.moveToElement(we).build().perform();
		 TestLogging.logWebStep(null,
		            "Mouse Hover On "+" " + we.toString(), false);
	}
	
	public void mouseHover(HtmlElement element)
	{
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(element.getBy());
		action.moveToElement(we).build().perform();
		 TestLogging.logWebStep(null,
		            "Mouse Hover On "+" " + element.toString(), false);
	}
	
	public void mouseHoverAndClick(HtmlElement element1,HtmlElement element2)
	{
		try
		{
		Actions action = new Actions(driver);
		WebElement we1 = driver.findElement(element1.getBy());
		WebElement we2 = driver.findElement(element2.getBy());
		action.moveToElement(we1).perform();
		action.moveToElement(we2);
		clickByJavaScript(we2);
		TestLogging.logWebStep(null,
	            "Mouse Hover On "+" " + element1.toString() +"and click on  "+element2.toString(), false);
		logger.info("Mouse Hover On "+" " + element1.toString() +"and click on  "+element2.toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.error("Error"+e.getMessage()+"Mouse Hover On "+" " + element1.toString() +"and click on  "+element2.toString());
		}
		
	}
	
	public static void scrollToElement(WebElement element) {
		logger.info("Scrolling to Element");
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", element);
	}

	public void clickByJavaScript(By locater)
	{
		waitForElementPresent(locater);
	WebElement element = driver.findElement(locater);
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", element);
	}
	
	public void clickByJavaScript(WebElement element)
	{
		//waitForElementPresent(locater);
	//WebElement element = driver.findElement(locater);
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", element);
	}
	
	public void clickByJavaScript(HtmlElement htmlelement)
	{
		waitForElementPresent(htmlelement);
	WebElement element = driver.findElement(htmlelement.getBy());
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", element);
	}
	
	public void waitForPageLoadByMe()
	{
	
	  WebDriverWait wait = new WebDriverWait(driver, 30);

	    wait.until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver wdriver) {
	            return ((JavascriptExecutor) driver).executeScript(
	                "return document.readyState"
	            ).equals("complete");
	        }
	    });
	}
	
	public void getHighLightedText()
	{
     ((JavascriptExecutor)driver).executeScript("return window.getSelection().toString();");
	}

}
