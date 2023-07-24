package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class activity18 {
    public static void main(String args[])
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/selects");
        System.out.println("page title: "+driver.getTitle());
        WebElement dropdown = driver.findElement(By.id("multi-select"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Javascript");
        for(int i=4;i<=6;i++)
        {
            select.selectByIndex(i);
        }
        select.selectByValue("node");
        select.deselectByIndex(4);
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        for(WebElement options:selectedOptions)
        {
            System.out.println("Selected options are: "+options.getText());
        }
        driver.close();

    }
}
