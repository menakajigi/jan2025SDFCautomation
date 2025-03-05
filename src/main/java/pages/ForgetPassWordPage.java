package pages;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.FileUtils;

public class ForgetPassWordPage extends BasePage{

	private ExtentTest test;
	private WebDriver driver;
	public ForgetPassWordPage(WebDriver driver,ExtentTest test) {
		super(driver);
		this.driver = driver;
		this.test = test;
		String forgotpswPage = driver.getTitle();
		assertTrue(forgotpswPage.equals("Forgot Your Password | Salesforce"),"verified Forget password page");
		this.test.log(Status.INFO, "Forgot Password Page is verified");
	}

	@FindBy(id = "header")
	public WebElement forgotURpassW;

	@FindBy(id = "un")
	public WebElement username;

	@FindBy(name = "cancel")
	public WebElement cancel;

	@FindBy(id = "continue")
	public WebElement continueButton;

	@FindBy(xpath = "//*[contains(@class,'message')]/p[1]")
	public WebElement tab;

	public void forgotPassword() throws InterruptedException, FileNotFoundException, IOException {
		this.username.sendKeys(FileUtils.readLoginPropertiesFile("valid.username"));
		this.continueButton.click();
		this.test.log(Status.INFO, "Continure Button is clicked");
		String displyTab = tab.getText();
		assertTrue(displyTab.equals("We’ve sent you an email with a link to finish resetting your password."), "Verified the Check Email Page");
	}

}
