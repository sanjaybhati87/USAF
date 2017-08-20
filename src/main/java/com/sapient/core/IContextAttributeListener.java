package com.sapient.core;

import org.testng.ITestContext;

/**
 * @author ssi248
 *
 */
public interface IContextAttributeListener {
    void load(ITestContext testNGCtx, SeleniumTestsContext seleniumTestsCtx);
}
