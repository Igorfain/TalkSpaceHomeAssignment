package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ActionBot;

public class MainPage {
    private final ActionBot actionBot;

    // Locators
    private final By productTitleLocator = By.className("title");
    private final By addToCartButtonLocator = By.xpath("//button[contains(text(),'Add to cart')]");
    private final By cartIconLocator = By.className("shopping_cart_link");
    private final By cartBadgeLocator = By.className("shopping_cart_badge");

    /**
     * Constructor for MainPage.
     *
     * @param driver the WebDriver instance
     */
    public MainPage(WebDriver driver) {
        this.actionBot = new ActionBot(driver);
    }

    /**
     * Get the title of the product page.
     *
     * @return the product page title as a String
     */
    public String getPageTitle() {
        return actionBot.getText(productTitleLocator);
    }

    /**
     * Add an item to the cart.
     */
    public void addItemToCart() {
        actionBot.click(addToCartButtonLocator);
    }

    /**
     * Navigate to the cart page.
     */
    public void navigateToCart() {
        actionBot.click(cartIconLocator);
    }

    /**
     * Get the number of items in the cart.
     *
     * @return the count of items in the cart, or 0 if no items are present
     */
    public int getCartItemCount() {
        try {
            WebElement cartBadge = actionBot.findElement(cartBadgeLocator);
            return Integer.parseInt(cartBadge.getText().trim());
        } catch (NoSuchElementException e) {
            // Return 0 if the cart badge is not present
            return 0;
        }
    }
}
