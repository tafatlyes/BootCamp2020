package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pnt.automation.base.TestBase;
import pnt.automation.extent.ExtentTestManager;

public class SignInPage extends TestBase {

    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement emailTab;


    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement passwordTab;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@id='auth-warning-message-box']")
    private WebElement errorMessage;

    @FindBy(xpath = "//a[@id='createAccountSubmit']")
    private WebElement createAccount;

    @FindBy(xpath = "//input[@id='ap_customer_name']")
    private WebElement nameTab;


    public void enterEmailAddress() {
        emailTab.sendKeys("Lyes@gmail.com");
        ExtentTestManager.log("email is provided !!!");
        continueButton.click();
        ExtentTestManager.log("continue button clicked !!!");
        Assert.assertTrue(passwordTab.isDisplayed());
        ExtentTestManager.log("password tab is displayed !!!");
    }

    public void enterPassword() {
        sleepFor(3);
        passwordTab.sendKeys("Lyoutcha");
        ExtentTestManager.log("password is provided !!!");
    }

    public void clickOnSignInButtonInSignInPage() {
        signInButton.click();
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    public void clickOnCreateAnAccount() {
        sleepFor(3);
        createAccount.click();
        ExtentTestManager.log("create Account is clicked!!!");
        Assert.assertTrue(nameTab.isDisplayed());
        ExtentTestManager.log("name tab is displayed!!!");
    }
}
