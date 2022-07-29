package testselenium4;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement myLink = wait
				.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("JavaScript Alerts")));
		myLink.click();

		// JS Alert
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[@onClick='jsAlert()']")).click();
		Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText());
		Thread.sleep(5000);
		alert1.accept();

		if (driver.getPageSource().contains("You successfully clicked an alert")) {
			System.out.println("You successfully clicked an alert");
		}

		// JS Confirm
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		Alert confirmAlert = driver.switchTo().alert();
		System.out.println(confirmAlert.getText());
		Thread.sleep(5000);
		confirmAlert.dismiss();

		if (driver.getPageSource().contains("You clicked: Cancel")) {
			System.out.println("You clicked: Cancel");
		}

		// JS Prompt
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Alert promptAlert = driver.switchTo().alert();
		System.out.println(promptAlert.getText());
		Thread.sleep(5000);
		promptAlert.sendKeys("Hello World");
		Thread.sleep(5000);
		promptAlert.accept();

		if (driver.getPageSource().contains("You entered: Hello World")) {
			System.out.println("You entered: Hello World");
		}
		driver.close();
		driver.quit();
	}

}
