package ui;
//=================== made by SerhiiQAA =================
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
        String errorEmail = newSignUpPage.getEmailErrorTextBlank();
        String errorPassword = newSignUpPage.getPasswordErrorTextBlank();
        String errorUsername = newSignUpPage.getUserNameErrorTextBlank();
        Assert.assertEquals("Email cannot be blank", errorEmail);
        Assert.assertEquals("Password cannot be blank", errorPassword);
        Assert.assertEquals("Username cannot be blank", errorUsername);
    }
    @Test
    public void singUpInvalidEmptyEmail(){
        SignUpPage newSignUpPage = signUpPage.registerWithInvalidCredts("", "er1111111111rr", "Jone12345698");
        SignUpPage clickContinue = signUpPage.continueClick();
        String errorEmail = newSignUpPage.getEmailErrorTextBlank();
        Assert.assertEquals("Email cannot be blank", errorEmail);
    }
    @Test
    public void singUpInvalidEmptyPassword(){
        SignUpPage newSignUpPage = signUpPage.registerWithInvalidCredts("dfy@sdg.hj", "", "Jone12345698");
        SignUpPage clickContinue = signUpPage.continueClick();
        String errorPassword = newSignUpPage.getPasswordErrorTextBlank();
        Assert.assertEquals("Password cannot be blank", errorPassword);
    }
    @Test
    public void singUpInvalidShotPassword(){
        SignUpPage newSignUpPage = signUpPage.registerWithInvalidCredts("sdfsdf@df.ddf", "123q", "Jone12345698");
        SignUpPage clickContinue = signUpPage.continueClick();
        String errorPassword = newSignUpPage.getPasswordErrorTextTooShort();
        Assert.assertEquals("Password is too short", errorPassword);
    }
    @Test
    public void singUpInvalidLongPassword(){
        SignUpPage newSignUpPage = signUpPage.registerWithInvalidCredts("sdfsdf@df.ddf", "dddddddddddddddddddddddddddddddddddddddddddddddddd123q77777777777777777777777777777", "Jone12345698");
        SignUpPage clickContinue = signUpPage.continueClick();
        String errorPassword = newSignUpPage.getPasswordErrorTextTooLong();
        Assert.assertEquals("Password is too long", errorPassword);
    }
    @Test
    public void singUpInvalidSpecSymbolPassword(){
        SignUpPage newSignUpPage = signUpPage.registerWithInvalidCredts("sdfsdf@df.ddf", "@#$%^&%&%&*&*(", "Jone12345698");
        SignUpPage clickContinue = signUpPage.continueClick();
        String errorPassword = newSignUpPage.getPasswordErrorSpecialSymbol();
        Assert.assertEquals("Password needs a number and lowercase letter", errorPassword);
    }
    @Test
    public void singUpInvalidEmptyUsername(){
        SignUpPage newSignUpPage = signUpPage.registerWithInvalidCredts("sdfsdf@df.ddf", "errr", "");
        SignUpPage clickContinue = signUpPage.continueClick();
        String errorUsername = newSignUpPage.getUserNameErrorTextBlank();
        Assert.assertEquals("Username cannot be blank", errorUsername);
    }
    @Test
    public void singUpInvalidUsernameIsNotAvailable(){
        SignUpPage newSignUpPage = signUpPage.registerWithInvalidCredts("sdfsdf@df.ddf", "er1111111111rr", "user");
        SignUpPage clickContinue = signUpPage.continueClick();
        String errorUsername = newSignUpPage.getUserNameErrorIsNotAvailable();
        Assert.assertEquals("Username user is not available.", errorUsername);
    }
    @After
    public void tearDown(){
        driver.quit();
        driver = null;
        System.gc();
    }

}
