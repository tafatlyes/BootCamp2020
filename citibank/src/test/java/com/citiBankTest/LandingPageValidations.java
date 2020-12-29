package com.citiBankTest;

import com.citiBank.LandingPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pnt.automation.base.TestBase;

public class LandingPageValidations extends TestBase {
    LandingPage landingPage;

    @BeforeMethod
    public void setUpObjects() {
        landingPage = PageFactory.initElements(driver, LandingPage.class);
    }


    @Test
    public void validateUserBeingAbleToEnterUsernameAndPassword() {
        landingPage.enterUsernameAndPassword();
    }

    @Test
    public void validateUserNotBeingAbleToLogInWithInvalidCredentials() {
        landingPage.enterUsernameAndPassword();
        landingPage.clickOnSignInWhenHavingInvalidData();
    }

    @Test
    public void validateUserBeingAbleToMouseHoverBankingButton() {
        landingPage.mouseHoverBankingButton();
    }

//    @Test
//    public void userBeingAbleToClickOnAllBankingOptionsAndGetTitleOfAWebPage(){
//        landingPage.clickOnAllBankingOptionsAndGetTitleOfAWebPage();
//    }

    @Test
    public void validateuserBeingAbleToClickOnCheckingAccount() {
        landingPage.clickOnCheckingAccount();
    }

    @Test
    public void validateUserBeingAbleToClickOnSavingButton() {
        landingPage.clickOnsavingButton();
    }


    @Test
    public void validateUserBeingAbleToClickOnBankingOverviewButton() {
        landingPage.clickOnBankingOverviewButton();
    }


    @Test
    public void validateUserBeingAbleToClickOnCODButtonButton() {
        landingPage.clickOnCODButtonButton();
    }


    @Test
    public void validateUserBeingAbleToClickOnForgetUserIDButton() {
        landingPage.clickOnForgetUserIDButton();
    }

    @Test
    public void validateUserBeingAbleToClickOnForgetPasswordButton() {
        landingPage.clickOnForgetPasswordButton();
    }

    @Test
    public void validateUserBeingAbleToClickOnActivateCardButton() {
        landingPage.clickOnActivateCardButton();
    }

    @Test
    public void validateUserBeingAbleToClickOnRegisterForOnlineAccessButton() {
        landingPage.clickOnRegisterForOnlineAccessButton();
    }
}
