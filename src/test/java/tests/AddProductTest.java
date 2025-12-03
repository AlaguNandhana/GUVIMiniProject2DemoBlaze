package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pages.AddProductPage;
import pages.LoginPage;

public class AddProductTest extends BaseClass  {
	
	
	
	
	@Test
	
	public void verifyAddProductToCart() throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		login.logIn();
		login.enterEmail("logintestpage@gmail.com");
		login.enterPassword("testmail@123");
		login.clicklogin();
	
		AddProductPage add = new AddProductPage(driver);
		
		add.openSamsungS6();
		String alertMsg = add.addToCart();
		
		Assert.assertEquals(alertMsg,"Product added.","Alert message mismatch!");
		
		add.openCart();
		
		boolean isProductFound = add.verifyProductInCart("Samsung galaxy s6");
		
		
		
		// Assert the alert text
		Assert.assertTrue(isProductFound, "Product not found in cart");
	
		System.out.println("Product added successfully");
		
	}
	@Test
	
	public void verifyaddmultipleproducts() throws InterruptedException {
		
		
		
		LoginPage login = new LoginPage(driver);
		login.logIn();
		login.enterEmail("logintestpage@gmail.com");
		login.enterPassword("testmail@123");
		login.clicklogin();
	
		AddProductPage add = new AddProductPage(driver);
		
		add.openSamsungS6();
		add.addToCart();
		add.goToHomePage();
		Thread.sleep(2000);
		add.clickNextBtn();
		Thread.sleep(2000);
		add.openMacBookAir();
		add.addMacToCart();
		Thread.sleep(2000);
		add.openCart();
		Assert.assertTrue(add.displayMultipleProducts(),"Products not displayed");
		
		
		
	}
	@Test
	
	
	public void verifyDeleteProduct() throws InterruptedException {
		
		LoginPage login = new LoginPage(driver);
		login.logIn();
		login.enterEmail("logintestpage@gmail.com");
		login.enterPassword("testmail@123");
		Thread.sleep(2000);
		login.clicklogin();
	
		AddProductPage add = new AddProductPage(driver);
		
		add.openSamsungS6();
		add.addToCart();
		add.goToHomePage();
		Thread.sleep(2000);
		add.clickNextBtn();
		Thread.sleep(2000);
		add.openMacBookAir();
		add.addMacToCart();
		Thread.sleep(2000);
		add.openCartAgain();
		add.deleteMacFromCart();
		Thread.sleep(2000);
		add.openCartAgain();
		
		boolean isProductFound = add.verifyProductInCart("MacBook air");
		Thread.sleep(2000);
		Assert.assertFalse(isProductFound, "Product  found in cart");
		
	}
}
