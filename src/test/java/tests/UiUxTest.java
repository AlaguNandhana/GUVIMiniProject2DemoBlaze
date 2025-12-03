package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class UiUxTest extends BaseClass {

    By logo = By.xpath("//a[@id='nava']");
    By navbar = By.id("navbarExample");
    By footer = By.xpath("//footer");
    By contactLink = By.xpath("//a[text()='Contact']");
    By aboutUsLink = By.xpath("//a[text()='About us']");

    @Test
    public void verifyLogoAndNavbarPresence() {
       // HomePage home = new HomePage(driver);
        Assert.assertTrue(driver.findElement(logo).isDisplayed(), "Logo is missing!");
        Assert.assertTrue(driver.findElement(navbar).isDisplayed(), "Navbar not visible!");
    }

    @Test
    public void verifyFooterPresence() {
        Assert.assertTrue(driver.findElement(footer).isDisplayed(), "Footer is not visible!");
    }

    @Test
    public void verifyContactAndAboutLinks() {
        Assert.assertTrue(driver.findElement(contactLink).isDisplayed(), "Contact link missing!");
        Assert.assertTrue(driver.findElement(aboutUsLink).isDisplayed(), "About Us link missing!");
    }
}



