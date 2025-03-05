package automationframeworks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import constants1.FileConstants1;

public class ReorterDemo {

public static void main(String[] args) {
		
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(FileConstants1.REPORT_PATH);
		
		ExtentReports report = new ExtentReports();
		
		report.attachReporter(sparkReporter);
		
		
		ExtentTest test = report.createTest("LoginErrorTC01");
		
		ExtentTest tes2t = report.createTest("LoginErrorTC02");
		
		ExtentTest tes3 = report.createTest("LoginErrorTC02");
		
		report.flush();
	}
}
