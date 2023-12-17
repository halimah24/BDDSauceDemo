package org.example.pageObject;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class COOverviewPage {
    public static WebDriver webDriver;

    public COOverviewPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(xpath = "//span[@class='title']")
    private WebElement overviewPageLabel;

    @FindBy(xpath = "//*[@id='checkout_summary_container']/div/div[2]/div[6]")
    private WebElement finalProductPrice;

    @FindBy(xpath = "//*[@id='checkout_summary_container']/div/div[2]/div[7]")
    private WebElement tax;

    @FindBy(xpath = "//*[@id='checkout_summary_container']/div/div[2]/div[8]")
    private WebElement total;

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishButton;

    public boolean verifyCOOverviewPage() {
        return overviewPageLabel.isDisplayed();
    }

    public String getPriceProduct(String product) {
        String locatorProduct = "//div[contains(text(),'" + product + "')]/ancestor::div[@class='cart_item']/descendant::div[@class='item_pricebar']/div[@class='inventory_item_price']";
        return webDriver.findElement(By.xpath(locatorProduct)).getText();
    }

    public String getFinalPriceProduct() {
        return finalProductPrice.getText();
    }

    public String getTax() {
        return tax.getText();
    }

    public String calculateTax() {
        String totalProductPrice = getFinalPriceProduct();
        String digitsTotalProductPrice = StringUtils.getDigits(totalProductPrice);
        double totalProductPriceDouble = Double.parseDouble(digitsTotalProductPrice);
        double expectedTaxValue = Math.ceil((8.00 / 100.00) * totalProductPriceDouble) / 100;
        return Double.toString(expectedTaxValue);
    }

    public String getTotal() {
        return total.getText();
    }

    public String calculateTotalCheckout() {
        String totalProductPrice = getFinalPriceProduct();
        String digitsTotalProductPrice = StringUtils.getDigits(totalProductPrice);
        double totalProductPriceDouble = Double.parseDouble(digitsTotalProductPrice) / 100;

        String calculatedTax = calculateTax();
        String digitsCalculatedTax = StringUtils.getDigits(calculatedTax);
        double calculatedTaxDouble = Double.parseDouble(digitsCalculatedTax) / 100;

        double totalCheckout = totalProductPriceDouble + calculatedTaxDouble;
        return Double.toString(totalCheckout);
    }

    public void clickFinishButton() {
        finishButton.click();
    }
}
