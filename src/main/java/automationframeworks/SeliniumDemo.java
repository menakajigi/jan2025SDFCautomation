package automationframeworks;

import java.time.Duration;
//import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeliniumDemo {
	
//	
//	  static WebDriver driver = new ChromeDriver();
//	  
//	  static void SelectByVisibleText(String elementname, String value) {
//	  WebElement element = driver.findElement(By.id(elementname)); 
//	  Select drpdwn	  =new Select(element); 
	//drpdwn.selectByVisibleText(value); }
	 
	
	/*
	 * static String getText(String elementId, String Locators) { String text =
	 * null; if(Locators.equals("ID")) { text =
	 * driver.findElement(By.id(elementId)).getText(); } else
	 * if(Locators.equals("NAME")) { text =
	 * driver.findElement(By.name(elementId)).getText(); } else
	 * if(Locators.equals("XPATH")) { text =
	 * driver.findElement(By.xpath(elementId)).getText(); } else
	 * if(Locators.equals("CLASSNAME")) { text =
	 * driver.findElement(By.className(elementId)).getText(); } return text;
	 * 
	 * }
	 */
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//ChromeOptions co=new ChromeOptions(); -* headlist mode
		//co.addArguments("--headless");
		 WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		
	/*	driver.get("https://www.google.com/");
		
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("Selinium Java");
		driver.findElement(By.name("q")).submit();
		Thread.sleep(5000);
		*/
		 
		 
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30)); // explicit wait object creation
		driver.get("https://selenium-prd.firebaseapp.com/"); 
		
		// * implicit wait
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	//	Thread.sleep(1000);	
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email_field"))));
		driver.findElement(By.id("email_field")).sendKeys("admin123@gmail.com");
		driver.findElement(By.id("password_field")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@onclick='login()']")).click();
		
		Thread.sleep(1000);	
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(text(),'Switch')]")))); // explicit
//		
		driver.findElement(By.xpath("//a[text()= 'Home']")).click();
//		
//		
//		WebElement switchTo =driver.findElement(By.xpath("//button[contains(text(),'Switch')]"));
//		
//		Actions action = new Actions(driver);
//		action.moveToElement(switchTo).build().perform();
//	//	Thread.sleep(2000);
////		driver.findElement(By.xpath("//a[text() = 'Alert']")).click();
//	//	Thread.sleep(2000);
////		driver.findElement(By.xpath("//button[text() ='Window Alert']")).click();
//	//	Thread.sleep(3000);
////		driver.switchTo().alert().accept();
//		
//	//	Thread.sleep(2000);
////		driver.findElement(By.xpath("//button[text()='Promt Alert']")).click();
////		driver.switchTo().alert().accept();
//	//	Thread.sleep(5000);
//		WebElement switchTo1 =driver.findElement(By.xpath("//button[contains(text(),'Switch')]"));
//		Actions action1 = new Actions(driver);
//		action1.moveToElement(switchTo1).build().perform();
//		
		//to switch to windows;
//		driver.findElement(By.xpath("//a[text() = 'Windows']")).click();
//		driver.findElement(By.xpath("//button[contains(text(),'Tab')]")).click();
//		String oldwindowID = driver.getWindowHandle();
//		Set<String> windowIDs = driver.getWindowHandles();
//		String[]getWindow= windowIDs.toArray(new String[windowIDs.size()]);
//		Thread.sleep(3000);
//		
//		driver.switchTo().window(getWindow[1]);
//		driver.close();	
//		driver.switchTo().window(oldwindowID);
//		
//		Thread.sleep(5000);
//		
//		driver.findElement(By.xpath("//button[contains(text(),'Window')]")).click();
//		String oldwindowID1 = driver.getWindowHandle();
//		Set<String> windowIDs1 = driver.getWindowHandles();
//		
//		String[]getWindow1= windowIDs1.toArray(new String[windowIDs1.size()]);
//		Thread.sleep(3000);
//		driver.switchTo().window(getWindow1[1]);
//		driver.close();	
//		driver.switchTo().window(oldwindowID1);
//		Thread.sleep(3000);
		
