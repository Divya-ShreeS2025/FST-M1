package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class activity5 {
    public static void main(String args[])
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver= new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/input-events");
        System.out.println("Home page title: "+ driver.getTitle());
        Actions action = new Actions(driver);
        action.click().build().perform();
        WebElement frontText = driver.findElement(By.className("active"));
        System.out.println("Active side num after left click: "+frontText.getText());
        action.doubleClick().build().perform();
        String frontText2= driver.findElement(By.className("active")).getText();
        System.out.println("Active side num after doubleclick: "+frontText2);
        action.contextClick().build().perform();
        String frontText1 = driver.findElement(By.className("active")).getText();
        System.out.println("Active side num after right click: "+frontText1);
        driver.close();
    }
}
