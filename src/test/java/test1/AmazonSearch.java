package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonSearch {

	public static void main(String[] args) {

		amazonSearch();
		
	}
	
	public static void amazonSearch() {
		
		//System.setProperty("webdriver.gecko.driver","drivers/geckodriver");
		
		WebDriverManager.chromedriver().setup(); 
		WebDriver driver = new ChromeDriver();
		
		
		
		
		driver.get("https://amazon.in");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nike");
		driver.findElement(By.xpath("//div//div//div//div[2]//div[1]//input[1]")).click();;
		
		driver.quit();
		
	}

}
