package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pages.LoginPage;

public class LogoutTest extends BaseClass {
	@Test
	
	
	public void verifyLogOutFunctionality() {
	LoginPage login = new LoginPage(driver);
	login.logIn();
	login.enterEmail("logintestpage@gmail.com");
	login.enterPassword("testmail@123");
	login.clicklogin();
	
	login.logout();
	
	 Assert.assertTrue(login.isLogoutSuccessful(), "Logout failed — login link not visible again!");
	}
}
