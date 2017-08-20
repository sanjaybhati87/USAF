/*package com.sapient.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sapient.core.TestLogging;
import com.sapient.driver.ScreenShot;
import com.sapient.driver.ScreenshotUtil;

*//**
 * @author ssi248
 *
 *//*
public abstract class WebPageSection extends BasePage {

    private String name = null;
    private String locator = null;
    protected WebElement element = null;
    private By by = null;

    public WebPageSection(final String name) {
        super();
        this.name = name;
    }

    public WebPageSection(final String name, final By by) {
        super();
        this.name = name;
        this.by = by;
    }

    *//**
     * Captures page snapshot.
     *//*
    public void capturePageSnapshot() {

        ScreenShot screenShot = new ScreenshotUtil(driver).captureWebPageSnapshot();
        String title = screenShot.getTitle();
        String url = screenShot.getLocation();

        TestLogging.logWebOutput(url, title + " (" + TestLogging.buildScreenshotLog(screenShot) + ")", false);
    }

    public String getLocator() {
        return locator;
    }

    public String getName() {
        return name;
    }

    public By getBy() {
        return by;
    }

    public boolean isPageSectionPresent() {
        return isElementPresent(by);
    }
}
*/