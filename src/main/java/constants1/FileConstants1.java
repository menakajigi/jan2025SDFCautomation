package constants1;
import utils.CommonUtils1;

public class FileConstants1 {
	public static final String ROOT_PATH = System.getProperty("user.dir");
	public static final String LOGIN_TEST_DATA_FILE = ROOT_PATH + "/src/main/java/testData/login.properties";
	public static final String HOME_TEST_DATA_FILE = ROOT_PATH + "/src/main/java/testData/Home.properties";
	public static final String Account_TEST_DATA_FILE = ROOT_PATH + "/src/main/java/testData/Account.properties";
	public static final String Opportunity_TEST_DATA_FILE = ROOT_PATH + "/src/main/java/testData/Opportunity.properties";
	public static final String Lead_TEST_DATA_FILE = ROOT_PATH + "/src/main/java/testData/Lead.properties";
	public static final String Contact_TEST_DATA_FILE = ROOT_PATH + "/src/main/java/testData/Contact.properties";
	public static final String REPORT_PATH = ROOT_PATH + "/src/main/resources/reports/" + CommonUtils1.getTimeStamp()
	+ ".html";

	
	public static final String SCREENSHOT_PATH = ROOT_PATH + "/src/main/resources/reports/" + CommonUtils1.getTimeStamp()
			+ ".PNG";

}
