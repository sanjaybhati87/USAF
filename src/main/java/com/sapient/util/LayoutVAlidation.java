/**
 * 
 */
package com.sapient.util;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import com.galenframework.validation.ValidationResult;
import com.sapient.driver.DriverConfig;
import com.sapient.driver.WebUIDriver;

import static java.util.Arrays.asList;

/**
 * @author ssi248
 *
 */
public class LayoutVAlidation {
	WebDriver driver;
	String pageName;
	String tier;
	String platform;
	private final String filePath="src/test/resources/spec/";
	
	static LinkedList<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();
	DriverConfig config = new DriverConfig();
	LayoutReport layoutReport;
	
	public LayoutVAlidation(String pageName)
	{
		this.driver=WebUIDriver.getWebDriver();
		this.pageName= pageName;
		
		
	}
	
	public void setPlatform()
	{
		platform= config.getPlatform();
	}
	
	@DataProvider(name="devices")
	public static Object[][] devices()
	{
		return new Object[][] {{new TestDevice("desktop", new Dimension(1144,768), asList("desktop"))}};
	}
	 public static class TestDevice {
	        private final String name;
	        private final Dimension screenSize;
	        private final List<String> tags;

	        public TestDevice(String name, Dimension screenSize, List<String> tags) {
	            this.name = name;
	            this.screenSize = screenSize;
	            this.tags = tags;
	        }

	        public String getName() {
	            return name;
	        }

	        public Dimension getScreenSize() {
	            return screenSize;
	        }

	        public List<String> getTags() {
	            return tags;
	        }
	    }
	 
	 public void checklayout(List<String> browserSizes, List<String> tagsToBeTested)
	 {
		 for(String browserSize:browserSizes)
		 {
			 int width=Integer.parseInt(browserSize.split("x")[0].trim());
			 int height=Integer.parseInt(browserSize.split("x")[0].trim());
			 driver.manage().window().setSize(new Dimension(width,height));
			 checklayout(tagsToBeTested);
			 driver.manage().window().maximize();
		 }
	 }
	 
	 public boolean checklayout(List<String> tagsToBeTested)
	 {
		 boolean status=true;
		 try
		 {
			 try{
			 layoutReport = Galen.checkLayout(this.driver, this.filePath+this.pageName+".spec", tagsToBeTested,null,null,null);
			 }
			 catch(Exception e)
			 {
				 e.printStackTrace();
			 }
			 GalenTestInfo test = GalenTestInfo.fromString(this.pageName+ "- layout test - " + tagsToBeTested.toString().replaceAll("\\[|\\]", "").trim());
			 test.getReport().layout(layoutReport, this.pageName+ "- layout test");
			 tests.add(test);
			 new HtmlReportBuilder().build(tests, "./target/galen-reports");
			 if(layoutReport.errors()>0)
				 
			 {
				 Reporter.log("\n[LAYOUT ERRORS]: There are layout errors on the page : " + this.pageName + "!!!The Error are for ", true);
				 for(ValidationResult errorresult : layoutReport.getValidationErrorResults())
				 {
					 for (String errormsg : errorresult.getError().getMessages())
					 {
						 Reporter.log("\t[layout error: ]" +errormsg, true);
					 }
				 }
				 status=false;
			 }
			 else
			 {
				 Reporter.log("\n[INFO] : Layout test for page :- " + this.pageName + "passed.", true);
			 }
			 Reporter.log("[INFO] : Check reports in the location: -" + System.getProperty("user.dir")+"\\target\\galen-reports"+"\n", true);
	 
}
		 catch(Exception ex)
		 {
			 Reporter.log(ex.getLocalizedMessage(), true);
		 }
		 return status;
}
}

