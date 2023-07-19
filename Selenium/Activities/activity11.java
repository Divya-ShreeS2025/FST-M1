package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity11 {
    public static void main(String args[]) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/DynamicControls");
        System.out.println("Home page title: " + driver.getTitle());
        WebElement checkbox = driver.findElement(By.xpath("//input[@id='checkbox']"));
        checkbox.click();
        System.out.println("Checkbox is selected: " + checkbox.isSelected());
        // Click the checkbox to deselect it
        checkbox.click();
        System.out.println("Checkbox is selected: " + checkbox.isSelected());
        driver.close();
    }
}

