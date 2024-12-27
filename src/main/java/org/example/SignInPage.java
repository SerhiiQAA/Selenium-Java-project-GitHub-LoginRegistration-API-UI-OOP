package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    WebDriver driver;

    public SignInPage(WebDriver driver){
        this.driver = driver;
    }
    private By userName = By.xpath("//*[@id=\"login_field\"]");
    private By userPassword = By.xpath("//*[@id=\"password\"]");
    private By signInButton = By.xpath("/html/body/div[1]/div[3]/main/div/div[4]/form/div/input[13]");
    private By heading = By.xpath("/html/body/div[1]/div[3]/main/div/div[1]/h1");
    private By error = By.xpath("/html/body/div[1]/div[3]/main/div/div[2]/div/div/div");
    private By createAccLink = By.xpath("/html/body/div[1]/div[3]/main/div/div[5]/p/a");

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
        driver.findElement(createAccLink).getText();
        return new SignUpPage(driver);
    }
}
