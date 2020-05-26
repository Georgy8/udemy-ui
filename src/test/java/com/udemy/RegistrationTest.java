package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {


    @Test(description = "Registration with valid data")
    public void registrationWithValidData() {
        homePage.openHomePage();
        headerSection.openSignupPopup();
        Assert.assertEquals(signupForm.getSignupPopupTitleText(), "Зарегистрируйтесь и начните обучение!");
        signupForm.fillNameField("Georgiy")
                .fillEmailAddresField("BLABLA" + timestamp + "@yopmail.com")
                .fillPasswordField("Qwerty123!")
                .submitForm();
        Assert.assertEquals(headerSection.getUserInitial(), "G");

    }
}
