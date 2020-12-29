package com.cnn;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pnt.automation.base.TestBase;
import pnt.automation.extent.ExtentTestManager;

public class SportsPage extends TestBase {


    @FindBy(linkText = "NBA")
    private WebElement NBAButton;

    @FindBy(linkText = "New York")
    private WebElement NewYorkTeam;

    @FindBy(linkText = "Boston")
    private WebElement BostonTeam;


    public void mouseHoverNBAButton() {
        mouseHover(NBAButton);
        ExtentTestManager.log("mouse hover NBA");
        Assert.assertTrue(NewYorkTeam.isDisplayed());
        sleepFor(3);
    }

    public void selectNewYorkUnderNBA() {
        NewYorkTeam.click();
        ExtentTestManager.log("New York Team is selected");
        Assert.assertEquals(driver.getCurrentUrl(), "https://bleacherreport.com/new-york-knicks");
        sleepFor(3);
    }

    public void selectBostonTeamUnderNBA() {
        BostonTeam.click();
        ExtentTestManager.log("Boston Team is selected");
        Assert.assertEquals(driver.getCurrentUrl(), "https://bleacherreport.com/boston-celtics");
        sleepFor(3);
    }
}
