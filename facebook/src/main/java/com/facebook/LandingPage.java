package com.facebook;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pnt.automation.base.TestBase;
import pnt.automation.extent.ExtentTestManager;

public class LandingPage extends TestBase {

    @FindBy(id = "email")
    private WebElement emailTab;

    @FindBy(id = "pass")
    private WebElement passwordTab;

    @FindBy(id = "u_0_b")
    private WebElement logInButton;

    @FindBy(xpath = "//div[text()='The password you’ve entered is incorrect. ']")
    private WebElement incorrectPasswordError;

    @FindBy(xpath = "//input[@placeholder='Search Facebook']")
    private WebElement searchTab;


    public void logInWithValidCredentials() {
        emailTab.sendKeys("lyoutchamokachi@gmail.com");
        ExtentTestManager.log("email entered");
        passwordTab.sendKeys("ABCD123456");
        ExtentTestManager.log("password entered");
        logInButton.click();
        sleepFor(2);
        ExtentTestManager.log("log in button clicked");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/?sk=welcome");
    }

    public void logInWithValidEmailAndInvalidPassword() {
        emailTab.sendKeys("lyoutchamok@gmail.com");
        ExtentTestManager.log("email entered");
        passwordTab.sendKeys("ABCD");
        ExtentTestManager.log("password entered");
        logInButton.click();
        sleepFor(10);
        ExtentTestManager.log("log in button clicked");
        Assert.assertTrue(incorrectPasswordError.isDisplayed());
    }


    public void logInWithInvalidEmailAndValidPassword() {
        emailTab.sendKeys("lyou@gmail.com");
        ExtentTestManager.log("email entered");
        passwordTab.sendKeys("ABCD123456");
        ExtentTestManager.log("password entered");
        logInButton.click();
        sleepFor(10);
        ExtentTestManager.log("log in button clicked");
        Assert.assertTrue(incorrectPasswordError.isDisplayed());
    }

    public void searchForName() {
        searchTab.sendKeys("lyes");
        ExtentTestManager.log("name entered");
        sleepFor(3);
        searchTab.sendKeys(Keys.ENTER);
        ExtentTestManager.log("search button clicked");
        sleepFor(15);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/search/top?q=lyes");
    }


}
