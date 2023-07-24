package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class activity22 {
    public static void main(String args[])
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/popups");
        System.out.println("Page title is: "+driver.getTitle());
        Actions action = new Actions(driver);
        WebElement button=driver.findElement(By.xpath("//button[@class='ui huge inverted orange button']"));
        action.moveToElement(button).build().perform();
        String toolTipMessage=button.getAttribute("data-tooltip");
        System.out.println("Tooltip message is: "+toolTipMessage);
        button.click();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        String message = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println(message);
        driver.quit();
    }
}
