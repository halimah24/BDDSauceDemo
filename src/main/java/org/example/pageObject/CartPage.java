package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    public static WebDriver webDriver;

    public CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkoutButton;

    public boolean verifyProduct1Displayed(String product1){
        String product1Locator = "//div[contains(text(),'" + product1 + "')]";
        return webDriver.findElement(By.xpath(product1Locator)).isDisplayed();
    }

    public boolean verifyProduct2Displayed(String product2){
        String product2Locator = "//div[contains(text(),'" + product2 + "')]";
        return webDriver.findElement(By.xpath(product2Locator)).isDisplayed();
    }

    public void removeProduct(String product){
        String productLocator = "//div[contains(text(),'" + product + "')]/ancestor::div[@class='cart_item']//button[text()='Remove']";
        webDriver.findElement(By.xpath(productLocator)).click();
    }

    public void clickCheckoutButton(){
        checkoutButton.click();
    }
}
