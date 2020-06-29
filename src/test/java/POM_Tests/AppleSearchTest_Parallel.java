package POM_Tests;

import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import POM_Pages.AppleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;


//Class to get data from testNg xml

public class AppleSearchTest_Parallel {



	public WebDriver driver;
	public String browserName = null;


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
		
		else if(browserName.equalsIgnoreCase("opera")) {


			WebDriverManager.operadriver().setup(); 
			driver = new OperaDriver();
			System.out.println("opera started successfully");

		}

		//driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}

	@Test
	public void appleSearchTest()  {



		AppleSearchPage searchPageObj = new AppleSearchPage(driver);

		driver.get("https://apple.com");
		searchPageObj.enterSearchBox();
		searchPageObj.inputSearch("macbook");
		searchPageObj.searchEnter();


	}


	@AfterTest
	public void tearDownTest()  {

		//driver.close();


		try { 
			Set<String> windows = driver.getWindowHandles(); 
			Iterator<String> iter = windows.iterator(); 
			String[] winNames=new String[windows.size()]; 
			int i=0;
			while (iter.hasNext()) { 
				winNames[i]=iter.next(); 
				i++;
			}

			System.out.println("windows count " +winNames.length);

//			if(winNames.length > 1) { for(i = winNames.length; i > 1; i--) {
//				driver.switchTo().window(winNames[i - 1]);
//
//			} }

			//driver.switchTo().window(winNames[0]);


		} 
		catch(Exception e)
		{ 
			driver.quit();
			e.printStackTrace(); 
			}


		driver.quit();

		System.out.println("Test completed successfully");


	}







}
