package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }
    private By heading = By.xpath("//*[@id=\"signup-form-fields\"]");
    private By email = By.xpath("//*[@id=\"email\"]");
    private By password = By.xpath("//*[@id=\"password\"]");
    private By username = By.xpath("//*[@id=\"login\"]");
    private By continueButton = By.xpath("/html/body/div[1]/div[4]/div/main/div/div[2]/div[2]/div/div[2]/div/form/div[3]/button/span");
    private By emailError = By.xpath("/html/body/div[1]/div[4]/div/main/div/div[2]/div[2]/div/div[2]/div/form/div[2]/div[1]/div[1]/auto-check/div/p");
    private By passwordError = By.xpath("/html/body/div[1]/div[4]/div/main/div/div[2]/div[2]/div/div[2]/div/form/div[2]/div[2]/div[1]/div[1]/visible-password/auto-check/div/p");
    private By userNameError = By.xpath("/html/body/div[1]/div[4]/div/main/div/div[2]/div[2]/div/div[2]/div/form/div[2]/div[3]/div[2]/div[1]/auto-check/div[2]/p");
    private By userNameErrorIsNotAvailable = By.xpath("//div[text()='Username user is not available.']");

    public SignUpPage typeEmail(String emailAdress){
        driver.findElement(email).sendKeys(emailAdress);
        return this;
    }
    public SignUpPage typePassword(String pwd){
        driver.findElement(password).sendKeys(pwd);
        return this;
    }
    public SignUpPage typeUserName(String usrName){
        driver.findElement(username).sendKeys(usrName);
        return this;
    }
    public SignUpPage registerWithInvalidCredts(String email, String password, String username){
        this.typeEmail(email);
        this.typePassword(password);
        this.typeUserName(username);
        return new SignUpPage(driver);
    }
    public SignUpPage continueClick(){
        driver.findElement(continueButton).click();
        return new SignUpPage(driver);
    }
    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }
    public String getEmailErrorText(){
        return driver.findElement(emailError).getText();
    }
    public String getPasswordErrorText(){
        return driver.findElement(passwordError).getText();
    }
    public String getUserNameErrorText(){
        return driver.findElement(userNameError).getText();
    }
    public String getUserNameErrorIsNotAvailable(){
        return driver.findElement(userNameErrorIsNotAvailable).getText();
    }

}
