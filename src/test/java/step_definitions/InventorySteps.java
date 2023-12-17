package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObject.InventoryPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class InventorySteps {
    private final WebDriver driver = Hooks.driver;
    InventoryPage inventoryPage = new InventoryPage(driver);

    @And("User is on the inventory page")
    public void verifyOnInventoryPage() {
        Assert.assertTrue(inventoryPage.verifyInventoryPage());
    }

    @When("User sorts products by {string}")
    public void sortProduct(String filter) {
        inventoryPage.sortProduct(filter);
    }

    @When("User clicks product {string} to add it to the cart")
    public void clickProduct(String product) {
        inventoryPage.clickAddToCartProduct(product);

    }

    @Then("Verify the number of products in the cart is {string}")
    public void verifyNumberOfProduct(String jumlah) {
        Assert.assertEquals(inventoryPage.getCountProducts(), jumlah);

    }

    @And("User clicks the cart button to go to the cart page")
    public void clickCartButton() {
        inventoryPage.openCart();
    }

    @Then("User is redirected to the cart page")
    public void verifyCartPage() {
        Assert.assertTrue(inventoryPage.verifyCartPage());

    }
}
