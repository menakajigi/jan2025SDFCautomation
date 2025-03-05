package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import listerns.TestListeners;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ReportPage;
import pages.UserMenu;
import utils.FileUtils;
import utils.WaitUtils;
@Listeners(TestListeners.class)
public class AccountTest extends BaseTest {
	WebDriver driver;
	ExtentTest test;
	
//	@BeforeMethod
//	public void pre() throws FileNotFoundException, IOException {
//		driver = getBrowserDriver("chrome", false);
//		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		LoginPage lp = new LoginPage(driver,test);
//		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"), FileUtils.readLoginPropertiesFile("valid.password"));
//		
//	}
//	
//	@AfterMethod
//	public void post() {
//		driver.quit();
//	}
	
	@Test(priority=1)
	public void AccountCheck_TC10() throws FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver, test);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"), FileUtils.readLoginPropertiesFile("valid.password"));
		UserMenu um = new UserMenu(driver, test);
		um.validateUserAction();
		HomePage hm = new HomePage(driver, test);
		hm.clickAccount();
		AccountPage ap = new AccountPage(driver);
		ap.NewButton();
		ap.newAccount();
		ap.checkNewAccPage();
		
	}
	
	@Test(priority=2)
	public void CreaNewViewAccount_TC11() throws InterruptedException, FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver, test);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"), FileUtils.readLoginPropertiesFile("valid.password"));
		UserMenu um = new UserMenu(driver, test);
		um.validateUserAction();
		HomePage hm = new HomePage(driver, test);
		hm.clickAccount();
		AccountPage ap = new AccountPage(driver);
		ap.createNewButton();
		ap.CreateViewName();
		WaitUtils.waitForElement(driver, ap.selectView);
		ap.verifyNewViewDropdown();
	}
	
	@Test(priority=3)
	public void EditView_TC12() throws FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver, test);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"), FileUtils.readLoginPropertiesFile("valid.password"));
		UserMenu um = new UserMenu(driver, test);
		um.validateUserAction();
		HomePage hm = new HomePage(driver, test);
		hm.clickAccount();
		AccountPage ap = new AccountPage(driver);
		ap.selectViewDropdown();
		ap.ClickEdit();
		ap.enterEditView();

	}
	
	@Test(priority=4)
	public void loginErrorMsg_TC14() throws FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver, test);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"), FileUtils.readLoginPropertiesFile("valid.password"));
		UserMenu um = new UserMenu(driver, test);
		um.validateUserAction();
		HomePage hm = new HomePage(driver, test);
		hm.clickAccount();
		AccountPage ap = new AccountPage(driver);
		ap.clickLast20daysReport();
		ReportPage rp = new ReportPage(driver);
		rp.runreport();
		rp.saveReport();
	}
	
	
	@Test(priority=5)
	public void loginErrorMsg_TC13() {
	}
	
}
