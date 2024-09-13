//package com.saucedemo.pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.PageFactory;
//
//// page_url = https://www.saucedemo.com/
//public class SauceDemoBasePage {
//    public static WebDriver driver;
//
//    public static void setDriver(WebDriver driver) {
//        SauceDemoBasePage.driver = driver;
//    }
//
//    protected WebElement find(By locator) {
//        return driver.findElement(locator);
//    }
//    protected void  set(By locator, String text){
//        find(locator).clear();
//        find(locator).sendKeys(text);
//    }
//    protected void click(By locator){
//        find(locator).click();
//    }
//}