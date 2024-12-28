package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    private By signInMenuButton = By.xpath("/html/body/div[1]/div[3]/header/div/div[2]/div/div/div/a");
    private By signUpMenuButton = By.xpath("/html/body/div[1]/div[3]/header/div/div[2]/div/div/a");
    private By signUpFormButton = By.xpath("/html/body/div[1]/div[6]/main/react-app/div/div/div/section[1]/div[1]/div[5]/div/form/section/div/button");
    private By tryCopilotButton = By.xpath("/html/body/div[1]/div[6]/main/react-app/div/div/div/section[1]/div[1]/div[5]/div/a");
    private By emailField = By.xpath("(//input[@name=\"user_email\"])[1]");
    private By searchField = By.xpath("/html/body/div[1]/div[3]/header/div/div[2]/div/div/qbsearch-input/div[1]/button/span");

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
