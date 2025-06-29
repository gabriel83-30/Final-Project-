package tests;

import pages.LoginPage;
import pages.ProductsPage;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test
    public void testProductPageLoadCorrectly() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.isPageLoaded();
    }
}
