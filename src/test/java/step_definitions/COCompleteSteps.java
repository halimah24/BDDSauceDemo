package step_definitions;

import io.cucumber.java.en.Then;
import org.example.pageObject.COCompletePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class COCompleteSteps {
    private final WebDriver driver = Hooks.driver;
    COCompletePage coCompletePage = new COCompletePage(driver);

    @Then("User will successfully complete the purchase")
    public void verifyCOComplete() {
        Assert.assertTrue(coCompletePage.verifyCheckoutComplete());

    }
}
