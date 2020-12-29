package com.citiBank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pnt.automation.base.TestBase;
import pnt.automation.extent.ExtentTestManager;

public class LandingPage extends TestBase {


    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameTab;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordTab;

    @FindBy(xpath = "//input[@id='signInBtn']")
    private WebElement signOnButton;

    @FindBy(xpath = "(//span[@id='signOnLoginError'])[1]")
    private WebElement signOnLoginError;

    @FindBy(xpath = "//a[@id='banking']")
    private WebElement bankingButton;

    @FindBy(xpath = "//a[@id='checkingBanking_Link']")
    private WebElement checkingButton;

    @FindBy(xpath = "(//div[@class='submenuRD'])[2]")
    private WebElement bankingOptions;

    @FindBy(xpath = "(//button[text()='Cancel'])[7]")
    private WebElement cancelButton;


    @FindBy(id = "savingsBanking_Link")
    private WebElement savingButton;


    @FindBy(id = "bankingOverview_Link")
    private WebElement bankingOverviewButton;


    @FindBy(id = "RequestUserIDReminder")
    private WebElement forgetUserIDButton;

    @FindBy(id = "RequestUserIDReminder-mobile")
    private WebElement forgetPasswordButton;

    @FindBy(id = "activate_card")
    private WebElement activateCardButton;

    @FindBy(id = "register_acc")
    private WebElement registerForOnlineAccessButton;

    @FindBy(id = "cdiraBanking_Link")
    private WebElement CODButton;


    public void enterUsernameAndPassword() {
        sleepFor(3);
        Assert.assertTrue(usernameTab.isDisplayed());
        ExtentTestManager.log("usernameTab is displayed!!!");
        usernameTab.sendKeys("Lyes");
        ExtentTestManager.log("username entered!!!");
        Assert.assertTrue(passwordTab.isDisplayed());
        ExtentTestManager.log("passwordTab is displayed!!!");
        passwordTab.sendKeys("123456");
        ExtentTestManager.log("password entered !!!");
        sleepFor(3);
    }

    public void clickOnSignInButton() {
        signOnButton.click();
    }

    public void clickOnSignInWhenHavingInvalidData() {
        signOnButton.click();
        ExtentTestManager.log("sign in button is clicked!!!");
        Assert.assertTrue(signOnLoginError.isDisplayed());
        ExtentTestManager.log("sign On Login Error is displayed!!!");
    }

    public void mouseHoverBankingButton() {
        mouseHover(bankingButton);
        Assert.assertTrue(checkingButton.isDisplayed());
        ExtentTestManager.log("mouse Hover Banking Button!!!");
    }

    public void clickOnCheckingAccount() { //in progress
        mouseHover(bankingButton);
        Assert.assertTrue(checkingButton.isDisplayed());
        ExtentTestManager.log("mouse Hover Banking Button!!!");
        checkingButton.click();
        Assert.assertTrue(cancelButton.isDisplayed());
        ExtentTestManager.log("checking page is displayed!!!");
    }


    public void clickOnsavingButton() {
        mouseHover(bankingButton);
        Assert.assertTrue(checkingButton.isDisplayed());
        ExtentTestManager.log("mouse Hover Banking Button!!!");
        savingButton.click();
        Assert.assertTrue(cancelButton.isDisplayed());
        ExtentTestManager.log("checking page is displayed!!!");
    }

    public void clickOnBankingOverviewButton() {
        mouseHover(bankingButton);
        Assert.assertTrue(checkingButton.isDisplayed());
        ExtentTestManager.log("mouse Hover Banking Button!!!");
        bankingOverviewButton.click();
        Assert.assertTrue(cancelButton.isDisplayed());
        ExtentTestManager.log("checking page is displayed!!!");
    }

    public void clickOnCODButtonButton() {
        mouseHover(bankingButton);
        Assert.assertTrue(checkingButton.isDisplayed());
        ExtentTestManager.log("mouse Hover Banking Button!!!");
        CODButton.click();
        Assert.assertTrue(cancelButton.isDisplayed());
        ExtentTestManager.log("checking page is displayed!!!");
    }


    public void clickOnForgetUserIDButton() {
        forgetUserIDButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://online.citi.com/US/ag/forgot-userid-pwd/account-type?fuipFlowInd=userID&&JFP"));
    }

    public void clickOnForgetPasswordButton() {
        forgetPasswordButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://online.citi.com/US/ag/forgot-userid-pwd/account-type?fuipFlowInd=pwd&&JFP"));
    }

    public void clickOnActivateCardButton() {
        activateCardButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://online.citi.com/US/ag/activate/index");
    }

    public void clickOnRegisterForOnlineAccessButton() {
        registerForOnlineAccessButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://online.citi.com/US/ag/bank/registration/set-up-online-access");
    }


//    public void clickOnAllBankingOptionsAndGetTitleOfAWebPage() {
//        List<WebElement> elements = bankingOptions.findElements(By.tagName("a"));
//
//        for (int i = 0; i < elements.size(); i++) {
//            sleepFor(3);
//            System.out.println(elements.size());
//            mouseHover(bankingButton);
//            sleepFor(3);
//            elements.get(i).click();
//            sleepFor(3);
//            System.out.println("The page title is " + driver.getTitle());
//            navigateBack();
//        }
//    }
}


