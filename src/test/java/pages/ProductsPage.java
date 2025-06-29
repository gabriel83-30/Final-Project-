package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static extentUtility.ExtentManager.logInfo;
import static extentUtility.ReportEventType.INFO_STEP;
import static extentUtility.ReportEventType.PASS_STEP;

public class ProductsPage extends BasePage {

    // locator pentru pagina de produse
    private By pageTitle = By.className("title");
    // locator pentru butonul"Add to cart" la produsul "Sauce Labs Backpack"
    private By addBackPackButton = By.id("add-to-cart-sauce-labs-backpack");
    // locator pt iconita de cos
    private final By cartIcon = By.className("shopping_cart_link");
    private By menuButton = By.id("react-burger-menu-btn");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageLoaded() {
        logInfo(PASS_STEP, "Validate that Product Page is loaded properly");
        Assert.assertEquals(elementMethods.getElementText(pageTitle), "Products",
                "Products page didn't load correctly");
    }

    public void addSauceLabsBackPackToCart(){
        logInfo(INFO_STEP, " User adds Sauce Labs Backpack to cart");
        elementMethods.clickElement(addBackPackButton);
    }

    public void navigateToCart(){
        logInfo(INFO_STEP, "User navigates to the shopping cart page");
        elementMethods.clickElement(cartIcon);
    }

    public void openSidebarMenu(){
        logInfo(INFO_STEP, " User opens the SideBar ");
        elementMethods.clickElement(menuButton);
    }

}



