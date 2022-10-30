package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(id="Email")WebElement emailbox; 
	@FindBy(id="Password")WebElement passwordbox; 
	@FindBy(css = "button.button-1.login-button") WebElement loginBtn;

	public void UserLogin(String email ,String password) throws InterruptedException
	{
		setTextElementTest(emailbox, email);
	Thread.sleep(2000);
		setTextElementTest(passwordbox, password);
		Thread.sleep(2000);
		clickButton(loginBtn);
		Thread.sleep(4000);

	}
}
