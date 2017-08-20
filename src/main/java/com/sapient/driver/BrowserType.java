package com.sapient.driver;

/**
 * @author ssi248
 *
 */
public enum BrowserType {
    FireFox("*firefox"),
    InternetExplore("*iexplore"),
    Chrome("*chrome"),
    HtmlUnit("*htmlunit"),
    Safari("*safari"),
    Android("*android"),
    IPhone("*iphone"),
    PhantomJS("*phantomjs"),
    SauceLabs("*saucelabs");

    public static BrowserType getBrowserType(final String browserType) {
        if (browserType.equalsIgnoreCase("*firefox") || browserType.equalsIgnoreCase("firefox")) {
            return BrowserType.FireFox;
        } else if (browserType.equalsIgnoreCase("*iexplore") || browserType.equalsIgnoreCase("iexplore")) {
            return BrowserType.InternetExplore;
        } else if (browserType.equalsIgnoreCase("*chrome") || browserType.equalsIgnoreCase("chrome")) {
            return BrowserType.Chrome;
        } else if (browserType.equalsIgnoreCase("*htmlunit") || browserType.equalsIgnoreCase("htmlunit")) {
            return BrowserType.HtmlUnit;
        } else if (browserType.equalsIgnoreCase("*safari") || browserType.equalsIgnoreCase("safari")) {
            return BrowserType.Safari;
        } else if (browserType.equalsIgnoreCase("*android") || browserType.equalsIgnoreCase("android")) {
            return BrowserType.Android;
        } else if (browserType.equalsIgnoreCase("*iphone") || browserType.equalsIgnoreCase("iphone")) {
            return BrowserType.IPhone;
        }else if (browserType.equalsIgnoreCase("*phantomjs") || browserType.equalsIgnoreCase("phantomjs")) {
            return BrowserType.PhantomJS;
        } else if (browserType.equalsIgnoreCase("*saucelabs") || browserType.equalsIgnoreCase("saucelabs")) {
            return BrowserType.SauceLabs;
        } else {
            return BrowserType.FireFox;
        }
    }

    private String browserType;

    BrowserType(final String type) {
        this.browserType = type;
    }

    public String getBrowserType() {
        return this.browserType;
    }

}
