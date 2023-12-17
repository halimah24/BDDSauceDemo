package org.example.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class COInformationPage {
    public static WebDriver webDriver;

    public COInformationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(xpath = "//span[@class='title']")
    private WebElement checkoutInformationLabel;

    @FindBy(css = "#first-name")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement postalcodeField;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    public boolean verifyLabelPage() {
        return checkoutInformationLabel.isDisplayed();
    }

    public void inputFirstName(String firstname) {
        firstNameField.sendKeys(firstname);
    }

    public void inputLastName(String lastname) {
        lastNameField.sendKeys(lastname);
    }

    public void inputPostalCode(String postalcode) {
        postalcodeField.sendKeys(postalcode);
    }

    public void clickContinueButton() {
        continueButton.click();
    }
}
