package ui;

import org.example.ResetPasswordPage;
import org.example.SignUpPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ResetPasswordPageTest {

    private WebDriver driver;
    private ResetPasswordPage resetPasswordPage;

    @Before
    public void setkUpTest(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/password_reset");
        resetPasswordPage = new ResetPasswordPage(driver);
    }
    @Test
    public void setUpTest(){
        String heading = resetPasswordPage.getHeadingText();
//        Assert.assertEquals("Reset your password", heading);
    }
//    @Test
//    public void getHeadingTest(){
//        SignUpPage newSignUpPage = resetPasswordPageTest.registerWithInvalidCredts("sdfsdf@df.ddf", "er1111111111rr", "user");
//        SignUpPage clickContinue = resetPasswordPageTest.continueClick();
//        String errorUsername = newSignUpPage.getUserNameErrorIsNotAvailable();
//        Assert.assertEquals("Username user is not available.", errorUsername);
//    }
    @After
    public void tearDown(){
        driver.quit();
        driver = null;
        System.gc();
    }
}
