package POM_Tests;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import POM_Pages.AppleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;


//Class to get data from testNg xml

public class AppleSearchTest_Parallel {
	

	
	private static WebDriver driver;
	public static String browserName = null;
	
	
	@Parameters("browserName")
	@BeforeTest
	public void setUpTest(String browserName) {
		
				
		if (browserName.equalsIgnoreCase("chrome")) {
			
			
			WebDriverManager.chromedriver().setup(); 
			//System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
			
			
			driver = new ChromeDriver();
			
			System.out.println("chrome started successfully");
		}

		else if(browserName.equalsIgnoreCase("firefox")) {
			
			
			WebDriverManager.firefoxdriver().setup(); 
			driver = new FirefoxDriver();
			System.out.println("firefox started successfully");

		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
	}
	
	@Test
	public static void appleSearchTest()  {
		
		
		
		AppleSearchPage searchPageObj = new AppleSearchPage(driver);
		
		driver.get("https://apple.com");
		searchPageObj.enterSearchBox();
		searchPageObj.inputSearch("macbook");
		searchPageObj.searchEnter();
		
		
	}
	
	
	@AfterClass
	public void tearDownTest()  {
		
		//driver.close();
		
		driver.quit();
		
		System.out.println("Test completed successfully");
		

	}
	
	
	
	
	
	

}
