package com.udemy;


import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    @Test(description = "Login with valid data")
    public void loginUsingCookie() {

        homePage.openHomePage();
        headerSection.setSessionCookie(cookie);
        Assert.assertEquals(headerSection.getUserEmail(), "BLABLA750000000@yopmail.com");

    }
}
