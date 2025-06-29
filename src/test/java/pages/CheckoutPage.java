package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static extentUtility.ExtentManager.logInfo;
import static extentUtility.ReportEventType.INFO_STEP;
import static extentUtility.ReportEventType.PASS_STEP;

public class CheckoutPage extends BasePage {

    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageLoaded() {
        logInfo(PASS_STEP, "Validate that Checkout Page is loaded properly");
        Assert.assertTrue(elementMethods.isElementDisplayed(firstNameField),
                "Checkout Page is not loaded properly.");
    }

    public void fillCheckoutInformation(String firstName, String lastName, String postalCode) {
        logInfo(INFO_STEP, "User fills in the checkout form with data: "
                + firstName + ", " + lastName + " and " + postalCode);
        elementMethods.fillElement(firstNameField, firstName);
        elementMethods.fillElement(lastNameField, lastName);
        elementMethods.fillElement(postalCodeField, postalCode);
        logInfo(INFO_STEP, "User clicked the button.");
        elementMethods.clickElement(continueButton);
    }

    public void finishOrder() {
        logInfo(INFO_STEP, "User clicked the finish button and finalize the order.");
        elementMethods.clickElement(finishButton);
    }


}
