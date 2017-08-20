package com.sapient.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/**
 * @author ssi248
 *
 */
public class CommonUtils {

  
  public static FileOutputStream getFileOutputStream(final String fileName) throws IOException {
    FileOutputStream fos = new FileOutputStream(fileName);
    return fos;
  }

  public static InputStream loadInputStream(final String classpathLocation, final String fileSystemLocation)
      throws IOException {
    InputStream in = null;
   
    in = CommonUtils.class.getResourceAsStream(classpathLocation);
    if (in == null) {
      in = new FileInputStream(fileSystemLocation);
    }
    return in;
  }

  public static void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  
  public static String getTestDataFilePath(final String className) {
	String fileSep = File.separator;
    return System.getProperty("user.dir") + fileSep + "test"+fileSep+"resources"+fileSep+"testdata"+fileSep + className + ".xlsx";
  }

  
 
  public static int getIntVal(String value) {
    String stringVal = value;
    if (value.contains(".")) {
      String[] valArray = stringVal.split("[.]");
      stringVal = valArray[0];
    }
    if (value.contains(",")) {
      stringVal = stringVal.replace(",", "");
    }
    return Integer.parseInt(stringVal);
  }

  
  public static int getRandomNum(int min, int max) {
    return new Random().nextInt((max - min) + 1) + min;
  }

 
  
  
}
