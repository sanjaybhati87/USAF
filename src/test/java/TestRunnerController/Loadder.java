/**
 * 
 */
package TestRunnerController;

import java.util.HashMap;
import java.util.Map;

import com.sapient.util.ExcelReader;



/**
 * @author ssi248
 *
 */
public class Loadder {
	static String file=".\\controller.xlsx";
	
	public static Map<String, RunMode> loadRunMode() throws Exception
	{
		String sheet="RunMode";
		int n;
		Map<String, RunMode> runModeMap= new HashMap<String, RunMode>();
		Object[][] runModeData= ExcelReader.getTableArray(file, sheet);
		for(int i=0; i<runModeData.length;i++)
		{
			RunMode runMode = new RunMode();
			//n=ExcelReader.getCellIndex(file, sheet, "Spec");
			runMode.setSpec((String) runModeData[i][ExcelReader.getCellIndex(file, sheet, "Spec")]);
			runMode.setRun((String) runModeData[i][ExcelReader.getCellIndex(file, sheet, "Run")]);
			runMode.setappUrl((String) runModeData[i][ExcelReader.getCellIndex(file, sheet, "appUrl")]);
			runMode.setBrowser((String) runModeData[i][ExcelReader.getCellIndex(file, sheet, "browser")]);
			runMode.setRunMode((String) runModeData[i][ExcelReader.getCellIndex(file, sheet, "RunMode")]);
			runMode.setWebwebDriverGrid((String) runModeData[i][ExcelReader.getCellIndex(file, sheet, "webDriverGrid")]);
			runMode.setSoftAssertEnabled((String) runModeData[i][ExcelReader.getCellIndex(file, sheet, "softAssertEnabled")]);
			runMode.setTestType((String) runModeData[i][ExcelReader.getCellIndex(file, sheet, "testType")]);
			runMode.setHtmlreportlogging((String) runModeData[i][ExcelReader.getCellIndex(file, sheet, "htmlreportlogging")]);
			runMode.setWebSessionTimeOut((String) runModeData[i][ExcelReader.getCellIndex(file, sheet, "webSessionTimeOut")]);
			runMode.setMaxConcurrentWebSessions((String) runModeData[i][ExcelReader.getCellIndex(file, sheet, "maxConcurrentWebSessions")]);
			runMode.setPlatform((String) runModeData[i][ExcelReader.getCellIndex(file, sheet, "platform")]);
			runMode.setMobilePlatformVersion((String) runModeData[i][ExcelReader.getCellIndex(file, sheet, "mobilePlatformversion")]);
			runMode.setDeviceName((String) runModeData[i][ExcelReader.getCellIndex(file, sheet, "deviceName")]);			
			runModeMap.put(runMode.getSpec(), runMode);
		}
		return runModeMap;
	}
	
	public static Map<String, Suite> loadSuite() throws Exception
	{
		String sheet="Suite";
		int n;
		Map<String, Suite> suiteMap= new HashMap<String, Suite>();
		Object[][] suiteData= ExcelReader.getTableArray(file, sheet);
		for(int i=0; i<suiteData.length;i++)
		{
			Suite suite = new Suite();
			n=ExcelReader.getCellIndex(file, sheet, "GroupName");
			suite.setSuiteName((String)suiteData[i][ExcelReader.getCellIndex(file, sheet, "SuiteName")]);
			suite.setRunFlag((String)suiteData[i][ExcelReader.getCellIndex(file, sheet, "RunFlag")]);
						
			suiteMap.put(suite.getSuiteName(), suite);
		}
		return suiteMap;
	}
	
	public static Map<String, Module> loadModules() throws Exception 
	{
		String sheet="Module";
		
		Map<String, Module> moduleMap= new HashMap<String, Module>();
		Object[][] moduleData= ExcelReader.getTableArray(file, sheet);
		for(int j=0; j<moduleData.length;j++)
		{
			Module module = new Module();
			module.setModuleName((String)moduleData[j][ExcelReader.getCellIndex(file, sheet, "ModuleName")]);
			module.setRunFlag((String)moduleData[j][ExcelReader.getCellIndex(file, sheet, "runFlag")]);
			module.setAppUrl((String)moduleData[j][ExcelReader.getCellIndex(file, sheet, "appUrl")]);
			module.setChrome((String)moduleData[j][ExcelReader.getCellIndex(file, sheet, "Chrome")]);
			module.setFirefox((String)moduleData[j][ExcelReader.getCellIndex(file, sheet, "FireFox")]);
			module.setIE((String)moduleData[j][ExcelReader.getCellIndex(file, sheet, "IE")]);
			module.setAppActivity((String)moduleData[j][ExcelReader.getCellIndex(file, sheet, "appActivity")]);
			module.setAppPackage((String)moduleData[j][ExcelReader.getCellIndex(file, sheet, "appPackage")]);
			module.setParallel((String)moduleData[j][ExcelReader.getCellIndex(file, sheet, "parallel")]);
			module.setPlatform((String)moduleData[j][ExcelReader.getCellIndex(file, sheet, "Platform")]);
			module.setMobilePlatformVersion((String)moduleData[j][ExcelReader.getCellIndex(file, sheet, "mobilePlatformVersion")]);
			module.setAndroid((String)moduleData[j][ExcelReader.getCellIndex(file, sheet, "Android")]);
			module.setIphone((String)moduleData[j][ExcelReader.getCellIndex(file, sheet, "Iphone")]);
			module.setDeviceName((String)moduleData[j][ExcelReader.getCellIndex(file, sheet, "deviceName")]);
			module.setTestType((String)moduleData[j][ExcelReader.getCellIndex(file, sheet, "TestType")]);
			moduleMap.put(module.getModuleName(), module);
		}
		return moduleMap;
	}
	
	public static Map<String, ExcelTestCase> loadTestCases() throws Exception 
	{
		String sheet="TestCases";
		Map<String, ExcelTestCase> testCaseMap= new HashMap<String, ExcelTestCase>();
		Object[][] testData= ExcelReader.getTableArray(file, sheet);
		for(int k=0; k<testData.length;k++)
		{
			ExcelTestCase excelTest = new ExcelTestCase();
			excelTest.setGroup((String) testData[k][ExcelReader.getCellIndex(file, sheet, "Suite")]);	
			excelTest.setModule((String) testData[k][ExcelReader.getCellIndex(file, sheet, "Module")]);
			excelTest.setAutomationClass((String) testData[k][ExcelReader.getCellIndex(file, sheet, "AutomationClass")]);
			excelTest.setTestCaseName((String) testData[k][ExcelReader.getCellIndex(file, sheet, "TestCase")]);
			excelTest.setTestMethod((String) testData[k][ExcelReader.getCellIndex(file, sheet, "TestMethod")]);
			excelTest.setMethodRunFlag((String) testData[k][ExcelReader.getCellIndex(file, sheet, "RunFlag")]);
			testCaseMap.put(excelTest.getTestMethod(), excelTest);
			
		}
		return testCaseMap;
	}
	

}
