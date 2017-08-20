/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  org.testng.xml.XmlClass
 *  org.testng.xml.XmlSuite
 *  org.testng.xml.XmlTest
 */
package TestRunnerController;



public class ExcelTestCase {
    public String group;
	public String module;
	public String browser;
    public String automationClass;
    public String TestCaseName;
    public String TestMethod;
    public String methodRunFlag;
    /**
	 * @return the browser
	 */
	public String getBrowser() {
		return browser;
	}

	/**
	 * @param browser the browser to set
	 */
	public void setBrowser(String browser) {
		this.browser = browser;
	}


	public String param;
    
    
    /**
	 * @return the param
	 */
	

    /**
	 * @return the module
	 */
	public String getModule() {
		return module;
	}

	/**
	 * @return the param
	 */
	public String getParam() {
		return param;
	}

	/**
	 * @param param the param to set
	 */
	public void setParam(String param) {
		this.param = param;
	}

	/**
	 * @param module the module to set
	 */
	public void setModule(String module) {
		this.module = module;
	}

	/**
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(String group) {
		this.group = group;
	}

	/**
	 * @return the automationClass
	 */
	public String getAutomationClass() {
		return automationClass;
	}

	/**
	 * @param automationClass the automationClass to set
	 */
	public void setAutomationClass(String automationClass) {
		this.automationClass = automationClass;
	}

	/**
	 * @return the methodRunFlag
	 */
	public String getMethodRunFlag() {
		return methodRunFlag;
	}

	/**
	 * @param methodRunFlag the methodRunFlag to set
	 */
	public void setMethodRunFlag(String methodRunFlag) {
		this.methodRunFlag = methodRunFlag;
	}

	/**
	 * @return the testCaseName
	 */
	public String getTestCaseName() {
		return TestCaseName;
	}

	/**
	 * @param testCaseName the testCaseName to set
	 */
	public void setTestCaseName(String testCaseName) {
		TestCaseName = testCaseName;
	}

	/**
	 * @return the testMethod
	 */
	public String getTestMethod() {
		return TestMethod;
	}

	/**
	 * @param testMethod the testMethod to set
	 */
	public void setTestMethod(String testMethod) {
		TestMethod = testMethod;
	}
  

    public String toString() {
    	 return "ExcelTestCase [GroupName: " + this.group + ",ModuleName: " + this.module + ",Browser"+ this.browser+ ",Suite Parameters: " + this.param+ ",AutomationClass: " + this.automationClass +  ", TestCaseName: " + this.TestCaseName + ", AutomationMethod: " + this.TestMethod +  ", MethodRunFlag: " + this.methodRunFlag + "]";
    }
}

