package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class Hooks {
    public static WebDriver driver;
    public static ActionBot actionBot;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AppConfig.BASE_URL);
        actionBot = new ActionBot(driver);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(AppConfig.STANDARD_USER, AppConfig.SECRET_SAUCE_PASSWORD);
    }

    @After
    public void tearDown() {
        // Quit the driver if it's initialized
        if (driver != null) {
            driver.quit();
        }
    }
}
