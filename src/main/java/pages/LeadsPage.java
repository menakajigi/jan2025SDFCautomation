package pages;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utils.FileUtils;

public class LeadsPage extends BasePage{
	WebDriver driver;
	public  LeadsPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
	}
	
	@FindBy(id ="fcf")
	public	WebElement selectView;

	@FindBy(name="go")
		public WebElement go;

	@FindBy(linkText="Edit")	
	public	WebElement edit;

		@FindBy(linkText="Create New View")
	public	WebElement createNewView;
		
		@FindBy(name="new")
		public	WebElement newButton;
		
		
		@FindBy(id="name_firstlea2")
		WebElement firstName;
		
		@FindBy(id="name_lastlea2")
		WebElement lastName;
		
		@FindBy(id="lea3")
		WebElement companytName;
		
		@FindBy(name="save")
		WebElement savebutton;
		
		@FindBy(name="save_new")
		WebElement save_newButon;
		
		@FindBy(name="cancel")
		WebElement cancel;
	public void ClickSelectView() {
		this.selectView.click();
	}
		
	public void ClickGo() {
		this.go.click();
	}	
		
	public void ClickEdit() {
		this.edit.click();
	}	
	public void ClickCreateNewView() {
		this.createNewView.click();
	}
	
	public void ClickNew() {
		this.newButton.click();
		String newpage =driver.getTitle();
		assertTrue(newpage.equals("Lead Edit: New Lead ~ Salesforce - Developer Edition"),("New Lead Page is noy Displayed"));
	}
	
	public void LeadsValidation() throws FileNotFoundException, IOException {
	String leadsTab = driver.getTitle();
	assertTrue(leadsTab.equals(FileUtils.readLeadPagePropertiesFile("leadPage.title")),"Leads Home Page is not Displayed");
//	if(leadsTab.equals("Leads: Home ~ Salesforce - Developer Edition") ) {
//		System.out.println("Leads Home Page is Displayed");
//	}else {
//		System.out.println("Leads Home Page is not Displayed");
//	}
	
	}
	public void LeadsViewCheck() throws FileNotFoundException, IOException {
		this.ClickSelectView();
		String expectedMenu[]= FileUtils.readLeadPagePropertiesFile("leads.expectedMenu").split(",");
		List< WebElement> elements = driver.findElements(By.xpath("//*[@id='fcf']/option"));
		int i =0;
		for(WebElement element:elements) {
			String menuitems = element.getText();
		//	System.out.println("print"+ menuitems);
			if(menuitems.equals(expectedMenu[i])) {
				System.out.println("Valid " + menuitems);
			}else {
				System.out.println("Invalid");
			}
			i++;
		}
		
	}
	
	public void SelectTodaysLead() throws FileNotFoundException, IOException {
		Select viewdrpdown = new Select(this.selectView);
		viewdrpdown.selectByVisibleText(FileUtils.readLeadPagePropertiesFile("select.ByVisibleText"));
	}
	
	public void enterDetailsNewPage() {
		this.lastName.sendKeys("ABCD");
		this.companytName.sendKeys("ABCD");
		this.savebutton.click();
		String abcdLead=driver.getTitle();
		assertTrue(abcdLead.equals("Lead: ABCD ~ Salesforce - Developer Edition"),("New ABCD Lead page is not Displayed"));
	}
	
}
