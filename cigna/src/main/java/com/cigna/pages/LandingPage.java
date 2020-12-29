package com.cigna.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pnt.automation.base.TestBase;
import pnt.automation.extent.ExtentTestManager;

public class LandingPage extends TestBase {

    @FindBy(xpath = "(//a[text()='Log in to myCigna'])[1]")
    private WebElement logInButton;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameTab;

    @FindBy(linkText = "Find a Doctor, Dentist or Facility")
    private WebElement findADoctorButton;

    @FindBy(xpath = "//a[@id='medicare-level-one-link']")
    private WebElement medicareButton;

    @FindBy(xpath = "//button[@id='medicare-coverage-tab']")
    private WebElement medicareCoverageOptions;

    @FindBy(linkText = "Shop Medicare Advantage Plans")
    private WebElement shopMedicarePlansButton;

    @FindBy(xpath = "//button[@id='enrollment-and-eligibility-tab']")
    private WebElement enrollmentAndEligibilityButton;

    @FindBy(linkText = "Medicare Advantage Enrollment and Eligibility")
    private WebElement medicareAdvantageEnrollmentButton;

    @FindBy(xpath = "//input[@id='search-desktop']")
    private WebElement searchTab;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    private WebElement searchButton;

    @FindBy(linkText = "Dental Insurance")
    private WebElement dentalInsuranceButton;

    @FindBy(xpath = "//a[@id='individuals-families-level-one-link']")
    private WebElement individualAndFamiliesButton;


    public void clickOnLogInButton() {
        logInButton.click();
        ExtentTestManager.log("log in button is clicked !!!");
    }

    public void clickOnFindADoctorButton() {
        findADoctorButton.click();
        ExtentTestManager.log("Find a Doctor, Dentist or Facility Button Clicked !!!");
        sleepFor(2);
        Assert.assertEquals(driver.getCurrentUrl(), "https://hcpdirectory.cigna.com/web/public/consumer/directory");
        ExtentTestManager.log("Find A Doctor page is displayed !!!");
    }

    public void mouseHoverMedicare() {
        mouseHover(medicareButton);
        ExtentTestManager.log("mouse Hover Medicare button!!!");
        Assert.assertTrue(medicareCoverageOptions.isDisplayed());
        ExtentTestManager.log("medicare Coverage Options button is displayed !!!");
    }

    public void clickOnShopMedicareAdvantagesPlansButtons() {
        shopMedicarePlansButton.click();
        ExtentTestManager.log("Shop Medicare Advantage Plans buttons is clicked !!!");
        sleepFor(2);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.cigna.com/medicare/medicare-advantage/");
    }

    public void clickOnEnrollmentAndEligibilityButton() {
        enrollmentAndEligibilityButton.click();
        ExtentTestManager.log(" enrollment And Eligibility Button is clicked !!!");
        sleepFor(2);
        Assert.assertTrue(medicareAdvantageEnrollmentButton.isDisplayed());
        ExtentTestManager.log("Medicare Advantage Enrollment button is displayed !!!");
    }

    public void clickOnMedicareAdvantageEnrollmentButton() {
        medicareAdvantageEnrollmentButton.click();
        ExtentTestManager.log("Medicare Advantage Enrollment button is clicked !!!");
        sleepFor(2);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.cigna.com/medicare/enrollment-and-eligibility/medicare-advantage");
        ExtentTestManager.log("Medicare Advantage Enrollment Eligibility is Displayed !!!");
    }

    public void searchForInformation() {
        searchTab.sendKeys("insurance");
        ExtentTestManager.log("text is entered !!!");
        sleepFor(3);
        searchButton.click();
        ExtentTestManager.log("search button is clicked !!!");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.cigna.com/search?query=insurance");
    }

    public void clickOnDentalInsuranceButton() {
        dentalInsuranceButton.click();
        ExtentTestManager.log("dental insurance button is clicked !!!");
        sleepFor(2);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.cigna.com/individuals-families/plans-services/dental-insurance-plans/");

    }

    public void mouseHoverIndividualAndFamiliesButton() {
        mouseHover(individualAndFamiliesButton);
        ExtentTestManager.log("mouse hover individual And Families !!!");
    }

}
