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

public class ContactPage extends BasePage {
	WebDriver driver;

	public ContactPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	@FindBy(name = "fcf")
	public WebElement selectView;

	@FindBy(name = "go")
	public WebElement go;

	@FindBy(linkText = "Edit")
	public WebElement edit;

	@FindBy(linkText = "Create New View")
	public WebElement createNewView;

	@FindBy(name = "new")
	public WebElement newButton;

	@FindBy(name = "name_firstcon2")
	public WebElement fName;

	@FindBy(name = "name_lastcon2")
	public WebElement lName;

	@FindBy(name = "save")
	public WebElement save;

	@FindBy(name = "save")
	WebElement saveButton;

	@FindBy(name = "save_new")
	WebElement saveAndNewButton;

	@FindBy(name = "cancel")
	WebElement cancel;

	@FindBy(id = "name_lastcon2")
	public WebElement lastName;

	@FindBy(id = "con4")
	public WebElement accName;

	@FindBy(id = "fname")
	public WebElement viewName;

	@FindBy(id = "hotlist_mode")
	public WebElement recentltCreated;

	@FindBy(id = "devname")
	public WebElement uniqueName;

	@FindBy(linkText= "Sachit")
	public WebElement contactName;
	
	public void ClickSelectView() {
		this.selectView.click();
	}

	public void ClickGo() {
		this.go.click();
	}

	public void ClickEdit() {
		this.edit.click();
	}

	public void ClickNew() throws FileNotFoundException, IOException {
		this.newButton.click();
		String newContactPage = driver.getTitle();
		assertTrue(newContactPage.equals(FileUtils.readContactPagePropertiesFile("contactEdit.newPage")),
				("Contact Edit View Pae is not Displayed"));
	}

	public void ValidateCreateNewView() throws InterruptedException, FileNotFoundException, IOException {
		this.createNewView.click();
		String clickCreateView = driver.getTitle();
		assertTrue(clickCreateView.equals(FileUtils.readContactPagePropertiesFile("contact.createNewView")),
				("Contacts createView Page is not Displayed"));
		this.viewName.sendKeys(FileUtils.readContactPagePropertiesFile("contact.ViewName"));
		this.uniqueName.click();
		this.save.click();
		Thread.sleep(5000);
		Select sel = new Select(selectView);
		String contactHomePage = sel.getFirstSelectedOption().getText();
		// String contactHomePage=driver.findElement(By.id("fcf")).getText();
		assertTrue(contactHomePage.equals("Sachit"), ("view name is not visible by default"));
	}

	public void CreateNewContact() {
		this.lName.sendKeys("ranjith");
		this.accName.sendKeys("Sachit");
		this.save.click();
		String newCon = driver.getTitle();
		assertTrue(newCon.equals("Contact: ranjith ~ Salesforce - Developer Edition"),
				("Contacts: recently created page is not displayed"));
	}

	public void recentlyCreated() {
		Select se = new Select(this.recentltCreated);
		se.selectByVisibleText("Recently Created");
		String recent= se.getFirstSelectedOption().getText();
		assertTrue(recent.equals("Recently Created"),("recently created dropdown is not visible"));
	}
	
	public void selectMyContact() {
		Select select=new Select(this.selectView);
		select.selectByContainsVisibleText("My Contacts");
		String myContact=select.getFirstSelectedOption().getText();
		assertTrue(myContact.equals("My Contacts"),("My Contact is not found of the Select View"));
	}
	
	public void clickContactName() {
		this.contactName.click();
		String conName=driver.getTitle();
		assertTrue(conName.equals("Contact: Sachit ~ Salesforce - Developer Edition"),("Contact details under view name is not visible"));
	}
	
	public void ContactCreateNewViewPage() throws FileNotFoundException, IOException {
		this.createNewView.click();
		String cNv=driver.getTitle();
		assertTrue(cNv.equals(FileUtils.readContactPagePropertiesFile("contact.createNewView")),(" Contact:Create New view page not Displayed"));
		this.uniqueName.sendKeys("EFGH");
		this.saveButton.click();
		String errorMsg=driver.findElement(By.xpath("//*[text()=' You must enter a value']")).getText();
		assertTrue(errorMsg.equals("Error: You must enter a value"),("Error msg is not displayed"));
	}
	
	public void ViewAndUniqueCancel() {
		this.createNewView.click();
		String cNv=driver.getTitle();
		assertTrue(cNv.equals("Contacts: Create New View ~ Salesforce - Developer Edition"),(" Contact:Create New view page not Displayed"));
		this.viewName.sendKeys("ABCD");
		this.uniqueName.clear();
		this.uniqueName.sendKeys("EFGH");
		this.cancel.click();
		Select select=new Select(this.selectView);
		select.selectByContainsVisibleText("My Contacts");
		List<WebElement> options =select.getAllSelectedOptions();
		for (WebElement option : options) {			
			assertTrue(!option.getText().equals("ABCD"), "ABCD is listed in the view. ");		
		}
		
	}
	
	
	public void ValidateCnewWithData() throws FileNotFoundException, IOException {
		this.ClickNew();
		this.lName.sendKeys("Indian");
		this.accName.sendKeys("Global Media");
		this.saveAndNewButton.click();
		String newDetail =driver.findElement(By.xpath("//h2[contains(text(),'New Contact')]")).getText();
		assertTrue((newDetail.equals("New Contact")) && !lName.getText().equals("Indian"), "Contact Edit: New Contact Page is not dispalyed");
	}
	
	
	
	
	
	
	
}