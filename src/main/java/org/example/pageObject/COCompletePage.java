package org.example.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class COCompletePage {
    public static WebDriver webDriver;

    public COCompletePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement completeCOSentence;

    public boolean verifyCheckoutComplete() {
        return completeCOSentence.isDisplayed();
    }
}
