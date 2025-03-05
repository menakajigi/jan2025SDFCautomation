package tests;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import listerns.TestListeners;
import pages.ContactPage;
import pages.HomePage;
import pages.LoginPage;
import utils.FileUtils;
@Listeners(TestListeners.class)
public class ContactsTest extends BaseTest{
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
	@Test
	public void CreateNewContact_TC25() throws FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver, test);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"), FileUtils.readLoginPropertiesFile("valid.password"));
		HomePage ldp = new HomePage(driver, test);
		ldp.clickContacts();
		String contactTitle=driver.getTitle();
		assertTrue(contactTitle.equals(FileUtils.readContactPagePropertiesFile("contact.title")),("Contacts: Home page is not displayed"));
		ContactPage cp =new ContactPage(driver);
		cp.ClickNew(); 
	}
	
	@Test
	public void RecentlyCreatedContact_TC26() throws InterruptedException, FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver, test);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"), FileUtils.readLoginPropertiesFile("valid.password"));
		HomePage ldp = new HomePage(driver, test);
		ldp.clickContacts();
		String contactTitle=driver.getTitle();
		assertTrue(contactTitle.equals(FileUtils.readContactPagePropertiesFile("contact.title")),("Contacts: Home page is not displayed"));
		Thread.sleep(2000);
		ContactPage cp =new ContactPage(driver);
		cp.ValidateCreateNewView();
	}
	
	@Test
	public void CheckRecentlyCreatedContact_TC27() throws FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver, test);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"), FileUtils.readLoginPropertiesFile("valid.password"));
		HomePage ldp = new HomePage(driver, test);
		ldp.clickContacts();
		String contactTitle=driver.getTitle();
		assertTrue(contactTitle.equals(FileUtils.readContactPagePropertiesFile("contact.title")),("Contacts: Home page is not displayed"));
		ContactPage cp =new ContactPage(driver);
		cp.recentlyCreated();
	}
	
	@Test
	public void CheckMyContacts_TC28() throws FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver, test);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"), FileUtils.readLoginPropertiesFile("valid.password"));
		HomePage ldp = new HomePage(driver, test);
		ldp.clickContacts();
		String contactTitle=driver.getTitle();
		assertTrue(contactTitle.equals(FileUtils.readContactPagePropertiesFile("contact.title")),("Contacts: Home page is not displayed"));
		ContactPage cp =new ContactPage(driver);
		cp.selectMyContact();
	}
	
	@Test
	public void ViewContactinContactPage_TC29() throws FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver, test);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"), FileUtils.readLoginPropertiesFile("valid.password"));
		HomePage ldp = new HomePage(driver, test);
		ldp.clickContacts();
		String contactTitle=driver.getTitle();
		assertTrue(contactTitle.equals(""),("Contacts: Home page is not displayed"));
		ContactPage cp =new ContactPage(driver);
		cp.clickContactName();
		
	}
	
	@Test
	public void loginErrorMsg_TC30() throws FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver, test);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"), FileUtils.readLoginPropertiesFile("valid.password"));
		HomePage ldp = new HomePage(driver, test);
		ldp.clickContacts();
		String contactTitle=driver.getTitle();
		assertTrue(contactTitle.equals(FileUtils.readContactPagePropertiesFile("contact.title")),("Contacts: Home page is not displayed"));
		ContactPage cp =new ContactPage(driver);
		cp.ContactCreateNewViewPage();
	}
	
	@Test
	public void CancelCreateNewView_TC31() throws FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver, test);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"), FileUtils.readLoginPropertiesFile("valid.password"));
		HomePage ldp = new HomePage(driver, test);
		ldp.clickContacts();
		String contactTitle=driver.getTitle();
		assertTrue(contactTitle.equals(FileUtils.readContactPagePropertiesFile("contact.title")),("Contacts: Home page is not displayed"));
		ContactPage cp =new ContactPage(driver);
		cp.ViewAndUniqueCancel();
	}
	
	@Test
	public void loginErrorMsg_TC32() throws FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver, test);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"), FileUtils.readLoginPropertiesFile("valid.password"));
		HomePage ldp = new HomePage(driver, test);
		ldp.clickContacts();
		String contactTitle=driver.getTitle();
		assertTrue(contactTitle.equals(FileUtils.readContactPagePropertiesFile("contact.title")),("Contacts: Home page is not displayed"));
		ContactPage cp =new ContactPage(driver);
		cp.ValidateCnewWithData();
		
	}
	
	
}
