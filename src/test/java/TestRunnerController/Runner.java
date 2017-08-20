/**
 * 
 */
package TestRunnerController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author ssi248
 *
 */
public class Runner {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static RunMode runmode= new RunMode();
	
		public static List<String> getSuiteToBeRun() throws Exception
		{
		Map<String, Suite> suiteMap=Loadder.loadSuite();
		List<String> suiteToBeRun = new ArrayList<String>();
		for(String s: suiteMap.keySet())
		{
			Suite suite= suiteMap.get(s);
			if(suite.getRunFlag().equalsIgnoreCase("Yes"))
			{
				suiteToBeRun.add(suite.getSuiteName().trim());
			}
		}
		return suiteToBeRun;
		}
		
		public static String getRunMode() throws Exception
		{
			Map<String, RunMode> runModeMap=Loadder.loadRunMode();
			String mode=null;
			for(String s: runModeMap.keySet())
			{
				RunMode spec = runModeMap.get(s);
						if(spec.getSpec().equalsIgnoreCase("Module"))
							mode= "Module";
						else mode= "Group";
			}
			return mode;
			
		}
		
		public static Set<String> getActiveModule() throws Exception
		{
			Set<String> activeModule= new HashSet<String>();
			Map<String, Module> modulemap=	Loadder.loadModules();
			//System.out.println(modulemap);
			for(String s: modulemap.keySet()){
				Module m = modulemap.get(s);
				if(m.getRunFlag().equalsIgnoreCase("Yes")){
					if(m.getFirefox().equalsIgnoreCase("Yes"))
					{
					activeModule.add(m.getModuleName().trim()+" "+"Firefox");
					}
					 if(m.getChrome()!=null &&m.getChrome().equalsIgnoreCase("Yes"))
					{
						activeModule.add(m.getModuleName().trim()+" "+"Chrome");	
					}
					 if(m.getIE().equalsIgnoreCase("Yes"))
					{
						activeModule.add(m.getModuleName().trim()+" "+"IE");	
					}
					 if(m.getAndroid().equalsIgnoreCase("Yes"))
						{
							activeModule.add(m.getModuleName().trim()+" "+"Android");	
						}
					 if(m.getIphone().equalsIgnoreCase("Yes"))
						{
							activeModule.add(m.getModuleName().trim()+" "+"Iphone");	
						}
				}
		}
			return activeModule;
		}
		
		public static Set<String> getAllClasses() throws Exception
		{
			Set<String> enabledClasses = new HashSet<String>();
			//System.out.println(Master.getSpecification());
			//System.out.println(spec.trim().equalsIgnoreCase("Feature"));
				//if(spec.trim().equalsIgnoreCase("Feature"))
					if(getRunMode().equalsIgnoreCase("Module"))
			{
				 Map<String, ExcelTestCase> testCasemap=	Loadder.loadTestCases();
					for(String sm: testCasemap.keySet())
					{
						ExcelTestCase t= testCasemap.get(sm);
						for(String mod :getActiveModule())
						{
						if(t.getModule().trim().equalsIgnoreCase(mod))
						{
						
							enabledClasses.add(t.getAutomationClass().trim());
						}
			}
			
		}
			}
			else if(runmode.getSpec().equalsIgnoreCase("Suite"))
			{
				 Map<String, ExcelTestCase> testCasemap=	Loadder.loadTestCases();
					for(String s: testCasemap.keySet())
					{
						ExcelTestCase t= testCasemap.get(s);
						for(String group :getSuiteToBeRun())
						{
						if(t.getGroup().equalsIgnoreCase(group))
						{
						
							enabledClasses.add(t.getAutomationClass());
						}
					}
					}
			}
				
		return enabledClasses;
		}

		
		
		
		public static List<String> getAllTestMethods() throws Exception	
		{
      Map<String, ExcelTestCase> testCasemap=	Loadder.loadTestCases();
      List<String> testCaseToBeRun = new ArrayList<String>();
		for(String s: testCasemap.keySet())
		{
			ExcelTestCase t= testCasemap.get(s);
			if(t.getMethodRunFlag().trim().equalsIgnoreCase("Yes"))
			{
				testCaseToBeRun.add(t.getTestMethod().trim());
			}
		}
		return testCaseToBeRun;
		
		
}
/*		
		public static Set<String> getClasses() throws Exception	
		{
      Map<String, ExcelTestCase> testCasemap=	Loadder.loadTestCases();
      Set<String> classToBeRun = new HashSet<String>();
		for(String s: testCasemap.keySet())
		{
			ExcelTestCase t= testCasemap.get(s);
				for(String module: getActiveModule())
				{
					if(t.getGroup().equalsIgnoreCase(module))
					{
						classToBeRun.add(t.getAutomationClass());
					}
				}
			}
			
		return classToBeRun;
}*/
		
