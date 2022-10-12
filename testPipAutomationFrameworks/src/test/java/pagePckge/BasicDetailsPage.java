package pagePckge;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicDetailsPage
{
public static WebDriver driver;


	public BasicDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()='OK']")
	WebElement btnOk;
	
	@FindBy(name="userName")
	WebElement userName;

	@FindBy(name="usrPwd")
	WebElement userPswd;

	@FindBy(name="cnfUsrPwd")
	WebElement userConPswd;
	
	@FindBy(xpath="//span[text()='Preferred Language']")
	WebElement fldPrefLan;
	
	@FindBy(xpath="//span[text()='English']")
	WebElement slctEnglish;
	
	@FindBy(xpath="//span[text()='Security Question']")
	WebElement securityQstn;

	@FindBy(xpath="//span[contains(text(),'Who was your')]")
	WebElement selctFavHero;
	
   @FindBy(xpath="//button[text()='Continue ']")
   WebElement btnContnue;
   
   @FindBy(xpath="//input[@placeholder='Security Answer']")
   WebElement secrityAnsers;
   
   

	/**
	 * click on Alert button  
	 * @throws Exception
	 */
	public void clckonAlertbtn() throws Exception {
		JavascriptExecutor j = (JavascriptExecutor)driver;
        if (j.executeScript("return document.readyState").toString().equals("complete")){
           System.out.println("Page has loaded"); }
        else {
        	   System.out.println("Page has not loaded");
        }
        Thread.sleep(3000);
		btnOk.click();
		System.out.println("Clicked on Alert Ok on the link");
	}
	

	/**
	 * enter userName,Password, confirmPassword 
	 * @throws Exception
	 */
	public void usrNamendPsswrd(String UserName,String Password,String CnfmPassword) throws Exception {
		Thread.sleep(1000);
		userName.sendKeys(UserName);	
		Thread.sleep(1000);
		userPswd.sendKeys(Password);
		Thread.sleep(1000);
		userConPswd.sendKeys(CnfmPassword);
		Thread.sleep(1000);
	}

	/**
	 * select Preferred Language and  
	 * security answers 
	 * @throws Exception
	 */
	public void selectPreferrdLanguage(String  SecurtyAnwrs) throws Exception{
		Thread.sleep(1000);
		fldPrefLan.click();
		slctEnglish.click();
		Thread.sleep(1000);
		securityQstn.click();
		selctFavHero.click();
		Thread.sleep(1000);
		secrityAnsers.sendKeys(SecurtyAnwrs);
		Thread.sleep(1000);
		btnContnue.click();
		Thread.sleep(1000);
	}
   
}
