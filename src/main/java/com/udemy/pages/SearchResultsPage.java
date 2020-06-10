package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public SearchResultsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By searchFieldOnPageLocator = By.xpath("//h1[@class='udlite-heading-xxl']");
    By firstSearchedItemLocator = By.xpath("(//*[contains(@class,'course-card--course-title')])[1]");

    public String getSearchedStringResult() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldOnPageLocator));
        WebElement searchFieldOnPage = driver.findElement(this.searchFieldOnPageLocator);
        return searchFieldOnPage.getText();
    }

    public String getSearchURL() {
        return driver.getCurrentUrl();
    }

    public String getTitleFirstSeachedItem() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstSearchedItemLocator));
        WebElement firstSearchedItem = driver.findElement(this.firstSearchedItemLocator);
        return firstSearchedItem.getText().toLowerCase();
    }
}
