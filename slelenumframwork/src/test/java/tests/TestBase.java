package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class TestBase 
{
	public static WebDriver driver;
	@BeforeSuite
	@Parameters({"browser"})
	public  void startDriver(@Optional("chrome")String browserName)
	{
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/Chromedriver.exe");
			driver = new ChromeDriver(); 
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			driver = new FirefoxDriver(); 
		}
		
		
		driver.manage().window().maximize();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.navigate().to("https://demo.nopcommerce.com/");
	}
	@AfterSuite
	public void  stopDriver()
	{
		driver.quit();
	}
}
