package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String getDataFromPropertiesFiles(String key) throws IOException {
		FileInputStream fis=new FileInputStream("D:\\Eclipse Programs\\vtigermain\\confiAppData\\local.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String data=prop.getProperty(key);
		
		return data;
	}
}
