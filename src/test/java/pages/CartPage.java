package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static extentUtility.ExtentManager.logInfo;
import static extentUtility.ReportEventType.INFO_STEP;
import static extentUtility.ReportEventType.PASS_STEP;

public class CartPage extends BasePage {

    // locator pt titlul produsului in cos
    private By cartItemName = By.className("inventory_item_name");
    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageLoaded() {
        logInfo(PASS_STEP, "Validate that Cart Page is loaded properly");
        Assert.assertTrue(elementMethods.isElementDisplayed(cartItemName),
                "Basket page not loading correctly!");
    }

    public void verifyBackPackIsInCart() {
        String expectedProduct = "Sauce Labs Backpack";
        String actualProduct = elementMethods.getElementText(cartItemName);
        logInfo(PASS_STEP, "Product " + actualProduct + " is correct in the cart.");
        Assert.assertEquals(actualProduct, expectedProduct,
                "The product in the basket is not what you expected");
    }

    public void proceedToCheckout() {
        logInfo(INFO_STEP, "User clicked the Checkout button.");
        elementMethods.clickElement(checkoutButton);
    }
}
