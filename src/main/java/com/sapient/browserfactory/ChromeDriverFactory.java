package com.sapient.browserfactory;


import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;

import com.sapient.core.TestLogging;
import com.sapient.driver.DriverConfig;



/**
 * @author ssi248
 *
 */
public class ChromeDriverFactory extends AbstractWebDriverFactory implements IWebDriverFactory {
	private static Logger logger = TestLogging.getLogger(ChromeDriverFactory.class);
    public ChromeDriverFactory(final DriverConfig cfg) {
        super(cfg);
    }

    protected WebDriver createNativeDriver() throws InvocationTargetException {
    	logger.info("Initilize the chrome driver creation, providing the capabilities defined in ChromeCapabilities to the chrome");
    	WebDriver driver= new ChromeDriver((Capabilities)new ChromeCapabilitiesFactory().createCapabilities(webDriverConfig));
    	//WebDriver driver= new ChromeDriver();
		return driver;
    }

    @Override
    public WebDriver createWebDriver()  {
        DriverConfig cfg = this.getWebDriverConfig();

        try {
        	 logger.info("Start creating the chromeDriver");
			driver = createNativeDriver();
			logger.info("End creating the chromeDriver");
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
        } catch (UnsupportedCommandException e) { }
    }

}
