package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CopilotPage {
    WebDriver driver;

    public CopilotPage(WebDriver driver) {
        this.driver = driver;
    }
    private By getStarted = By.xpath("//span[text()='Get started for free']");
    private By seePlans = By.xpath("//span[text()='See plans & pricing']");
    private By openNow = By.xpath("(//span//a[text()='Open now'])[1]");
    private By checkTitle = By.xpath("//h1[text()=\"The AI editor for everyone\"]");
    private By checkTitleForCopilotTry = By.xpath("//h1[text()='Sign in to GitHub']");
    private By checkTitleForCopilotPlans = By.xpath("//h2[text()='Take flight with GitHub Copilot']");

    public CopilotPage copilotTry(){
        driver.findElement(getStarted).click();
        return new CopilotPage(driver);
    }
    public CopilotPage copilotPlans(){
        driver.findElement(seePlans).click();
        return new CopilotPage(driver);
    }
    public CopilotPage copilotOpenNow(){
        driver.findElement(openNow).click();
        return new CopilotPage(driver);
    }
    public CopilotPage checkCopilotTitle(){
        driver.findElement(checkTitle).click();
        return new CopilotPage(driver);
    }
}
