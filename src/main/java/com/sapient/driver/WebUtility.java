package com.sapient.driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import com.sapient.core.TestLogging;

/**
 * @author ssi248
 *
 */
public class WebUtility {
    private WebDriver driver;

    public WebUtility(final WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Resize window to given dimensions.
     *
     * @param  width
     * @param  height
     */
    public void resizeWindow(final int width, final int height) {
        try {
            TestLogging.logWebStep(null, "Resize browser window to width " + width + " height " + height, false);

            Dimension size = new Dimension(width, height);
            driver.manage().window().setPosition(new Point(0, 0));
            driver.manage().window().setSize(size);
        } catch (Exception ex) { }
    }

    public void maximizeWindow() {
        try {
            BrowserType browser = BrowserType.getBrowserType(WebUIDriver.getWebUIDriver().getBrowser());
            if (browser == BrowserType.Android || browser == BrowserType.IPhone) {
                return;
            }

            driver.manage().window().maximize();
        } catch (Exception ex) {

            try {
                ((JavascriptExecutor) driver).executeScript(
                    "if (window.screen){window.moveTo(0, 0);window.resizeTo(window.screen.availWidth,window.screen.availHeight);}");
            } catch (Exception ignore) {
                TestLogging.log("Unable to maximize browser window. Exception occured: " + ignore.getMessage());
            }
        }
    }

    public static void main(final String[] args) {
        WebUIDriver.getWebUIDriver().setMode("ExistingGrid");
        WebUIDriver.getWebUIDriver().setHubUrl(" ");

        WebDriver driver = WebUIDriver.getWebDriver(true);
        System.out.print(driver.manage().window().getSize().width + ":" + driver.manage().window().getSize().height);
    }

}
