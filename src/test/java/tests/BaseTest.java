package tests;

import extentUtility.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import propertyUtility.PropertyUtility;

import java.time.Duration;
import java.util.Map;

import static extentUtility.ExtentManager.*;


public class BaseTest {

    public WebDriver driver;
    ChromeOptions options = new ChromeOptions();
    public String testName;

    @BeforeSuite
    public void initializeReport() {
        initiateReport();
    }

    @BeforeMethod // această metodă se rulează înainte de fiecare test.
    public void openBrowser() {

        // Dezactivam Google Password Manager
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--incognito");
        options.setExperimentalOption("prefs", Map.of("credentials_enable_service", false,
                "profile.password_manager_enabled", false));
//        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(
                Integer.parseInt(PropertyUtility.get("implicit.wait"))));
        driver.manage().window().maximize();
        driver.get(PropertyUtility.get("app.url"));
//        driver.get("https://www.saucedemo.com");
//        driver.manage().window().maximize();
        testName = this.getClass().getSimpleName();
        createTest(testName);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus()==ITestResult.FAILURE) {
            String errorMesage = result.getThrowable().getMessage();
            logFailScreenshot(driver, errorMesage);
        }
        if(driver!=null){
            driver.quit();
        }
        finishTest(testName);
    }


    @AfterSuite
    public void finalizeReport() {
        generateReport();
    }

}
