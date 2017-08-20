package com.sapient.driver;

import java.net.URISyntaxException;

import java.util.ArrayList;
import java.util.Date;

import org.openqa.selenium.Platform;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.sapient.browserfactory.*;
import com.sapient.core.SeleniumTestsContext;
import com.sapient.core.SeleniumTestsContextManager;
import com.sapient.core.TestLogging;
import com.sapient.customexception.CustomSeleniumTestsException;

/**
 * This class provides factory to create webDriver session.
 * @author ssi248
 *
 */
public class WebUIDriver {

    private static ThreadLocal<WebDriver> driverSession = new ThreadLocal<WebDriver>();
    private static ThreadLocal<WebUIDriver> uxDriverSession = new ThreadLocal<WebUIDriver>();
    private String node;
    private DriverConfig config = new DriverConfig();
    private WebDriver driver;
    private IWebDriverFactory webDriverBuilder;
    private String url = null;

    public String getNode() {
        return node;
    }

    public void setNode(final String node) {
        this.node = node;
    }

    public static void cleanUp() {
        IWebDriverFactory iWebDriverFactory = getWebUIDriver().webDriverBuilder;
        if (iWebDriverFactory != null) {
            iWebDriverFactory.cleanUp();
        } else {
            WebDriver driver = driverSession.get();
            if (driver != null) {
                try {
                    driver.quit();
                } catch (WebDriverException ex) {
                    ex.printStackTrace();
                }

                driver = null;
            }
        }

        driverSession.remove();
        uxDriverSession.remove();
    }

    /**
     * Returns native WebDriver which can be converted to RemoteWebDriver.
     *
     * @return  webDriver
     */
    public static WebDriver getNativeWebDriver() {
        return ((CustomEventFiringWebDriver) getWebDriver(false)).getWebDriver();
    }

    /**
     * Get EventFiringWebDriver.
     *
     * @return  webDriver
     */
    public static WebDriver getWebDriver() {
    	System.out.println("First Instance");
        return getWebDriver(false);
    }

