package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class activity13 {
    public static void main(String args[])
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/tables");
        System.out.println("Title of the page is: "+driver.getTitle());
        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class,' striped')]/tbody/tr"));
        System.out.println("Rows: "+rows.size());
        List<WebElement> cols=driver.findElements(By.xpath("//table[contains(@class,' striped')]/tbody/tr[1]/td"));
        System.out.println("Columns: "+cols.size());
        List<WebElement> thirdRow=driver.findElements(By.xpath("//table[contains(@class,' striped')]/tbody/tr[3]/td"));
        System.out.println("Third row cell values: ");
        for(WebElement cell:thirdRow) {
            System.out.println(cell.getText());
        }
       WebElement cellValue = driver.findElement(By.xpath("//table[contains(@class,' striped')]/tbody/tr[2]/td[2]"));
        System.out.println("Second row, second cell value is: "+cellValue.getText());
        driver.close();
    }
}
