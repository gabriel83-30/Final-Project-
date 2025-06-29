package extentUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

import static extentUtility.ReportEventType.*;

public class ExtentManager {

    // clasa aceasta populeaza informatii comune in raport si deseneaza crearea si configurarea raportului;
    private static ExtentReports extentReports;
    // creeaza entry-uri in raport si face update la statusul metodelor de test;
    private static ExtentTest extentTest;
    //se ocupa de UI DE CUM ARATA RAPORTUL SI GESTIONAREA IN format html;
    private static ExtentSparkReporter extentSparkReporter;
    private static final String pathProject = System.getProperty("user.dir") + "/target/extentReports/";   // path
    private static final ConcurrentHashMap<String, ExtentTest> context = new ConcurrentHashMap<>();

    //Metoda care face un folder
    private static void createDirectory() {
        File directory = new File(pathProject);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    //Metoda care sa initializeze fisierul html
    public static synchronized void initiateReport() {
        createDirectory();
        extentSparkReporter = new ExtentSparkReporter(pathProject + "ExtentReport.html");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setDocumentTitle("Test Report");
        extentSparkReporter.config().setReportName("Automated Tests Results");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
    }

    //Metoda care sa logheze informatia
    public static synchronized void logInfo(String eventType, String message) {
        String threadName = Thread.currentThread().getName();
        if (eventType.equals(INFO_STEP)){
            context.get(threadName).log(Status.INFO, message);
        }
        if (eventType.equals(PASS_STEP)){
            context.get(threadName).log(Status.PASS, message);
        }
    }

    //Metoda care sa faca un extent-test pentru fiecare test;
    public static synchronized void createTest(String  testName){
        extentTest = extentReports.createTest(testName + " - report");
        context.put(Thread.currentThread().getName(), extentTest);
        logInfo(INFO_STEP, " ---Start test ---" + testName);
    }

    //Metoda care sa logheze inchiderea unui extent-test;
    public static synchronized void finishTest(String testName){
        logInfo(INFO_STEP, " ---Finish test ---" + testName);
    }

    //Metoda care sa faca un ScreenShot
    private static String getScreenShot(WebDriver driver){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
    }

    //Metoda care sa logheze un failed test(cu screenshot);
    public static synchronized void logFailScreenshot(WebDriver driver, String message){
        context.get(Thread.currentThread().getName()).fail(message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenShot(driver)).build());
    }

    //Metoda care sa genereze raportul final;
    public static synchronized void generateReport(){
        extentReports.flush();
    }
}
