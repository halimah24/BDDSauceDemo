package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.example.pageObject.COOverviewPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class COOverviewSteps {
    private final WebDriver driver = Hooks.driver;
    COOverviewPage coOverviewPage = new COOverviewPage(driver);

    @Then("User is redirected to the Checkout Overview Page")
    public void verifyOnCOOverviewPage() {
        Assert.assertTrue(coOverviewPage.verifyCOOverviewPage());

    }

    @And("Verify the price of product {string} should be equal to the total price")
    public void verifyPrice(String product) {
        String actualText = coOverviewPage.getFinalPriceProduct();
        String expectedValue = coOverviewPage.getPriceProduct(product);
        String actualValue = actualText.substring(actualText.indexOf(expectedValue));

        Assert.assertEquals(expectedValue, actualValue);
    }

    @And("Verify the tax value should be equal to 8% of the total price")
    public void verifyTax() {
        String tax = coOverviewPage.getTax();
        String taxValue = StringUtils.getDigits(tax);
        double taxValueDouble = Double.parseDouble(taxValue) / 100.00;
        String expectedTaxValue = Double.toString(taxValueDouble);
        Assert.assertEquals(coOverviewPage.calculateTax(), expectedTaxValue);
    }

    @And("Verify total payment should be equal to total product price plus tax")
    public void verifyTotal() {
        String total = coOverviewPage.getTotal();
        String totalValue = StringUtils.getDigits(total);
        double totalValueDouble = Double.parseDouble(totalValue) / 100;
        String expectedTotalValue = Double.toString(totalValueDouble);
        Assert.assertEquals(coOverviewPage.calculateTotalCheckout(), expectedTotalValue);
    }

    @When("User clicks the finish button")
    public void clickFinishButton() {
        coOverviewPage.clickFinishButton();
    }
}
