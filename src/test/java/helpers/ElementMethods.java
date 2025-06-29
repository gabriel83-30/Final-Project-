package helpers;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementMethods {

    public WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    Actions action;


    public ElementMethods(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }

//    public void pause(int milliseconds) {
//        try {
//            Thread.sleep(milliseconds);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

//    public void highlightElement(WebElement element) {
//        js.executeScript("arguments[0].style.border='3px solid red'", element);
//    }

    public void scrollPageDown(String scrollValue) {
        js.executeScript("window.scrollBy(0," + scrollValue + ")");
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public String getElementText(By locator) {
        return getElement(locator).getText();
    }

    public void waitForElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public void clickElement(By locator) {
        waitForElement(locator);
        WebElement element = getElement(locator);
//        highlightElement(element);
//        pause(800);
        getElement(locator).click();
    }


    public void fillElement(By locator, String textValue) {
        waitForElement(locator);
        WebElement element = getElement(locator);
//        highlightElement(element);
//        pause(500);
        getElement(locator).clear();
        getElement(locator).sendKeys(textValue);
//        pause(500);
    }

//    public boolean isElementDisplayed(By locator) {
//        try {
//            return getElement(locator).isDisplayed();
//        } catch (Exception e) {
//            return false;
//        }
//    }

    public boolean isElementDisplayed(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        if (!elements.isEmpty()) {
            return elements.get(0).isDisplayed();
        } else {
            return false;
        }
    }
}
