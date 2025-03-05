package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReportPage extends BasePage{

	@FindBy(xpath ="//*[text()='Unsaved Report']")
	WebElement report;
	
	public ReportPage(WebDriver driver) {
		super(driver);
		String reportPage = this.report.getText();
		assertTrue(reportPage.equals("Unsaved Report"), "Report Page is not displayed");
	}

	@FindBy(name ="dateColumn")
	WebElement datedrop;
	
	@FindBy(name ="startDate")
	WebElement fromDate;
	
	@FindBy(name ="endDate")
	WebElement toDate;
	
	@FindBy(xpath ="//div[text()='Created Date']")
	WebElement datefieldCreatedDate;
	
	@FindBy(xpath ="//*[text()='Save']")
	WebElement saveButton;
	
	@FindBy(name ="reportName")
	WebElement reportName;
	
	@FindBy(name ="reportDevName")
	WebElement reportUniqueName;
	
	@FindBy(xpath="//*[text()='Save and Run Report']")
	WebElement saveRun;
	
	public void runreport() {
		this.datedrop.click();
		this.datefieldCreatedDate.click();
		this.fromDate.sendKeys("2/13/2025");
		this.toDate.sendKeys("2/13/2025");
		clickSaveButton();
	}
	
	public void clickSaveButton() {
		this.saveButton.click();
	}
	
	public void saveReport() {
		
		this.reportName.sendKeys("Sachit");
		this.reportUniqueName.click();
		this.reportUniqueName.clear();
		this.reportUniqueName.sendKeys("Sachit");
		this.saveRun.click();
		
	}
	
	
}
