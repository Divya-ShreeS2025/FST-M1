package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class activity17 {
    public static void main(String args[])
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver= new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/selects");
        System.out.println("Page title is: "+driver.getTitle());
        WebElement dropdown = driver.findElement(By.id("single-select"));
        Select select= new Select(dropdown);
        select.selectByVisibleText("Option 1");
        System.out.println("second option is:"+select.getFirstSelectedOption().getText());
        select.selectByIndex(2);
        System.out.println("Third option is: "+select.getFirstSelectedOption().getText());
        select.selectByValue("4");
        System.out.println("Fourth option is: "+select.getFirstSelectedOption().getText());
        List<WebElement> options = select.getOptions();
        for(WebElement option:options)
        {
            System.out.println(option.getText());
        }
        driver.close();

    }
}
