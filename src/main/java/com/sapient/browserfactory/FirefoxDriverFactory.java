package com.sapient.browserfactory;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sapient.core.TestLogging;
import com.sapient.driver.DriverConfig;



/**
 * @author ssi248
 *
 */
public class FirefoxDriverFactory extends AbstractWebDriverFactory implements IWebDriverFactory {
    private long timeout = 60;
    private static Logger logger = TestLogging.getLogger(FirefoxDriverFactory.class);

    /**
     * @param  cfg  the configuration of the firefoxDriver
     */
    public FirefoxDriverFactory(final DriverConfig cfg) {
        super(cfg);
    }

    /**
     * create native driver instance, designed for unit testing.
     *
     * @return
     */
    protected WebDriver createNativeDriver() {
    	logger.info("Initilize the frirefox driver creation, providing the capabilities defined in FirefoxCapabilities to the firefox");
    	 return new FirefoxDriver((Capabilities)new FirefoxCapabilitiesFactory().createCapabilities(this.webDriverConfig));
    }

    @Override
    public WebDriver createWebDriver() {
        DriverConfig cfg = this.getWebDriverConfig();

        logger.info("Start creating the firefoxDriver");
        driver = createWebDriverWithTimeout();

        logger.info("End creating the firefoxDriver");

        // Implicit Waits to handle dynamic element. The default value is 5
        // seconds.
        setImplicitWaitTimeout(cfg.getImplicitWaitTimeout());
        if (cfg.getPageLoadTimeout() >= 0) {
            setPageLoadTimeout(cfg.getPageLoadTimeout());
        }

        this.setWebDriver(driver);
        return driver;
    }

    /**
     * Create webDriver, capture socket customexception and retry with timeout.
     *
     * @return  WebDriver
     */
    protected WebDriver createWebDriverWithTimeout() {
        long time = 0;
        while (time < getTimeout()) {
            try {
                driver = createNativeDriver();
                return driver;
            } catch (WebDriverException ex) {
                if (ex.getMessage().contains("SocketException")
                        || ex.getMessage().contains("Failed to connect to binary FirefoxBinary")
                        || ex.getMessage().contains("Unable to bind to locking port 7054 within 45000 ms")) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) { }

                    time++;
                } else {
                    throw new RuntimeException(ex);
                }
            }
        }

        throw new RuntimeException("Got customexception when creating webDriver with socket timeout 1 minute");
    }

    /**
     * It's designed for shorten tiemout in unit testing.
     *
     * @return  timeout
     */
    protected long getTimeout() {
        return timeout;
    }

    protected void setPageLoadTimeout(final long timeout) {
        driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
    }
}
