package pagePckge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class BusPagetourst {
	
public static WebDriver driver;
	
	public BusPagetourst(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='departFrom']")
	WebElement btnDeptFrom;
	
	@FindBy(xpath="//li[@class='ui-menu-item']/div[text()='Hyderabad']")
	WebElement slcHyd;
	
	
	@FindBy(xpath="//input[@id='goingTo']")
	WebElement btnGongTo;
	
	@FindBy(xpath="//li[@class='ui-menu-item']/div[text()='Goa']")
	//@FindBy(xpath="(//li[@class='ui-menu-item']/div[text()='Goa'])[1]")
	WebElement btnGoa;
	
	@FindBy(xpath="//input[@id='departDate']")
	WebElement btnDeptureDte;
	
	@FindBy(xpath="//button[contains(text(),'Search')]")
	WebElement btnSearchBox;
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement btnNxtMont;
	
	@FindBy(xpath="//tbody/tr/td[@data-handler='selectDay']/a[text()='7']")
	WebElement slectDate;
 
	public void cityDeptureFrom()  throws Exception{
		Actions a=new Actions(driver);
		Thread.sleep(3000);
		btnDeptFrom.sendKeys("Hyderabad");
		Thread.sleep(2000);
		a.doubleClick(slcHyd).build().perform();
		//a.moveToElement(slcHyd).build().perform();
		//slcHyd.click();
		System.out.println("Selected City as Hyderabad");
	}
	
	public void cityGngTo() throws Exception {
		Actions a=new Actions(driver);
		Thread.sleep(3000);
	btnGongTo.sendKeys("Goa");
	Thread.sleep(3000);
//	a.doubleClick(btnGoa).build().perform();
//	a.moveToElement(btnGoa).build().perform();
	btnGoa.click();
		System.out.println("City  Going to Goa");
	}
	
	public void slectDeptureDate() throws Exception{
		Thread.sleep(1000);
		btnDeptureDte.click();
		Thread.sleep(1000);
		btnNxtMont.click();
		Thread.sleep(1000);
		slectDate.click();
		System.out.println("Depture Date Select as");
	}
	
	public void selectSearchBox() throws Exception {
		Thread.sleep(1000);
		btnSearchBox.click();
		System.out.println("Search Box selected");
		Thread.sleep(3000);
	}
	
	
	public void resultsforBuses() {
   //  String text= driver.findElement(By.xpath("//*[text()='We have got 37 results']")).getText();
   //  String text=driver.findElement(By.xpath("((//div[@class='container-fluid'])[2]//div[contains(@class,'heading')])[6]")).getText();
  //   WebElement text=driver.findElement(By.xpath("//h3[text()='We have got 37 results']"));
     //    String text=driver.findElement(By.xpath("((//div[@class='container-fluid'])[2]//div[contains(@class,'heading')])[6]/h3")).getText();
     
		String text=driver.findElement(By.xpath("//div//h3[contains(text(),'We have got')]")).getText();
		System.out.println(text);
		String txt2="We have got 38 results";
		if(text.equals(txt2)) {
			System.out.println("We have got results");
		}
		else {
			System.out.println("We have not got results");
		}
				
	//	boolean isDisplayed = driver.findElement(By.xpath("//*[contains(text(),'We have got')]")).isDisplayed();
		//Assert.assertTrue(isDisplayed);
		//System.out.println("We have got results");
	}
}
