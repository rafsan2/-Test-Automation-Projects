package esxcelLoginUtils;

import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelLoginUtils {

	static String projectPath;
	static XSSFWorkbook credWorkBook;
	static XSSFSheet credSheet;
	static String urlCell1;
	static String userNameCell1;
	static String passCell1;

	public static void main(String[] args) throws InterruptedException {

		getRowCount();
		getCellData();

	}

	public static void getRowCount() {

		try {

			projectPath = System.getProperty("user.dir");
			credWorkBook = new XSSFWorkbook(projectPath + "/Excel/loginCred.xlsx");
			credSheet = credWorkBook.getSheet("Sheet1");
			int rowCount = credSheet.getPhysicalNumberOfRows();
			System.out.println("No of Rows : " + rowCount);

		} catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();

		}

	}

	public static void getCellData() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		try {

			projectPath = System.getProperty("user.dir");
			credWorkBook = new XSSFWorkbook(projectPath + "/Excel/loginCred.xlsx");
			credSheet = credWorkBook.getSheet("Sheet1");

			urlCell1 = credSheet.getRow(1).getCell(0).getStringCellValue();
			URI uri = new URI(urlCell1);
			URL url = uri.toURL();
			String myUrl = url.toString();
			driver.get(myUrl);
			driver.manage().window().maximize();

			userNameCell1 = credSheet.getRow(1).getCell(1).getStringCellValue();
			passCell1 = credSheet.getRow(1).getCell(2).getStringCellValue();
			
			String strAdmin = userNameCell1.toString();
			String paasWord= passCell1.toString();
			
			WebElement admin = driver.findElement(By.name("txtUsername"));
			admin.sendKeys(strAdmin);
			
			WebElement pass = driver.findElement(By.name("txtPassword"));
			pass.sendKeys(paasWord);
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			WebElement button =  driver.findElement(By.name("Submit"));
			js.executeScript("arguments[0].click();", button);
			
			Thread.sleep(10000);

			System.out.println(urlCell1);
			System.out.println(url);
			System.out.println(userNameCell1);
			System.out.println(passCell1);

		} catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();

		}

	}

}
