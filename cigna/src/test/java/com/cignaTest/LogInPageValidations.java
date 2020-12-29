package com.cignaTest;

import com.cigna.data.DataProviders;
import com.cigna.pages.LandingPage;
import com.cigna.pages.LogInPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pnt.automation.base.TestBase;

public class LogInPageValidations extends TestBase {
    LandingPage landingPage;
    LogInPage logInPage;

    @BeforeMethod
    public void setUpObjetcs() {
        landingPage = PageFactory.initElements(driver, LandingPage.class);
        logInPage = PageFactory.initElements(driver, LogInPage.class);

    }


    @Test
    public void validateUserBeingAbleToEnterUserName() {
        landingPage.clickOnLogInButton();
        switchToTab2();
        logInPage.enterUsername();
        switchToTab1();
    }

    @Test(dataProvider = "credentials", dataProviderClass = DataProviders.class)
    public void validateUserBeingAbleToEnterDifferentUserNamesAndPasswords(String username, String password) {
        landingPage.clickOnLogInButton();
        switchToTab2();
        logInPage.userEnterUsernameAndPassword(username, password);
        switchToTab1();
    }

    @Test(dataProvider = "Negative Test", dataProviderClass = DataProviders.class)
    public void validateUserNotBeingAbleToLogInWithInvalidCredentials(String username, String password) {
        landingPage.clickOnLogInButton();
        switchToTab2();
        logInPage.userEnterUsernameAndPassword(username, password);
        logInPage.clickOnLogInButton();
        logInPage.alertMessageValidation();
        switchToTab1();
    }

}


