package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import listerns.TestListeners;
import pages.HomePage;
import pages.LoginPage;
import utils.FileUtils;
@Listeners(TestListeners.class)
public class RandomScenarioTest extends BaseTest {
	WebDriver driver;
	ExtentTest test;
//	@BeforeMethod
//	public void pre() throws FileNotFoundException, IOException {
//		driver = getBrowserDriver("chrome", false);
//		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		LoginPage lp = new LoginPage(driver, test);
//		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"), FileUtils.readLoginPropertiesFile("valid.password"));
//		
//	}
//	
//	@AfterMethod
//	public void post() {
//		driver.quit();
//	}
	
	@Test
	public void RandomScenarios_TC33() throws FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver, test);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"), FileUtils.readLoginPropertiesFile("valid.password"));
		HomePage hm  = new HomePage(driver, test);
		hm.VerifyFirstLastName();
	}
	
	
	@Test
	public void RandomScenarios_TC34() throws FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver, test);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"), FileUtils.readLoginPropertiesFile("valid.password"));
		HomePage hm  = new HomePage(driver, test);    //unfinished
		hm.VerifyFirstLastName();
	}
	
	
	@Test
	public void loginErrorMsg_TC35() {
	}
	
	
	@Test
	public void loginErrorMsg_TC36() {
	}
	
	
	@Test
	public void loginErrorMsg_TC37() {
	}
	
}
