package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProductPage {
		WebDriver driver;
		WebDriverWait wait;
	
			public AddProductPage(WebDriver driver) {
					this.driver = driver;
					this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
					}
	
	//locators
	By samsungGalaxys6 = By.xpath("//a[text()='Samsung galaxy s6']");
	By adds6ToCart= By.xpath("//a[@onclick='addToCart(1)']");   
	By nextBtn = By.xpath("//button[@id='next2']");
	By previousBtn = By.xpath("//button[@id='prev2']");
	By macBookAir = By.xpath("//a[text()='MacBook air']");
	By addmacBookToCart = By.xpath("//a[@onclick='addToCart(11)']");
	By cartField = By.id("cartur");
	By productInCart = By.xpath("//tbody[@id='tbodyid']//tr/td[2]");
	
	By multipleProductInCart = By.xpath("//table[@class='table table-bordered table-hover table-striped']");
	By deleteMacBookAir= By.xpath("//tr[td[contains(text(),'MacBook air')]]//a[text()='Delete']");
	By homeField = By.xpath("//a[@class='nav-link' and contains(text(),'Home')]");
	
	//Adding products to cart
	public void openSamsungS6() {
		
		//By samsungGalaxys6 = By.xpath("//a[text()='Samsung galaxy s6']");
		
		try {
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			WebElement product = wait.until(ExpectedConditions.elementToBeClickable(samsungGalaxys6));
			
			JavascriptExecutor js = (JavascriptExecutor) driver;		
			js.executeScript("arguments[0].scrollIntoView(true);", product);
		
			product.click();
		}
		catch(StaleElementReferenceException e) {
			WebElement product = wait.until(ExpectedConditions.elementToBeClickable(samsungGalaxys6));
			product.click();
		}
		
		wait.until(ExpectedConditions.urlContains("prod.html"));
		}
	public String addToCart() {
		
		WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(adds6ToCart));
		
		addToCart.click();
		
		//handle alert
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		String alertMsg =  alert.getText();
        alert.accept();
        
        return alertMsg;
        
		}
	
	public void openCart() throws InterruptedException
	{
		WebElement cart = wait.until(ExpectedConditions.visibilityOfElementLocated(cartField));
		cart.click();
		wait.until(ExpectedConditions.urlContains("cart.html"));
		
		Thread.sleep(2000);
		}
	public boolean verifyProductInCart(String expectedProductName) {
		List<WebElement> productNames = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productInCart));
		
		for (WebElement name: productNames) {
			if(name.getText().equalsIgnoreCase(expectedProductName)) {
				return true;
			}
		}
		return false;	
		
	}
	public void goToHomePage() {
		driver.findElement(homeField).click();
	}
	
	public void openMacBookAir() {
		
		
		try {
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			WebElement product = wait.until(ExpectedConditions.elementToBeClickable(macBookAir));
			
			JavascriptExecutor js = (JavascriptExecutor) driver;		
			js.executeScript("arguments[0].scrollIntoView(true);", product);
		
			product.click();
			}
		catch(StaleElementReferenceException e) {
			WebElement product = wait.until(ExpectedConditions.elementToBeClickable(macBookAir));
			product.click();
			}
		
		wait.until(ExpectedConditions.urlContains("prod.html"));
			}
	public String addMacToCart() {
		
		WebElement addmToCart = wait.until(ExpectedConditions.elementToBeClickable(addmacBookToCart));
		
		addmToCart.click();
		
		//handle alert
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		String alertMsg =  alert.getText();
        alert.accept();
        
        return alertMsg;
        
		}
	
	public void clickNextBtn() throws InterruptedException {
		try {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
		   
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].scrollIntoView(true);",  nextButton);
	
		    Thread.sleep(2000);
		    nextButton.click();
		    Thread.sleep(2000);
			} catch (StaleElementReferenceException e) {
			WebElement nextButton = driver.findElement(nextBtn);
			 Thread.sleep(3000);
	        nextButton.click();	
			}
	
	}
	public boolean displayMultipleProducts() {
		return driver.findElement(multipleProductInCart).isDisplayed();
		
	}
	public void openCartAgain() {
		driver.findElement(By.xpath("//a[@onclick='showcart()']")).click();
	}
	public void deleteMacFromCart() {
		driver.findElement(deleteMacBookAir).click();
		
		
	}
	
	}

