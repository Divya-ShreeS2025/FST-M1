package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class activity10 {
    public static void main(String[] args) {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Create the Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the page
        driver.get("https://training-support.net/selenium/DynamicControls");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());

        // Find the checkbox
        WebElement checkbox = driver.findElement(By.xpath("//input[@id='checkbox']"));
        // Find the toggle button and click it
        WebElement checkboxToggle = driver.findElement(By.xpath("//button[contains(text(),'Toggle Checkbox')]"));
        checkboxToggle.click();
        // Wait for the checkbox to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@id='checkbox']")));
        System.out.println("Checkbox is displayed: " + checkbox.isDisplayed());
        // Click the button again
        checkboxToggle.click();
        // Wait for the element to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='checkbox']")));
        System.out.println("Checkbox is displayed: " + checkbox.isDisplayed());
        // Click the checkbox
        driver.findElement(By.xpath("//input[@id='checkbox']")).click();

        // Close the browser
        driver.close();
    }
}
