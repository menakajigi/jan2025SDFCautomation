package tests;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import listerns.TestListeners;
import pages.HomePage;
import pages.LeadsPage;
import pages.LoginPage;
import pages.UserMenu;
import utils.FileUtils;
import utils.WaitUtils;

@Listeners(TestListeners.class)
public class LeadsTest extends BaseTest {
	WebDriver driver;
	ExtentTest test;

//	@BeforeMethod
//	public void pre() throws FileNotFoundException, IOException {
//		driver = getBrowserDriver("chrome", false);
//		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		LoginPage lp = new LoginPage(driver, test);
//		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"),
//				FileUtils.readLoginPropertiesFile("valid.password"));
//
//	}
//
//	@AfterMethod
//	public void post() {
//		driver.quit();
//	}

	@Test(priority = 1)
	public void LeadsTab_TC20() throws FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver, test);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"),
				FileUtils.readLoginPropertiesFile("valid.password"));
		HomePage ldp = new HomePage(driver, test);
		ldp.clickLeads();
		LeadsPage lpg = new LeadsPage(driver);
		lpg.LeadsValidation();

	}

	@Test(priority = 2)
	public void leadsSelectView_TC21() throws FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver, test);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"),
				FileUtils.readLoginPropertiesFile("valid.password"));
		HomePage ldp = new HomePage(driver, test);
		ldp.clickLeads();
		LeadsPage lpg = new LeadsPage(driver);
		lpg.LeadsValidation();
		lpg.LeadsViewCheck();

	}

	@Test(priority = 3)
	public void LeadsLogoutLogin_TC22() throws InterruptedException, FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver, test);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"),
				FileUtils.readLoginPropertiesFile("valid.password"));
		HomePage ldp = new HomePage(driver, test);
		ldp.clickLeads();
		LeadsPage lpg = new LeadsPage(driver);
		lpg.ClickSelectView();
		WaitUtils.waitForElement(driver, lpg.selectView);
		lpg.SelectTodaysLead();
		UserMenu up = new UserMenu(driver, test);
//	up.mouseover();
		up.logout();
		Thread.sleep(2000);
		String viewLoginPage = driver.getTitle();
		assertTrue(viewLoginPage.equals(FileUtils.readLoginPropertiesFile("page.title")),
				"Login Salesforce Page is  not Displayed");
		LoginPage lp1 = new LoginPage(driver, test);
		lp1.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"),
				FileUtils.readLoginPropertiesFile("valid.password"));
		HomePage ldp1 = new HomePage(driver, test);
		ldp1.clickLeads();
		LeadsPage lpg1 = new LeadsPage(driver);
		lpg1.LeadsValidation();
		LeadsPage lpg2 = new LeadsPage(driver);
		lpg2.ClickGo();
		String leadsGoPage = driver.getTitle();
		assertTrue(leadsGoPage.equals(FileUtils.readLeadPagePropertiesFile("leads.goPage")),
				"Leads go  Page is  not Displayed");

	}

	@Test(priority = 4)
	public void ClickTodayLeads_TC23() throws InterruptedException, FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver, test);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"),
				FileUtils.readLoginPropertiesFile("valid.password"));
		HomePage ldp = new HomePage(driver, test);
		ldp.clickLeads();
		LeadsPage lpg = new LeadsPage(driver);
		lpg.ClickSelectView();
		WaitUtils.waitForElement(driver, lpg.selectView);
		Select viewdrpdown = new Select(lpg.selectView);
		viewdrpdown.selectByVisibleText("Today's Leads");
		assertTrue(viewdrpdown.getFirstSelectedOption().getText()
				.equals(FileUtils.readLeadPagePropertiesFile("select.ByVisibleText")), "Today's Leads is not selected");
//		if(viewdrpdown.getFirstSelectedOption().getText().equals("Today's Leads")) {
//			System.out.println("Today's Leads is selected");
//		}else {
//			System.out.println("Today's Leads is not selected");
//		}

	}

	@Test(priority = 5)
	public void loginErrorMsg_TC24() throws FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver, test);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"),
				FileUtils.readLoginPropertiesFile("valid.password"));
		HomePage ldp = new HomePage(driver, test);
		ldp.clickLeads();
		LeadsPage lpg = new LeadsPage(driver);
		lpg.ClickNew();
		lpg.enterDetailsNewPage();
	}

}
