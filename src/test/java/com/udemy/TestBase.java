package com.udemy;

import com.udemy.pages.HeaderSection;
import com.udemy.pages.HomePage;
import com.udemy.pages.SearchResultsPage;
import com.udemy.pages.SignupPopup;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestBase {

    public WebDriver driver;
    public WebDriverWait wait;
    public Cookie cookie;

    HomePage homePage;
    HeaderSection headerSection;
    SignupPopup signupForm;
    SearchResultsPage searchResultsPage;

    @BeforeClass(description = "Open browser")
    public void openBrowser() {

        File chromeDriver = new File("src/main/resources/chromedriver.exe");
        ChromeDriverService chromeService = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriver)
                .usingAnyFreePort()
                .build();

        ChromeOptions chromeOptions = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("intl.accept_languages", "en-US");
        chromeOptions.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(chromeService, chromeOptions);

        cookie = new Cookie.Builder("dj_session_id", "snhpy9h9ow65gkzqvdjb97n9c2g70qoq")
                .domain("www.udemy.com")
                .expiresOn(new Date(2020, 6, 16))
                .isHttpOnly(true)
                .isSecure(true)
                .path("/")
                .build();

        wait = new WebDriverWait(driver, 5);

        homePage = new HomePage(driver, wait);
        headerSection = new HeaderSection(driver, wait);
        signupForm = new SignupPopup(driver, wait);
        searchResultsPage = new SearchResultsPage(driver, wait);
    }

    @AfterMethod(description = "Close browser")
    public void closeBrowser() {
        driver.quit();
    }
}
