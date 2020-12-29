package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pnt.automation.base.TestBase;
import pnt.automation.extent.ExtentTestManager;

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

    @FindBy(linkText = "Sell products on Amazon")
    private WebElement sellProductsOnAmazonButton;

    @FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
    private WebElement pokelingDogToy;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@data-feature-id='proceed-to-checkout-label']")
    private WebElement proceedToCheckOutButton;


    public void mouseHoverActAndList() {
        mouseHover(accountAndList);
        Assert.assertTrue(signInButton.isDisplayed());
    }

    public void searchForItems() {
        searchBar.sendKeys("dog toys");
        searchButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.amazon.com/s?k=dog+toys"));
    }


    public void selectDepartmentUnderAllDepartmentsButton() {
        selectInList(allButton).selectByVisibleText("Baby");
        ExtentTestManager.log("Baby option is selected !!!");
        Assert.assertTrue(allButton.getText().contains("Baby"));
    }

    public void clickOnSignInButtonUnderAccountsAndLists() {
        mouseHover(accountAndList);
        ExtentTestManager.log("mouse is hover account and list button !!!");
        Assert.assertTrue(signInButton.isDisplayed());
        ExtentTestManager.log("sign in button is displayed !!!");
        signInButton.click();
        Assert.assertTrue(emailTab.isDisplayed());
        ExtentTestManager.log("email tab is displayed !!!");
    }

    public void clickOnSellProductsOnAmazonButtonOnFooterOfLandingPage() {
        scroll(sellProductsOnAmazonButton);
        sleepFor(3);
        sellProductsOnAmazonButton.click();
        ExtentTestManager.log("sell products on amazon button is clicked !!!");
        Assert.assertEquals(driver.getCurrentUrl(), "https://sell.amazon.com/?ld=AZFSSOA&ref_=footer_soa");
        ExtentTestManager.log("sell page is displayed !!!");
    }


    public void provideMultipleData(String text) {
        searchBar.sendKeys(text);
        sleepFor(2);
    }

}
