/**
 * 
 */
package com.sapient.browserfactory;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.sapient.driver.DriverConfig;

/**
 * @author ssi248
 *
 */
public class CapabilityPrectice extends AbstractWebDriverFactory {

	/**
	 * @param cfg
	 */
	public CapabilityPrectice(DriverConfig cfg) {
		super(cfg);
		// TODO Auto-generated constructor stub
	}
	public void setCapability()
	{
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setBrowserName(DesiredCapabilities.chrome().getBrowserName());
	cap.setPlatform(DesiredCapabilities.android().getPlatform());
	cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	cap.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
	cap.setCapability("ignoreZomeSeeting", true);
	cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
	}
	

}
