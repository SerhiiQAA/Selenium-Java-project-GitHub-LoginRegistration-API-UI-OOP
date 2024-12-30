package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

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
        signUpPage.continueClick();
//        Thread.sleep(2000);
        signUpPage.getEmailErrorTextBlank();
        signUpPage.getPasswordErrorTextBlank();
        signUpPage.getUserNameErrorTextBlank();
//        System.out.println(signUpPage.getUserNameErrorText());

        driver.quit();
        driver = null;
        System.gc();
    }
}