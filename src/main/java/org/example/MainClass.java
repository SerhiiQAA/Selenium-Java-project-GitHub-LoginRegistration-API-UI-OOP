package org.example;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainClass {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com");
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());

        MainPage mainPage = new MainPage(driver);
        mainPage.clickSignIn();

        SignInPage signInPage = new SignInPage(driver);
        signInPage.signInInvalidCreds("df", "df");
        signInPage.getErrorText();
        SignUpPage account = signInPage.createAccount();

        account.registerWithInvalidCredts("", "" , "");
        account.continueClick();
        account.getEmailErrorText();
        account.getPasswordErrorText();
        account.getUserNameErrorText();

        driver.quit();
    }
}