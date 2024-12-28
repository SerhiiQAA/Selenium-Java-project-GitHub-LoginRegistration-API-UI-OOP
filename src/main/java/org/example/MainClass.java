package org.example;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("moz:webdriver-bidi", true);
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
        driver.get("https://github.com");

        MainPage mainPage = new MainPage(driver);
//        mainPage.clickSignIn();
        mainPage.clickCopilot();

        CopilotPage copilotPage = new CopilotPage(driver);
        copilotPage.copilotTry();
//        mainPage.clickSignUp();
//        mainPage.clickCopilot();

        SignInPage signInPage = new SignInPage(driver);
        signInPage.signInInvalidCreds("df", "df");
        signInPage.getErrorText();
        signInPage.createAccount();

        SignUpPage signUpPage = new SignUpPage(driver);
//        signUpPage.registerWithInvalidCredts("", "" , "");
        Thread.sleep(2000);
        signUpPage.continueClick();
//        Thread.sleep(2000);
        signUpPage.getEmailErrorText();
        signUpPage.getPasswordErrorText();
        signUpPage.getUserNameErrorText();
//        System.out.println(signUpPage.getUserNameErrorText());

        driver.quit();
    }
}