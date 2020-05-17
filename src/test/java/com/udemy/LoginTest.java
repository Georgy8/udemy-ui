package com.udemy;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test(description = "Login with valid data")
    public void LoginWithValidData() {
        By userAvatarLocator = By.xpath("(//div[@aria-label='Georgiy'])[1]");

        driver.get("https://www.udemy.com/");

        driver.manage().addCookie(cookie);

        driver.navigate().refresh();

        wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarLocator));
        WebElement userAvatar = driver.findElement(userAvatarLocator);
        Assert.assertEquals(userAvatar.getText(),"G");

    }
}
