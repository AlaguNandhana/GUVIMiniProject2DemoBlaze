package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartFunctionPage {
		WebDriver driver;
		
		public CartFunctionPage(WebDriver driver) {
			this.driver = driver;
			
		}    
		
		//locators
		By samsungGalaxys6 = By.xpath("//a[text()='Samsung galaxy s6']");
		By adds6ToCart= By.xpath("//a[@onclick='addToCart(1)']");   
		By nextBtn = By.xpath("//button[@id='next2']");
		By previousBtn = By.xpath("//button[@id='prev2']");
		By macBookAir = By.xpath("//a[text()='MacBook air']");
		By addmacBookToCart = By.xpath("//a[@onclick='addToCart(11)']");
		
		
		public void addProductToCart() {
			
			
		}
		
		
		
}
