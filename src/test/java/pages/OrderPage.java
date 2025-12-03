package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.BaseClass;

public class OrderPage extends BaseClass {
	WebDriverWait wait;
	
	public  OrderPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	//locators
	By cartField = By.xpath("//a[text()='Cart']");
	By placeOrderBtn= By.xpath("//button[@class='btn btn-success']");
	By nameField = By.xpath("//input[@id='name']");
	By countryField =By.xpath("//input[@id='country']");
	By cityField = By.xpath("//input[@id='city']");
	By creditCardField = By.xpath("//input[@id='card']");
	By monthField = By.xpath("//input[@id='month']");
	By yearField = By.xpath("//input[@id='year']");
	By purchaseBtn = By.xpath("//button[@onclick='purchaseOrder()']");
	By confirmationMsg =By.xpath("//h2[text()='Thank you for your purchase!']");
	By okBtn = By.xpath("//button[@class='confirm btn btn-lg btn-primary']");
	
	public void clickCart() {
		driver.findElement(cartField).click();
	}
	public void clickPlaceOrder() {
		wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
	}
	public void fillOrderDetails(String name,String country,String city,String card,String month,String year) {
		
		driver.findElement(nameField).sendKeys(name);
		driver.findElement(countryField).sendKeys(country);
		driver.findElement(cityField).sendKeys(city);
		driver.findElement(creditCardField).sendKeys(card);
		driver.findElement(monthField).sendKeys(month);
		driver.findElement(yearField).sendKeys(year);	
	}
	
	public void clickPurchase() {
		driver.findElement(purchaseBtn).click();
	}
	public boolean verifyOrderPlaced() {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMsg)).isDisplayed();
		}catch (Exception e) {
			return false;
			
		}
	}
	
	public void confirmOrder() {
		driver.findElement(okBtn).click();
	}
		
}
