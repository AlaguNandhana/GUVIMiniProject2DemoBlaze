 package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.BaseClass;

public class HomePage extends BaseClass {
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}

	//locators
	By nextBtn = By.xpath("//button[@id='next2']");
	By previousBtn = By.xpath("//button[@id='prev2']");
	By cartField = By.id("cartur");
	By productInCart = By.xpath("//tbody[@id='tbodyid']");
	By homeField = By.xpath("//a[@class='nav-link' and contains(text(),'Home')]");
	By phoneLink = By.xpath("//a[text()='Phones']");
	By laptopLink = By.xpath("//a[text()='Laptops']");
	By monitorsLink = By.xpath("//a[text()='Monitors']");
	
	private void safeClick(By locator) {
		int attempts = 0;
		while(attempts<3) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement element  = wait.until(ExpectedConditions.elementToBeClickable(locator));
				element.click();
				return;
				
			}catch (StaleElementReferenceException e) {
				 System.out.println("Stale element found, retrying... attempt " + (attempts + 1));
			}
			attempts++;
			
		}
		throw new RuntimeException("Element still stale after 3 retries: " +locator);
	}
	
	public void openPhones() {
		safeClick(phoneLink);
	}
	public void openLaptops() {
		safeClick(laptopLink);
	}
	public void openMonitors() {
	safeClick(monitorsLink);
			
		}
	public void clickNext() {
		safeClick(nextBtn);
	}
	public void clickPrevious() {
		safeClick(previousBtn);
	}
	public void goToCart() {
		safeClick(cartField);
	}
	
}

	