package com.sapient.browserfactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.sapient.core.TestLogging;
import com.sapient.driver.DriverConfig;
import com.sapient.driver.WebUIDriver;

/**
 * @author ssi248
 *
 */
public abstract class AbstractWebDriverFactory {

    protected DriverConfig webDriverConfig;

    protected WebDriver driver;

    public AbstractWebDriverFactory(final DriverConfig cfg) {
        this.webDriverConfig = cfg;
    }

    public void cleanUp() {
        try {
            if (driver != null) {
                try {
                    TestLogging.log("quiting webdriver" + Thread.currentThread().getId());
                    driver.quit();
                } catch (WebDriverException ex) {
                    TestLogging.log("Exception encountered when quiting driver: "
                            + WebUIDriver.getWebUIDriver().getConfig().getBrowser().name() + ":" + ex.getMessage());
                }

                driver = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WebDriver createWebDriver() throws Exception {
        return null;
    }

    /**
     * Accessed by sub classes so that they don't have be declared abstract class.
     *
     * @return  driver instance
     */
    public WebDriver getWebDriver() {
        return driver;
    }

    public DriverConfig getWebDriverConfig() {
        return webDriverConfig;
    }

    public void setImplicitWaitTimeout(final double timeout) {
        if (timeout < 1) {
            driver.manage().timeouts().implicitlyWait((long) (timeout * 1000), TimeUnit.MILLISECONDS);
        } else {
            try {
                driver.manage().timeouts().implicitlyWait(new Double(timeout).intValue(), TimeUnit.SECONDS);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void setWebDriver(final WebDriver driver) {
        this.driver = driver;
    }

    public void setWebDriverConfig(final DriverConfig cfg) {
        this.webDriverConfig = cfg;
    }
}
