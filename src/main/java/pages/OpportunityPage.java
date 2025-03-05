package pages;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utils.FileUtils;

public class OpportunityPage extends BasePage {

	WebDriver driver;

	public OpportunityPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	@FindBy(id = "fcf")
	public WebElement selectView;

	@FindBy(name = "go")
	public WebElement go;

	@FindBy(linkText = "Edit")
	public WebElement edit;

	@FindBy(linkText = "Create New View")
	public WebElement createNewView;

	@FindBy(name = "new")
	public WebElement newButton;

	public void mouseover() {
		Actions action = new Actions(driver);
		action.moveToElement(selectView).click().perform();
	}

	public void SelectViewButton() {
		this.selectView.click();
	}

	public void ClickGo() {
		this.go.click();
	}

	public void ClickcreateNewView() {
		this.createNewView.click();
	}

	public void ClickEdit() {
		this.edit.click();
	}

	public void clickNew() {
		this.newButton.click();
	}

	@FindBy(name = "save")
	WebElement savebutton;

	@FindBy(name = "save_new")
	WebElement save_newButton;

	@FindBy(name = "cancel")
	WebElement cancel;

	@FindBy(name = "opp3")
	WebElement opporName;

	@FindBy(id = "opp4")
	WebElement accName;

	@FindBy(id = "opp6")
	WebElement leadSource;

	@FindBy(id = "opp9")
	WebElement closeDate;

	@FindBy(id = "opp11")
	WebElement stage;

	@FindBy(id = "opp12")
	WebElement probability;

	@FindBy(name = "opp17")
	WebElement PrimaryCampaignSource;

	public void ClickSave() {
		this.savebutton.click();
	}

	public void ClickSaveNewButton() {
		this.save_newButton.click();
	}

	public void ClickCancel() {
		this.cancel.click();
	}

	public void enterOpportunityName() throws FileNotFoundException, IOException {
		this.opporName.sendKeys(FileUtils.readOpportunityPagePropertiesFile("Oppourtunity.Name"));
	}

	public void ClickAccountName() throws FileNotFoundException, IOException {
		this.accName.sendKeys(FileUtils.readAccountPagePropertiesFile("enterAccountName.Name"));
	}

	public void ClickCloseDate() throws FileNotFoundException, IOException {
		this.closeDate.sendKeys(FileUtils.readOpportunityPagePropertiesFile("CloseDate.date"));
	}

	public void ClickLeadSource() throws FileNotFoundException, IOException {
		Select sl = new Select(this.leadSource);
		sl.selectByVisibleText(FileUtils.readOpportunityPagePropertiesFile("OppNewPage.leadsource"));

	}

	public void ClickStage() throws FileNotFoundException, IOException {
		Select sl = new Select(this.stage);
		sl.selectByVisibleText(FileUtils.readOpportunityPagePropertiesFile("OppNewPage.Stage"));

	}

	public void EnterProbability() throws FileNotFoundException, IOException {
		this.probability.clear();
		this.probability.sendKeys(FileUtils.readOpportunityPagePropertiesFile("OppNewPage.probability"));
	}

	public void EnterPrimaryCampaignSource() throws FileNotFoundException, IOException {
		this.PrimaryCampaignSource
				.sendKeys(FileUtils.readOpportunityPagePropertiesFile("OppNewPage.PrimaryCampaignSource"));
	}

	public void ValidateSelectOpptyView() throws FileNotFoundException, IOException {
		SelectViewButton();
		String[]  expectedMenu= FileUtils.readOpportunityPagePropertiesFile("expectedMenu.Menu").split(",");
		List<WebElement> elements = driver.findElements(By.xpath("//*[@id='fcf']/option"));
		int i = 0;
		for (WebElement element : elements) {
			String menuitems = element.getText();
			assertTrue(menuitems.equals(expectedMenu[i]), "Invalid " + menuitems);
//			if(menuitems.equals(expectedMenu[i])) {
//				System.out.println("Valid " + menuitems);
//			}else {
//				System.out.println("Invalid");
//			}
			i++;
		}
	}

	public void ValidateOppPageVisible() throws FileNotFoundException, IOException {
		String oppPage = driver.getTitle();
		assertTrue(oppPage.equals(FileUtils.readOpportunityPagePropertiesFile("OppHomePage.title")),
				"Opportunities Home Page is not Displayed");	

	}

	public void entringNewOppPage() throws FileNotFoundException, IOException {
		this.clickNew();
		this.enterOpportunityName();
		this.ClickAccountName();
		this.ClickLeadSource();
		this.ClickCloseDate();
		this.ClickStage();
		this.EnterProbability();
		this.EnterPrimaryCampaignSource();
		this.ClickSave();
		String nOp = driver.findElement(By.xpath("//h2[contains(text(),'test')]")).getText();
		assertTrue(nOp.equals("test"), "New Opportunity Page is not Displayed");
//			if (nOp.equals("Opportunity: tekarch ~ Salesforce - Developer Edition")) {
//				System.out.println("New Opportunity Page is Displayed");
//			} else {
//				System.out.println("New Opportunity Page is not Displayed");
//			}
	}
}
