package Driver;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class DriverSetup {
	public static WebDriver driver;

	@BeforeClass
	public static void setDriver() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public static void close() {
		driver.close();
	}

}