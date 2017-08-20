package com.sapient.browserfactory;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.sapient.driver.DriverConfig;

/**
 * @author ssi248
 *
 */
public interface ICapabilitiesFactory {

    DesiredCapabilities createCapabilities(DriverConfig cfg);

}
