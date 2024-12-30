package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    private By signInMenuButton = By.xpath("(//a[@href=\"/login\"])[2]");
    private By signUpMenuButton = By.xpath("//a[contains(@href, 'signup') and contains(@href, 'source=header-home')]");
    private By signUpFormButton = By.xpath("(//button[@type=\"submit\"])[3]");
    private By tryCopilotButton = By.xpath("(//a[@href=\"/features/copilot\"])[1]");
    private By emailField = By.xpath("(//input[@name=\"user_email\"])[1]");
    private By searchField = By.xpath("//span[@class=\"flex-1\"]");

    public SignInPage clickSignIn(){
        driver.findElement(signInMenuButton).click();
        return new SignInPage(driver);
    }
    public SignUpPage clickSignUp(){
        driver.findElement(signUpMenuButton).click();
        return new SignUpPage(driver);
    }
    public SignUpPage clickSignUpForm(){
        driver.findElement(signUpFormButton).click();
        return new SignUpPage(driver);
    }
    public MainPage typeEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }
    public MainPage typeSearch(String search){
        driver.findElement(searchField).sendKeys(search);
        return this;
    }
    public CopilotPage clickCopilot(){
        driver.findElement(tryCopilotButton).click();
        return new CopilotPage(driver);
    }
//    public SignUpPage register(String username, String email, String password){
//        this.typeEmail(email);
//        this.typePassword(password);
//        this.typeUserName(username);
//        this.clickSignUp();
//    }

}
