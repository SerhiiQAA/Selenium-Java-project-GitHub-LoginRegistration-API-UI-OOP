package ui;

import org.example.SignUpPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {
    private WebDriver driver;
    private SignUpPage signUpPage;

    @Before
    public void setUpTest(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/signup");
        signUpPage = new SignUpPage(driver);
    }
    @Test
    public void getHeadingTest(){
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Sign up to GitHub", heading);
    }
    @Test
    public void singUpInvalidEmptyCreds(){
        SignUpPage newSignUpPage = signUpPage.registerWithInvalidCredts("", "", "");
        SignUpPage clickContinue = signUpPage.continueClick();
        String errorEmail = newSignUpPage.getEmailErrorText();
        String errorPassword = newSignUpPage.getPasswordErrorText();
        String errorUsername = newSignUpPage.getUserNameErrorText();
        Assert.assertEquals("Email cannot be blank", errorEmail);
        Assert.assertEquals("Password cannot be blank", errorPassword);
        Assert.assertEquals("Username cannot be blank", errorUsername);
    }
    @Test
    public void singUpInvalidEmptyEmail(){
        SignUpPage newSignUpPage = signUpPage.registerWithInvalidCredts("", "er1111111111rr", "Jone12345698");
        SignUpPage clickContinue = signUpPage.continueClick();
        String errorEmail = newSignUpPage.getEmailErrorText();
        String errorPassword = newSignUpPage.getPasswordErrorText();
        String errorUsername = newSignUpPage.getUserNameErrorText();
        Assert.assertEquals("Email cannot be blank", errorEmail);
//        Assert.assertEquals("", errorPassword);
//        Assert.assertEquals("", errorUsername);
    }
    @Test
    public void singUpInvalidEmptyPassword(){
        SignUpPage newSignUpPage = signUpPage.registerWithInvalidCredts("dfy@sdg.hj", "", "Jone12345698");
        SignUpPage clickContinue = signUpPage.continueClick();
        String errorEmail = newSignUpPage.getEmailErrorText();
        String errorPassword = newSignUpPage.getPasswordErrorText();
        String errorUsername = newSignUpPage.getUserNameErrorText();
        Assert.assertEquals("Email cannot be blank", errorEmail);
        Assert.assertEquals("Password cannot be blank", errorPassword);
//        Assert.assertEquals("", errorUsername);
    }
    @Test
    public void singUpInvalidEmptyUsername(){
        SignUpPage newSignUpPage = signUpPage.registerWithInvalidCredts("sdfsdf@df.ddf", "errr", "");
        SignUpPage clickContinue = signUpPage.continueClick();
        String errorEmail = newSignUpPage.getEmailErrorText();
        String errorPassword = newSignUpPage.getPasswordErrorText();
        String errorUsername = newSignUpPage.getUserNameErrorText();
//        Assert.assertEquals("Email cannot be blank", errorEmail);
//        Assert.assertEquals("Password cannot be blank", errorPassword);
        Assert.assertEquals("Username cannot be blank", errorUsername);
    }
    @Test
    public void singUpInvalidUsernameIsNotAvailable(){
        SignUpPage newSignUpPage = signUpPage.registerWithInvalidCredts("sdfsdf@df.ddf", "er1111111111rr", "user");
        SignUpPage clickContinue = signUpPage.continueClick();
         String errorEmail = newSignUpPage.getEmailErrorText();
        String errorPassword = newSignUpPage.getPasswordErrorText();
        String errorUsername = newSignUpPage.getUserNameErrorIsNotAvailable();
        Assert.assertEquals("Email is available", errorEmail);
        Assert.assertEquals("Password cannot be blank", errorPassword);
        Assert.assertEquals("Username user is not available.", errorUsername);
    }
    @Test
    public void singUpInvalidShotPassword(){
        SignUpPage newSignUpPage = signUpPage.registerWithInvalidCredts("sdfsdf@df.ddf", "123q", "Jone12345698");
        SignUpPage clickContinue = signUpPage.continueClick();
        String errorEmail = newSignUpPage.getEmailErrorText();
        String errorPassword = newSignUpPage.getPasswordErrorText();
        String errorUsername = newSignUpPage.getUserNameErrorText();
//        Assert.assertEquals("Email cannot be blank", errorEmail);
        Assert.assertEquals("Password is too short", errorPassword);
//        Assert.assertEquals("Username cannot be blank", errorUsername);
    }


    @After
    public void tearDown(){
        driver.quit();
        driver = null;
        System.gc();
    }
}
