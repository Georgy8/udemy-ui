package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Timestamp;

public class SignupPopup {
    private WebDriver driver;
    private WebDriverWait wait;

    public SignupPopup(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By signupPopupTitleLocator = By.xpath("//div[@class=' loginbox-v4__header loginbox-v4__header--signup']");
    By nameFieldLocator = By.xpath("//input[@id='id_fullname']");
    By emailaddressFieldLocator = By.xpath("//input[@id='email--1']");
    By passwordFieldLocator = By.xpath("//input[@id='password']");
    By submitSignupButtonLocator = By.xpath("//input[@id='submit-id-submit']");


    int timestamp = new Timestamp(System.currentTimeMillis()).getNanos();

    public String getSignupPopupTitleText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupPopupTitleLocator));
        WebElement signupPopupTitle = driver.findElement(signupPopupTitleLocator);
        return signupPopupTitle.getText();
    }

    public SignupPopup fillNameField(String name) {
        WebElement nameField = driver.findElement(nameFieldLocator);
        nameField.sendKeys(name);
        return this;
    }

    public SignupPopup fillEmailAddresField(String string) {
        WebElement emailaddressField = driver.findElement(emailaddressFieldLocator);
        emailaddressField.sendKeys(string);
        System.out.println("Email = " + string);
        return this;
    }

    public SignupPopup fillPasswordField(String password) {
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.sendKeys(password);
        return this;
    }

    public void submitForm() {
        wait.until(ExpectedConditions.elementToBeClickable(submitSignupButtonLocator));
        WebElement submitSignupButton = driver.findElement(submitSignupButtonLocator);
        submitSignupButton.click();
    }

}
