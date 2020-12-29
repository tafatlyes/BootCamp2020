package com.cnnTest;

import com.cnn.LandingPage;
import com.cnn.LogInPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pnt.automation.base.TestBase;

public class LogInPageValidations extends TestBase {
    LandingPage landingPage;
    LogInPage logInPage;

    @BeforeMethod
    public void setUpObjects() {
        landingPage = PageFactory.initElements(driver, LandingPage.class);
        logInPage = PageFactory.initElements(driver, LogInPage.class);
    }


    @Test
    public void validateUserNotBeingAbleToLogInWithInvalidCredentials() {
        landingPage.clickOnUserAccountButton();
        logInPage.logInWithInvalidCredentials();
    }


}
