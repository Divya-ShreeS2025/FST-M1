package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class verifyingWebElement_Methods {
    public static void main(String args[])
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/DynamicControls");
        WebElement checkbox = driver.findElement(By.xpath("//input[@id='checkbox']"));
        System.out.println("Checkbox is displayed: "+checkbox.isDisplayed());
        driver.findElement(By.xpath("//button[contains(text(),'Toggle Checkbox')]")).click();
        System.out.println("Checkbox is displayed: "+checkbox.isDisplayed());
        WebElement inputTextBox = driver.findElement(By.xpath("//input[@id='textInput']"));
        System.out.println("Input text box is Enabled? "+inputTextBox.isEnabled());
        driver.findElement(By.xpath("//button[contains(text(),'Enable Input')]")).click();
        System.out.println("Input text box is Enabled? "+inputTextBox.isEnabled());
        driver.quit();
    }
}
