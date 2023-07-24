package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class activity21 {
    public static void main(String args[])
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/tab-opener");
        System.out.println(driver.getTitle());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String parentWindow = driver.getWindowHandle();
        System.out.println("current tab: "+parentWindow);
        driver.findElement(By.id("launcher")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> childWindows=driver.getWindowHandles();
        System.out.println("Current opened windows: "+childWindows);
        for(String handle:childWindows)
        {
            if(handle!=parentWindow) {
                driver.switchTo().window(handle);
            }
        }
        System.out.println("Current tab: "+driver.getWindowHandle());
        System.out.println("window 2 title: "+driver.getTitle());
       String Pageheading = driver.findElement(By.xpath("//div[@class='content']")).getText();
       System.out.println("PageHeading is : "+Pageheading);
        driver.findElement(By.id("actionButton")).click();
        Set<String> handles=driver.getWindowHandles();
        for(String handle:handles)
        {
            driver.switchTo().window(handle);
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content")));
        System.out.println("Current tab: " + driver.getWindowHandle());
        System.out.println("Page title: " + driver.getTitle());
        String pageHeading = driver.findElement(By.className("content")).getText();
        System.out.println("Page Heading: " + pageHeading);

        driver.quit();



    }
}
