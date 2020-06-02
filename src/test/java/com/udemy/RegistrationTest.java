package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.udemy.testdata.UserData.basicUser;

public class RegistrationTest extends TestBase {


    @Test(description = "Registration with valid data")
    public void registrationWithValidData() {
        homePage.openHomePage();
        headerSection.openSignupPopup();
        Assert.assertEquals(signupForm.getSignupPopupTitleText(), "Зарегистрируйтесь и начните обучение!");
        signupForm.fillNameField(basicUser.getName())
                .fillEmailAddresField(basicUser.getEmail())
                .fillPasswordField(basicUser.getPassword())
                .submitForm();
        Assert.assertEquals(headerSection.getUserInitial(), basicUser.getName().substring(0,1));

    }
}
