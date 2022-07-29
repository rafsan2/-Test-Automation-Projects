package testselenium4;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProxyDemo {

	public static void main(String[] args) throws InterruptedException {

		Proxy myProxy = new Proxy();
		myProxy.setAutodetect(false);
		//myProxy.setHttpProxy("localhost:8080");
		myProxy.setSslProxy("localhost:8080");

		ChromeOptions myOptions = new ChromeOptions();
		myOptions.setCapability("myProxy", myProxy);
		myOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(myOptions);
		
		driver.get("https://google.com/");
		Thread.sleep(5000);
		driver.quit();

	}

}