		public static Set<String> getClass_ByModuleName(String module) throws Exception	
		{
      Map<String, ExcelTestCase> testCasemap=	Loadder.loadTestCases();
      Set<String> classToBeRun = new HashSet<String>();
      String tModule;
		for(String s: testCasemap.keySet())
		{
			ExcelTestCase t= testCasemap.get(s);
			
			//if(Master.getSpecification().equalsIgnoreCase("Feature"))
				if(getRunMode().equalsIgnoreCase("Module"))
			{
				 String[] mo=module.split(" ");
				 tModule=mo[0];
			}
			else{
				tModule=module;	
			}
					if(t.getModule().equalsIgnoreCase(tModule))
					{
						classToBeRun.add(t.getAutomationClass().trim());
					}
				}
			
			
		return classToBeRun;
}
		
		public static List<String> getTestMethods_ByClassName(String clas) throws Exception	
		{
      Map<String, ExcelTestCase> testCasemap=	Loadder.loadTestCases();
      List<String> testCaseToBeRun = new ArrayList<String>();
		for(String s: testCasemap.keySet())
		{
			ExcelTestCase t= testCasemap.get(s);
			if(t.getMethodRunFlag().equalsIgnoreCase("Yes") && t.getAutomationClass().trim().equalsIgnoreCase(clas))
			{
				testCaseToBeRun.add(t.getTestMethod());
			}
		}
		return testCaseToBeRun;
		
}
	
		public static Set<String> getAllModules() throws Exception
		{
			Set<String> allModules = new HashSet<String>();
			//String spec=Master.getSpecification();
			System.out.println(runmode.getSpec());
				if(getRunMode().equalsIgnoreCase("Module"))
			{
		
					allModules.addAll(getActiveModule());		
			}
				
		else if(getRunMode().equalsIgnoreCase("Group"))
		{
			 Map<String, ExcelTestCase> testCasemap=	Loadder.loadTestCases();
				for(String s: testCasemap.keySet())
				{
					ExcelTestCase t= testCasemap.get(s);
					for(String group :getSuiteToBeRun())
					{
					if(t.getGroup().equalsIgnoreCase(group))
					{
					
						allModules.add(t.getModule());
					}
				}
				}
		}
			
	return allModules;
	
		}


public List<String> getTestMethodGroup(String method) throws Exception
{
	 Map<String, ExcelTestCase> testCasemap=	Loadder.loadTestCases();
     List<String> testGroup = new ArrayList<String>();
		for(String s: testCasemap.keySet())
		{
			ExcelTestCase t= testCasemap.get(s);
			if(t.getTestMethod().equalsIgnoreCase(method) )
			{
				testGroup.add(t.getGroup());
			}
		}
		return testGroup;
		
	
	
}

public List<String> getTestMethodModule(String method) throws Exception
{
	 Map<String, ExcelTestCase> testCasemap=	Loadder.loadTestCases();
     List<String> testModule = new ArrayList<String>();
		for(String s: testCasemap.keySet())
		{
			ExcelTestCase t= testCasemap.get(s);
			if(t.getTestMethod().equalsIgnoreCase(method) )
			{
				testModule.add(t.getModule());
			}
		}
		return testModule;
			
}

public static Map<String,String> getParam(String module) throws Exception
{
	 Map<String, ExcelTestCase> testCasemap=	Loadder.loadTestCases();
	Map<String, String> parameterMap= new HashMap<String, String>();
	String tModule;
		for(String s: testCasemap.keySet())
		{
			ExcelTestCase t= testCasemap.get(s);
			if(t.getBrowser()!=null)
			{
			 tModule= t.getModule()+t.getBrowser();
			}
			else{
				tModule=t.getModule();
			}
			if(tModule.equalsIgnoreCase(module) )
			{
			String parametrs=(String) t.getParam();
			if(!(parametrs.equalsIgnoreCase("null")) )
			{
			String[] parameterarray= parametrs.split(",");
			for(int i=0;i<parameterarray.length;i++)
			{
				String[] param= parameterarray[i].split("=");
				parameterMap.put(param[0].trim(), param[1].trim());
			}
				
				
			}
		}
		}
		return parameterMap;
}
		
		public static Map<String,String> getModuleParameter2(String moduleName)
		{
			Map<String, String> moduleparameterMap= new HashMap<String, String>();
			String[] parameterarray1= moduleName.split(" ");
			moduleparameterMap.put("browser", parameterarray1[1]);
			return moduleparameterMap;
			
			
		}
		
