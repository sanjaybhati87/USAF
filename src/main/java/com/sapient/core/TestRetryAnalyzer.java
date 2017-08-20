package com.sapient.core;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author ssi248
 *
 */
public class TestRetryAnalyzer implements IRetryAnalyzer {

   // private static final String TEST_RETRY_COUNT = "testRetryCount";
    private int count = 1;
    private int maxCount ;
    //DriverConfig cfg = new Driver

    public TestRetryAnalyzer() {
    	//maxCount = SeleniumTestsContextManager.getThreadContext().getRetryCount();
        int retryMaxCount = SeleniumTestsContextManager.getThreadContext().getRetryCount();
       
            maxCount = retryMaxCount;
        }
    

    public void setMaxCount(final int count) {
        this.maxCount = count;
    }

    public int getCount() {
        return this.count;
    }

    public int getMaxCount() {
        return this.maxCount;
    }

    public synchronized boolean retry(final ITestResult result) {
        String testClassName = String.format("%s.%s", result.getMethod().getRealClass().toString(),
                result.getMethod().getMethodName());

        if (count <= maxCount) {
            result.setAttribute("RETRY", new Integer(count));

            TestLogging.log("[RETRYING] " + testClassName + " FAILED, " + "Retrying " + count + " time", true);

            count += 1;
            return true;
        }

        return false;
    }

}
