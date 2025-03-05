package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import constants1.FileConstants1;

//import constants.FileConstants;

public class CommonUtils1 {
	public static String captureScreenshot(WebDriver driver) {
		String path = FileConstants1.SCREENSHOT_PATH;
	//	String path = System.getProperty("user.dir")+"/src/main/resources/reports/"+CommonUtils1.getTimeStamp()+".PNG";
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dst = new File(path);
		src.renameTo(dst);
		return path;
	}

	public static String getTimeStamp() {
		return new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	}

}
