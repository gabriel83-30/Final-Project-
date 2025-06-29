package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static extentUtility.ExtentManager.logInfo;
import static extentUtility.ReportEventType.PASS_STEP;

public class ConfirmationPage extends BasePage {

    private By confirmationMessage = By.className("complete-header");

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageLoaded() {
        logInfo(PASS_STEP, "Validate that Confirmation Page is loaded properly");
        Assert.assertTrue(elementMethods.isElementDisplayed(confirmationMessage),
                "Confirmation Page did not load properly.");
    }


    public void verifyOrderConfirmationMessage() {
        String actualMessage = elementMethods.getElementText(confirmationMessage);
        logInfo(PASS_STEP, "The order confirmation message is correct: " + actualMessage);
        Assert.assertEquals(actualMessage, "Thank you for your order!",
                "The confirmation message is not correct!");
    }


}
