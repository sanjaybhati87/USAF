package com.sapient.browserfactory;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.sapient.driver.DriverConfig;

/**
 * Sets Android capabilities.
 */
/**
 * @author ssi248
 *
 */

public class AndroidCapabilitiesFactory implements ICapabilitiesFactory {

    public DesiredCapabilities createCapabilities(final DriverConfig cfg) {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("automationName", cfg.getAutomationName());
        capabilities.setCapability("platformName", cfg.getMobilePlatformName());

        // Set up version and device name else appium server would pick the only available emulator/device
        // Both of these are ignored for android for now
        capabilities.setCapability("platformVersion", cfg.getMobilePlatformVersion());
        capabilities.setCapability("deviceName", cfg.getDeviceName());

        capabilities.setCapability("app", cfg.getApp());
        capabilities.setCapability("appPackage", cfg.getAppPackage());
        capabilities.setCapability("appActivity", cfg.getAppActivity());
        capabilities.setCapability(CapabilityType.BROWSER_NAME, cfg.getBrowserName());
        capabilities.setCapability("newCommandTimeout", cfg.getNewCommandTimeout());

        return capabilities;
    }
}
