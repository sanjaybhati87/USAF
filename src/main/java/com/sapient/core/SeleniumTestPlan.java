package com.sapient.core;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.xml.XmlTest;

import com.sapient.driver.WebUIDriver;
import com.sapient.webelements.PageObject;
import com.sapient.webpage.HomePage;
import com.sapient.webpage.LoginPage;

/**
 * This class initializes context, sets up and tears down and clean up drivers An STF test should extend this class.
 */
public abstract class SeleniumTestPlan {
	
    private static final Logger logger = TestLogging.getLogger(SeleniumTestPlan.class);
    private Date start;
    protected static WebDriver driver;

    /**
     * @param   testContext
     * @throws Exception 
     *
     * @throws  IOException
     */
    
   /* public SeleniumTestPlan() throws Exception
    {
    	loginPage = new LoginPage(true);
    	homePage = new HomePage(true);
    }*/
    @BeforeSuite(alwaysRun = true)
    public void beforeTestSuite(final ITestContext testContext) throws IOException {
        System.out.println("####################################################");
        System.out.println("WWW.SAPIENT.COM");
        System.out.println("####################################################");
        start = new Date();
        SeleniumTestsContextManager.initGlobalContext(testContext);
        SeleniumTestsContextManager.initThreadContext(testContext, null);
    }

    /**
     * Configure Test Params setting.
     *
     * @param  xmlTest
     */
    @BeforeTest(alwaysRun = true)
    public void beforeTest(final ITestContext testContext, final XmlTest xmlTest) {
        SeleniumTestsContextManager.initTestLevelContext(testContext, xmlTest);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeTestMethod(final Object[] parameters, final Method method, final ITestContext testContex,
            final XmlTest xmlTest) throws Exception {
        logger.info(Thread.currentThread() + " Start method " + method.getName());
        SeleniumTestsContextManager.initThreadContext(testContex, xmlTest);
        if (method != null) {
            SeleniumTestsContextManager.getThreadContext().setAttribute(SeleniumTestsContext.TEST_METHOD_SIGNATURE,
                buildMethodSignature(method, parameters));
            driver=WebUIDriver.getWebDriver();
            //driver.navigate().to("https://wellingtonfunds-staging.kurtosysweb.com");
            //PageObject.open("https://wellingtonfunds-staging.kurtosysweb.com");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void afterTestSuite() {
        logger.info("Test Suite Execution Time: " + (new Date().getTime() - start.getTime()) / 1000 / 60 + " minutes.");
    }

    /**
     * clean up.
     *
     * @param  parameters
     * @param  method
     * @param  testContex
     * @param  xmlTest
     */
    @AfterMethod(alwaysRun = true)
    public void afterTestMethod(final Object[] parameters, final Method method, final ITestContext testContex,
            final XmlTest xmlTest) {
        List<TearDownService> serviceList = SeleniumTestsContextManager.getThreadContext().getTearDownServices();
        if (serviceList != null && !serviceList.isEmpty()) {
            for (TearDownService service : serviceList) {
                service.tearDown();
            }
        }

        WebUIDriver.cleanUp();
        logger.info(Thread.currentThread() + " Finish method " + method.getName());
    }

    private String buildMethodSignature(final Method method, final Object[] parameters) {
        return method.getDeclaringClass().getCanonicalName() + "." + method.getName() + "("
                + buildParameterString(parameters) + ")";
    }

    /**
     * Remove name space from parameters.
     *
     * @param   parameters
     *
     * @return
     */
    private String buildParameterString(final Object[] parameters) {
        StringBuffer parameter = new StringBuffer();

        if (parameters != null) {
            for (int i = 0; i < parameters.length; i++) {
                if (parameters[i] == null) {
                    parameter.append("null, ");
                } else if (parameters[i] instanceof java.lang.String) {
                    parameter.append("\"").append(parameters[i]).append("\", ");
                } else {
                    parameter.append(parameters[i]).append(", ");
                }
            }
        }

        if (parameter.length() > 0) {
            parameter.delete(parameter.length() - 2, parameter.length() - 1);
        }

        return parameter.toString();
    }
}
