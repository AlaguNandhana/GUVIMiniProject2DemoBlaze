package tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import baseClass.BaseClass;
import pages.LoginPage;
import pages.OrderPage;
import utils.ExcelUtils;
public class OrderPageTest extends BaseClass {
	
	//@BeforeMethod
	public static void loginOnce() {

		LoginPage login = new LoginPage(driver);
		login.logIn();
		login.enterEmail("logintestpage@gmail.com");
		login.enterPassword("testmail@123");
		login.clicklogin();
		System.out.println("Logged in Successfully before tests.");
	}
	
	//@AfterMethod
	public void logOutOnce() {
	try {
        driver.findElement(By.id("logout2")).click();
        System.out.println("Logged out!");
    } catch (Exception e) {
        System.out.println("Logout skipped – browser may have closed or popup still open.");
    }
}
	
	@DataProvider(name= "userdata")
	public Object[][] getOrderData() throws IOException {
		String filePath = System.getProperty("user.dir") +"/testdata/userdata.xlsx";
		
		return ExcelUtils.getTestData(filePath,"Sheet1");
		
	}
	
	
	 @Test(dataProvider = "userdata")
	public void placeOrderWithValidDetails(String name,String country,String city,String card,String month,String year) throws InterruptedException {
		 loginOnce();
		 Thread.sleep(3000);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   // WebElement cart = wait.until(ExpectedConditions.elementToBeClickable("));
		 driver.findElement(By.xpath("//a[text()='Cart']")).click();
	   
	    OrderPage order = new OrderPage(driver);
	    order.clickPlaceOrder();
	    order.fillOrderDetails(name, country, city, card, month, year);
	    order.clickPurchase();
	
	    Assert.assertTrue(order.verifyOrderPlaced(),"Order confirmation not displayed");
	    order.confirmOrder();
	
	}
	
	@Test
	public void placeOrderWithEmptyForm() throws InterruptedException {
		 loginOnce();
		 Thread.sleep(3000);
		 	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 	WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Cart']")));
		    cart.click();
		
		    OrderPage order = new OrderPage(driver);
	        order.clickPlaceOrder();
	        order.clickPurchase();
	        Assert.assertFalse(order.verifyOrderPlaced(), "Order placed even when fields are empty!");
		
	}
	
}
