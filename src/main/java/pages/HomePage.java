package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.WaitUtils;

public class HomePage extends BasePage {
	private WebDriver driver;
	private ExtentTest test;
	public HomePage(WebDriver driver,ExtentTest test) {
		
		super(driver);
		this.driver = driver;
		this.test = test;
		WaitUtils.waitForElement(driver, Home);
		String title = driver.getTitle();
		assertTrue(title.contains("Home Page ~ Salesforce - Developer Edition"),"Home Page ~ Salesforce - Developer Edition is not displayed");
		this.test.log(Status.INFO, "Home Page is verified");
	}

	@FindBy(xpath = "//*[@class='currentStatusUserName']/a")
	WebElement username;

	@FindBy(xpath = "//*[@class='pageDescription']/a")
	WebElement datelink;

	@FindBy(xpath = "//*[@class='publisherattachtext ' and text()='Post']")
	WebElement post;

	@FindBy(xpath = "//*[@class='publisherattachtext ' and text()='File']")
	WebElement file;

	@FindBy(id = "publishersharebutton")
	WebElement share;

	@FindBy(linkText = "Upload a file from your computer")
	WebElement uploadFileComp;

	@FindBy(id = "chatterFile")
	WebElement chooseFile;

	@FindBy(linkText = "Home")
	public WebElement Home;

	@FindBy(linkText = "Accounts")
	public WebElement Account;

	@FindBy(linkText = "Opportunities")
	public WebElement Opportunities;

	@FindBy(linkText = "Leads")
	public WebElement Leads;

	@FindBy(linkText = "Contacts")
	public WebElement Contacts;

	@FindBy(linkText = "Menaka Jigi")
	public WebElement firstLastName;

	@FindBy(xpath = "//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div/div/a/img")
	public WebElement editProfileIcon;
	
	
	public void clickAccount() {
		this.Account.click();
	}

	public void clickOpportunities() {
		this.Opportunities.click();
	}

	public void clickLeads() {
		this.Leads.click();
	}

	public void clickContacts() {
		this.Contacts.click();
	}

	public void username(String username) {
		this.username.click();
	}

	public void datekink(String password) {
		this.datelink.click();

	}

	public void file() {
		this.file.click();
	}

	public void share() {
		this.share.click();
	}

	public void post() {
		this.post.click();
	}

	public void uploadFileComp() {
		this.uploadFileComp.click();
	}

	public void chooFile() {
		this.chooseFile.click();
	}
	public void ClickEditProfileIcon() {
		this.editProfileIcon.click();
		String contactTab =driver.findElement(By.xpath("//*[contains(text(),'Contact') and @role='tab']")).getText();
		assertTrue(contactTab.equals("Contact"),("Edit profile popup didn't open with contact  tab selected"));
		
	}

	public void VerifyFirstLastName() {
		String verifyFLname = this.firstLastName.getText();
		assertTrue(verifyFLname.equals("Menaka Jigi"), ("Firstname,Lastname is not displayed"));
		this.firstLastName.click();
		String verifytitle = driver.getTitle();
		assertTrue(verifytitle.equals("User: Menaka Jigi ~ Salesforce - Developer Edition"),
				("First name, Last name profile page is not same as Home page"));
	}

}
