package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pnt.automation.base.TestBase;

public class SignInPage extends TestBase {

    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement emailTab;


    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement passwordTab;

//    @FindBy(xpath = "")
//    private WebElement ;
//
//    @FindBy(xpath = "")
//    private WebElement ;


    public void enterEmailAddress(){
        emailTab.sendKeys("Lyes@gmail.com");
        continueButton.click();
        Assert.assertTrue(passwordTab.isDisplayed());
    }
}
