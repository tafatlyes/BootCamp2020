package com.amazonTest;

import com.amazon.pages.LandingPage;
import com.amazon.pages.SignInPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pnt.automation.base.TestBase;

public class SignInPageValidations extends TestBase {

    LandingPage landingPage;
    SignInPage signInPage;

    @BeforeMethod
    public void setUpObjects() {
        landingPage = PageFactory.initElements(driver, LandingPage.class);
        signInPage = PageFactory.initElements(driver, SignInPage.class);
    }


    @Test
    public void validateUserBeingAbleToEnterEmailAddress() {
        landingPage.clickOnSignInButtonUnderAccountsAndLists();
        signInPage.enterEmailAddress();
    }


    @Test
    public void validateUserBeingAbleToEnterPassword() {
        landingPage.clickOnSignInButtonUnderAccountsAndLists();
        signInPage.enterEmailAddress();
        signInPage.enterPassword();
    }

    @Test
    public void validateUserNotBeingAbleToSignInWithInvalidCredentials() {
        landingPage.clickOnSignInButtonUnderAccountsAndLists();
        signInPage.enterEmailAddress();
        signInPage.enterPassword();
        signInPage.clickOnSignInButtonInSignInPage();
        captureScreenshot(driver, "validateUserNotBeingAbleToSignInWithInvalidCredentials.png");
    }

    @Test
    public void validateUserBeingAbleToClickOnCreateAnAccount() {
        landingPage.clickOnSignInButtonUnderAccountsAndLists();
        signInPage.clickOnCreateAnAccount();
        captureScreenshot(driver, " validateUserBeingAbleToClickOnCreateAnAccount.png");
    }

}
