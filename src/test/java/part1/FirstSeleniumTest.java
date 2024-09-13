package part1;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class FirstSeleniumTest {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }


    @Test
    public void loginTest() {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(250));
//                .ignoring(ElementNotInteractableException.class);


        var usernameInput =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.name("username")));
        usernameInput.sendKeys("Admin");

        var passwordInput =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.name("password")));
        passwordInput.sendKeys("admin123");
        driver.findElement(By.tagName("button")).click();

        var actualResult=
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.tagName("h6")));
        Assert.assertEquals(actualResult.getText(),"Dashboard");
    }
}
