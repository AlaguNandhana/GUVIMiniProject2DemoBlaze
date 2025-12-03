package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pages.HomePage;
import pages.LoginPage;
public class HomePageNavigationTest extends BaseClass{
	
	public static  void loginOnce() {

		LoginPage login = new LoginPage(driver);
		login.logIn();
		login.enterEmail("logintestpage@gmail.com");
		login.enterPassword("testmail@123");
		login.clicklogin();
		System.out.println("Logged in Successfully before tests.");
	}
	
	@ Test
	
	public void verifyCategoryNavigation() throws InterruptedException {
		
		loginOnce();
		HomePage home = new HomePage(driver);
		
		home.openPhones();
		Thread.sleep(2000);
		Assert.assertTrue(driver.getPageSource().contains("Samsung galaxy s7"), "Phones Category not loaded!");
		
		home.openLaptops();
		Thread.sleep(2000);
		Assert.assertTrue(driver.getPageSource().contains("Sony vaio i5"), "Laptops Category not loaded!");
		
		home.openMonitors();
		Thread.sleep(2000);
		Assert.assertTrue(driver.getPageSource().contains("Apple monitor 24"), "Monitors Category not loaded!");
		
	}
	@Test 
	public void verifyPageNavigationButtons() {
		loginOnce();
		HomePage home = new HomePage(driver);
		
		home.clickNext();
		home.clickPrevious();
		
		Assert.assertTrue(driver.getPageSource().contains("PRODUCT STORE"), "Next or Previous Button not working");
		
	}
	@Test
	public void verifyCartNavigation() {
		loginOnce();
		HomePage home = new HomePage(driver);
		
		home.goToCart();
		
		Assert.assertTrue(driver.getPageSource().contains("cart"), "Cart page not opened");
		
	}
	
	
	
}




