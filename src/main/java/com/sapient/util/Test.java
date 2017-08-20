/**
 * 
 */
package com.sapient.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * @author ssi248
 *
 */
public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File file = new File("E:\\Json Files\\fund_family_json.txt");
		String s = FileUtils.readFileToString(file);
		
		Object o  = JsonParser.recursiveSelect("fundFamilyId", s);
		System.out.println(o);
		
		//Object c= JsonParser.getValueFromArray("domicileName", "fundFamilyId", "5410", s);
		Object c= JsonParser.getValueFromArray("registration", "fundFamilyId", "307378", s);
		System.out.println(c);

	}

}
