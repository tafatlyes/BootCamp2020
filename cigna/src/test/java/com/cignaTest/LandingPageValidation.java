package com.cignaTest;

import com.cigna.pages.LandingPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pnt.automation.base.TestBase;

public class LandingPageValidation extends TestBase {

    LandingPage landingPage;

    @BeforeMethod
    public void setUpObjetcs() {
        landingPage = PageFactory.initElements(driver, LandingPage.class);
    }


    @Test
    public void validateUserBeingAbleToClickOnLogInButton() {
        landingPage.clickOnLogInButton();
    }

    @Test
    public void userBeingAbleToClickOnFindADoctorButton() {
        landingPage.clickOnFindADoctorButton();
    }

    @Test
    public void validateUserBeingAbleToMouseHoverMedicare() {
        landingPage.mouseHoverMedicare();
    }

    @Test
    public void userBeingAbleToClickOnShopMedicareAdvantagesPlansButtons() {
        landingPage.mouseHoverMedicare();
        landingPage.clickOnShopMedicareAdvantagesPlansButtons();
    }

    @Test
    public void userBeingAbleToClickOnMedicareAdvantageEnrollmentButton() {
        landingPage.mouseHoverMedicare();
        landingPage.clickOnEnrollmentAndEligibilityButton();
        landingPage.clickOnMedicareAdvantageEnrollmentButton();
    }

    @Test
    public void userBeingAbleToSearchForInformation() {
        landingPage.searchForInformation();
    }

    @Test
    public void userBeingAbleToClickOnDentalInsuranceButton() {
        landingPage.mouseHoverIndividualAndFamiliesButton();
        landingPage.clickOnDentalInsuranceButton();
    }
}
