package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserProfilePage{

	public  UserProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(className="contactInfoLaunch editLink")
	public WebElement editprofilebutton;
	
	
	@FindBy(id="contactInfoTitle")
	public WebElement editprofile;
	
	@FindBy(id="aboutTab")
	public WebElement about;
	
	@FindBy(id="firstName")
	public WebElement firstName ;
	
	@FindBy(id="lastName")
	public WebElement lastName;
	
	@FindBy(id="contactTab")
	public WebElement contact;
	
	@FindBy(id="Email")
	public WebElement email;
	
	@FindBy(className="zen-btn zen-primaryBtn zen-pas")
	public WebElement saveAll;
	@FindBy(id="tailBreadcrumbNode")
	public WebElement username;
	
	
	public void editProfileAbout() {
		this.about.click();
		this.lastName.sendKeys("Jigi 2");
		saveAll.click();
		if(username.getText().equals("Jigi 2")) {
			System.out.println("Name is Changed");
		} else {
			System.out.println("Name is not Changed");
		}
		
		
	}
	
}
