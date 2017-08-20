package com.sapient.util; 

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author ssi248
 *
 */
public class Config {

	public static String path = "src/test/resources/environments/";
	private static final Properties props = new Properties();

	public void loadProps(String fileName) {
		try {
			FileInputStream inputStream = new FileInputStream(path+fileName);
			try {
				props.load(inputStream);
			} catch (IOException e) {
				e.getMessage();
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	public String getProperty(String key) {
		return props.getProperty(key);
	}

	public void setProperty(String key, String value) {
		props.setProperty(key, value);
	}

}
