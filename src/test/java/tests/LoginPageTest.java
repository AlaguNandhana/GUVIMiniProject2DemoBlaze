package tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pages.LoginPage;

//E-Commerce
public class LoginPageTest extends BaseClass{
	
			@Test(priority=1)

			public void verifyLoginWithValidInputs() throws IOException {
				LoginPage login = new LoginPage(driver);
				login.logIn();
				login.enterEmail("logintestpage@gmail.com");
				login.enterPassword("testmail@123");
				login.clicklogin();
			
				login.welcomeTextmsg();
			
				String text = "Welcome logintestpage@gmail.com";
				Assert.assertEquals(text, "Welcome logintestpage@gmail.com", "Welcome Message not displayed");
			
				System.out.println("Valid login test passed");
				

				// take Screenshot after login
				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				File target = new File("./screenshot/loginpage.png");
				FileUtils.copyFile(source, target);
			}
			
			@Test(priority=2) // login with invalid email and password
			public void invalidlogintest() {
				LoginPage login = new LoginPage(driver);
				login.logIn();
				login.enterEmail("wrong@example.com");
				login.enterPassword("wrongpass");
				login.clicklogin();
			
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.alertIsPresent());
			
				// Switch to alert and capture its message
				String alertText = driver.switchTo().alert().getText();
				driver.switchTo().alert().accept(); // close alert
			
				// Assert the alert text
				Assert.assertEquals(alertText, "User does not exist.", " Unexpected alert message!");
			
				// Print if test passed
			
				System.out.println("Invalid login test executed");
			
			}
			
			@Test(priority=3) // login with empty fields
			public void emptyfieldLoginTest() {
				LoginPage login = new LoginPage(driver);
				login.logIn();
				login.enterEmail("");
				login.enterPassword("");
				login.clicklogin();
			
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.alertIsPresent());
			
				// Switch to alert and capture its message
				String alertText = driver.switchTo().alert().getText();
				driver.switchTo().alert().accept(); // close alert
			
				// Assert the alert text
				Assert.assertEquals(alertText, "Please fill out Username and Password.", " Unexpected alert message!");
			
				System.out.println("Please fill out Username and Password");
			
			}
			
			@Test(priority = 4) // login with invalid email format and password
			public void invalidEmailformatTest() {
				LoginPage login = new LoginPage(driver);
				login.logIn();
				login.enterEmail("loginpage.com");
				login.enterPassword("testmail@123");
				login.clicklogin();
			
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.alertIsPresent());
				// switch to alert and capture its message
				String alertmsg = driver.switchTo().alert().getText();
				driver.switchTo().alert().accept();
			
				Assert.assertEquals(alertmsg, "User does not exist.", "Unexpected alert message");
			
				System.out.println("User does not exists");
			}
			
			@Test(priority = 5) // verify if password field is masked 
			public void passwordMaskTest() {
				LoginPage login = new LoginPage(driver);
				login.logIn();
				login.enterEmail("logintestpage@gmail.com");
			
				
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword")));
				
				String typeAttribute = passwordField.getAttribute("type");
				login.enterPassword("testmail@123");
				Assert.assertEquals(typeAttribute, "password", "Password Field is not masked");
				//login.clicklogin();
			
			}
			
			} 



