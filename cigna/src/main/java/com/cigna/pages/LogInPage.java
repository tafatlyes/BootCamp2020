package com.cigna.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pnt.automation.base.TestBase;
import pnt.automation.extent.ExtentTestManager;

public class LogInPage extends TestBase {


    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameTab;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordTab;

    @FindBy(xpath = "//input[@id='loginbutton']")
    private WebElement logInButton;

    @FindBy(xpath = "//div[@id='alertmessage']")
    private WebElement alertMessage;


    public void enterUsername() {
        usernameTab.sendKeys("Lyes");
        ExtentTestManager.log("username is entered!!!");
        sleepFor(3);
    }

    public void enterUserNameInLoginPage() {

    }

    public void userEnterUsernameAndPassword(String username, String password) {
        usernameTab.sendKeys(username);
        ExtentTestManager.log("username entered !!!");
        passwordTab.sendKeys(password);
        ExtentTestManager.log("password entered !!!");
        sleepFor(3);
    }

    public void clickOnLogInButton() {
        logInButton.click();
        ExtentTestManager.log("lOg iN Button Clicked !!!");
    }

    public void alertMessageValidation() {
        Assert.assertTrue(alertMessage.isDisplayed());
        ExtentTestManager.log("The username and password combination you entered does not match our records.!!!");
    }
}
