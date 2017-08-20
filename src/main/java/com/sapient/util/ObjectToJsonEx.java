/**
 * 
 */
package com.sapient.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.reporter.ShortTestResult;



/**
 * @author ssi248
 *
 */
public class ObjectToJsonEx {
	  public static void main(String[] a)
	  {
		  ShortTestResult testresult = new ShortTestResult("result");
	 ObjectMapper mapperObj = new ObjectMapper();
     
     try {
         // get Employee object as a json string
         String jsonStr = mapperObj.writeValueAsString(testresult);
         System.out.println(jsonStr);
     } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
     }


}
	public static void getJasonString(Object obj)
	{
		  //ShortTestResult testresult = new ShortTestResult("result");
			 ObjectMapper mapperObj = new ObjectMapper();
		     
		     try {
		         // get Employee object as a json string
		         String jsonStr = mapperObj.writeValueAsString(obj);
		         System.out.println(jsonStr);
		     } catch (IOException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		     }
	}
	  
}
