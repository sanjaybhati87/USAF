package com.sapient.driver;


/**
 * @author ssi248
 *
 */
public enum TestType {

    WEB("web"),
    APP("app"),
    NON_GUI("NonGUI"),
    APPIUM_WEB_ANDROID("appium_web_android"),
    APPIUM_WEB_IOS("appium_web_ios");

    String testType;

    TestType(final String testType) {
        this.testType = testType;
    }

    public String getTestType() {
        return testType;
    }

}
