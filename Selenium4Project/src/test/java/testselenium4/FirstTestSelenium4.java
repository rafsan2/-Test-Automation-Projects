package testselenium4;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTestSelenium4 {

	public static void main(String[] args) {
		
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		/*Tried with an older version
			WebDriverManager.chromedriver().driverVersion("102.0.5005.61").setup();
		*/
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.get("https://google.com");
		driver.close();
	}
	
}
