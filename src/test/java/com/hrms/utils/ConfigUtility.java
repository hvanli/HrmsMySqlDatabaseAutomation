package com.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ConfigUtility {


	public static Properties prop;

//	public static Properties readProperties(String filePath) {
//		try {
//			FileInputStream fis = new FileInputStream(filePath);
//			prop = new Properties();
//			prop.load(fis);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return prop;
//	}

	public static String getProperty(String filePath, String key) {

//		String filePath = Constants.CREDENTIALS_FILEPATH;

		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop.getProperty(key);
	}
}
