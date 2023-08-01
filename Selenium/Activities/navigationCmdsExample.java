package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class navigationCmdsExample {
    public static void main(String args[])
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://www.training-support.net/");
        driver.getTitle();
        driver.navigate().forward();
        driver.findElement(By.linkText("About Us")).click();
        driver.navigate().refresh();
        driver.navigate().back();
        driver.quit();
    }
}
