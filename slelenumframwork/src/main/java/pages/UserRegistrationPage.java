package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase
{
	public UserRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(id="gender-male")WebElement genderRdoBtn; 
	@FindBy(id="FirstName")WebElement firstname; 
	@FindBy(id="LastName")WebElement lastname; 
	@FindBy(id="Email")WebElement email; 
	@FindBy(id="Password")WebElement password; 
	@FindBy(id="ConfirmPassword")WebElement confermpassword ; 
	@FindBy(id ="register-button") WebElement registerbtn; 
	@FindBy(css="div.result")public WebElement success;
    @FindBy(css ="a.ico-logout")public WebElement logout;
	@FindBy(linkText = "My account")WebElement myaccountlink;
	
	public void userRegistration (String FirstName ,String LastName ,String Email ,String Password ) throws InterruptedException
	{	
		clickButton(genderRdoBtn);
	    setTextElementTest(firstname, FirstName);
	    setTextElementTest(lastname, LastName);
	    setTextElementTest(email, Email);
	    setTextElementTest(password, Password);
	    setTextElementTest(confermpassword, Password);
	    clickButton(registerbtn);
		
	}
	public void userlogout()
	
	{
		clickButton(logout);
	}
	public void openMyAccountPage()
	{
		clickButton(myaccountlink);
	}

	
}
	
	
