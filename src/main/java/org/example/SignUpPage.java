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
    private By continueButton = By.xpath("(//span[@class=\"Button-content\"])[1]");

    private By emailErrorBlank = By.xpath("(//p[@class=\"mb-0\"])[1]");
    private By emailErrorInvalidData = By.xpath("(//div[@class=\"error\"])[1]");

    private By passwordErrorBlank = By.xpath("(//p[@class=\"mb-0\"])[2]");
    private By passwordErrorTooShot = By.xpath("//p[@class=\"password-validity-summary password-validity-summary-fail my-2\"]");
    private By passwordErrorTooLong = By.xpath("//p[@class=\"password-validity-summary password-validity-summary-fail my-2\"]");
    private By passwordErrorSpecialSymbol = By.xpath("//p[contains(text(), \"Password needs a number and lowercase letter\")]");

    private By userNameErrorBlank = By.xpath("//p[text()=\"Username cannot be blank\"]");
    private By userNameErrorIsNotAvailable = By.xpath("//div[@class=\"m-1\"]/div");

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

    public String getEmailErrorTextBlank(){
        return driver.findElement(emailErrorBlank).getText();
    }
    public String getEmailErrorTextInvalidData(){
        return driver.findElement(emailErrorInvalidData).getText();
    }


    public String getPasswordErrorTextBlank(){
        return driver.findElement(passwordErrorBlank).getText();
    }
    public String getPasswordErrorTextTooShort(){
        return driver.findElement(passwordErrorTooShot).getText();
    }
    public String getPasswordErrorTextTooLong(){
        return driver.findElement(passwordErrorTooLong).getText();
    }
    public String getPasswordErrorSpecialSymbol(){
        return driver.findElement(passwordErrorSpecialSymbol).getText();
    }


    public String getUserNameErrorTextBlank(){
        return driver.findElement(userNameErrorBlank).getText();
    }
    public String getUserNameErrorIsNotAvailable(){
        return driver.findElement(userNameErrorIsNotAvailable).getText();
    }

}
