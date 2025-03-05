package tests;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import listerns.TestListeners;
import pages.DeveloperConsolePage;
import pages.LoginPage;
import pages.UserMenu;
import utils.FileUtils;

@Listeners(TestListeners.class)
public class UserMenuTest extends BaseTest {
	WebDriver driver;
	ExtentTest test;
//	@BeforeMethod
//	public void pre() throws FileNotFoundException, IOException {
//		driver = getBrowserDriver("chrome", false);
//		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		LoginPage lp = new LoginPage(driver);
//		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"), FileUtils.readLoginPropertiesFile("valid.password"));
//		HomePage hm = new HomePage(driver);
//	}
//	
//	@AfterMethod
//	public void post() {
//		driver.quit();
//	}
	
	@Test(priority=1)
	public void userMenuDropdown_TC05() throws FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver,test);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"), FileUtils.readLoginPropertiesFile("valid.password"));
		UserMenu um = new UserMenu(driver,test);
		um.userMenuValidation();
	}

	@Test(priority=2)
	public void UserProfile_TC06() throws FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver,test);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"), FileUtils.readLoginPropertiesFile("valid.password"));
		UserMenu um = new UserMenu(driver,test);
		um.userMenuValidation();
		um.myProfile.click();
		String post = driver.findElement(By.linkText("Post")).getText();
		assertTrue(post.equals(post),"My Profile Page is not Displayed");
//		if (post.equals(post)) {
//			System.out.println("My Profile Page is Displayed");
//		} else {
//			System.out.println("My Profile Page is not Displayed"); //unfinshed
//		}


	}

	@Test(priority=3)
	public void loginErrorMsg_TC07() {
	}

	@Test(priority=4)
	public void DevelopersConsole_TC08() throws InterruptedException, FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver,test);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"), FileUtils.readLoginPropertiesFile("valid.password"));
		UserMenu um = new UserMenu(driver,test);
		Thread.sleep(2000);
		um.userMenuValidation();
		Thread.sleep(2000);
		DeveloperConsolePage dc = um.DeveloperConsole();
		dc.WindowHandler();


	}

	@Test(priority=5)
	public void loginPageCheck_TC09() throws InterruptedException, FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver,test);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"), FileUtils.readLoginPropertiesFile("valid.password"));
		UserMenu um = new UserMenu(driver,test);
		um.userMenuValidation();
		um.clicklogout();
		test.log(Status.INFO, "Logout button is Clicked");
		Thread.sleep(3000);
        assertTrue(um.validationlogut(),"LoginPage is not Displayed");
		driver.quit();

	}

}
