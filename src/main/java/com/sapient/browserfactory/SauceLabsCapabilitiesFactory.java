package com.sapient.browserfactory;

import com.sapient.core.SeleniumTestsContext;
import com.sapient.core.SeleniumTestsContextManager;
import com.sapient.driver.DriverConfig;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author ssi248
 *
 */
public class SauceLabsCapabilitiesFactory implements ICapabilitiesFactory {
    @Override
    public DesiredCapabilities createCapabilities(final DriverConfig cfg) {

        final DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("browserName", cfg.getBrowserName());
        capabilities.setCapability("platform", cfg.getPlatform());
        capabilities.setCapability("version", cfg.getVersion());
        capabilities.setCapability("name",
            SeleniumTestsContextManager.getThreadContext().getAttribute(SeleniumTestsContext.TEST_METHOD_SIGNATURE));

        return capabilities;
    }
}
