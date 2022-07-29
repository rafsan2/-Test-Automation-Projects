package Rk.TestNGPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginDemoTestNG {

	/*
	 * System.out.println(driver.getTitle()); String expectedTitle =
	 * "orange hrm login - Google Search"; String actualTitle = driver.getTitle();
	 * Assert.assertEquals(actualTitle, expectedTitle, "Title is Matched");
	 * 
	 * 
	 * 
	 * Thread.sleep(5000); driver.quit(); }
	 */

	ExtentReports extent;
	ExtentSparkReporter sparkReporter;
	WebDriver driver;

	@BeforeSuite
	public void setUp() {

		extent = new ExtentReports();
		sparkReporter = new ExtentSparkReporter("target/Spark/Login.html");
		extent.attachReporter(sparkReporter);

	}

	@BeforeTest
	public void setUpTest() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void test1() {

		ExtentTest loginTest = extent.createTest("Valid Login Test");
		driver.get("https://google.com");
		loginTest.info("This step shows navigated to expected website");
		
		driver.findElement(By.name("q")).sendKeys("orange hrm login", Keys.ENTER);
		String expectedTitle ="orange hrm login - Google Search"; 
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Title is Matched");
		loginTest.log(Status.INFO, "This step shows Assertion was Validated");
		

		loginTest.info("This step shows opening the web browser as expected");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement myLink = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("OrangeHRM")));
		myLink.click();

		loginTest.info("Navigated to Expected WebSite");
		
		WebElement admin = driver.findElement(By.name("txtUsername"));
		admin.sendKeys("Admin");
		
		WebElement pass = driver.findElement(By.name("txtPassword"));
		pass.sendKeys("admin123");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement button =  driver.findElement(By.name("Submit"));
		js.executeScript("arguments[0].click();", button);
		
		loginTest.pass("Successfully Logged In");
		
	}

	/*
	 * @Test public void test2() {
	 * 
	 * ExtentTest loginTest = extent.createTest("Valid Login Test");
	 * loginTest.log(Status.INFO, "This step shows usage of log");
	 * loginTest.info("This step shows usage of info"); loginTest.fail("Failed");
	 * 
	 * }
	 */

	@AfterTest
	public void tearDownTest() throws InterruptedException {

		Thread.sleep(5000);
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");

	}
	
	@AfterSuite
	public void tearDown() {

		extent.flush();

	}

	

}
