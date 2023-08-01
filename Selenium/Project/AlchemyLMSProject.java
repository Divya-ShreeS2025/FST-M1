package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AlchemyLMSProject {
    WebDriver driver;

    @BeforeMethod
    public void launchapplication() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void Activity1() {
        String sTitle = driver.getTitle();
        Assert.assertEquals("Alchemy LMS – An LMS Application", sTitle);
    }

    @Test
    public void Activity2() {
        String sHeadingText = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals("Learn from Industry Experts", sHeadingText);
    }

    @Test
    public void Activity3() {
        WebElement infoBox = driver.findElement(By.xpath("(//h3[@class='uagb-ifb-title'])[1]"));
        String infoBoxText = infoBox.getText();
        Assert.assertEquals(infoBoxText, "Actionable Training");
    }

    @Test
    public void Activity5() {
        driver.findElement(By.linkText("My Account")).click();
        String sTitle = driver.getTitle();
        Assert.assertEquals("My Account – Alchemy LMS", sTitle);
    }

    @Test
    public void Activity6() {
        driver.findElement(By.linkText("My Account")).click();
        String sTitle = driver.getTitle();
        Assert.assertEquals("My Account – Alchemy LMS", sTitle);
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        WebElement logoutbutton = driver.findElement(By.linkText("Logout"));
        Assert.assertTrue(logoutbutton.isDisplayed());
    }

    @Test
    public void Activity7() {
        driver.findElement(By.linkText("All Courses")).click();
        List<WebElement> numOfCourses = driver.findElements(By.xpath("//div[@class='ld-course-list-items row']"));
        System.out.println("Number of courses : " + numOfCourses.size());
    }

    @Test
    public void Activity8() {
        driver.findElement(By.linkText("My Account")).click();
        String sTitle = driver.getTitle();
        Assert.assertEquals("My Account – Alchemy LMS", sTitle);
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        WebElement logoutbutton = driver.findElement(By.linkText("Logout"));
        Assert.assertTrue(logoutbutton.isDisplayed());
    }

    @Test
    @Parameters({"sUsername", "sPassword"})
    public void Activity9(String sUsername, String sPassword) throws InterruptedException {

        driver.findElement(By.linkText("All Courses")).click();
        driver.findElement(By.linkText("See more...")).click();
        driver.findElement(By.xpath("//a[text()='Login to Enroll' or  text()='Login']")).click();
        driver.findElement(By.id("user_login")).sendKeys(sUsername);
        driver.findElement(By.id("user_pass")).sendKeys(sPassword);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Log In']"))).click();
        WebElement courseSection = driver.findElement(By.xpath("(//div[@class='ld-item-title'])[2]"));
        String title = courseSection.getText().split("\n")[0];
        courseSection.click();
        Assert.assertEquals(driver.getTitle(), title + " – Alchemy LMS");
        driver.findElement(By.xpath("//span[@class='ld-topic-title']")).click();
        try {
            WebElement markComplete = driver.findElement(By.xpath("(//input[@value='Mark Complete'])[2]"));
            if (markComplete.isDisplayed()) {
                markComplete.click();
                System.out.println("Course marked Completed");
            } else {
                System.out.println("Mark Complete is disabled.");
            }
        } catch (Exception e) {
            System.out.println("Course already completed");
        }
    }

    @AfterMethod
    public void closebrowser() {
        driver.close();
    }
}