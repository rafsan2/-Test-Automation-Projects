package testselenium4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Elements {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		driver.get("https://google.com");

//		driver.findElement(By.name("q")).sendKeys("Automation Step By Step");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("orange hrm sign in", Keys.ENTER);

		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

//		WebElement email = driver.findElement(By.name("identifier"));
//		email.sendKeys("Admin");
//		
//		WebElement nextButton = driver.findElement(By.id("identifierNext"));
//		nextButton.click();
//		
//		WebElement pass = driver.findElement(By.name("pass"));
//		pass.sendKeys("12234");
//		
//		WebElement nextPass = driver.findElement(By.id("passwordNext"));
//		nextPass.click();
		
		driver.manage().window().maximize();
		WebElement Username = driver.findElement(By.name("txtUsername"));
		Username.sendKeys("Admin");

		WebElement pass = driver.findElement(By.name("txtPassword"));
		pass.sendKeys("admin123");

		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement button =  driver.findElement(By.name("Submit"));
		js.executeScript("arguments[0].click();", button);

		Thread.sleep(10000);

		driver.close();
		driver.quit();

	}

}
