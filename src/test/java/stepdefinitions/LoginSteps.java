package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.testng.Assert;
import pages.LoginPage;
import pages.MainPage;
import utils.AppConfig;
import utils.Hooks;

public class LoginSteps {

    private static final String EXPECTED_PRODUCTS_TITLE = "Products";

    private final LoginPage loginPage = new LoginPage(Hooks.driver);
    private final MainPage mainPage = new MainPage(Hooks.driver);

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        Hooks.driver.get(AppConfig.BASE_URL);
        loginPage.login(AppConfig.STANDARD_USER, AppConfig.SECRET_SAUCE_PASSWORD);
    }

    @When("the user enters valid credentials")
    public void theUserEntersValidCredentials() {
        loginPage.login(AppConfig.STANDARD_USER, AppConfig.SECRET_SAUCE_PASSWORD);
    }

    @Then("the user should be redirected to the products page")
    public void theUserShouldBeRedirectedToTheProductsPage() {
        String actualTitle = mainPage.getPageTitle();
        Assert.assertEquals(actualTitle, EXPECTED_PRODUCTS_TITLE, "The user is not on the Products page.");
    }
}
