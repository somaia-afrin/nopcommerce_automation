package Testcases;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class Register extends DriverSetup {

	public static String baseURL = "https://training.nop-station.com/";

	@Test // TestNG Annotation
	public static void registration() throws InterruptedException {
		driver.get(baseURL); // Get base url and run on browser
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize(); // maximize the browser window
		Thread.sleep(1000); // used for waiting

		driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click(); // click is a method used for click
		driver.findElement(By.xpath("//input[@id='gender-female']")).click();	
		driver.findElement(By.xpath("//input[@id='FirstName']")).click();
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("somaia");
		driver.findElement(By.xpath("//input[@id='LastName']")).click();
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("afrin");
		driver.findElement(By.xpath("//input[@id='Email']")).click();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("somaia123@gmail.com");
		
		WebElement ddown1=driver.findElement(By.name("DateOfBirthDay"));
		Select select1=new Select(ddown1);
		select1.selectByValue("10");
		
		WebElement ddown2=driver.findElement(By.name("DateOfBirthMonth"));
		Select select2=new Select(ddown2);
		select2.selectByValue("10");
		
		WebElement ddown3=driver.findElement(By.name("DateOfBirthYear"));
		Select select3=new Select(ddown3);
		select3.selectByValue("1996");
		
		driver.findElement(By.xpath("//input[@id='Company']")).click();
		driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("ABC Company");
		driver.findElement(By.xpath("//input[@id='Password']")).click();
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("@123Abc");
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).click();
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("@123Abc");
		driver.findElement(By.xpath("//button[@id='register-button']")).click();
		
		String message=driver.findElement(By.xpath("//div[@class='result']")).getText();
		System.out.println(message);
		Assert.assertEquals("Your registration completed", message);
		//Thread.sleep(1000);

	}
}

