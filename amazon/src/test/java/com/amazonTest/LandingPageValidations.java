package com.amazonTest;

import com.amazon.pages.LandingPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pnt.automation.base.TestBase;

public class LandingPageValidations extends TestBase {
    LandingPage landingPage;

    @BeforeMethod
    public void setUpObjects(){
        landingPage = PageFactory.initElements(driver, LandingPage.class);
    }



    @Test(enabled = false)
    public void validateUserCanMouseHoverSignIn(){
        landingPage.mouseHoverActAndList();
    }

    @Test(enabled = false)
    public void validateUserBeingAbleToSearchForItems(){
        landingPage.searchForItems();
    }

    @Test(enabled = false)
    public void validateUserBeingAbleToSelectDepartmentUnderAllDepartmentsButton(){
        landingPage.searchForItems();
    }

    @Test(enabled = false)
   public void validateUserBeingAbleToClickOnSignInButtonUnderAccountsAndLists(){
        landingPage.clickOnSignInButtonUnderAccountsAndLists();
    }
}
