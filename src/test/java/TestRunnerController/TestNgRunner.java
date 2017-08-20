/**
 * 
 */
package TestRunnerController;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.annotations.BeforeSuite;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;


/**
 * @author ssi248
 *
 */
public class TestNgRunner {
	/*private static final Logger logger = LogManager
			.getLogger(TestNgRunner.class.getName());*/
	//public static RunMode runmode= new RunMode();
	
	
	@BeforeSuite
	 public void runTestNg() throws Exception
	 {
		 TestNG myTestNG = new TestNG();
	 XmlSuite mySuite = new XmlSuite(); 
	 
	 //if(Master.getSpecification().equalsIgnoreCase("Group"))
	System.out.println(Runner.getRunMode());
		 if(Runner.getRunMode().equalsIgnoreCase("Group"))
	 {
		//logger.info("Admin has selected to run the application based on Suite");
		 mySuite.setName("WMF"+" "+Runner.getSuiteToBeRun().get(0)+ " "+"Suite");
		
		 
		// logger.info("Admin has selected suite:  " + Runner.getSuiteToBeRun().get(0)+" For run" );
	 }
	 else
	 {
		 mySuite.setName("WMF Test Suite"); 
		// logger.info("Admin has selected to run the application based on Module");
	 }
		 mySuite.setParameters(Runner.getSuiteParameters());
		 
	 List<XmlTest> allTest = new ArrayList<XmlTest>();
	 for(String module: Runner.getAllModules())
	 {
		 XmlTest myTest = new XmlTest(mySuite);
		 myTest.setName(module+" "+"Test");
		 if(Runner.getRunMode().equalsIgnoreCase("Module"))
		 {
		//myTest.setParameters(Runner.getParam(module));
			// myTest.setParameters(Runner.getModuleParameters(module));
		 }
		// logger.info("TestNG XML test tag setup with :"+ module +" Test");
		 List<XmlClass> myClasses = new ArrayList<XmlClass> ();
		 for(String clas: Runner.getClass_ByModuleName(module))
		 {
		 myClasses.add(new XmlClass("com.sapient.tests."+clas));
		//logger.info("Class " + clas +" included in the test " + module +" Test");
		 ArrayList<XmlInclude> includedMethods = new ArrayList<XmlInclude>();
		 for(String method :Runner.getTestMethods_ByClassName(clas))
		 {
			 includedMethods.add(new XmlInclude(method));
			 // XmlClass testClass1 = new XmlClass ();
			 
			//myClasses.get(0).setIncludedMethods(includedMethods);
			myClasses.get(myClasses.size()-1).setIncludedMethods(includedMethods);
			//logger.info("Test methods has been included in the class : " + clas);
		
			 
		 }
		 myTest.setXmlClasses(myClasses);
		 }
	 
		 allTest.add(myTest);
	 }
	 mySuite.setTests(allTest);
	 mySuite.addListener("com.sapient.reporter.SeleniumTestsReporter");
	 mySuite.addListener("com.sapient.core.TestRetryListener");
	
	 
	// mySuite.addListener(listener);
	 List<XmlSuite> mySuites = new ArrayList<XmlSuite>();
	 mySuites.add(mySuite);
	 myTestNG.setXmlSuites(mySuites);
	 System.out.println(mySuite.toXml());
	myTestNG.run();
	  
	 }
	 

}
	
	 
	
	 
	