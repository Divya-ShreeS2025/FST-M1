package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class cssSelectorDemo {
    public static void main(String args[])
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
        driver.get("https://www.training-support.net/");
        WebElement cssSelector = driver.findElement(By.cssSelector(".green")); //css selector using class
        System.out.println(cssSelector.getText());
        WebElement cssSelector1 = driver.findElement(By.cssSelector(".ui.green"));//css selector using class
        System.out.println(cssSelector1.getText());
        WebElement cssSelector2 = driver.findElement(By.cssSelector("#about-link"));//css selector using id
        System.out.println(cssSelector2.getText());
        WebElement cssSelector3 = driver.findElement(By.cssSelector("a#about-link"));//css selector using id
        System.out.println(cssSelector3.getText());
        WebElement cssSelector4 = driver.findElement(By.cssSelector("ui.big.list li:nth-of-type(3)"));//css selector using id
        System.out.println(cssSelector4.getText());
        driver.quit();



    }
}
