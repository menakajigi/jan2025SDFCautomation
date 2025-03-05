package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewViewPage{

	public  CreateNewViewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="fname")
	WebElement viewName;
	
	@FindBy(id="devname")
	WebElement viewUniqueName;

	@FindBy(id="fcol1")
	WebElement additional_field;
	
	@FindBy(id="fop1")
	WebElement additional_opperator;
	
	@FindBy(id="fval1")
	WebElement additional_value;
	
	@FindBy(id="colselector_select_0")
	WebElement available_field;
	
	@FindBy(id="colselector_select_1")
	WebElement selected_field;
	
	@FindBy(name="save")
	WebElement save;
	
	public void enterTextViewName() {
		this.viewName.sendKeys("jigi");
	}
	
	public void enterUniqueName() {
		this.viewUniqueName.click();
	}
	
	public void ClickSave() {
		this.save.click();
	}
	
	public void CreateViewName() {
		enterTextViewName();
		enterUniqueName();
		ClickSave();
	}
	
	
	
	
	
	
	
}
