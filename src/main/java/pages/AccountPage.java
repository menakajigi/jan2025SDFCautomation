package pages;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utils.FileUtils;

public class AccountPage extends BasePage {
	public AccountPage(WebDriver driver) throws FileNotFoundException, IOException {

		super(driver);
		String driveTitle = driver.getTitle();
		assertTrue(driveTitle.equals(FileUtils.readAccountPagePropertiesFile("accountTitle.title")),
				"Account Page is not Displayed");

	}

	@FindBy(name = "save")
	WebElement saveButton;

	@FindBy(name = "save_new")
	WebElement saveAndNewButton;

	@FindBy(name = "cancel")
	WebElement cancel;

	@FindBy(name = "acc2")
	WebElement accountName;

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

	@FindBy(xpath = "//*[@class='list']")
	public WebElement accountTable;
	@FindBy(id = "fname")
	WebElement viewName;

	@FindBy(id = "devname")
	WebElement viewUniqueName;

	@FindBy(id = "fcol1")
	WebElement additional_field;

	@FindBy(id = "fop1")
	WebElement additional_operator;

	@FindBy(id = "fval1")
	WebElement additional_value;

	@FindBy(id = "colselector_select_0")
	WebElement available_field;

	@FindBy(xpath = "//*[@id=\"colselector_select_0_right\"]/img")
	WebElement addtoright;

	@FindBy(id = "colselector_select_1")
	WebElement selected_field;

	@FindBy(xpath = "//*[@class='content']/h2")
	WebElement newAccountName;

	@FindBy(linkText = "Accounts with last activity > 30 days")
	WebElement lastActivity30days;

	public void NewButton() {
		this.newButton.click();
	}

	public void createNewButton() {
		this.createNewView.click();
	}

	public void ClickEdit() {
		this.edit.click();
	}

	public void ClickGo() {
		this.go.click();
	}

	public void enterAccountName(String accountname) {
		this.accountName.sendKeys(accountname);
	}

	public void ClickSave() {
		this.saveButton.click();
	}

	public void newAccount() throws FileNotFoundException, IOException {
		enterAccountName(FileUtils.readAccountPagePropertiesFile("enterAccountName.Name"));
		ClickSave();

	}

	public void enterTextViewName() throws FileNotFoundException, IOException {
		this.viewName.sendKeys(FileUtils.readAccountPagePropertiesFile("enter.viewName"));
	}

	public void enterUniqueName() throws FileNotFoundException, IOException {
		this.viewUniqueName.click();
		this.viewUniqueName.clear();
		this.viewUniqueName.sendKeys(FileUtils.readAccountPagePropertiesFile("enter.viewUniqueName"));
	}

	public void CreateViewName() throws FileNotFoundException, IOException {
		enterTextViewName();
		enterUniqueName();
		ClickSave();

	}

	public void selectViewDropdown() {
		Select viewdrpdown = new Select(this.selectView);
		viewdrpdown.selectByVisibleText("Sachit");
	}

	public void checkNewAccPage() throws FileNotFoundException, IOException {
		String newPageCheck = this.newAccountName.getText();
		assertTrue(newPageCheck.equals(FileUtils.readAccountPagePropertiesFile("newAccountpage.accountName")),
				"New Account Page is not Displayed");
	}

	public void verifyNewViewDropdown() throws FileNotFoundException, IOException {
		Select viewdrpdown = new Select(this.selectView);
		String createNewView = viewdrpdown.getFirstSelectedOption().getText();
		assertTrue(createNewView.equals(FileUtils.readAccountPagePropertiesFile("enter.viewName")),
				"CreateNewView is not selected");
	}

	public void additionalFields() {
		Select fielddropdown = new Select(this.additional_field);
		fielddropdown.selectByVisibleText("Account Name");
		Select operatordropdown = new Select(this.additional_operator);
		operatordropdown.selectByVisibleText("contains");
		this.additional_value.sendKeys("Sachit");
	}

	public void fieldsDisplay() {
		Select availablefielddropdown = new Select(this.available_field);
		availablefielddropdown.selectByVisibleText("Last Activity");
		this.addtoright.click();
	}

	public void viewSave() {
		this.saveButton.click();
	}

	public void enterEditView() {
		additionalFields();
		fieldsDisplay();
		viewSave();
	}

	public void clickLast20daysReport() {
		this.lastActivity30days.click();
	}

//	public void verifyTable() {
//		
//		WebElement table = driver.findElement(By.id("myTable")); // Or use another locator
//
//        List<WebElement> rows = table.findElements(By.tagName("tr"));
//        for (WebElement row : rows) {
//            List<WebElement> cells = row.findElements(By.tagName("td"));
//            for (WebElement cell : cells) {
//                System.out.println(cell.getText());
//            }
//        }
//	}

}
