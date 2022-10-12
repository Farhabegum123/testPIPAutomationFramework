package pagePckge;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressPage {
	/**
	 * Page is to fill all the Address details
	 * of User
	 */
public static WebDriver driver;
	
	public AddressPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="resAddress1")
	WebElement txtFlatNum;

	@FindBy(name="resAddress2")
	WebElement txtStrtLne;
	
	@FindBy(name="resAddress3")
	WebElement txtlocality;
	
	@FindBy(name="resPinCode")
	WebElement txtPinCde;
	
	@FindBy(name="resState")
	WebElement txtState;
	
	@FindBy(xpath="//a[contains(text(),'Terms and Condition')]")
	WebElement lnkTermsndCondtions;
	
	@FindBy(id="resPhone")
	WebElement txtPhone;
	
	@FindBy(xpath="(//div[@role='radio'])[3]")
	WebElement rdioResiYes;
	
	/**
	 * enter Address Fields 
	 * @throws Exception
	 */
	public void enterAddressFld(String FlatNum,String LaneNum,String LocaltyNum,String PinCode) throws Exception {
		JavascriptExecutor j = (JavascriptExecutor)driver;
        if (j.executeScript("return document.readyState").toString().equals("complete")){
           System.out.println("Page has loaded"); }
        else {
        	   System.out.println("Page has not loaded");
        }
        txtFlatNum.sendKeys(FlatNum);
        Thread.sleep(3000);
        txtStrtLne.sendKeys(LaneNum);
        Thread.sleep(3000);
        txtlocality.sendKeys(LocaltyNum);
        Thread.sleep(3000);
        txtPinCde.sendKeys(PinCode);
        Thread.sleep(3000);
	}
        
	/**
	 * select residence and click on 
	 * Terms and conditions
	 * @throws Exception
	 */
        public void copyResidence() throws Exception {
            Thread.sleep(3000);
        	  rdioResiYes.click();
              Thread.sleep(3000);
              lnkTermsndCondtions.click();
        }
      

    	/**
    	 * select city as Hyderabada and postal city 
    	 * @throws Exception
    	 */
        public void selectCityHyd(String State,String PhoneNum) throws Exception{
        //	 txtState.sendKeys(State);
             Thread.sleep(3000);
             txtPhone.sendKeys(PhoneNum);
             Thread.sleep(3000);
        	 WebElement slctCity=driver.findElement(By.xpath("//select[@formcontrolname='resCity']"));
     		Select slctCityHyd=new Select(slctCity);
     		slctCityHyd.selectByIndex(1);
            Thread.sleep(3000);
     		WebElement slctPstOff=driver.findElement(By.xpath("//select[@formcontrolname='resPostOff']"));
     		Select slctPostofHyd=new Select(slctPstOff);
     		slctPostofHyd.selectByIndex(1);
        }
       
	/*
	/ * farhana --Function to move focus driver 
	 * from one window to other window
	 */
	public void getWindowHandle() throws Exception {
		Set<String> windowsIds = driver.getWindowHandles();
		Iterator<String> it = windowsIds.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(parentId);
		System.out.println("Parent window title: " + driver.getTitle());
		driver.switchTo().window(childId);
		System.out.println("Child window title: " + driver.getTitle());
		driver.switchTo().window(childId);
		Thread.sleep(3000);
	}
}
