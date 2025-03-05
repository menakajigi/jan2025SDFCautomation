package pages;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.FileUtils;

public class UserMenu extends BasePage {

	WebDriver driver;
	ExtentTest test;

	public UserMenu(WebDriver driver, ExtentTest test) {
		super(driver);
		this.driver = driver;
		this.test = test;
	}

	@FindBy(linkText = "My Profile")
	public WebElement myProfile;

	@FindBy(linkText = "My Settings")
	public WebElement mySetting;

	@FindBy(linkText = "Developer Console")
	public WebElement developerConsole;

	@FindBy(linkText = "Logout")
	public WebElement logout;

	@FindBy(id = "userNavLabel")
	public WebElement user_action;

	public boolean validateUserAction() throws FileNotFoundException, IOException {
		String user = this.user_action.getText();
		boolean flag = false;
		if (user.equals(FileUtils.readHomePagePropertiesFile("username.name"))) {
			System.out.println("Logged in with correct username");
			flag = true;
		} else {
			System.out.println("Logged in with incorrect username");
		}
		return flag;
	}

	public void mouseover() {
		Actions action = new Actions(driver);
		action.moveToElement(user_action).click().perform();
	}

	public void clicklogout() {

		this.logout.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		this.test.log(Status.INFO, "Logout is clicked");
//		String username = driver.findElement(By.id("idcard-identity")).getText();
//		if (username.equals("menaka@tekarch.com")) {
//			System.out.println("Username is displayed");
//		} else {
//			System.out.println("Username is not displayed");
//		}
	}

	public LoginPage logout() {
		mouseover();
		clicklogout();

		return new LoginPage(driver, test);

	}

	public void myProfile() {
		mouseover();
		this.myProfile.click();
		this.test.log(Status.INFO, "My Profile is clicked");

	}

	public void ClickmySetting() {
		mouseover();
		this.mySetting.click();
		this.test.log(Status.INFO, "My Setting is clicked");

	}

	public DeveloperConsolePage DeveloperConsole() {
		this.developerConsole.click();
		this.test.log(Status.INFO, "Developer Console is clicked");
		return new DeveloperConsolePage(driver, test);
	}

	public void userMenuValidation() {
		mouseover();
		String expectedMenu[] = { "My Profile", "My Settings", "Developer Console", "Switch to Lightning Experience",
				"Logout" };
		List<WebElement> elements = driver.findElements(By.xpath("//*[contains(@id,'userNav-menuItems')]/a"));
		int i = 0;
		for (WebElement element : elements) {
			String menuitems = element.getText();
			assertTrue(menuitems.equals(expectedMenu[i]), "InValid " + menuitems);
			i++;

		}
		this.test.log(Status.INFO, "User Menu validation is completed");
	}

	public boolean validationlogut() {
		String loginPageCheck = driver.getTitle();
		// assertTrue(loginPageCheck.equals("Login | Salesforce"),"LoginPage is not
		// Displayed");
		boolean flag = false;
		if (loginPageCheck.equals("Login | Salesforce")) {
			System.out.println("LoginPage is Displayed");
			flag = true;
		} else {
			System.out.println("LoginPage is not Displayed");
		}
		return flag;

	}

}
