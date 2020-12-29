package com.facebookTest;

import com.facebook.HomePage;
import com.facebook.LandingPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pnt.automation.base.TestBase;

public class LandingPageValidations extends TestBase {
    LandingPage landingPage;
    HomePage homePage;

    @BeforeMethod
    public void setUpObjects() {
        landingPage = PageFactory.initElements(driver, LandingPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void validateUserBeingAbleToLogInWithValidCredentials() {
        landingPage.logInWithValidCredentials();
    }

    @Test
    public void validateUserNotBeingAbleToLogInWithValidEmailAndInvalidPassword() {
        landingPage.logInWithValidEmailAndInvalidPassword();
    }

    @Test
    public void validateUserNotBeingAbleToLogInWithInvalidEmailAndValidPassword() {
        landingPage.logInWithInvalidEmailAndValidPassword();
    }

    @Test
    public void validateUserBeingAbleToSearchForAName() {
        landingPage.logInWithValidCredentials();
        landingPage.searchForName();
    }
}