package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//E-Commerce

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		 this.driver = driver;
	}
	
	// Locators
	By logInBtn = By.xpath("//a[@id='login2']");
	By userName = By.id("loginusername"); 
	By passWord = By.id("loginpassword");
	By clickLogIn = By.xpath("//button[@onclick='logIn()']"); //.click();
	By welcomeText = By.id("nameofuser");
	By logoutBtn = By.id("logout2");
	//By passwordText = By.xpath("//input[@type='password']");
	
	public void logIn()
		{
		driver.findElement(logInBtn).click();
		
		}
	public void enterEmail(String email) {
		driver.findElement(userName).sendKeys(email);
		}
	public void enterPassword(String password) {
		driver.findElement(passWord).sendKeys(password);
		
		}
	public void clicklogin() {
		driver.findElement(clickLogIn).click();
		}
	public void welcomeTextmsg() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement welcomeMsg  = wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeText));
		String text =  welcomeMsg.getText();
		System.out.println("Displayed message: "+text);
		}
	public void logout() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement logOut = wait.until(ExpectedConditions.visibilityOfElementLocated(logoutBtn));
		logOut.click();
		
	}	
	public boolean isLogoutSuccessful() {
	    return driver.findElement(logInBtn ).isDisplayed();
	}

}
