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
//        driver.manage().window().maximize();
        driver.get("https://github.com/signup?ref_cta=Sign+up&ref_loc=header+logged+out&ref_page=%2F&source=header-home");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
//        System.out.println(driver.getPageSource());
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.registerWithInvalidCredts("sdsd@dd.gsg", "s22345Victorydfsff" , "QQdsfffffffffffffffff");
//
        driver.quit();
    }
}