package com.sapient.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Compress {
	
	static List<String> fileList = new ArrayList<String>();
	public static void main(String args[]) throws IOException {
	        sendToZip(new File("C:\\Users\\ssi248\\Desktop\\Cucumber"), new File("C:\\Users\\ssi248\\Desktop\\TryForZip\\ZipFile.ZIP"));
	}
	
	 private static List<String> addFiletoList(File inputDir)
	    {
	        File[] listOfFile=inputDir.listFiles();
	        for (File file : listOfFile) {
	        if(file.isFile())
	            fileList.add(file.getAbsolutePath());
	        else
	            addFiletoList(file);
	        }
	    return fileList;     
	    }
	  private  static void sendToZip(File zipInput,File zipOutPut) throws FileNotFoundException, IOException
	    {   
	        List<String> fileList=new ArrayList<String>();
	        fileList=addFiletoList(zipInput);
	        FileOutputStream fos=new FileOutputStream(zipOutPut);
	        ZipOutputStream zos=new ZipOutputStream(fos);
	        for(String filePath:fileList){
	            FileInputStream fis = new FileInputStream(filePath);
	           
	            //String name is required for showing the file name after zip same as before zip
	 
	            String name = filePath.substring(zipInput.getAbsolutePath().length()+1, filePath.length());
	            ZipEntry entry = new ZipEntry(name);
	            zos.putNextEntry(entry);

	            int len;
	            byte[] buffer = new byte[4096];
	            while ((len = fis.read(buffer)) != -1) {
	                zos.write(buffer, 0, len);
	            }

	            fis.close();
	            zos.closeEntry();
	        }
	        zos.close();
	        fos.close();
	    }
	} 

