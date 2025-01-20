package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.testng.Assert;
import pages.LoginPage;
import pages.MainPage;
import utils.Hooks;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage(Hooks.driver);
    private final MainPage mainPage = new MainPage(Hooks.driver);

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        Hooks.driver.get("https://www.saucedemo.com");
        LoginPage loginPage = new LoginPage(Hooks.driver);
        loginPage.login("standard_user", "secret_sauce");
    }

    @When("the user enters valid credentials")
    public void theUserEntersValidCredentials() {
        loginPage.login("standard_user", "secret_sauce");
    }

    @Then("the user should be redirected to the products page")
    public void theUserShouldBeRedirectedToTheProductsPage() {
        String actualTitle = mainPage.getPageTitle();
        String expectedTitle = "Products"; // Assuming this is the expected title
        Assert.assertEquals(actualTitle, expectedTitle, "The user is not on the Products page.");
    }
}
