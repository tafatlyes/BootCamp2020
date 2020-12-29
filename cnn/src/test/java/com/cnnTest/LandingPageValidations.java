package com.cnnTest;

import com.cnn.LandingPage;
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
    public void validateUserBeingAbleToClickOnUserAccountButton() {
        landingPage.clickOnUserAccountButton();
    }

    @Test
    public void validateUserBeingAbleToClickOnLiveTvButton() {
        landingPage.clickOnLiveTv();
    }

    @Test
    public void validateUserBeingAbleToClickOnUsButtonAndLandInUsPageThenNavigateBackToMainPAGE() {
        landingPage.clickOnUSButton();
    }

    @Test
    public void validateUserBeingAbleToSearchForNews() {
        landingPage.searchForNews();
    }

    @Test
    public void validateUserBeingAbleToClickOnTravelsButton() {
        landingPage.clickOntravelsButton();
    }

    @Test
    public void validateUserBeingAbleToClickOnVideosButton() {
        landingPage.clickOnvideosButton();
    }

    @Test
    public void validateUserBeingAbleToClickOnSportsButton() {
        landingPage.clickOnsportsButton();
    }


}
