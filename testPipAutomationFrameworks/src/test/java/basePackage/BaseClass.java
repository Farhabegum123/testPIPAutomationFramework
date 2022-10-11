package basePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class BaseClass {

	public  static WebDriver driver;
	@BeforeSuite
	 public void openBrowser() throws Exception {
	     System.setProperty("webdriver.chrome.driver","C:\\Users\\farhana.begum\\pip_workSpace\\testPipAutomationFrameworks\\drivers\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
	}
	
	@AfterSuite
	 public void closeBrowser()  {
		// driver.close();
	 }
}
