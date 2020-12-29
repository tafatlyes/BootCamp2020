package com.facebookTest;

import com.facebook.HomePage;
import com.facebook.LandingPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pnt.automation.base.TestBase;

public class HomePageValidations extends TestBase {
    LandingPage landingPage;
    HomePage homePage;

    @BeforeMethod
    public void setUpObjects() {
        landingPage = PageFactory.initElements(driver, LandingPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
    }


    @Test
    public void validateUserBeingAbleToAddAFriend() {
        landingPage.logInWithValidCredentials();
        homePage.addAFriend();
    }

    @Test
    public void validateUserBeingAbleToAddBioToProfile() {
        landingPage.logInWithValidCredentials();
        homePage.addBioToProfile();
    }


    @Test(enabled = false)
    public void validateUserBeingAbleToAddAPost() {
        landingPage.logInWithValidCredentials();
        homePage.writeAPost();
    }

    @Test
    public void validateUserBeingAbleToClickOnMarketPlaceButton() {
        landingPage.logInWithValidCredentials();
        homePage.clickOnMarketPlaceButton();
    }

    @Test
    public void validateUserBeingAbleToClickOnSavedButton() {
        landingPage.logInWithValidCredentials();
        homePage.clickOnSavedButton();
    }

    @Test
    public void validateUserBeingAbleToClickOnFriendRequestButton() {
        landingPage.logInWithValidCredentials();
        homePage.clickOnFriendRequestButton();
    }
}
