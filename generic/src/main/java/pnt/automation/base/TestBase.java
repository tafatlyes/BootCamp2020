package pnt.automation.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pnt.automation.extent.ExtentManager;
import pnt.automation.extent.ExtentTestManager;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static ExtentReports extent;
    public static WebDriver driver;
    public static String sauceUserName = "tafatlyes";
    public static String sauceKey = "81b590a4-d403-43f3-a79d-84fe1d009331";
    public static String browserStackUserName = "lyestafat1";
    public static String browserStackKey = "TyEqYWktieVZxMmfbp54";
    //http:// + username + : + key + specific url for cloud
    public static String SAUCE_URL = "http://" + sauceUserName + ":" + sauceKey + "@ondemand.saucelabs.com:80/wd/hub";
    public static String BROWSERSTACK_URL = "https://" + browserStackUserName + ":" + browserStackKey + "@hub-cloud.browserstack.com/wd/hub";
    private static Logger LOGGER = Logger.getLogger(TestBase.class);

    /**
     * @param platform       -
     * @param url            -
     * @param browser        -
     * @param cloud          -
     * @param browserVersion -
     * @param envName        -
     * @return
     * @throws MalformedURLException
     * @Parameters - values are coming from the runner.xml file of the project modules
     */

    @Parameters({"platform", "url", "browser", "cloud", "browserVersion", "envName"})

    @BeforeMethod
    public static WebDriver setupDriver(String platform, String url, String browser,
                                        boolean cloud, String browserVersion, String envName) throws MalformedURLException {
        if (cloud) {
            driver = getCloudDriver(browser, browserVersion, platform, envName);
        } else {
            driver = getLocalDriver(browser, platform);
        }
        driver.get(url);
        return driver;
    }

    /**
     * @param browser  the browser you want to execute your test case
     * @param platform in the operating system you want to execute your test case
     * @return WebDriver Object
     */
    public static WebDriver getLocalDriver(String browser, String platform) {
        if (platform.equalsIgnoreCase("mac") && browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "../generic/src/main/resources/chromedriver");
            driver = new ChromeDriver();
        } else if (platform.equalsIgnoreCase("windows") && browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "../generic/src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (platform.equalsIgnoreCase("mac") && browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "../generic/src/main/resources/geckodriver");
            driver = new FirefoxDriver();
        } else if (platform.equalsIgnoreCase("windows") && browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "../generic/src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getCloudDriver(String browser, String browserVersion, String platform,
                                           String envName) throws MalformedURLException {

        //for interview question about how tu set up cloud: until line 110*********************
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("os_version", "Catalina");
        desiredCapabilities.setCapability("resolution", "1920x1080");
        desiredCapabilities.setCapability("browser", browser);
        desiredCapabilities.setCapability("browser_version", browserVersion);
        desiredCapabilities.setCapability("os", platform);
        desiredCapabilities.setCapability("name", "Sample Test");
        if (envName.equalsIgnoreCase("saucelabs")) {
            //driver = new RemoteWebDriver(new URL(SAUCE_URL), desiredCapabilities);
            driver = new RemoteWebDriver(new URL(SAUCE_URL), desiredCapabilities);

        } else if (envName.equalsIgnoreCase("browserstack")) {
            driver = new RemoteWebDriver(new URL(BROWSERSTACK_URL), desiredCapabilities);
        }

        return driver;
    }

    public static void navigateToURL(String url) {
        driver.get(url);
        LOGGER.info("navigated to the url : " + url);
    }

    public static void sleepFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void closeDriver() {
        driver.quit();
        LOGGER.info("closed the instance of the driver");
    }


    public static void navigateBack() {
        driver.navigate().back();
    }

    public static void clickOnElement(String element) {
        driver.findElement(By.xpath(element)).click();
    }


    //screenshot
    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        DateFormat df = new SimpleDateFormat("HH_mm_ss");
        Date date = new Date();
        df.format(date);
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/screenshots/" + screenshotName + " " + df.format(date) + ".png"));
            System.out.println("Screenshot captured");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
    }

    //reporting starts
    @BeforeSuite
    public void extentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().assignCategory(className);
    }

    protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }

    @AfterMethod
    public void afterEachTestMethod(ITestResult result) {
        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));
        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
        } else if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, getStackTrace(result.getThrowable()));
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
        }

        ExtentTestManager.endTest();
        extent.flush();
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(driver, result.getName());
        }
    }

    public Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }



    // Alert Handling Method
    public Alert alertHandler(){
        Alert alert = driver.switchTo().alert();
        return alert;
    }



    //Cookies Handling
    public WebDriver.Options cookiesHandler(){
        WebDriver.Options cookie = driver.manage();
        return cookie;
    }



    //Selecting items from the drop down menu
    public Select selectInList(WebElement element) {
        Select select = new Select(element);
        return select;
    }



   /* Implicit Wait ==> Waiting  for n seconds before throwing an exception and applicable for all the TestCases,
                       but if find the element before that time the test case will be executed. */
    public void setImplicitWait() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    // Explicit Wait ==> Waiting  for n seconds before throwing an exception, but applicable for only a specific TestCase.

    public WebDriverWait setExplicitWait() {
        WebDriverWait w = new WebDriverWait(driver, 40);
        return w;
    }


    //Popup window Handling
    public void switchToChildWindow(){
        Set<String> handler = driver.getWindowHandles();
        Iterator<String> it = handler.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
    }


    // Mouse Hover option.
    public void mouseHover(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }


    //Drag and Drop option.
    public void dragAndDrop(WebElement source, WebElement target) {
        Actions action = new Actions(driver);
        action.dragAndDrop(source, target).build().perform();
    }


    //Navigation.
    public WebDriver.Navigation navigate(){

        WebDriver.Navigation navigation = new WebDriver.Navigation() {
            @Override
            public void back() {}

            @Override
            public void forward() {}

            @Override
            public void to(String url) {}

            @Override
            public void to(URL url) {}

            @Override
            public void refresh() {}
        };
        return navigation;
    }


    //Scrolling option on the web page by horizontally and vertically.
    public void scroll(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }


    //Taking Screenshot.
    public void screenShot() throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:\\Users\\tafat\\screenshot.png"));
    }



        @AfterSuite
    public void generateReport() {
        extent.close();
    }
    //reporting finish


    @AfterMethod
    public void cleanUp() {
        driver.close();
        driver.quit();
        LOGGER.info("Driver closed !!!");
    }
}

