package com.amazonTest;

import com.amazon.data.DataProviders;
import com.amazon.pages.LandingPage;
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
    public void validateUserCanMouseHoverSignIn() {
        landingPage.mouseHoverActAndList();
    }

    @Test
    public void validateUserBeingAbleToSearchForItems() {
        landingPage.searchForItems();
    }

    @Test
    public void validateUserBeingAbleToSelectDepartmentUnderAllDepartmentsButton() {
        landingPage.searchForItems();
    }

    @Test
    public void validateUserBeingAbleToClickOnSignInButtonUnderAccountsAndLists() {
        landingPage.clickOnSignInButtonUnderAccountsAndLists();
    }

    @Test
    public void validateUserBeingAbleToClickOnSellProductsOnAmazonButtonOnFooterOfLandingPage() {
        landingPage.clickOnSellProductsOnAmazonButtonOnFooterOfLandingPage();
        captureScreenshot(driver, "validateUserBeingAbleToClickOnSellProductsOnAmazonButtonOnFooterOfLandingPage.png");
    }

    @Test(dataProvider = "TestData", dataProviderClass = DataProviders.class)
    public void validateUserBeingAbleTopProvideMultipleDataInSearchBar(String text) {
        landingPage.provideMultipleData(text);
    }

}