//		//switch to Tab
//		WebElement switchTo2 =driver.findElement(By.xpath("//button[contains(text(),'Switch')]"));
//		Actions action2 = new Actions(driver);
//		action2.moveToElement(switchTo2).build().perform();
//		
//		driver.findElement(By.xpath("//a[(text()='Tabs')]")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//button[text()='London']")).click();
//		Thread.sleep(2000);
//		String londonText = driver.findElement(By.xpath("//*[@id=\"London\"]/h3")).getText();  //checking the text
//		if(londonText.equals("London")) {
//			System.out.println("Valid Click of London");
//		} else {
//			System.out.println("Invalid Text");
//		}
//		
//		driver.findElement(By.xpath("//button[text()='Paris']")).click();
//		Thread.sleep(2000);
//		String parisText = driver.findElement(By.xpath("//*[@id=\"Paris\"]/h3")).getText();
////		String parisText = getText("//*[@id='Paris']/h3", "XPATH");//checking the text?
//		if(parisText.equals("Paris")) {
//			System.out.println("Valid Click of Paris");
//		} else {
//			System.out.println("Invalid Text");
//		}
//		
//		driver.findElement(By.xpath("//button[text()='Tokyo']")).click();
//		Thread.sleep(2000);
//		String tokyoText = driver.findElement(By.xpath("//*[@id=\"Tokyo\"]/h3")).getText();  //checking the text
//		if(tokyoText.equals("Tokyo")) {
//			System.out.println("Valid Click of Tokyo");
//		} else {
//			System.out.println("Invalid Text");
//		}
//		
//		
//		
		
		
		
		//switch to Interactions
		/*
		 * WebElement switchTo2
		 * =driver.findElement(By.xpath("//button[contains(text(),'Intractions')]"));
		 * Actions action2 = new Actions(driver);
		 * action2.moveToElement(switchTo2).build().perform();
		 */
		
	//	driver.findElement(By.xpath("//a[(text()='Drag & Drop')]")).click();
	//	Thread.sleep(3000);
	//	WebElement from = driver.findElement(By.id("drag1"));
		
	//	WebElement to = driver.findElement(By.id("div1"));
		
	//	action2.dragAndDrop(from, to).perform();
		
		//double click
		/*
		 * WebElement switchTo2
		 * =driver.findElement(By.xpath("//button[contains(text(),'Intractions')]"));
		 * Actions action2 = new Actions(driver);
		 * action2.moveToElement(switchTo2).build().perform();
		 * 
		 * driver.findElement(By.xpath("//a[contains(text(),'Double Click')]")).click();
		 * Thread.sleep(3000);
		 * driver.findElement(By.xpath("//button[contains(text(),'single Click')]")).
		 * click(); String CountText = driver.findElement(By.id("demo1")).getText();
		 * //checking the text if(CountText.equals("Count = 1")) {
		 * System.out.println("Valid Click of Click1"); } else {
		 * System.out.println("Invalid Text"); } Thread.sleep(3000); //double click
		 * check
		 * 
		 * WebElement Doubleclick =
		 * driver.findElement(By.xpath("//button[contains(text(),'Double Click')]"));
		 * Actions action3 = new Actions(driver);
		 * action3.doubleClick(Doubleclick).perform(); Thread.sleep(3000); String
		 * CountText1 = driver.findElement(By.id("Selenium")).getText(); //checking the
		 * text if(CountText1.equals("Count = 1")) {
		 * System.out.println("Valid Click of Click2"); } else {
		 * System.out.println("Invalid Text2"); }
		 */
		  //tool tip
		WebElement switchTo2 =driver.findElement(By.xpath("//button[(text()='Intractions']"));
		Actions action4 = new Actions(driver);
		action4.moveToElement(switchTo2).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[(text(),'Tool Tip')]")).click();
		
		WebElement element = driver.findElement(By.xpath("//div[@class='tooltipr']"));
		Actions action5 = new Actions(driver);
		action5.moveToElement(element).perform();
		Thread.sleep(3000);
		
		
		
	/*	driver.findElement(By.name("name")).sendKeys("Menaka Jigi");
		driver.findElement(By.id("lname")).sendKeys("Mundhava Rao");
		driver.findElement(By.id("postaladdress")).sendKeys("123,abc");
		driver.findElement(By.id("personaladdress")).sendKeys("345,cdr");
		driver.findElement(By.xpath("//input[@value='female']")).click();
		WebElement cityDD = driver.findElement(By.id("city"));
		Select drpdwnCity =new Select(cityDD);
		drpdwnCity.selectByVisibleText("NEW DELHI");
		
		WebElement courseDD = driver.findElement(By.id("course"));
		Select drpdwnCourse =new Select(courseDD);
		drpdwnCourse.selectByVisibleText("MCA");
		
		WebElement districtDD =driver.findElement(By.id("district"));
		Select drpdwnDist =new Select(districtDD);
		drpdwnDist.selectByVisibleText("MUMBAI");
		
		WebElement stateDD =driver.findElement(By.id("state"));
		Select drpdwnState =new Select(stateDD);
		drpdwnState.selectByVisibleText("GOA");
		
		driver.findElement(By.id("pincode")).sendKeys("12345");
		driver.findElement(By.id("emailid")).sendKeys("abc@mail.com");
		driver.findElement(By.className("bootbutton")).click();
		/*
		 * SelectByVisibleText("city", "NEW DELHI"); SelectByVisibleText("course",
		 * "MCA"); SelectByVisibleText("district", "MUMBAI");
		 * SelectByVisibleText("state","GOA");
		 */
		
		
		Thread.sleep(5000);	
		
		driver.quit();
		System.out.println(" successfully executed");
		
		
	}

}
