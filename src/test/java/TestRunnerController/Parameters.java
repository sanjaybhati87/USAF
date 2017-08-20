/**
 * 
 */
package TestRunnerController;

import com.sapient.util.ExcelReader;


/**
 * @author ssi248
 *
 */
public class Parameters {
	
	public static void main(String args[]) throws Exception
	{
	String file="E:\\MasterSuite2.xlsx";
	String sheet="TestCases";
	Object[][] groupData= ExcelReader.getTableArray(file, sheet);
	
	}

}
