package com.sapient.browserfactory;

import org.openqa.selenium.WebDriver;

import com.sapient.driver.DriverConfig;

/**
 * @author ssi248
 *
 */
public interface IWebDriverFactory {

    void cleanUp();

    WebDriver createWebDriver() throws Exception;

    WebDriver getWebDriver();

    DriverConfig getWebDriverConfig();
}
