package ui;

import org.example.SignInPage;
import org.example.SignUpPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SignInPageTest {

    private WebDriver driver;
    private SignInPage signInPage;

    @Before
    public void setUpTest(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/login");
        signInPage = new SignInPage(driver);
    }
    @Test
    public void signInInvalidDataTest(){
        SignInPage newSignInPage = signInPage.signInInvalidCreds("./", "lkj");
        String error = newSignInPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.", error);
    }
    @Test
    public void signInInvalidEmptyEmailTest(){
        SignInPage newSignInPage = signInPage.signInInvalidCreds("./", "");
        String error = newSignInPage.getErrorText();
        Assert.assertEquals("Please fill out this field.", error);
    }
    @Test
    public void signInInvalidEmptyPasswordTest(){
        SignInPage newSignInPage = signInPage.signInInvalidCreds("", "lkj");
        String error = newSignInPage.getErrorText();
        Assert.assertEquals("Please fill out this field.", error);
    }
    @Test
    public void signInInvalidEmptyFieldsTest(){
        SignInPage newSignInPage = signInPage.signInInvalidCreds("", "");
        String error = newSignInPage.getErrorText();
        Assert.assertEquals("Please fill out this field.", error);
    }
    @Test
    public void createAccTest(){
        SignUpPage signUpPage = signInPage.createAccount();
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Sign up to GitHub", heading);
    }
    @After
    public void tearDown(){
        driver.quit();
        driver = null;
        System.gc();
    }
}
