package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ActionBot;

public class LoginPage {
    private final ActionBot actionBot;

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.actionBot = new ActionBot(driver);
    }

    public void login(String username, String password) {
        actionBot.enterText(usernameField, username);
        actionBot.enterText(passwordField, password);
        actionBot.click(loginButton);
    }
}
