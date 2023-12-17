package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.pageObject.CartPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CartSteps {
    private final WebDriver driver = Hooks.driver;
    CartPage cartPage = new CartPage(driver);

    @And("Product {string} and {string} will be displayed in item list")
    public void verifyProductList(String product1, String product2) {
        Assert.assertTrue(cartPage.verifyProduct1Displayed(product1));
        Assert.assertTrue(cartPage.verifyProduct2Displayed(product2));
    }

    @When("User removes {string} from the cart")
    public void removeProduct(String product) {
        cartPage.removeProduct(product);

    }

    @And("User clicks checkout button")
    public void clickCheckoutButton() {
        cartPage.clickCheckoutButton();
    }
}
