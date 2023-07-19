package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class activity9 {
    public static void main(String args[])
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/ajax");
        WebElement button = driver.findElement(By.xpath("//button[contains(@class,'ui violet button')]"));
        button.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("h1")));
        WebElement displayedText = driver.findElement(By.tagName("h1"));
        System.out.println(displayedText.getText());
        WebElement lateText = driver.findElement(By.tagName("h3"));
        System.out.println(lateText.getText());
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h3"),"I'm late!"));
        WebElement lateText1 = driver.findElement(By.tagName("h3"));
        System.out.println(lateText1.getText());
        driver.close();

    }
}
