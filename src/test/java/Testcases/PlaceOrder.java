package Testcases;

import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import Driver.DriverSetup;

public class PlaceOrder extends DriverSetup {

	public static String baseURL = "https://training.nop-station.com/";

	@Test // TestNG Annotation
	public static void placeOrder() throws InterruptedException {
		driver.get(baseURL); // Get base url and run on browser
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize(); // maximize the browser window
		Thread.sleep(1000); // used for waiting

		driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']")).click();
		driver.findElement(By.xpath("//img[@title='Show products in category Cell phones']")).click();
		driver.findElement(By.xpath("//img[@title='Show details for Nokia Lumia 1020']")).click();
		driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
		driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).sendKeys("2");
		driver.findElement(By.xpath("//button[@id='add-to-cart-button-20']")).click();
		driver.findElement(By.xpath("//span[@class='cart-label']")).click();
		driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Checkout as Guest']")).click();
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_FirstName']")).click();
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_FirstName']")).sendKeys("somaia");
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_LastName']")).click();
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_LastName']")).sendKeys("afrin");
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_Email']")).click();
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_Email']")).sendKeys("somaia@gmail.com");
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_Company']")).click();
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_Company']")).sendKeys("ABC Comapany");
		
		WebElement ddown1=driver.findElement(By.name("BillingNewAddress.CountryId"));
		Select select1=new Select(ddown1);
		select1.selectByValue("19");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement ddown2=driver.findElement(By.id("BillingNewAddress_StateProvinceId"));
		Select select2=new Select(ddown2); 
		select2.selectByValue("70");
		
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).click();
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("Dhaka");
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']")).click();
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']")).sendKeys("Dhaka");
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address2']")).click();
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address2']")).sendKeys("Dhaka");
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).click();
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("1234");
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).click();
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).sendKeys("01893736577");
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_FaxNumber']")).click();
		driver.findElement(By.xpath("//input[@id='BillingNewAddress_FaxNumber']")).sendKeys("9876554");
		driver.findElement(By.xpath("//button[@onclick='Billing.save()']")).click();
		driver.findElement(By.xpath("//input[@id='shippingoption_1']")).click();
		driver.findElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']")).click();
		driver.findElement(By.xpath("//input[@id='paymentmethod_1']")).click();
		driver.findElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']")).click();
		driver.findElement(By.xpath("//input[@id='CardholderName']")).click();
		driver.findElement(By.xpath("//input[@id='CardholderName']")).sendKeys("abc def");
		driver.findElement(By.xpath("//input[@id='CardNumber']")).click();
		driver.findElement(By.xpath("//input[@id='CardNumber']")).sendKeys("4214521720236933");
		
		WebElement ddown3=driver.findElement(By.name("ExpireMonth"));
		Select select3=new Select(ddown3);
		select3.selectByValue("5");
		
		WebElement ddown4=driver.findElement(By.name("ExpireYear"));
		Select select4=new Select(ddown4);
		select4.selectByValue("2025");
		
		driver.findElement(By.xpath("//input[@id='CardCode']")).click();
		driver.findElement(By.xpath("//input[@id='CardCode']")).sendKeys("4286");
		driver.findElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Confirm']")).click();
		
		String message=driver.findElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']")).getText();
		System.out.println(message);
		Assert.assertEquals("Your order has been successfully processed!", message);
		
		Thread.sleep(2000);

	}
}

