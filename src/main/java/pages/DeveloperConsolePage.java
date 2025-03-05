package pages;

import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class DeveloperConsolePage extends BasePage {
	WebDriver driver;
	ExtentTest test;

	public DeveloperConsolePage(WebDriver driver, ExtentTest test) {
		super(driver);
		this.driver = driver;
		this.test = test;

	}

	public HomePage WindowHandler() throws InterruptedException {

		String oldwindowID1 = driver.getWindowHandle();
		Set<String> windowIDs1 = driver.getWindowHandles();
		String[] getWindow1 = windowIDs1.toArray(new String[windowIDs1.size()]);
		Thread.sleep(3000);
		driver.switchTo().window(getWindow1[1]);
		String checkWindow = driver.getTitle();
		assertTrue(checkWindow.equals("Developer Console"), "New Developer Window is not Opened");
		driver.close();
		driver.switchTo().window(oldwindowID1);
		Thread.sleep(3000);
		return new HomePage(driver, test);

	}

}
