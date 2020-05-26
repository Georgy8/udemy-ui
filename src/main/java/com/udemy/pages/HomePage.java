package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By searchFieldLocator = By.xpath("//input[@data-purpose='home-quick-search-box']");

    public void openHomePage() {
        driver.get("https://www.udemy.com/");
    }

    public HomePage fillSearchField(String string) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldLocator));
        WebElement searchField = driver.findElement(searchFieldLocator);
        searchField.sendKeys(string);
        return this;
    }

    public void submiteSearchField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldLocator));
        WebElement seachField = driver.findElement(searchFieldLocator);
        seachField.submit();
    }
}
