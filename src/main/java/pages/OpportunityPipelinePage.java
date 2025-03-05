package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityPipelinePage {
	WebDriver driver;
	public OpportunityPipelinePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	@FindBy(xpath="//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[1]/a")
	public WebElement OpportunityPipeline;
	
	@FindBy(xpath="//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[2]/a")
	public WebElement StuckOpportunities ;
	
	public void OppPipelink() {
		this.OpportunityPipeline.click();
	}
	
	public void StruckOpp() {
		this.StuckOpportunities.click();
	}
	
	
	public boolean PipelinePageValidation() {
		String PipePage = driver.getTitle();
		boolean flag = false;
		if(PipePage.equals("Opportunity Pipeline ~ Salesforce - Developer Edition"))  {
			System.out.println("Opportunity Pipeline link  under Reports are visible");
			flag =true;
		}else {
			System.out.println("Opportunity Pipeline link  under Reports are invisible");
		}
		return flag;
	}
	
	public void StruckPipelineValidation() {
		String stPipePage = driver.getTitle();
		assertTrue(stPipePage.equals("Stuck Opportunities ~ Salesforce - Developer Edition"),"Struck Opportunitylink link  under Reports are not Displayed");
//		if(stPipePage.equals("Stuck Opportunities ~ Salesforce - Developer Edition"))  {
//			System.out.println("Struck Opportunitylink  under Reports are displayed");
//		}else {
//			System.out.println("Struck Opportunitylink link  under Reports are not Displayed");
//		}
	}
	
	
	
	
	
	
}
