package org.example.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public static WebDriver webDriver;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = "#login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement productLabel;

    @FindBy(xpath = "//h3")
    private WebElement errorTextLabel;

    public boolean verifyUsernameField() {
        return usernameField.isDisplayed();
    }

    public boolean verifyPasswordField() {
        return passwordField.isDisplayed();
    }

    public void inputUsernameField(String userName) {
        usernameField.sendKeys(userName);
    }

    public void inputPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean verifyInventoryPage() {
        return productLabel.isDisplayed();
    }

    public String getErrorTextLabel() {
        return errorTextLabel.getText();
    }
}
