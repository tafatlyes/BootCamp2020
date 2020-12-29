package com.cnn;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pnt.automation.base.TestBase;
import pnt.automation.extent.ExtentTestManager;


public class LandingPage extends TestBase {

    @FindBy(xpath = "(//*[@id = 'account-icon-button'])[1]")
    private WebElement userAccountButton;

    @FindBy(linkText = "LIVE TV")
    private WebElement liveTvButton;

    @FindBy(xpath = "(//a[@name='us'])[1]")
    private WebElement usButton;

    @FindBy(xpath = "//*[@aria-labelledby='searchIconTitle']")
    private WebElement searchButton;

    @FindBy(xpath = "(//input[@name='q'])[1]")
    private WebElement searchTab;

    @FindBy(xpath = "(//div[text()='Search'])[1]")
    private WebElement secondSearchButton;

    @FindBy(linkText = "Sports")
    private WebElement sportsButton;

    @FindBy(linkText = "Videos")
    private WebElement videosButton;

    @FindBy(linkText = "Travel")
    private WebElement travelsButton;


    public void clickOnUserAccountButton() {
        userAccountButton.click();
        sleepFor(3);
        ExtentTestManager.log("User Account Button is clicked");
    }


    public void clickOnLiveTv() {
        liveTvButton.click();
        ExtentTestManager.log("live tv button clicked");
        sleepFor(3);
    }


    public void clickOnUSButton() {
        usButton.click();
        ExtentTestManager.log("Us button clicked and Us page is displayed");
        sleepFor(15);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.cnn.com/us");
        navigateBack();
        sleepFor(15);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.cnn.com/");
        ExtentTestManager.log("main page is displayed");
        sleepFor(3);
    }

    public void searchForNews() {
        searchButton.click();
        ExtentTestManager.log("first search button clicked");
        searchTab.sendKeys("Corona Virus");
        ExtentTestManager.log("text entered");
        secondSearchButton.click();
        ExtentTestManager.log("second search button clicked");
        sleepFor(3);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.cnn.com/search?q=Corona+Virus");
    }

    public void clickOntravelsButton() {
        travelsButton.click();
        ExtentTestManager.log(" button clicked");
        sleepFor(3);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.cnn.com/travel");
    }

    public void clickOnvideosButton() {
        videosButton.click();
        ExtentTestManager.log(" button clicked");
        sleepFor(3);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.cnn.com/videos");
    }

    public void clickOnsportsButton() {
        sportsButton.click();
        ExtentTestManager.log(" button clicked");
        sleepFor(3);
        Assert.assertEquals(driver.getCurrentUrl(), "https://bleacherreport.com/");
    }


}
