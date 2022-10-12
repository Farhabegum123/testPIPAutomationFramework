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
	     @Parameters("browserName")
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
	}
	
	public void exreportopen()
	    {
		     report= new ExtentReports();
			 spark=new ExtentSparkReporter(System.getProperty("user.dir") + "/test-results/googleClass.html");
			 report.attachReporter(spark);
			 Test=report.createTest("Google Class room Meeting functionality testing");
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
	    public void googleClassPageOpen(WebDriver driver) throws Exception
		{
	    		String temp=getScreenshot(driver); 		
				Test.pass("Google Class Page Open",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
	    
	    public void googleclassMeetingnotOpen(WebDriver driver) throws Exception {
	    	String temp=getScreenshot(driver);
			Test.fail("Google Class Page not Open",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	    }
	    
	
	    public void exreportclose()
	    {
	    	report.flush();
	    }
	    
	@AfterTest
	 public void closeBrowser()  {
		 driver.close();
		 System.out.println("Test completed Successfully");
	 }
}
