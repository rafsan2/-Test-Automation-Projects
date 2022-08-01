package LoginExcelTestNG;

import java.net.URI;
import java.net.URL;
import java.time.Duration;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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

public class ExcelLoginTestNG {

	static ExtentReports extent;
	ExtentSparkReporter sparkReporter;

	static WebDriver driver;
	static String projectPath;
	static XSSFWorkbook credWorkBook;
	static XSSFSheet credSheet;
	static String urlCell1;
	static String userNameCell1;
	static String userNameCell2;
	static String passCell1;
	static String passCell2;
	static String strAdmin;
	static String passWord;
	static String myUrl;
	static JavascriptExecutor js;

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
	public void getRowCount() {

		ExtentTest rowCountTest = extent.createTest("Row Count Test");

		try {

			projectPath = System.getProperty("user.dir");
			credWorkBook = new XSSFWorkbook(projectPath + "/ExcelFiles/Login_TestNG.xlsx");
			credSheet = credWorkBook.getSheet("Sheet1");
			int rowCount = credSheet.getPhysicalNumberOfRows();
			rowCountTest.info("No of Rows : " + rowCount);
			System.out.println("No of Rows : " + rowCount);
			rowCountTest.pass("No of Rows Verified");

		} catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();

		}

	}

	@Test
	public static void getCellData() {

		ExtentTest cellDataTest = extent.createTest("Cell Data Test");

		try {

			projectPath = System.getProperty("user.dir");
			credWorkBook = new XSSFWorkbook(projectPath + "/ExcelFiles/Login_TestNG.xlsx");
			credSheet = credWorkBook.getSheet("Sheet1");

			urlCell1 = credSheet.getRow(1).getCell(0).getStringCellValue();
			URI uri = new URI(urlCell1);
			URL url = uri.toURL();
			myUrl = url.toString();

			userNameCell1 = credSheet.getRow(1).getCell(1).getStringCellValue();
			passCell1 = credSheet.getRow(1).getCell(2).getStringCellValue();

			userNameCell2 = credSheet.getRow(2).getCell(1).getStringCellValue();
			passCell2 = credSheet.getRow(2).getCell(2).getStringCellValue();

			Thread.sleep(3000);
			cellDataTest.info("URL from Cell: " + myUrl);
			cellDataTest.info("Usename from Exel: " + userNameCell1);
			cellDataTest.info("Usename from Exel: " + userNameCell2);
			cellDataTest.pass("Got all the values from excel.");

			System.out.println(urlCell1);
			System.out.println(userNameCell1);
			System.out.println(userNameCell2);
			System.out.println(passCell1);
			System.out.println(passCell2);

		} catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();

		}

	}

	@Test
	public void validLogin() throws InterruptedException {

		ExtentTest loginTest = extent.createTest("Valid Login Test");
		driver.get(myUrl);
		String expectedTitle = "OrangeHRM";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Title is Matched");
		loginTest.log(Status.INFO, "This step shows Assertion was Validated");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		loginTest.info("Navigated to Expected WebSite");

		strAdmin = userNameCell1.toString();
		passWord = passCell1.toString();

		WebElement admin = driver.findElement(By.name("txtUsername"));
		admin.sendKeys(strAdmin);

		WebElement pass = driver.findElement(By.name("txtPassword"));
		pass.sendKeys(passWord);

		js = (JavascriptExecutor) driver;
		WebElement button = driver.findElement(By.name("Submit"));
		js.executeScript("arguments[0].click();", button);

		Thread.sleep(3000);
		loginTest.addScreenCaptureFromPath("successfulLogin.png");

		loginTest.pass("Successfully Logged via Excel Credentials");

	}

	
	  @Test public void verifyLogin() throws InterruptedException {
	  
	  WebElement element = driver.findElement(By.id("welcome"));
	  System.out.println(element.isDisplayed());
	  System.out.println(element.getText()); Thread.sleep(3000);
	  
	  }
	 

	@Test
	public void inValidLogin() throws InterruptedException {

		ExtentTest invLoginTest = extent.createTest("Invalid Login Test");
		driver.get(myUrl);
		String expectedTitle = "OrangeHRM";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Title is Matched");
		invLoginTest.log(Status.INFO, "This step shows Assertion was Validated");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		invLoginTest.info("Navigated to Expected WebSite");

		strAdmin = userNameCell2.toString();
		passWord = passCell2.toString();

		WebElement admin = driver.findElement(By.name("txtUsername"));
		admin.sendKeys(strAdmin);

		WebElement pass = driver.findElement(By.name("txtPassword"));
		pass.sendKeys(passWord);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement button = driver.findElement(By.name("Submit"));
		js.executeScript("arguments[0].click();", button);

		Thread.sleep(3000);
		//exten.addScreenCaptureFromPath("./InvalidLogin.png");
		invLoginTest.fail("Couldn't Logged via Excel Credentials");
		//Thread.sleep(5000);

	}

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
