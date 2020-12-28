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
    public void setUpObjects(){
        landingPage = PageFactory.initElements(driver, LandingPage.class);
        signInPage = PageFactory.initElements(driver, SignInPage.class);
    }



    @Test
    public void validateUserBeingAbleToEnterEmailAddress(){
        landingPage.clickOnSignInButtonUnderAccountsAndLists();
        signInPage.enterEmailAddress();
    }
}
