package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MySettingPage{

	public  MySettingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	WebElement Home;
}
