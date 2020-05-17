package com.udemy;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.sql.Timestamp;

public class RegistrationTest {

    @Test(description = "Registration with valid data")
    public void registrationWithValidData() throws InterruptedException {
        int timestamp = new Timestamp(System.currentTimeMillis()).getNanos();

        File chromeDriver = new File("src/main/resources/chromedriver.exe");
        ChromeDriverService chromeService = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriver)
                .usingAnyFreePort()
                .build();

       WebDriver driver = new ChromeDriver(chromeService);
       driver.get("https://www.udemy.com/");


        //открытие попапа регистрации
        WebElement signupPopupButton = driver.findElement(
                By.xpath("//div[contains(@class,'signup')]//button"));
        signupPopupButton.click();
        Thread.sleep(5000);


        //проверка совпадения по тайтлу
        WebElement signupPopupTitle = driver.findElement(
                By.xpath("//div[@class=' loginbox-v4__header loginbox-v4__header--signup']"));
        Assert.assertEquals(signupPopupTitle.getText(), "Зарегистрируйтесь и начните обучение!");


        WebElement nameField = driver.findElement(
                By.xpath("//input[@id='id_fullname']"));
        nameField.sendKeys("Georgiy");

        WebElement emailaddressField = driver.findElement(
                By.xpath("//input[@id='email--1']"));
        emailaddressField.sendKeys("BLABLA"+ timestamp +"@yopmail.com");
        System.out.println("Email = BLABLA" + timestamp + "@yopmail.com");

        WebElement passwordField = driver.findElement(
                By.xpath("//input[@id='password']"));
        passwordField.sendKeys("Qwerty1234!");

        //сабмит формы регистрации
        WebElement submitSignupButton = driver.findElement(
                By.xpath("//input[@id='submit-id-submit']"));
        submitSignupButton.click();
        Thread.sleep(4000);


        //финальная проверка
        WebElement userAvatar = driver.findElement(
                By.xpath("(//div[@aria-label='Georgiy'])[1]"));
        Assert.assertEquals(userAvatar.getText(),"G");
        Thread.sleep(3000);

        driver.quit();
    }
}
