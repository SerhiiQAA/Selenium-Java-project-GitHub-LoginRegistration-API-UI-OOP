package ui;

import org.example.CopilotPage;
import org.example.MainPage;
import org.example.SignInPage;
import org.example.SignUpPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com");
        mainPage = new MainPage(driver);
    }
    @Test
    public void signIn(){
        SignInPage signInPage = mainPage.clickSignIn();
        String heading = signInPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", heading);
    }
    @Test
    public void signUp(){
        SignUpPage signUnPage = mainPage.clickSignUp();
        String heading = signUnPage.getHeadingText();
        Assert.assertEquals("Sign up to GitHub", heading);
    }
    @Test
    public void signUpForm(){
        SignUpPage signUnPage = mainPage.clickSignUpForm();
        String heading = signUnPage.getHeadingText();
        Assert.assertEquals("Sign up to GitHub", heading);
    }
    @Test
    public void copilotTry(){
        CopilotPage copilotPage = mainPage.clickCopilot();
        String heading = copilotPage.getHeadingText();
        Assert.assertEquals("The AI editor for everyone", heading);
    }
    @After
    public void tearDown(){
        driver.quit();
        driver = null;
        System.gc();
    }

}
