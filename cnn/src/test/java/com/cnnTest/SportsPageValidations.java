package com.cnnTest;

import com.cnn.LandingPage;
import com.cnn.LogInPage;
import com.cnn.SportsPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pnt.automation.base.TestBase;

public class SportsPageValidations extends TestBase {
    LandingPage landingPage;
    LogInPage logInPage;
    SportsPage sportsPage;

    @BeforeMethod
    public void setUpObjects() {
        landingPage = PageFactory.initElements(driver, LandingPage.class);
        logInPage = PageFactory.initElements(driver, LogInPage.class);
        sportsPage = PageFactory.initElements(driver, SportsPage.class);
    }


    @Test
    public void validateUserBeingAbleToMouseHoverNBAButton() {
        landingPage.clickOnsportsButton();
        sportsPage.mouseHoverNBAButton();
    }

    @Test
    public void validateUserBeingAbleToSelectNewYorkUnderNBA() {
        landingPage.clickOnsportsButton();
        sportsPage.mouseHoverNBAButton();
        sportsPage.selectNewYorkUnderNBA();
    }

    @Test
    public void validateUserBeingAbleToSelectBostonTeamUnderNBA() {
        landingPage.clickOnsportsButton();
        sportsPage.mouseHoverNBAButton();
        sportsPage.selectBostonTeamUnderNBA();
    }
}
