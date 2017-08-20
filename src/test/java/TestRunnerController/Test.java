/**
 * 
 */
package TestRunnerController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ssi248
 *
 */
public class Test {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*System.out.println(Runner.getAllModules());
		Runner.getModuleParameter("Home Firefox");
		System.out.println(Runner.getModuleParameter("Home Firefox"));*/
		
		//System.out.println(Loadder.loadRunMode());
		//System.out.println(Loadder.loadModules());
		
		//Map<String, Module> map= Loadder.loadModules();
		
		//System.out.println(Loadder.loadSuite());
		//System.out.println(Loadder.loadTestCases());
		//System.out.println(Runner.getSuiteToBeRun());
		//System.out.println(Runner.getActiveModule());
		
		//recursion(1);
		//System.out.println(getModuleParameters("Login"));
		
		//System.out.println(Runner.getAllModules());
		//System.out.println(Loadder.loadRunMode());
		//System.out.println(Runner.getRunMode());
		System.out.println(Runner.getSuiteParameters());
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
						parameterMap.put("Browser",parameterarray[1] );
						
					parameterMap.put("Platform", t.getPlatform());
					parameterMap.put("Parallel", t.getParallel());
					}
					
					
				
				}
				return parameterMap;

	}
	
}
