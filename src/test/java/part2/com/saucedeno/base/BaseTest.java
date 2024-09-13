package part2.com.saucedeno.base;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    private static WebDriver driver;
    private static LoginPage loginPage;
    private static ProductsPage productsPage;
    protected static String url = "https://www.saucedemo.com";

    @BeforeClass
    public static void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        loginPage = new LoginPage(driver);
        productsPage= new ProductsPage(driver);
    }

    @AfterClass
    public static void tearDown() {
//        driver.quit();
    }

    @Test
    public void testSuccessfulLogin() {
        loginPage.loginIntoApplication("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.isProductHeaderDisplayed());
        String expectedUrl=url+"/inventory.html";
        Assert.assertEquals(expectedUrl,driver.getCurrentUrl());

    }

}
