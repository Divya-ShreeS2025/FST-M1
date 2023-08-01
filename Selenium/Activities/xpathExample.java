package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class xpathExample {
    public static void main(String args[])
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
        System.out.println(driver.getTitle());
        driver.get("https://www.training-support.net/");
        //Absolute xpath
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/a")).click();
        //Relative xpath using id
        driver.findElement(By.xpath("//a[@id='about-link']")).click();

        //Relative xpath using class name
        driver.findElement(By.xpath("//a[@class='ui inverted huge green button']")).click();

        //Relative xpath using contains keyword
        driver.findElement(By.xpath("//a[contains(@id,'about-link')]")).click();
        driver.findElement(By.xpath("//a[contains(@class,'ui inverted huge green button']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'About Us')]")).click();



    }
}
