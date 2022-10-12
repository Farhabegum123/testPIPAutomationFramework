package testRunnerPckge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Test1 {

	public static void main(String[] args) {
		
		
		 System.setProperty("webdriver.edge.driver","C:\\Users\\farhana.begum\\pip_workSpace\\testPipAutomationFrameworks\\drivers\\msedgedriver.exe");
          WebDriver driver=new EdgeDriver();
          driver.manage().window().maximize();
			driver.get("https://www.irctctourism.com/accommodation");
			   String title=driver.getTitle();
				System.out.println("Title of the Page "+title);
			Assert.assertEquals(title,"IRCTC Tourism Official Website | Incredible India Travel & Tour Package");
	}
}
