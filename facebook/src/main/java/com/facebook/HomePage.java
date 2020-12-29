package com.facebook;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pnt.automation.base.TestBase;
import pnt.automation.extent.ExtentTestManager;

public class HomePage extends TestBase {


    @FindBy(css = "[class*='o6r2urh6 buofh1pr datstx6m l9j0dhe7 oh7imozk']")
    public WebElement postSpaceToWrite;
    @FindBy(xpath = "//input[@placeholder='Search Facebook']")
    private WebElement searchTab;
    @FindBy(xpath = "(//div[@aria-label='Add friend'])[2]")
    private WebElement addFriendButton;
    @FindBy(xpath = "//a[@href='https://www.facebook.com/lyou.mokachi/']")
    private WebElement goToProfielButton;
    @FindBy(xpath = "//div[text()='Add Bio']")
    private WebElement addBioButton;
    @FindBy(xpath = "//textarea[@aria-label='Enter bio text']")
    private WebElement bioTextArea;
    @FindBy(xpath = "//div[@aria-label='Save']")
    private WebElement saveButton;
    @FindBy(xpath = "//span[text()='Share Now']")
    private WebElement shareNowButton;
    @FindBy(xpath = "//div[@aria-label='Update Profile Picture']")
    private WebElement uploadPictureButton;
    @FindBy(xpath = "//span[text()='Upload Photo']")
    private WebElement secondUploadPictureButton;
    @FindBy(css = "[class*='oajrlxb2 b3i9ofy5 qu0x051f esr5mh6w e9989ue4 r7d6kgcz rq0escxv nhd2j8a9']")
    private WebElement sharePostTab;
    @FindBy(xpath = "//div[@aria-label='Post']")
    private WebElement postButton;
    @FindBy(xpath = "//span[text()='Marketplace']")
    private WebElement marketPlaceButton;

    @FindBy(xpath = "(//span[@class='a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7'])[10]")
    private WebElement savedButton;

    @FindBy(xpath = "(//a[@href='/friends/'])[1]")
    private WebElement friendRequestButton;


    public void addAFriend() {
        searchTab.sendKeys("Lyes Tafat");
        ExtentTestManager.log("name entered");
        sleepFor(3);
        searchTab.sendKeys(Keys.ENTER);
        ExtentTestManager.log("search button clicked");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/search/top?q=Lyes%20Tafat");
        sleepFor(15);
        addFriendButton.click();
        sleepFor(10);
    }

    public void addBioToProfile() {
        goToProfielButton.click();
        ExtentTestManager.log("profile displayed");
        addBioButton.click();
        ExtentTestManager.log("add bio button clicked");
        bioTextArea.sendKeys("I'm The Ghost");
        ExtentTestManager.log("bio entered");
        saveButton.click();
        ExtentTestManager.log("bio saved");
        shareNowButton.click();
        ExtentTestManager.log("bio shared");
        sleepFor(3);
    }


    public void writeAPost() {
        goToProfielButton.click();
        ExtentTestManager.log("profile displayed");
        sleepFor(5);
        sharePostTab.click();
        ExtentTestManager.log("share post tab is clicked");
        sleepFor(5);
        postSpaceToWrite.sendKeys("Life is beautiful");
        sleepFor(3);
        ExtentTestManager.log("text entered");
        postButton.click();
        ExtentTestManager.log("post shared");
        sleepFor(5);
    }

    public void clickOnMarketPlaceButton() {
        marketPlaceButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/marketplace/?ref=bookmark");
    }


    public void clickOnSavedButton() {
        savedButton.click();
        sleepFor(3);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/pages/?category=top&ref=bookmarks");
    }

    public void clickOnFriendRequestButton() {
        friendRequestButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/friends");
    }

}
