package testRunnerPckge;

import org.testng.Assert;
import org.testng.annotations.Test;

import basePackage.BaseClass;
import pagePckge.BusPagetourst;
import pagePckge.HomePagetourst;

public class TourismRunnerClass extends BaseClass
{
	@Test()
	public void tourismTest() throws Exception {
		//BasicDetailsPage homePgeTrst=new BasicDetailsPage(driver);
	//	exreportopen();
			driver.get("https://www.irctctourism.com/accommodation");
			//driver.get("https://www.bus.irctc.co.in/home");
	        String title=driver.getTitle();
			System.out.println("Title of the Page "+title);
		Assert.assertEquals(title,"IRCTC Tourism Official Website | Incredible India Travel & Tour Package");
		//	homePgeTrst.selctStationName();
			/**homePgeTrst.busTicket();
			homePgeTrst.getWindowHandle();
		     String title2=driver.getTitle();
			System.out.println("Title of the Page "+title2);
			busPgeTrst.cityDeptureFrom();
			busPgeTrst.cityGngTo();
			busPgeTrst.slectDeptureDate();
			busPgeTrst.selectSearchBox();
			busPgeTrst.resultsforBuses();
			//exreportclose();
			**/
		
	
	}

}
