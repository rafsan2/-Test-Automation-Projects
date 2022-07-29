package Rk.TestNGPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoFirstTestNG {
	
	@Test
	public void TestGoogle() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("HYR Tutorials", Keys.ENTER);
		System.out.println(driver.getTitle());
		String expectedTitle="HYR Tutorials - Google Searchhh";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle,"Title is MisMatched");
		Thread.sleep(5000);
		driver.quit();
	}
	
	
	  @Test public void TestFB() throws Exception {
	  
	  WebDriverManager.chromedriver().setup(); WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize(); driver.get("https://facebook.com");
	  driver.findElement(By.name("email")).sendKeys("HYR Tutorials", Keys.ENTER);
	  System.out.println(driver.getTitle());
	  
	  Thread.sleep(5000); driver.quit(); }
	 

}
