package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    WebDriver driver;

    public SignInPage(WebDriver driver){
        this.driver = driver;
    }
    private By userName = By.xpath("//input[@name=\"login\"]");
    private By userPassword = By.xpath("//input[@id=\"password\"]");
    private By signInButton = By.xpath("//input[@value=\"Sign in\"]");
    private By heading = By.xpath("//h1[1]");
    private By error = By.xpath("//div[@role=\"alert\"]");
    private By createAccLink = By.xpath("//a[@data-ga-click=\"Sign in, switch to sign up\"]");

    public SignInPage typeUserName(String username){
        driver.findElement(userName).sendKeys(username);
        return this;
    }
    public SignInPage typePassword(String password){
        driver.findElement(userPassword).sendKeys(password);
        return this;
    }
    public SignInPage signInInvalidCreds(String username, String password){
        this.typeUserName(username);
        this.typePassword(password);
        driver.findElement(signInButton).click();
        return new SignInPage(driver);
    }
    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }
    public String getErrorText(){
        return driver.findElement(error).getText();
    }
    public SignUpPage createAccount(){
        driver.findElement(createAccLink).click();
        return new SignUpPage(driver);
    }
}
