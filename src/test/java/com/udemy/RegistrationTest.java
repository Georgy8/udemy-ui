package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.udemy.testdata.UserData.basicUser;

public class RegistrationTest extends TestBase {


    @Test(description = "Registration with valid data")
    public void registrationWithValidData() {
        homePage.openHomePage();
        headerSection.openSignupPopup();
        Assert.assertEquals(signupForm.getSignupPopupTitleText(), "Sign Up and Start Learning!");
        signupForm
                .enterName(basicUser.getName())
                .enterEmail(basicUser.getEmail())
                .enterPassword(basicUser.getPassword())
                .submitForm();
        Assert.assertEquals(headerSection.getUserEmail(), basicUser.getEmail());

    }
}
