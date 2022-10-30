package tests;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import data.ExelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithExcel extends TestBase 
{
	HomePage homeObject ;
	UserRegistrationPage registrationObject;
	LoginPage loginObject;
	
	@DataProvider(name="Exeldata")
	public Object [][] userRegistrerData() throws IOException
	{
		// get data from Excel Reader class
		
		ExelReader ER = new ExelReader();
			return ER.getExcelData();
		}
	@Test (priority = 1,alwaysRun = true,dataProvider ="Exeldata")
	public void UserCanRegiterSuccssfully (String firstname ,String lastname ,String email ,String password ) throws InterruptedException
	
	{
		homeObject = new HomePage(driver); 
		homeObject.OpenRegistrationPage();
		registrationObject = new UserRegistrationPage(driver);
		registrationObject.userRegistration(firstname,lastname,email,password);
        Assert.assertTrue(registrationObject.success.getText().contains("completed"));
        registrationObject.userlogout();
        homeObject.OpenLogenpage();
        loginObject = new LoginPage(driver);
        loginObject.UserLogin(email,password);
        Assert.assertTrue(registrationObject.logout.getText().contains("Log out"));
        registrationObject.userlogout(); 
       
	}

}
