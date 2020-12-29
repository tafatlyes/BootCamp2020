package com.cnn;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pnt.automation.base.TestBase;
import pnt.automation.extent.ExtentTestManager;

public class LogInPage extends TestBase {


    @FindBy(xpath = "//input[@aria-label='Email address']")
    private WebElement emailTab;

    @FindBy(xpath = "//input[@aria-label='Password']")
    private WebElement passwordTab;

    @FindBy(xpath = "//button[@id='login-form-button']")
    private WebElement logInButton;

    @FindBy(xpath = "//div[text()='You have entered an invalid username or password.']")
    private WebElement errorMessage;


    public void logInWithInvalidCredentials() {
        emailTab.sendKeys("Lyoutcha@gmail.com");
        ExtentTestManager.log("email provided !!!");
        passwordTab.sendKeys("123456");
        ExtentTestManager.log("password entered !!!");
        logInButton.click();
        Assert.assertTrue(errorMessage.isDisplayed());
        sleepFor(3);
    }
}
