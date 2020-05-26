package com.udemy;


import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    @Test(description = "Login with valid data")
    public void LoginUsingCookie() {

        homePage.openHomePage();
        headerSection.setSessionCookie(cookie);
        Assert.assertEquals(headerSection.getUserInitial(), "G");

    }
}
