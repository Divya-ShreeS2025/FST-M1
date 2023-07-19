package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class activity8 {
    public static void main(String args[])
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver= new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://training-support.net/selenium/dynamic-controls");
        System.out.println(driver.getTitle());
        WebElement checkbox = driver.findElement(By.id("toggleCheckbox"));
        checkbox.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dynamicCheckbox")));
        System.out.println(checkbox.isDisplayed());
        checkbox.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamicCheckbox")));
        System.out.println(checkbox.isDisplayed());
        driver.close();



    }

}
