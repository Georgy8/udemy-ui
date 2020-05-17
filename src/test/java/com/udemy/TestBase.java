package com.udemy;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.Date;

public class TestBase {

    WebDriver driver;
    WebDriverWait wait;
    Cookie cookie;

    @BeforeClass(description = "Open browser")
    public void openBrowser(){

        File chromeDriver = new File("src/main/resources/chromedriver.exe");
        ChromeDriverService chromeService = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriver)
                .usingAnyFreePort()
                .build();

        driver = new ChromeDriver(chromeService);

        cookie = new Cookie.Builder("dj_session_id","snhpy9h9ow65gkzqvdjb97n9c2g70qoq")
                .domain("www.udemy.com")
                .expiresOn(new Date(2020,6,16))
                .isHttpOnly(true)
                .isSecure(true)
                .path("/")
                .build();

        wait = new WebDriverWait(driver,5);
    }

    @AfterMethod(description = "Close browser")
    public void closeBrowser(){
        driver.quit();
    }
}
