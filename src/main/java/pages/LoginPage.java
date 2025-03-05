package pages;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.FileUtils;
import utils.WaitUtils;

public class LoginPage extends BasePage {
	 WebDriver driver;
	 ExtentTest test;
	public LoginPage(WebDriver driver,ExtentTest test) {
		super(driver);
		this.driver = driver;
		this.test = test;
		WaitUtils.waitForElement(driver, this.password);
		String title = driver.getTitle();
		System.out.println(title);
		System.out.println("Login | Salesforce");
		assertTrue(title.equals("Login | Salesforce"),"Login Page is not displayed");
		test.log(Status.INFO, "Login Page is verified");
		
	}

	@FindBy(id = "username")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(id = "Login")
	public WebElement loginButton;

	@FindBy(id = "hint_back_chooser")
	public WebElement savedUsername;

	@FindBy(id = "error")
	public WebElement errorMsg;

	@FindBy(name = "rememberUn")
	public WebElement rememeberMe;

	@FindBy(linkText = "Forgot Your Password?")
	public WebElement forgotUrPassword;

	@FindBy(id = "signup_link")
	public WebElement tryForFree;
	

	public void enterUsername(String username) {
		this.username.clear();
		this.username.sendKeys(username);
	}

	public void enterPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}

	public void Clicklogin() {
		this.loginButton.click();
	}
	
	public void forgotPassWordLink() {
		this.forgotUrPassword.click();
	}
	
	public void selectRemberMeCheckbox() {
		if (this.rememeberMe.isSelected()) {
			System.out.println("Checkbox is already selected");
			this.test.log(Status.INFO, "Remember Checkbox is alreadt selected");
		} else {
			this.rememeberMe.click();
			this.test.log(Status.INFO, "Remember Me is clicked");
		}
	}

	public HomePage loginToApp(String username, String password) {
		this.enterUsername(username);
		this.enterPassword(password);
		this.Clicklogin();
		this.test.log(Status.INFO, "Login button is Clicked");
		return new HomePage(driver,test);

	}
	
	public HomePage loginToAppRemember(String username, String password) {
		this.enterUsername(username);
		this.enterPassword(password);
		selectRemberMeCheckbox();
		this.Clicklogin();
		this.test.log(Status.INFO, "Login button is Clicked");
		return new HomePage(driver,test);
	}
	
	public LoginPage loginWithInvalidUser(String username, String password) {
		this.enterUsername(username);
		this.enterPassword(password);
		selectRemberMeCheckbox();
		this.Clicklogin();
		this.test.log(Status.INFO, "Login button is Clicked");
		return new LoginPage(driver,test);
	}
	
	public boolean validateUsername() throws FileNotFoundException, IOException {
		String username = driver.findElement(By.id("idcard-identity")).getText();
		return username.equals(FileUtils.readLoginPropertiesFile("valid.username"));

	}
	
	public boolean validateErrorMessage(String expectedErrorMsg) {
		String actualErrorMsg = errorMsg.getText();
		return actualErrorMsg.equals(expectedErrorMsg);
	}
	
	
}
