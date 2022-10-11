package pagePckge;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePagetourst {

	public static WebDriver driver;
	
	public HomePagetourst(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "city")
	WebElement btnStationNme;
	
	@FindBy(xpath="(//div[contains(@class,'BusTickets')])[1]")
    WebElement btnBustckt;
	
	
	
	public void selctStationName() {
		WebElement stationName=driver.findElement(By.name("city"));
		Select stionNme=new Select(stationName);
		stionNme.selectByIndex(1);
		//btnStationNme.click();
	}
	
	public void selctLoungesName() {
		WebElement stationName=driver.findElement(By.name("laungecity"));
		Select stionNme=new Select(stationName);
		stionNme.selectByIndex(1);
	}
	
	public void busTicket() {
	//	Actions a=new Actions(driver);
		//a.doubleClick(btnBustckt).build().perform();
		btnBustckt.click();
		System.out.println("Clicked on Bus Ticket link");

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
