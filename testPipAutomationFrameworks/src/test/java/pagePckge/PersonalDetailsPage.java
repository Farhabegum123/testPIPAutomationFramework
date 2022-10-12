package pagePckge;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PersonalDetailsPage {
	/**
	 * Page is to fill all the personal details
	 * of User
	 */
	public static WebDriver driver;
	
	public PersonalDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="firstName")
	WebElement txtFirstNme;
	
	@FindBy(name="lastname")
	WebElement txtLastNme;
	
	@FindBy(name="middleName")
	WebElement txtMiddleNme;
	
	@FindBy(xpath="//span[text()='Select Occupation']")
	WebElement slctOcuption;
	
	@FindBy(xpath="//span[text()='PRIVATE']")
	WebElement slctPrvteJob;
	
	@FindBy(xpath="//input[@placeholder='Date Of Birth']")
	WebElement entrDteBirth;
	
	@FindBy(xpath="(//div[@role='radio'])[1]")
	WebElement rdiobtn;
	
	@FindBy(xpath="//span[text()='Male']")
	WebElement btnGendr;
	
	@FindBy(id="email")
	WebElement entrEmail;
	
	@FindBy(name="mobile")
	WebElement fldMobile;
	
	@FindBy(xpath="(//select[contains(@class,'form-control')])[2]")
     WebElement slctNationality;
	
	@FindBy(xpath="//button[text()='Continue ']")
	WebElement btnContnue;
	
	@FindBy(xpath="//input[@placeholder='Date Of Birth']")
	WebElement tbleDatebirth;
	
	@FindBy(xpath="//tbody//tr//td/a[text()='22']")
	WebElement slctDate;
	

	/**
	 * enter Name of the user 
	 * @throws Exception
	 */
	public void enterNamesFld(String FirstName,String MiddleName,String LastName) throws Exception {
		JavascriptExecutor j = (JavascriptExecutor)driver;
        if (j.executeScript("return document.readyState").toString().equals("complete")){
           System.out.println("Page has loaded"); }
        else {
        	   System.out.println("Page has not loaded");
        }
        Thread.sleep(3000);
        txtFirstNme.sendKeys(FirstName);
        Thread.sleep(1000);
        txtMiddleNme.sendKeys(MiddleName);
        Thread.sleep(1000);
        txtLastNme.sendKeys(LastName);
        Thread.sleep(1000);
	}
	

	/**
	 * select occuption  and DOB 
	 * @throws Exception
	 */
	public void selectOccuptionndDOB() throws Exception {
		tbleDatebirth.click();
		 WebElement slectDob=driver.findElement(By.xpath("(//select[contains(@class,'datepicker')])[2]"));
  		Select slectyers=new Select(slectDob);
  		slectyers.selectByValue("1976");
		  Thread.sleep(3000);
		  slctDate.click();
		  Thread.sleep(3000);
		  slctOcuption.click();
	        Thread.sleep(1000);
	        slctPrvteJob.click();
	        Thread.sleep(1000);
	     //   entrDteBirth.sendKeys(DateBirth);
	        rdiobtn.click();
	        Thread.sleep(1000);
	        btnGendr.click();
	}
	

	/**
	 * enter email and  Mobile 
	 * @throws Exception
	 */
	public void enterEmilndMoble(String Email,String Mobile)  throws Exception  {
		  Thread.sleep(3000);
			entrEmail.sendKeys(Email);
			  Thread.sleep(2000);
			fldMobile.sendKeys(Mobile);
	}
	
	/**
	 * select Nationality as India and 
	 * click continue
	 * @throws Exception
	 */
	public void slctNationality()   throws Exception  {
		WebElement nationlity=driver.findElement(By.xpath("(//select[contains(@class,'form-control')])[2]"));
		Select slectNtionalty=new Select(nationlity);
		slectNtionalty.selectByVisibleText("India");
		  Thread.sleep(3000);
		  btnContnue.click();
		  Thread.sleep(2000);
		
	}
	 
	}
