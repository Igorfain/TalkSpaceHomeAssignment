package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.MainPage;
import utils.AppConfig;
import utils.Hooks;

public class MainPageSteps {

    private static final String TITLE_MISMATCH_MESSAGE = "Main page title does not match!";
    private static final String CART_ITEM_MISMATCH_MESSAGE = "Cart item count does not match!";

    private final MainPage mainPage;

    public MainPageSteps() {
        mainPage = new MainPage(Hooks.driver);
    }

    @Given("the user is on the Sauce Demo login page")
    public void theUserIsOnTheSauceDemoLoginPage() {
        Hooks.driver.get(AppConfig.BASE_URL);
    }

    @Then("the main page title should be {string}")
    public void theMainPageTitleShouldBe(String expectedTitle) {
        String actualTitle = mainPage.getPageTitle();
        Assert.assertEquals(actualTitle, expectedTitle, TITLE_MISMATCH_MESSAGE);
    }

    @When("the user adds a product to the cart")
    public void theUserAddsAProductToTheCart() {
        mainPage.addItemToCart();
    }

    @Then("the cart should have {int} item")
    public void theCartShouldHaveItem(int expectedItemCount) {
        int actualItemCount = mainPage.getCartItemCount();
        Assert.assertEquals(actualItemCount, expectedItemCount, CART_ITEM_MISMATCH_MESSAGE);
    }
}
