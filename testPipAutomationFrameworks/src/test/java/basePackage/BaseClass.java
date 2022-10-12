package basePackage;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class BaseClass {

	public  static WebDriver driver;
	ExtentReports report; 
	ExtentSparkReporter spark;
	ExtentTest Test;
	
	  
         @BeforeTest
         public void openSetUp() throws Exception{
        	 System.setProperty("webdriver.chrome.driver","C:\\Users\\farhana.begum\\pip_workSpace\\testPipAutomationFrameworks\\drivers\\chromedriver.exe");
				 driver=new ChromeDriver();
				 driver.manage().window().maximize();
	
         }
            
         
	    /**@Parameters("browserName")
        public void openBrowser(String browserName) throws Exception {
            System.out.println("Browser  Name is:  "+ browserName);
			if(browserName.equals("chrome")){
				   System.setProperty("webdriver.chrome.driver","C:\\Users\\farhana.begum\\pip_workSpace\\testPipAutomationFrameworks\\drivers\\chromedriver.exe");
					 driver=new ChromeDriver();
					 driver.manage().window().maximize();
			}
			else if(browserName.equals("edge")) {
				 System.setProperty("webdriver.edge.driver","C:\\Users\\farhana.begum\\pip_workSpace\\testPipAutomationFrameworks\\drivers\\msedgedriver.exe");
		     driver=new EdgeDriver();
		          driver.manage().window().maximize();
			}
	}**/
         
        /** public void openBrowser(String browserName) throws Exception {
             System.out.println("Browser  Name is:  "+ browserName);
 				   System.setProperty("webdriver.chrome.driver","C:\\Users\\farhana.begum\\pip_workSpace\\testPipAutomationFrameworks\\drivers\\chromedriver.exe");
 					 driver=new ChromeDriver();
 					 driver.manage().window().maximize();
 			}**/
	
	
	  
	   
	 public void exreportopen()
	    {
		     report= new ExtentReports();
			 spark=new ExtentSparkReporter(System.getProperty("user.dir") + "/test-results/regstrProfileIrctc.html");
			 report.attachReporter(spark);
			 Test=report.createTest("Registration Profile IRCTC functionality testing");
	    }
	 
	    public static String getScreenshot(WebDriver driver) throws Exception
		{
	    	   TakesScreenshot ts=(TakesScreenshot)driver;
			   File src=ts.getScreenshotAs(OutputType.FILE);	  
			   String path=System.getProperty("user.dir") + "/Screenshots/"+System.currentTimeMillis()+".png";
			   File finalDest=new File(path); 
			   FileUtils.copyFile(src, finalDest);
			   return path;
			   
	    }
	    public void registrationProfilePageOpen(WebDriver driver) throws Exception
		{
	    		String temp=getScreenshot(driver); 		
				Test.pass("Registration Profile Page Open",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
    
	    public void registrationProfilePagenotOpen(WebDriver driver) throws Exception {
	    	String temp=getScreenshot(driver);
			Test.fail("Registration Profile Page not able Open",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	    }
	   
		@AfterTest
		 public void closeBrowser()  {
			 driver.close();
			 System.out.println("Test completed Successfully");
		 }
	    
		  public void exreportclose()
		    {
		    	report.flush();
		    }
}
