package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class complexInteractions_dragdrop {
    public static void main(String args[])
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/drag-drop");
        WebElement football = driver.findElement(By.xpath("//img[@id='draggable']"));
        WebElement dropZone1 = driver.findElement(By.xpath("//div[@id='droppable']"));
        WebElement dropZone2 = driver.findElement(By.xpath("//div[@id='dropzone2']"));
        Actions action = new Actions(driver);
        action.clickAndHold(football).moveToElement(dropZone1).release().build().perform();
        action.dragAndDrop(football,dropZone2).build().perform();
        driver.close();
    }
}