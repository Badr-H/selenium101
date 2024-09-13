package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private WebDriver driver;
    private final By productHeader = By.cssSelector("span[data-test='title']");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductHeaderDisplayed() {
        return driver.findElement(productHeader).isDisplayed();
    }
}
