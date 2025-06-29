package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static extentUtility.ExtentManager.logInfo;
import static extentUtility.ReportEventType.INFO_STEP;
import static extentUtility.ReportEventType.PASS_STEP;

public class LogoutPage extends BasePage {

    private By logoutButton = By.id("logout_sidebar_link");

    public LogoutPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public void isPageLoaded() {
        logInfo(PASS_STEP, "Validate that Logout Page is loaded properly");
        Assert.assertTrue(elementMethods.isElementDisplayed(logoutButton),
                "Logout element is not displayed or page did not load.");
    }


    public void setLogoutButton(){
        logInfo(INFO_STEP, "User clicked the Logout button.");
        elementMethods.clickElement(logoutButton);
    }
}
