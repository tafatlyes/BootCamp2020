package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pnt.automation.base.TestBase;

public class LandingPage extends TestBase {


    @FindBy(xpath = "(//span[@class='nav-line-1'])[3]")
    private WebElement accountAndList;

    @FindBy(xpath = "(//span[@class='nav-action-inner'])[1]")
    private WebElement signInButton;

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchBar;

    @FindBy(xpath = "//span[@id='nav-search-submit-text']")
    private WebElement searchButton;

    @FindBy(xpath = "//Select[@id='searchDropdownBox']")
    private WebElement allButton;

    @FindBy(xpath = "//input[@id='ap_email']")
    private WebElement emailTab;

//    @FindBy(xpath = "")
//    private WebElement ;
//
//    @FindBy(xpath = "")
//    private WebElement ;
//
//    @FindBy(xpath = "")
//    private WebElement ;
//
//    @FindBy(xpath = "")
//    private WebElement ;
//
//    @FindBy(xpath = "")
//    private WebElement ;
//
//    @FindBy(xpath = "")
//    private WebElement ;
//
//    @FindBy(xpath = "")
//    private WebElement ;
//
//    @FindBy(xpath = "")
//    private WebElement ;


    public void mouseHoverActAndList(){
        mouseHover(accountAndList);
        Assert.assertTrue(signInButton.isDisplayed());
    }

    public void searchForItems(){
        searchBar.sendKeys("dog toys");
        searchButton.click();
       Assert.assertTrue(driver.getCurrentUrl().contains("https://www.amazon.com/s?k=dog+toys"));
//        Assert.assertEquals(driver.getCurrentUrl(),"https://www.amazon.com/s?k=dog+toys&ref=nb_sb_noss");
    }


    public void selectDepartmentUnderAllDepartmentsButton(){
        selectInList(allButton).selectByVisibleText("Baby");
        Assert.assertTrue(allButton.getText().contains("Baby"));
    }

    public void clickOnSignInButtonUnderAccountsAndLists(){
        mouseHover(accountAndList);
        Assert.assertTrue(signInButton.isDisplayed());
        signInButton.click();
        Assert.assertTrue(emailTab.isDisplayed());
    }

}
