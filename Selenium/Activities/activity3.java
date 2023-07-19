package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity3 {
    public static void main(String args[])
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
        driver.get("https://www.training-support.net/");
        System.out.println("Home page title: " + driver.getTitle());
        driver.findElement(By.xpath("//a[@id='about-link']")).click();
        System.out.println("About page title: " + driver.getTitle());
        driver.get("https://training-support.net/selenium/login-form");
        System.out.println("Home page title: "+driver.getTitle());
        driver.findElement(By.xpath("//input[contains(@id,'username')]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys("password");
        driver.findElement(By.xpath("//button[@class='ui button']")).click();
        driver.close();
    }
}
