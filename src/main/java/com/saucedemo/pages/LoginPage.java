package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// page_url = https://www.saucedemo.com/
public class LoginPage {
    private final WebDriver driver;
    private final By usernameField = By.cssSelector("input[data-test='username']");
    private final By passwordField = By.cssSelector("input[data-test='password']");
    private final By loginButton = By.cssSelector("input[data-test='login-button']");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public void setUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);

    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void loginIntoApplication(String username, String password){
        setUsername(username);
        setPassword(password);
        driver.findElement(loginButton).click();
    }
    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }
}