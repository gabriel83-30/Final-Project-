package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static extentUtility.ExtentManager.logInfo;
import static extentUtility.ReportEventType.INFO_STEP;
import static extentUtility.ReportEventType.PASS_STEP;


public class LoginPage extends BasePage {

    // locatori specifici paginii

    private By userNameFieldLocator = By.id("user-name");
    private By passwordLocator = By.id("password");
    private By loginButtonLocator = By.id("login-button");
    private By loginErrorMesageLocator = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageLoaded() {
        logInfo(PASS_STEP, "Validate that Login Page is loaded properly");
        Assert.assertEquals(driver.getTitle(), "Swag Labs",
                "Product is not displayed");
    }

    public void login(String username, String password) {
        logInfo(INFO_STEP, "User fill the credentials to login: " + username + ", " + password);
        elementMethods.fillElement(userNameFieldLocator, username);
        elementMethods.fillElement(passwordLocator, password);
        logInfo(INFO_STEP, "User clicked the login button.");
        elementMethods.clickElement(loginButtonLocator);
    }

    public boolean isErrorMessageDisplayed(){
        return elementMethods.isElementDisplayed(loginErrorMesageLocator);
    }

    public String getErrorMessageText(){
        return elementMethods.getElementText(loginErrorMesageLocator);
    }


}
