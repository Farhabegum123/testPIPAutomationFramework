package testRunnerPckge;

import org.testng.Assert;
import org.testng.annotations.Test;

import basePackage.ExcelDataSupplier;
import basePackage.BaseClass;
import pagePckge.AddressPage;
import pagePckge.BasicDetailsPage;
import pagePckge.BusPagetourst;
import pagePckge.HomePagetourst;
import pagePckge.PersonalDetailsPage;

public class UserRegistrtionRuner extends  BaseClass{
	 @Test(dataProvider = "getData", dataProviderClass = basePackage.ExcelDataSupplier.class)
	public void profileRegstionTest(String UserName,String Password,String CnfmPassword
			,String SecurtyAnwrs,String FirstName,String MiddleName,String LastName,
			String Email,String Mobile,String FlatNum,String LaneNum,String LocaltyNum,String PinCode,
			String State,String PhoneNum) throws Exception {
		BasicDetailsPage bascDetlsPge=new BasicDetailsPage(driver);
		PersonalDetailsPage prsonlDetlsPage=new PersonalDetailsPage(driver);
		AddressPage adressPage=new AddressPage(driver);
		exreportopen();
		try {
			driver.get("https://www.irctc.co.in/nget/profile/user-registration");
	        String title=driver.getTitle();
			System.out.println("Title of the Page "+title);
	        Assert.assertEquals(title,"IRCTC Next Generation eTicketing System");
	        registrationProfilePageOpen(driver);
	        bascDetlsPge.clckonAlertbtn();
	        bascDetlsPge.usrNamendPsswrd(UserName, Password, CnfmPassword);
	        //bascDetlsPge.userNdPssword();
	        bascDetlsPge.selectPreferrdLanguage(SecurtyAnwrs);
	        registrationProfilePageOpen(driver);
	        prsonlDetlsPage.enterNamesFld(FirstName,MiddleName,LastName);
	        registrationProfilePageOpen(driver);
	        prsonlDetlsPage.selectOccuptionndDOB();
	        registrationProfilePageOpen(driver);
	        prsonlDetlsPage.enterEmilndMoble(Email, Mobile);
	        prsonlDetlsPage.slctNationality();
	           registrationProfilePageOpen(driver);
	           adressPage.enterAddressFld(FlatNum, LaneNum, LocaltyNum, PinCode);
	           registrationProfilePageOpen(driver);
	           adressPage.selectCityHyd(State, PhoneNum);
	           adressPage.copyResidence();
	           registrationProfilePageOpen(driver);
	           adressPage.getWindowHandle();
	            registrationProfilePageOpen(driver);     
	           }
		catch (Exception ex) {
			System.out.println("Not able to navigate to email account page");
			registrationProfilePagenotOpen(driver);
		}
			
	}

}
