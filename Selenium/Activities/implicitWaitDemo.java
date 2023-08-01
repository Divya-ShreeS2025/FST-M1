package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class implicitWaitDemo {
    public static void main(String args[])
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
        driver.get("https://www.training-support.net/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement text = driver.findElement(By.tagName("h1"));
        System.out.println(text.getText());
        driver.close();
    }
}
