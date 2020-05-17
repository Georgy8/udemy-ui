package com.udemy;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Timestamp;

public class RegistrationTest extends TestBase{

    @Test(description = "Registration with valid data")
    public void registrationWithValidData() {
        By signupPopupButtonLocator =  By.xpath("//div[contains(@class,'signup')]//button");
        By signupPopupTitleLocator =  By.xpath("//div[@class=' loginbox-v4__header loginbox-v4__header--signup']");
        By nameFieldLocator = By.xpath("//input[@id='id_fullname']");
        By emailaddressFieldLocator = By.xpath("//input[@id='email--1']");
        By passwordFieldLocator = By.xpath("//input[@id='password']");
        By submitSignupButtonLocator = By.xpath("//input[@id='submit-id-submit']");
        By userAvatarLocator = By.xpath("(//div[@aria-label='Georgiy'])[1]");



        int timestamp = new Timestamp(System.currentTimeMillis()).getNanos();

       driver.get("https://www.udemy.com/");


        //открытие попапа регистрации
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupPopupButtonLocator));
        WebElement signupPopupButton = driver.findElement(signupPopupButtonLocator);
        signupPopupButton.click();


        //проверка совпадения по тайтлу
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupPopupTitleLocator));
        WebElement signupPopupTitle = driver.findElement(signupPopupTitleLocator);
        Assert.assertEquals(signupPopupTitle.getText(), "Зарегистрируйтесь и начните обучение!");

        WebElement nameField = driver.findElement(nameFieldLocator);
        nameField.sendKeys("Georgiy");

        WebElement emailaddressField = driver.findElement(emailaddressFieldLocator);
        emailaddressField.sendKeys("BLABLA"+ timestamp +"@yopmail.com");
        System.out.println("Email = BLABLA" + timestamp + "@yopmail.com");

        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.sendKeys("Qwerty1234!");

        //сабмит формы регистрации
        WebElement submitSignupButton = driver.findElement(submitSignupButtonLocator);
        submitSignupButton.click();


        //финальная проверка
        wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarLocator));
        WebElement userAvatar = driver.findElement(userAvatarLocator);
        Assert.assertEquals(userAvatar.getText(),"G");

    }
}
