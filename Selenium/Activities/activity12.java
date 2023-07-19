package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity12 {
    public static void main(String args[]) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/DynamicControls");
        System.out.println("Home page title: " + driver.getTitle());
        WebElement inputTextBox = driver.findElement(By.xpath("//input[@id='textInput']"));
        System.out.println("Input text box is Enabled? " + inputTextBox.isEnabled());
        driver.findElement(By.xpath("//button[contains(text(),'Enable Input')]")).click();
        System.out.println("Input text box is Enabled? " + inputTextBox.isEnabled());
        driver.quit();
    }
}
