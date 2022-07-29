package testselenium4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://trytestingthis.netlify.app/");
		WebElement dropDown = driver.findElement(By.id("option"));
		Select selecObject = new Select(dropDown);
		selecObject.selectByIndex(1);
		Thread.sleep(3000);
		selecObject.selectByValue("option 2");
		Thread.sleep(3000);
		selecObject.selectByVisibleText("Option 3");
		Thread.sleep(3000);

		Select selecObject2 = new Select(dropDown);
		List<WebElement> allAvailableOptions = selecObject2.getOptions();

		for (WebElement option : allAvailableOptions) {
			System.out.println(option.getText());
			if (option.getText().equalsIgnoreCase("option 2")) {
				option.click();
			}
			Thread.sleep(3000);
		}

		WebElement dropDown2 = driver.findElement(By.id("owc"));
		Select deSelecObject = new Select(dropDown2);
		
		deSelecObject.selectByIndex(1);
		Thread.sleep(3000);
		deSelecObject.selectByValue("option 2");
		Thread.sleep(3000);
		deSelecObject.deselectByVisibleText("Option 3");

		Thread.sleep(4000);
		driver.quit();
		System.out.println("Done");

	}

}
