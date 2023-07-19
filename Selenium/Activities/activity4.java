package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity4 {
    public static void main(String args[]) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
        System.out.println("Home page title: " + driver.getTitle());
        String header3 = driver.findElement(By.xpath("//h3[@id='third-header']")).getText();
        System.out.println(header3);
        String header5 = driver.findElement(By.xpath("//h5[contains(text(),'Fifth header')]")).getCssValue("color");
        System.out.println(header5);
        String violetBtn = driver.findElement(By.xpath("//button[contains(text(),'Violet')]")).getAttribute("class");
        System.out.println(violetBtn);
        String grayBtnText = driver.findElement(By.xpath("//button[contains(text(),'Grey')]")).getText();
        System.out.println(grayBtnText);
        driver.close();
    }

}
