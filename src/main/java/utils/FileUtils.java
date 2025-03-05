package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import constants1.FileConstants1;

public class FileUtils {
	
	public static String readLoginPropertiesFile(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader(FileConstants1.LOGIN_TEST_DATA_FILE));
		return p.getProperty(key);
	}

	public static String readHomePagePropertiesFile(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader(FileConstants1.HOME_TEST_DATA_FILE));
		return p.getProperty(key);
	}
	
	public static String readAccountPagePropertiesFile(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader(FileConstants1.Account_TEST_DATA_FILE));
		return p.getProperty(key);
	}
	
	public static String readOpportunityPagePropertiesFile(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader(FileConstants1.Opportunity_TEST_DATA_FILE));
		return p.getProperty(key);
	}
	
	public static String readLeadPagePropertiesFile(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader(FileConstants1.Lead_TEST_DATA_FILE));
		return p.getProperty(key);
	}
	
	public static String readContactPagePropertiesFile(String key) throws FileNotFoundException, IOException {
		Properties p = new Properties();
		p.load(new FileReader(FileConstants1.Contact_TEST_DATA_FILE));
		return p.getProperty(key);
	
	}
	
}