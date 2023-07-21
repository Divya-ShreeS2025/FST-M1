package projectactivities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
public class activity3 {
    // Driver Declaration
    AndroidDriver driver;
    WebDriverWait wait;
    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        driver.get("https://v1.training-support.net/selenium");
    }
    @Test
    public void chromeTest() {
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.TextView")));
        //driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollTextIntoView(\"To-Do List\")"));
        //driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='To-Do List']")).click();
        //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"To-Do List\"))"));
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='To-Do List']")).click();
        wait.until((ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.EditText"))));
        driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("Add tasks to list");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
        driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("Get number of tasks");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
        driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("Clear the list");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Clear List']")).click();
    }

    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}