package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPasswordPage {
    WebDriver driver;
    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    private By heading = By.xpath("//h1");
    private By emailEnter = By.xpath("[id=\"email_field\"]");
    private By verifyButton = By.xpath("//button[text()=\"Verify\"]");
    private By verifyHeader = By.xpath("//h2[@class=\"f4 mb-3\"]");
    private By audioButton = By.xpath("//button[@aria-label=\"Audio\"]");
    private By submitButton = By.xpath("//button[text()=\"Submit\"]");
    private By visulButton = By.xpath("//button[@aria-label=\"Visual\"]");
    private By restartButton = By.xpath("//button[@aria-label=\"Restart\"]");
    private By incorrectVerifyHeader = By.xpath("aria-label=\"That was not quite right.\"");
    private By sendPasswordResetEmail = By.xpath("//input[@value=\"Send password reset email\"]");

    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }
    public ResetPasswordPage typeEmail(String email){
        driver.findElement(emailEnter).sendKeys(email);
        return this;
    }
    public ResetPasswordPage verify(){
        driver.findElement(verifyButton).click();
        return new ResetPasswordPage(driver);
    }
    public ResetPasswordPage sendEmail(){
        driver.findElement(sendPasswordResetEmail).click();
        return new ResetPasswordPage(driver);
    }
    public ResetPasswordPage audioButton(){
        driver.findElement(audioButton).click();
        return new ResetPasswordPage(driver);
    }
    public String getVerifyHeaderText(){
        return driver.findElement(verifyHeader).getText();
    }
    public ResetPasswordPage submitButton(){
        driver.findElement(submitButton).click();
        return new ResetPasswordPage(driver);
    }
    public String getVerifyErrorHeaderText(){
        return driver.findElement(incorrectVerifyHeader).getText();
    }

}
