package testselenium4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementPrac {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

//		FindElements
		/*
		 * driver.get("https://www.google.com"); driver.manage().window().maximize();
		 * WebElement searchBox = driver.findElement(By.name("q"));
		 * searchBox.sendKeys("Selenium", Keys.ENTER);
		 */

//		FindElements By Tag_name for all 'Select' tag
		/*
		 * driver.get("https://trytestingthis.netlify.app/"); List<WebElement>
		 * SelectElements = driver.findElements(By.tagName("select"));
		 * 
		 * for(WebElement element:SelectElements) {
		 * System.out.println(element.getText()); }
		 */

		// Find Elements within Elements

		/*
		 * driver.get("https://www.google.com"); driver.manage().window().maximize();
		 * WebElement searchForm= driver.findElement(By.tagName("form"));
		 * searchForm.findElement(By.name("q")).sendKeys("ABCD"+Keys.ENTER);
		 */

		// Get Active Element

		/*
		 * driver.get("https://www.google.com");
		 * driver.findElement(By.name("q")).sendKeys("Selenium" + Keys.ENTER);
		 * driver.manage().window().maximize(); driver.findElement(By.tagName("form"));
		 * String title = driver.switchTo().activeElement().getAttribute("title");
		 * System.out.println(title);
		 */

		// Get tag name, text, css etc
		/*
		 * driver.get("https://www.google.com"); driver.manage().window().maximize();
		 * WebElement searchBox = driver.findElement(By.name("q")); String tagName =
		 * searchBox.getTagName(); String text = searchBox.getText(); String cssValue =
		 * searchBox.getCssValue("color");
		 * 
		 * System.out.println(tagName + " | " + text + " | " + cssValue);
		 */
		
		//Check element is selected, enabled etc
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		driver.manage().window().maximize();
		WebElement checkBox1 =  driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
		WebElement checkBox2 =  driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		System.out.println("CheckBox1 Enable: "+checkBox1.isEnabled());
		System.out.println("CheckBox1 Selected: "+checkBox1.isSelected());
		System.out.println("CheckBox2 Enable: "+checkBox2.isEnabled());
		System.out.println("CheckBox2 Selected: "+checkBox2.isSelected());
		Thread.sleep(5000);
		driver.quit();

	}

}
