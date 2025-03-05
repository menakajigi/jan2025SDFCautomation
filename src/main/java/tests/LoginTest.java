package tests;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import listerns.TestListeners;
import pages.ForgetPassWordPage;
import pages.LoginPage;
import pages.UserMenu;
import utils.FileUtils;
import utils.WaitUtils;


@Listeners(TestListeners.class)
public class LoginTest extends BaseTest{
//	WebDriver driver;
	
//	@BeforeMethod
//	public void pre() throws FileNotFoundException, IOException {
////		driver = BaseTest.getBrowser();
////		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
////		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	}
	
//	@AfterMethod
//	public void post() {
//		driver.quit();
//	}
	
	@Test(priority=1)
	public void loginErrorMsg_TC01() throws FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver,test);
		lp.loginWithInvalidUser("username@gmail.com", "");
		
		WaitUtils.waitForElement(driver, lp.errorMsg);
		assertTrue(lp.errorMsg.getText().equals(FileUtils.readLoginPropertiesFile("error.password")), "Password error message is not displayed");
		test.log(Status.INFO, "Verified the password Error Message");
//		assertTrue(lp.validateErrorMessage(FileUtils.readLoginPropertiesFile("error.password")),"Verify password error message");
	}

	@Test(priority=2)
	public void login_TC02() throws FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver,test);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"), FileUtils.readLoginPropertiesFile("valid.password"));
	}

	@Test(priority=3)
	public void loginErrorMsg_TC03() throws FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver,test);
		lp.loginToAppRemember(FileUtils.readLoginPropertiesFile("valid.username"), FileUtils.readLoginPropertiesFile("valid.password"));
		UserMenu usm = new UserMenu(driver,test);
		lp = usm.logout();
		assertTrue(lp.validateUsername(), "Remember the Username is verified");
	}

	@Test(priority=4)
	public void forgetPassWord_TC04A() throws InterruptedException, FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver,test);
		lp.forgotPassWordLink();
		ForgetPassWordPage fp = new ForgetPassWordPage(driver,test);
		fp.forgotPassword();
	}

	@Test(priority=5)
	public void forgotPassWord_TC04B() throws FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver,test);
		lp.loginWithInvalidUser(FileUtils.readLoginPropertiesFile("invalid.username"), FileUtils.readLoginPropertiesFile("invalid.password"));
		assertTrue(lp.validateErrorMessage(FileUtils.readLoginPropertiesFile("error.invaliduserpassword")),"verify invalid username error message");
	}

}