    /**
     * Returns WebDriver instance Creates a new WebDriver Instance if it is null and isCreate is true.
     *
     * @param   isCreate  create webdriver or not
     *
     * @return
     */
    public static WebDriver getWebDriver(final Boolean isCreate) {
        if (driverSession.get() == null && isCreate) {
            try {
                getWebUIDriver().createWebDriver();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
System.out.println("Second Instance");
        return driverSession.get();
    }

    /**
     * Returns WebUIDriver instance Creates new WebUIDriver instance if it is null.
     *
     * @return
     */
    public static WebUIDriver getWebUIDriver() {
        if (uxDriverSession.get() == null) {
            uxDriverSession.set(new WebUIDriver());
        }
System.out.println("Third Instance");
        return uxDriverSession.get();
    }

    /**
     * Lets user set their own driver This can be retrieved as WebUIDriver.getWebDriver().
     *
     * @param  driver
     */
    public static void setWebDriver(final WebDriver driver) {
        if (driver == null) {
            driverSession.remove();
        } else {
            if (getWebUIDriver() == null) {
                new WebUIDriver();
            }

            driverSession.set(driver);
        }
    }

    public WebUIDriver() {
        init();
        uxDriverSession.set(this);
    }

    public WebUIDriver(final String browser, final String mode) {
        init();
        this.setBrowser(browser);
        this.setMode(mode);
        uxDriverSession.set(this);
    }

    public WebDriver createRemoteWebDriver(final String browser, final String mode) throws Exception {
        WebDriver driver = null;
        config.setBrowser(BrowserType.getBrowserType(browser));
        config.setMode(DriverMode.valueOf(mode));

        if (config.getMode() == DriverMode.ExistingGrid) {
            webDriverBuilder = new RemoteDriverFactory(this.config);
        } else {
            if (config.getBrowser() == BrowserType.FireFox) {
                webDriverBuilder = new FirefoxDriverFactory(this.config);
            } else if (config.getBrowser() == BrowserType.InternetExplore) {
                webDriverBuilder = new IEDriverFactory(this.config);
            } else if (config.getBrowser() == BrowserType.Chrome) {
                webDriverBuilder = new ChromeDriverFactory(this.config);
            } else if (config.getBrowser() == BrowserType.HtmlUnit) {
                webDriverBuilder = new HtmlUnitDriverFactory(this.config);
            } else if (config.getBrowser() == BrowserType.Safari) {
                webDriverBuilder = new SafariDriverFactory(this.config);
            } 
            else if (config.getBrowser() == BrowserType.SauceLabs) {
                webDriverBuilder = new SauceLabsDriverFactory(this.config);
            } else if (config.getBrowser() == BrowserType.Android) {
                webDriverBuilder = new AndroidDriverFactory(this.config);
            } else if (config.getBrowser() == BrowserType.IPhone) {
                webDriverBuilder = new IPhoneDriverFactory(this.config);
            } 
        else {
                throw new RuntimeException("Unsupported browser" + browser);
            }
        }

        synchronized (this.getClass()) {
            driver = webDriverBuilder.createWebDriver();
        }

        driver = handleListeners(driver);

        return driver;
    }

    protected WebDriver handleListeners(WebDriver driver) {
        ArrayList<WebDriverEventListener> listeners = config.getWebDriverListeners();
        if (listeners != null && listeners.size() > 0) {
            for (int i = 0; i < config.getWebDriverListeners().size(); i++) {
                driver = new CustomEventFiringWebDriver(driver).register(listeners.get(i));
            }
        }

        return driver;
    }

    public WebDriver createWebDriver() throws Exception {
        System.out.println(Thread.currentThread() + ":" + new Date() + ":::Start creating web driver instance: "
                + this.getBrowser());
     
        driver = createRemoteWebDriver(config.getBrowser().getBrowserType(), config.getMode().name());

        System.out.println(Thread.currentThread() + ":" + new Date() + ":::Finish creating web driver instance: "
                + this.getBrowser());

        driverSession.set(driver);
        return driver;
    }
    
    ///Recent change done for achiving uniformity
    
    public WebDriver getDriver() {
        driver = getWebDriver();

        return driver;

    }
    protected void setUrl(final String openUrl) {
        this.url = openUrl;
    }
    
    public final void maximizeWindow() {
        new WebUtility(driver).maximizeWindow();
    }
    
    
    
    
    /**
     * @return
     * @throws Exception
     * This method will provide the final driver that need to be used for testing an application under test
     */
    public  WebDriver createFinalDriver() throws Exception
    {
    	 if (this.getDriver() == null) {
            // TestLogging.logWebStep(url, "Launch application", false);
             driver = getWebUIDriver().createWebDriver();
         }
		return driver;
    }
    
    

    /**
     * @param url
     * @param driver
     * @throws Exception
     * This method is used to launch the application, on the driver which is provided by CREATEFIALDRIVER method
     */
    /*public void open(final String url, WebDriver driver) throws Exception {

        if (this.getDriver() == null) {
            TestLogging.logWebStep(url, "Launch application", false);
            driver = createWebDriver();
        }

        setUrl(url);
        try {

            // Navigate to app URL for browser test
            if (SeleniumTestsContextManager.isWebTest()) {
                driver.navigate().to(url);
            }
        } catch (UnreachableBrowserException e) {

            // handle if the last window is closed
            TestLogging.logWebStep(url, "Launch application", false);
            driver = createFinalDriver();
            maximizeWindow();
            driver.navigate().to(url);
        } catch (UnsupportedCommandException e) {
            TestLogging.log("get UnsupportedCommandException, retry");
            driver = createFinalDriver();
            maximizeWindow();
            driver.navigate().to(url);
        } catch (org.openqa.selenium.TimeoutException ex) {
            TestLogging.log("got time out when loading " + url + ", ignored");
        } catch (org.openqa.selenium.UnhandledAlertException ex) {
            TestLogging.log("got UnhandledAlertException, retry");
            driver.navigate().to(url);
        } catch (Throwable e) {
            e.printStackTrace();
            throw new CustomSeleniumTestsException(e);
        }
*/
        // switchToDefaultContent();
    
    
    
    
    
    
    
    
    
    public String getBrowser() {
        return config.getBrowser().getBrowserType();
    }

    public String getPlatform() {
        return config.getWebPlatform().name();
    }

    public String getBrowserVersion() {
        return config.getBrowserVersion();
    }

    public String getChromeBinPath() {
        return config.getChromeBinPath();
    }

    public String getChromeDriverPath() {
        return config.getChromeDriverPath();
    }

    public DriverConfig getConfig() {
        return config;
    }

    public int getExplicitWait() {
        return config.getExplicitWaitTimeout();
    }

    public String getFfBinPath() {
        return config.getFirefoxBinPath();
    }

    public String getFfProfilePath() throws URISyntaxException {
        return config.getFirefoxProfilePath();
    }

    public String getOperaProfilePath() throws URISyntaxException {
        return config.getOperaProfilePath();
    }

    public void setOperaProfilePath(final String operaProfilePath) {
        config.setOperaProfilePath(operaProfilePath);
    }

    public String getHubUrl() {
        return config.getHubUrl();
    }

    public String getIEDriverPath() {
        return config.getIeDriverPath();
    }

    public double getImplicitWait() {
        return config.getImplicitWaitTimeout();
    }

    public String getMode() {
        return config.getMode().name();
    }

    public String getOutputDirectory() {
        return config.getOutputDirectory();
    }

    public String getNtlmAuthTrustedUris() {
        return config.getNtlmAuthTrustedUris();
    }

    public void setNtlmAuthTrustedUris(final String url) {
        config.setNtlmAuthTrustedUris(url);
    }

    public int getPageLoadTimeout() {
        return config.getPageLoadTimeout();
    }

    public String getProxyHost() {
        return config.getProxyHost();
    }

    public void setUserAgentOverride(final String userAgentOverride) {
        config.setUserAgentOverride(userAgentOverride);
    }

    public String getUserAgentOverride() {
        return config.getUserAgentOverride();
    }

    public IWebDriverFactory getWebDriverBuilder() {
        return webDriverBuilder;
    }

    public int getWebSessionTimeout() {
        return config.getWebSessionTimeout();
    }

    private void init() {
        if (SeleniumTestsContextManager.getThreadContext() == null) {
            return;
        }
        //SeleniumTestsContext testLevelContext = SeleniumTestsContextManager.getTestLevelContext(testName);

        String browser = SeleniumTestsContextManager.getThreadContext().getWebRunBrowser();
        //String browser=testLevelContext.getWebRunBrowser();
        config.setBrowser(BrowserType.getBrowserType(browser));

        String mode = SeleniumTestsContextManager.getThreadContext().getWebRunMode();
        config.setMode(DriverMode.valueOf(mode));

        String hubUrl = SeleniumTestsContextManager.getThreadContext().getWebDriverGrid();
        config.setHubUrl(hubUrl);

        String ffProfilePath = SeleniumTestsContextManager.getThreadContext().getFirefoxUserProfilePath();
        config.setFfProfilePath(ffProfilePath);

        String operaProfilePath = SeleniumTestsContextManager.getThreadContext().getOperaUserProfilePath();
        config.setOperaProfilePath(operaProfilePath);

        String ffBinPath = SeleniumTestsContextManager.getThreadContext().getFirefoxBinPath();
        config.setFfBinPath(ffBinPath);

        String chromeBinPath = SeleniumTestsContextManager.getThreadContext().getChromeBinPath();
        config.setChromeBinPath(chromeBinPath);

        String chromeDriverPath = SeleniumTestsContextManager.getThreadContext().getChromeDriverPath();
        config.setChromeDriverPath(chromeDriverPath);

        String ieDriverPath = SeleniumTestsContextManager.getThreadContext().getIEDriverPath();
        config.setIeDriverPath(ieDriverPath);

        int webSessionTimeout = SeleniumTestsContextManager.getThreadContext().getWebSessionTimeout();
        config.setWebSessionTimeout(webSessionTimeout);

        double implicitWaitTimeout = SeleniumTestsContextManager.getThreadContext().getImplicitWaitTimeout();
        config.setImplicitWaitTimeout(implicitWaitTimeout);

        int explicitWaitTimeout = SeleniumTestsContextManager.getThreadContext().getExplicitWaitTimeout();
        config.setExplicitWaitTimeout(explicitWaitTimeout);
        config.setPageLoadTimeout(SeleniumTestsContextManager.getThreadContext().getPageLoadTimeout());

        String outputDirectory = SeleniumTestsContextManager.getGlobalContext().getOutputDirectory();
        config.setOutputDirectory(outputDirectory);

        if (SeleniumTestsContextManager.getThreadContext().isWebProxyEnabled()) {
            String proxyHost = SeleniumTestsContextManager.getThreadContext().getWebProxyAddress();
            config.setProxyHost(proxyHost);
        }

        String browserVersion = SeleniumTestsContextManager.getThreadContext().getWebBrowserVersion();
        config.setBrowserVersion(browserVersion);

        String webPlatform = SeleniumTestsContextManager.getThreadContext().getWebPlatform();
        if (webPlatform != null) {
            config.setWebPlatform(Platform.valueOf(webPlatform));
        }

        if ("false".equalsIgnoreCase(
                    (String) SeleniumTestsContextManager.getThreadContext().getAttribute(
                        SeleniumTestsContext.Set_Assume_Untrusted_Certificate_Issuer))) {
            config.setSetAssumeUntrustedCertificateIssuer(false);
        }

        if ("false".equalsIgnoreCase(
                    (String) SeleniumTestsContextManager.getThreadContext().getAttribute(
                        SeleniumTestsContext.Set_Accept_Untrusted_Certificates))) {
            config.setSetAcceptUntrustedCertificates(false);
        }

        if ("false".equalsIgnoreCase(
                    (String) SeleniumTestsContextManager.getThreadContext().getAttribute(
                        SeleniumTestsContext.ENABLE_JAVASCRIPT))) {
            config.setEnableJavascript(false);
        }

        if (SeleniumTestsContextManager.getThreadContext().getNtlmAuthTrustedUris() != null) {
            config.setNtlmAuthTrustedUris(SeleniumTestsContextManager.getThreadContext().getNtlmAuthTrustedUris());
        }

        if (SeleniumTestsContextManager.getThreadContext().getBrowserDownloadDir() != null) {
            config.setBrowserDownloadDir(SeleniumTestsContextManager.getThreadContext().getBrowserDownloadDir());
        }

        if (SeleniumTestsContextManager.getThreadContext().getAddJSErrorCollectorExtension() != null) {
            config.setAddJSErrorCollectorExtension(Boolean.parseBoolean(
                    SeleniumTestsContextManager.getThreadContext().getAddJSErrorCollectorExtension()));
        }

        String ua = null;
        if (SeleniumTestsContextManager.getThreadContext().getUserAgent() != null) {
            ua = SeleniumTestsContextManager.getThreadContext().getUserAgent();
        } else {
            ua = null;
        }

        config.setUserAgentOverride(ua);

        String listeners = SeleniumTestsContextManager.getThreadContext().getWebDriverListener();
        if (SeleniumTestsContextManager.getThreadContext().getEnableExceptionListener()) {
            if (listeners != null) {
                listeners = listeners + ",";
            } else {
                listeners = "";
            }

            listeners = listeners + DriverExceptionListener.class.getName();
        }

        if (listeners != null && !listeners.equals("")) {
            config.setWebDriverListeners(listeners);
        } else {
            config.setWebDriverListeners("");
        }

        config.setUseFirefoxDefaultProfile(SeleniumTestsContextManager.getThreadContext().isUseFirefoxDefaultProfile());

        String size = SeleniumTestsContextManager.getThreadContext().getBrowserWindowSize();
        if (size != null) {
            int width = -1;
            int height = -1;
            try {
                width = Integer.parseInt(size.split(",")[0].trim());
                height = Integer.parseInt(size.split(",")[1].trim());
            } catch (Exception ex) { }

            config.setBrowserWindowWidth(width);
            config.setBrowserWindowHeight(height);
        }

        String appiumServerURL = SeleniumTestsContextManager.getThreadContext().getAppiumServerURL();
        config.setAppiumServerURL(appiumServerURL);

        String automationName = SeleniumTestsContextManager.getThreadContext().getAutomationName();
        config.setAutomationName(automationName);

        String mobilePlatformName = SeleniumTestsContextManager.getThreadContext().getMobilePlatformName();
        config.setMobilePlatformName(mobilePlatformName);

        String mobilePlatformVersion = SeleniumTestsContextManager.getThreadContext().getMobilePlatformVersion();
        config.setMobilePlatformVersion(mobilePlatformVersion);

        String deviceName = SeleniumTestsContextManager.getThreadContext().getDeviceName();
        config.setDeviceName(deviceName);

        String app = SeleniumTestsContextManager.getThreadContext().getApp();
        config.setApp(app);

        String browserName = SeleniumTestsContextManager.getThreadContext().getBrowserName();
        config.setBrowserName(browserName);

        String appPackage = SeleniumTestsContextManager.getThreadContext().getAppPackage();
        config.setAppPackage(appPackage);

        String appActivity = SeleniumTestsContextManager.getThreadContext().getAppActivity();
        config.setAppActivity(appActivity);

        String newCommandTimeOut = SeleniumTestsContextManager.getThreadContext().getNewCommandTimeout();
        config.setNewCommandTimeout(newCommandTimeOut);

        config.setVersion(SeleniumTestsContextManager.getThreadContext().getVersion());
        config.setPlatform(SeleniumTestsContextManager.getThreadContext().getPlatform());
        config.setSauceLabsURL(SeleniumTestsContextManager.getThreadContext().getSaucelabsURL());
        config.setTestType(SeleniumTestsContextManager.getThreadContext().getTestType());
        config.setRetryCount(SeleniumTestsContextManager.getThreadContext().getRetryCount());
    }

    public static void main(final String[] args) {
        System.out.println(DriverExceptionListener.class.getName());
    }

    public boolean isSetAcceptUntrustedCertificates() {
        return config.isSetAcceptUntrustedCertificates();
    }

    public boolean isAddJSErrorCollectorExtension() {
        return config.isAddJSErrorCollectorExtension();
    }

    public void setAddJSErrorCollectorExtension(final Boolean addJSErrorCollectorExtension) {
        config.setAddJSErrorCollectorExtension(addJSErrorCollectorExtension);
    }

    public boolean isSetAssumeUntrustedCertificateIssuer() {
        return config.isSetAssumeUntrustedCertificateIssuer();
    }

    public boolean isEnableJavascript() {
        return config.isEnableJavascript();
    }

    public void setEnableJavascript(final Boolean enableJavascript) {
        config.setEnableJavascript(enableJavascript);
    }

    public void setBrowser(final String browser) {
        config.setBrowser(BrowserType.getBrowserType(browser));

    }

    public void setBrowserVersion(final String browserVersion) {
        config.setBrowserVersion(browserVersion);
    }

    public void setPlatform(final String platform) {
        config.setWebPlatform(Platform.valueOf(platform));
    }

    public void setChromeBinPath(final String chromeBinPath) {
        config.setChromeBinPath(chromeBinPath);
    }

    public void setBrowserDownloadDir(final String browserDownloadDir) {
        config.setBrowserDownloadDir(browserDownloadDir);
    }

    public String getBrowserDownloadDir() {
        return config.getBrowserDownloadDir();
    }

    public void setChromeDriverPath(final String chromeDriverPath) {
        config.setChromeDriverPath(chromeDriverPath);
    }

    public void setConfig(final DriverConfig config) {
        this.config = config;
    }

    public void setExplicitTimeout(final int explicitWaitTimeout) {
        config.setExplicitWaitTimeout(explicitWaitTimeout);
    }

    public void setFfBinPath(final String ffBinPath) {
        config.setFfBinPath(ffBinPath);
    }

    public void setFfProfilePath(final String ffProfilePath) {
        config.setFfProfilePath(ffProfilePath);
    }

    public void setHubUrl(final String hubUrl) {
        config.setHubUrl(hubUrl);
    }

    public void setIEDriverPath(final String ieDriverPath) {
        config.setIeDriverPath(ieDriverPath);
    }

    public void setImplicitlyWaitTimeout(final double implicitTimeout) {
        config.setImplicitWaitTimeout(implicitTimeout);
    }

    public void setMode(final String mode) {
        config.setMode(DriverMode.valueOf(mode));
    }

    public void setOutputDirectory(final String outputDirectory) {
        config.setOutputDirectory(outputDirectory);
    }

    public void setPageLoadTimeout(final int pageLoadTimeout) {
        config.setPageLoadTimeout(pageLoadTimeout);
    }

    public void setProxyHost(final String proxyHost) {
        config.setProxyHost(proxyHost);
    }

    public void setSetAcceptUntrustedCertificates(final boolean setAcceptUntrustedCertificates) {
        config.setSetAcceptUntrustedCertificates(setAcceptUntrustedCertificates);
    }

    public void setSetAssumeUntrustedCertificateIssuer(final boolean setAssumeUntrustedCertificateIssuer) {
        config.setSetAssumeUntrustedCertificateIssuer(setAssumeUntrustedCertificateIssuer);
    }

    public void setWebDriverBuilder(final IWebDriverFactory builder) {
        this.webDriverBuilder = builder;
    }

    public void setWebSessionTimeout(final int webSessionTimeout) {
        config.setWebSessionTimeout(webSessionTimeout);
    }
}
