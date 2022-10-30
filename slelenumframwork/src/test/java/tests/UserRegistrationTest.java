package tests;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.HomePage;
import pages.UserRegistrationPage;
public class UserRegistrationTest extends TestBase 
{
	HomePage homeObject ;
	UserRegistrationPage registrationObject;
	@Test
	public void UserCanRegiterSuccssfully () throws InterruptedException 
	{
		homeObject = new HomePage(driver); 
		homeObject.OpenRegistrationPage();
		registrationObject = new UserRegistrationPage(driver);
		registrationObject.userRegistration("ahmed","shahin","otp8a@gmail.com","UAt123");
        Assert.assertTrue(registrationObject.success.getText().contains("completed"));
        Thread.sleep(1000); 
   // next 164 
	}

}
