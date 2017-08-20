/**
 * 
 */
package com.sapient.webelements;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import com.sapient.core.RepositoryParser;
import com.sapient.driver.WebUIDriver;
import com.sapient.util.LayoutVAlidation;

/**
 * @author ssi248
 *
 */
public class DummyBasePage {
	
	public static final Logger logger = LogManager.getLogger(DummyBasePage.class.getName());
    protected static WebDriver driver;
    private int explictWaitTimeout = WebUIDriver.getWebUIDriver()
        .getExplicitWait();
    private int sessionTimeout = WebUIDriver.getWebUIDriver()
        .getWebSessionTimeout();
    public static RepositoryParser parser = new RepositoryParser();
    LayoutVAlidation layouttest;
    
    public DummyBasePage(WebDriver driver,String className) {
    	this.driver=driver;
    	layouttest = new LayoutVAlidation(className);
		
    }
    
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
    	return testPageLayout(Arrays.asList(tagsToBeTested));
    	
    }
    
    public boolean isElementPresent(By locator) {
		if (driver.findElements(locator).size() > 0) {
			return true;
		} else
			return false;
	}



	public void waitForElementPresent(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, explictWaitTimeout, 10);
			logger.info("waiting for locator " + locator);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			e.getStackTrace();
		}
		// driver.findElements((By) element).size()

	}

	public void moveToELement(By locator) {
		Actions build = new Actions(driver);
		build.moveToElement(driver.findElement(locator));
	}

	public void get(String Url) {
		driver.get(Url);
	}

	public void click(By locator) {
		findElement(locator).click();
	}

	public void type(By locator, String input) {
		findElement(locator).sendKeys(input);
	}
	public void RecoveryType(By locator, String input) {
		findElement(locator).sendKeys(input);
	}
	public void quit() {
		driver.quit();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public List<WebElement> findElements(By by) {
		// movetToElementJavascript(by);
		return driver.findElements(by);
	}

	public WebElement findElement(By by) {
		movetToElementJavascript(by);
		return driver.findElement(by);
	}

	public WebElement findElementWithoutMove(By by) {
		// movetToElementJavascript(by);
		return driver.findElement(by);
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public void close() {
		driver.close();
	}

	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	public TargetLocator switchTo() {
		return driver.switchTo();
	}

	public Navigation navigate() {
		return driver.navigate();

	}

	public Options manage() {
		return driver.manage();
	}

	public Select getSelect(By by) {
		return new Select(findElement(by));
	}

	public void scrollToBottomJS() throws InterruptedException {
		((JavascriptExecutor) driver)
		.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
	}

	public void clear(By by) {
		try
		{
		findElement(by).clear();
		}
		catch(Exception ex)
		{
			//invokeRecovery(ex)
		}
	}
	
	public void recoveryClear(By by)
	{
		Actions action = new Actions(driver);
		int lenText = findElement(by).getText().length();

		for(int i = 0; i < lenText; i++){
		  action.sendKeys(Keys.ARROW_LEFT);
		}
		action.build().perform();

		for(int i = 0; i < lenText; i++){
		  action.sendKeys(Keys.DELETE);
		}
		pauseExecutionFor(1000);
		action.build().perform();
	}

	public void movetToElementJavascript(By locator) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);",
				driver.findElement(locator));
	}

	public String getAttribute(By by, String name) {
		return findElement(by).getAttribute(name);
	}


	public String getText(By by) {
		return findElement(by).getText();
	}

	public void fnDragAndDrop(By by) throws InterruptedException {
		WebElement Slider = driver.findElement(by);
		Actions moveSlider = new Actions(driver);
		moveSlider.clickAndHold(Slider);
		moveSlider.dragAndDropBy(Slider, 150, 0).build().perform();
	}

	public Actions action() {
		return new Actions(driver);
	}

	public void pauseExecutionFor(long lTimeInMilliSeconds) {
		try {
			Thread.sleep(lTimeInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public boolean IsElementVisible(WebElement element) {
		return element.isDisplayed() ? true : false;
	}


	public boolean waitForElementToBeVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(locator));
		return IsElementVisible(element);
	}


	public boolean IsTitleEqual(By locator, int timeOut, String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.titleIs(title));
	}


	public boolean IsTitleContains(By locator, int timeOut, String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.titleContains(title));
	}


	public WebElement waitForElementToBeClickable(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(locator));
		return element;
	}


	public boolean waitForElementToBeInVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions
				.invisibilityOfElementLocated(locator));
	}

	public boolean waitForPageLoad() {
		boolean isLoaded = false;
		try {
			logger.info("Waiting For Page load via JS");
			ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					return ((JavascriptExecutor) driver).executeScript(
							"return document.readyState").equals("complete");
				}
			};
			WebDriverWait wait = new WebDriverWait(driver, explictWaitTimeout);
			wait.until(pageLoadCondition);
			isLoaded = true;
		} catch (Exception e) {
			logger.error("Error Occured waiting for Page Load "
					+ driver.getCurrentUrl());
		}
		return isLoaded;
	}

	public void selectFromList(List<WebElement> lstElementList,
			String sValueToBeSelected) throws Exception {
		logger.info("START OF FUNCTION->selectFromList");
		boolean flag = false;
		logger.info("Total element found --> " + lstElementList.size());
		logger.info("Value to be selected " + sValueToBeSelected + " from list"
				+ lstElementList);
		for (WebElement e : lstElementList) {
			logger.info(">>>>>>>>>>>>>" + e.getText() + "<<<<<<<<<<<<<<<");
			if (e.getText().equalsIgnoreCase(sValueToBeSelected)) {
				logger.info("Value matched in list as->" + e.getText());
				e.click();
				flag = true;
				break;
			}
		}
		if (flag == false) {
			throw new Exception("No match found in the list for value->"
					+ sValueToBeSelected);
		}
		logger.info("END OF FUNCTION->selectFromList");
	}

	public WebElement waitForElementToBeClickable(WebElement element,
			int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}


	public boolean retryingFindClick(By by) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 3) {
			try {
				driver.findElement(by).click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public boolean deleteAllCookies() {
		boolean IsDeleted = false;
		try {
			driver.manage().deleteAllCookies();
			IsDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return IsDeleted;
	}

	public static void scrollToElement(WebElement element) {
		logger.info("Scrolling to Element");
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", element);
	}

	public void turnOffImplicitWaits() {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	public void turnOnImplicitWaits() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void clickByJS(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public String takeSnapShotAndRetPath(ITestResult result) throws Exception {
		logger.info("INTO METHOD->Fn_TakeSnapShotAndRetPath");
		String FullSnapShotFilePath = "";

		try {
			logger.info("Take Screen shot started");
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			String sFilename = null;
			//sFilename = "Screenshot-" + getDateTime() + ".png";
			FullSnapShotFilePath = System.getProperty("user.dir")
					+ "\\Output\\ScreenShots\\" + sFilename;
			FullSnapShotFilePath="target/custom-test-reports/"+ result.getTestClass().getName()
                    + "_screenshot.png";
			FileUtils.copyFile(scrFile, new File(FullSnapShotFilePath));
		} catch (Exception e) {

		}

		return FullSnapShotFilePath;
	}


	public static String getDateTime() {
		String sDateTime = "";
		try {
			SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
			Date now = new Date();
			String strDate = sdfDate.format(now);
			String strTime = sdfTime.format(now);
			strTime = strTime.replace(":", "-");
			sDateTime = "D" + strDate + "_T" + strTime;
		} catch (Exception e) {
			System.err.println(e);
		}
		return sDateTime;
	}
}
