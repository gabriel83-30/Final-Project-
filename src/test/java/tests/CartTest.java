package tests;

import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void testAddSauceLabsBackPackToCart(){
        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.isPageLoaded();
        loginPage.login("standard_user", "secret_sauce");
        //Add product
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.isPageLoaded();
        productsPage.addSauceLabsBackPackToCart();
        // Navigate to cart
        productsPage.navigateToCart();
        // Verify product in cart
        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();
    }
}
