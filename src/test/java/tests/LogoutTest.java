package tests;

import pages.LoginPage;
import pages.LogoutPage;
import pages.ProductsPage;
import org.testng.annotations.Test;

public class  LogoutTest extends BaseTest {

    @Test
    public void testLogoutSuccessfully() {
        //Pas1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.isPageLoaded();
        loginPage.login("standard_user", "secret_sauce");

        // Pas 2: Verifică dacă pagina de produse s-a încărcat
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.isPageLoaded();

        // Pas 3: Deschide meniul lateral
        productsPage.openSidebarMenu();

        // Pas 4: Click pe Logout
        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.setLogoutButton();

        }
}
