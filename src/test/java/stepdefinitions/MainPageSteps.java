package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.MainPage;
import utils.Hooks;

public class MainPageSteps {

    private final MainPage mainPage;

    public MainPageSteps() {
        mainPage = new MainPage(Hooks.driver);
    }

    @Given("the user is on the Sauce Demo login page")
    public void the_user_is_on_the_sauce_demo_login_page() {
        Hooks.driver.get("https://www.saucedemo.com");
    }

    @Then("the main page title should be {string}")
    public void theMainPageTitleShouldBe(String expectedTitle) {
        String actualTitle = mainPage.getPageTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Main page title does not match!");
    }

    @When("the user adds a product to the cart")
    public void theUserAddsAProductToTheCart() {
        mainPage.addItemToCart();
    }

    @Then("the cart should have {int} item")
    public void theCartShouldHaveItem(int expectedItemCount) {
        int actualItemCount = mainPage.getCartItemCount();
        Assert.assertEquals(actualItemCount, expectedItemCount, "Cart item count does not match!");
    }

}
