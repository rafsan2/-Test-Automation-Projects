package testselenium4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseActionsDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
		WebElement boxA = driver.findElement(By.xpath("//li[text()='A']"));
		WebElement boxD = driver.findElement(By.xpath("//li[text()='D']"));
		Actions clicknHoldActions = new Actions(driver);

		clicknHoldActions.moveToElement(boxA);
		clicknHoldActions.clickAndHold();
		clicknHoldActions.moveToElement(boxD);
		clicknHoldActions.build().perform();

		Thread.sleep(5000);

		driver.get("https://selenium08.blogspot.com/2020/01/drag-drop.html");
		WebElement elm1 = driver.findElement(By.id("draggable"));
		WebElement elm2 = driver.findElement(By.id("droppable"));
		Actions dragnDropActions = new Actions(driver);
		dragnDropActions.dragAndDrop(elm1, elm2);
		dragnDropActions.build().perform();

		WebElement rightClickElm = driver.findElement(By.className("search-expand-text"));
		Actions rightClickActions = new Actions(driver);
		rightClickActions.contextClick(rightClickElm);
		rightClickActions.build().perform();

		Thread.sleep(5000);
		driver.quit();
		System.out.println("Done.");

	}

}
