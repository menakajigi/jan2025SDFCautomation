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
import pages.HomePage;
import pages.LoginPage;
import pages.OpportunityPage;
import pages.OpportunityPipelinePage;
import utils.FileUtils;

@Listeners(TestListeners.class)
public class OpportunityTest extends BaseTest {
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

	@Test(priority = 1)
	public void Opportunity_TC15() throws FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver, test);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"),
				FileUtils.readLoginPropertiesFile("valid.password"));
		HomePage hm = new HomePage(driver, test);
		hm.clickOpportunities();
		OpportunityPage opty = new OpportunityPage(driver);
		opty.ValidateOppPageVisible();
		opty.ValidateSelectOpptyView();

	}

	@Test(priority = 2)
	public void CreateNewOpporty_TC16() throws FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver, test);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"),
				FileUtils.readLoginPropertiesFile("valid.password"));

		HomePage hm = new HomePage(driver, test);
		hm.clickOpportunities();
		OpportunityPage opty = new OpportunityPage(driver);
		opty.ValidateOppPageVisible();
		opty.entringNewOppPage();

	}

	@Test(priority = 3)
	public void OppPipelineReport_TC17() throws FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver, test);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"),
				FileUtils.readLoginPropertiesFile("valid.password"));
		HomePage hm = new HomePage(driver, test);
		hm.clickOpportunities();
		OpportunityPage opty = new OpportunityPage(driver);
		opty.ValidateOppPageVisible();
		OpportunityPipelinePage opPipe = new OpportunityPipelinePage(driver);
		opPipe.OppPipelink();
		assertTrue(opPipe.PipelinePageValidation(), "Opportunity Pipeline link  under Reports are invisible");

	}

	@Test(priority = 4)
	public void StuckOpportunitiesReport_TC18() throws FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver, test);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"),
				FileUtils.readLoginPropertiesFile("valid.password"));
		HomePage hm = new HomePage(driver, test);
		hm.clickOpportunities();
		OpportunityPage opty = new OpportunityPage(driver);
		opty.ValidateOppPageVisible();
		OpportunityPipelinePage opPipe = new OpportunityPipelinePage(driver);
		opPipe.StruckOpp();
		opPipe.StruckPipelineValidation();

	}

	@Test(priority = 5)
	public void loginErrorMsg_TC19() throws FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver, test);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.username"),
				FileUtils.readLoginPropertiesFile("valid.password"));
		HomePage hm = new HomePage(driver, test);
		hm.clickOpportunities();
		OpportunityPage opty = new OpportunityPage(driver); // unfinished
		opty.ValidateOppPageVisible();

	}

}