		public static Map<String,String> getModuleParameters(String module) throws Exception
		{
			 Map<String, Module> testCasemap=	Loadder.loadModules();
			Map<String, String> parameterMap= new HashMap<String, String>();
			String[] parameterarray= module.split(" ");
			
				for(String s: testCasemap.keySet())
				{
					Module t= testCasemap.get(s);
					if(t.getModuleName().equalsIgnoreCase(parameterarray[0]))
					{
					parameterMap.put("browser","*"+parameterarray[1] );		
					//parameterMap.put("platform", t.getPlatform());
					parameterMap.put("parallel", t.getParallel());
					parameterMap.put("testType", t.getTestType());
					//parameterMap.put("mobilePlatformVersion", t.getMobilePlatformVersion());
					//parameterMap.put("deviceName", t.getDeviceName());
					parameterMap.put("appURL", t.getAppUrl());
					//parameterMap.put("appPackage", t.getAppPackage());
					//parameterMap.put("appActivity", t.getAppActivity());
					
					}
					
					
				
				}
				return parameterMap;

	}
	
		public static Map<String,String> getSuiteParameters() throws Exception
		{
			 Map<String, RunMode> suiteMap=	Loadder.loadRunMode();
			Map<String, String> parameterMap= new HashMap<String, String>();
			
			
				for(String s: suiteMap.keySet())
				{
					RunMode run= suiteMap.get(s);
					
					parameterMap.put("browser",run.getBrowser() );		
					//parameterMap.put("platform", run.getPlatform());
					//parameterMap.put("parallel", run.getParallel());
					//parameterMap.put("testType", run.getTestType());
					//parameterMap.put("mobilePlatformVersion", run.getMobilePlatformVersion());
					//parameterMap.put("deviceName", run.getDeviceName());
					parameterMap.put("appURL", run.getappUrl());
					parameterMap.put("runMode", run.getRunMode());
					parameterMap.put("webDriverGrid", run.getWebwebDriverGrid());
					//parameterMap.put("maxConcurrentWebSessions", run.getMaxConcurrentWebSessions());
					//parameterMap.put("webSessionTimeOut", run.getWebSessionTimeOut());
					//parameterMap.put("softAssertEnabled", run.getSoftAssertEnabled());
					//parameterMap.put("htmlreportlogging", run.getHtmlreportlogging());
					
					
					
					
					
					
					
				
				}
				return parameterMap;

	}
		
}

///Get module parameters 
/*public static Map<String,String> getModuleParam1(String module) throws Exception
{
	 Map<String, Module> modulemap=	Loadder.loadModules();
	Map<String, String> parameterMap= new HashMap<String, String>();
	String tModule;
		for(String s: modulemap.keySet())
		{
			Module t= modulemap.get(s);
			if(t.getBrowser()!=null)
			{
			 tModule= t.getModule()+t.getBrowser();
			}
			else{
				tModule=t.getModule();
			}
			if(t.getModuleName().equalsIgnoreCase(module) )
			{
			String parametrs=(String) t.getParam1();
			if(!(parametrs.equalsIgnoreCase("null")) )
			{
			String[] parameterarray= parametrs.split(",");
			for(int i=0;i<parameterarray.length;i++)
			{
				String[] param= parameterarray[i].split("=");
				parameterMap.put(param[0].trim(), param[1].trim());
			}
				
				
			}
		}
		}
		return parameterMap;
		
}*/

		
/*public static Map<String,String> getParam(String module) throws Exception
{
	 Map<String, ExcelTestCase> testCasemap=	Loadder.loadTestCases();
	Map<String, String> parameterMap= new HashMap<String, String>();
    Set<String> testModule = new HashSet<String>();
    for(String m: getAllModules())
    {
		for(String s: testCasemap.keySet())
		{
			ExcelTestCase t= testCasemap.get(s);
			//testModule.add(t.getModule());
		
	
			if(m.equalsIgnoreCase(module) )
			{
			String parametrs=(String) t.getParam();
			String[] parameterarray= parametrs.split(",");
			for(int i=0;i<parameterarray.length;i++)
			{
				String[] param= parameterarray[i].split("=");
				System.out.println(param[0]);
				System.out.println(param[1]);
				parameterMap.put(param[0], param[1]);
				System.out.println(parameterMap.get(param[0]));
				
				
				
			}
		}
		}
		
		
}
	return parameterMap;
}
}*/
		
	
	
	/*for(String enabledModule : enabledModules)
	{
	    Map<String, ExcelTestCase> testCasemap=	Loadder.loadTestCases("E:\\MasterSuite.xlsx", "TestCases");
	      List<String> testCaseToBeRun = new ArrayList<String>();
			for(String s: testCasemap.keySet())
			{
				ExcelTestCase t= testCasemap.get(s);
				if(t.getMethodRunFlag().equalsIgnoreCase("Yes") && t.getModule().equalsIgnoreCase(enabledModule))
				{
					testCaseToBeRun.add(t.getTestMethod());
				}
			}
			System.out.println(testCaseToBeRun);
	}

**********************************************************************************************************************
}*/
