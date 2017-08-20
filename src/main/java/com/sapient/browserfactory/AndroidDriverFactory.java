package com.sapient.browserfactory;

import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;

import com.sapient.driver.DriverConfig;

import io.appium.java_client.android.AndroidDriver;

/**
 * AndroidDriverFactory.
 */
/**
 * @author ssi248
 *
 */
public class AndroidDriverFactory extends AbstractWebDriverFactory implements IWebDriverFactory {

    public AndroidDriverFactory(final DriverConfig webDriverConfig) {
        super(webDriverConfig);
    }

    protected WebDriver createNativeDriver() throws MalformedURLException {

        return new AndroidDriver(new URL(webDriverConfig.getAppiumServerURL()), new AndroidCapabilitiesFactory()
                    .createCapabilities(webDriverConfig));
    }

    @Override
    public WebDriver createWebDriver() throws IOException {
        DriverConfig cfg = this.getWebDriverConfig();

        driver = createNativeDriver();

        setImplicitWaitTimeout(cfg.getImplicitWaitTimeout());
        if (cfg.getPageLoadTimeout() >= 0) {
            setPageLoadTimeout(cfg.getPageLoadTimeout());
        }

        this.setWebDriver(driver);
        return driver;
    }

    protected void setPageLoadTimeout(final long timeout) {
        try {
            driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
        } catch (UnsupportedCommandException e) {
        }
    }

}
