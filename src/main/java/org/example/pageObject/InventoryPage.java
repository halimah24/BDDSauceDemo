package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {
    public static WebDriver webDriver;

    public InventoryPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(xpath = "//span[@class='title']")
    private WebElement productLabel;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement selectProduct;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartButton;

    @FindBy(css = ".title")
    private WebElement yourCartLabel;

    @FindBy(xpath = "//div[@id='shopping_cart_container']")
    private WebElement countProducts;

    public boolean verifyInventoryPage(){
        return productLabel.isDisplayed();
    }

    public void sortProduct(String filter){
        Select sort = new Select(selectProduct);
        sort.selectByVisibleText(filter);
    }

    public void clickAddToCartProduct(String product){
        String xpath = "//div[contains(text(),'" + product + "')]/ancestor::div[@class='inventory_item_description']//button[text()='Add to cart']";
        webDriver.findElement(By.xpath(xpath)).click();
    }

    public String getCountProducts(){
        return countProducts.getText();
    }

    public void openCart(){
        cartButton.click();
    }

    public boolean verifyCartPage(){
        return yourCartLabel.isDisplayed();
    }
}
