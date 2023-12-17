package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.COInformationPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class COInformationSteps {
    private final WebDriver driver = Hooks.driver;
    COInformationPage coInformationPage = new COInformationPage(driver);

    @Then("User is on the 'Checkout Information' page")
    public void verifyOnCOPage() {
        Assert.assertTrue(coInformationPage.verifyLabelPage());

    }

    @When("User inputs {string} in the first name field, {string} in the last name field, and {string} in the postal code field")
    public void inputInformation(String firstName, String lastName, String postalCode) throws InterruptedException {
        coInformationPage.inputFirstName(firstName);
        coInformationPage.inputLastName(lastName);
        coInformationPage.inputPostalCode(postalCode);

    }

    @And("User clicks the continue button")
    public void clickContinueButton() {
        coInformationPage.clickContinueButton();
    }
}
