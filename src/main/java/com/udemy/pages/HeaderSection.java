package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class HeaderSection {

    private WebDriver driver;
    private WebDriverWait wait;

    public HeaderSection(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By signupPopupButtonLocator = By.xpath("(//span[contains(text(),'Регистрация')])[2]"); //-//div[contains(@class,'signup')]//button
    By userAvatarLocator = By.xpath("(//div[@aria-label='Georgiy'])[1]");
    By searchFieldLocator = By.xpath("//input[@data-purpose='search-input']");
    By searchFieldCoursesLocator = By.xpath("//form[@action='/courses/search/']//input");
    By categoryButtonLocator = By.xpath("//*[contains(text(),'Категории')]");  //-//a[@data-purpose='browse-courses-link']
    By categoryMainListLocator = By.xpath("//a[@aria-label='Мой профиль']/div"); //-//ul[@aria-label='Категории']//following-sibling::span[@class='fx']

    public void openSignupPopup() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupPopupButtonLocator));
        WebElement signupPopupButton = driver.findElement(signupPopupButtonLocator);
        signupPopupButton.click();
    }

    public String getUserInitial() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarLocator));
        WebElement userAvatar = driver.findElement(userAvatarLocator);
        return userAvatar.getText();
    }


    public Boolean checkISSearchFieldEmpty() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldLocator));
        WebElement searchField = driver.findElement(searchFieldLocator);
        return searchField.getText().isEmpty();
    }

    public String getSearchedStringFromHeaderSearchField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldCoursesLocator));
        WebElement searchFieldInHeader = driver.findElement(this.searchFieldCoursesLocator);
        return searchFieldInHeader.getAttribute("value");
    }

    public void openListOfCateogries() {
        wait.until(ExpectedConditions.elementToBeClickable(categoryButtonLocator));
        WebElement categoryButton = driver.findElement(categoryButtonLocator);
        categoryButton.click();
    }

    public List<String> getTitlesListOfCategories() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoryMainListLocator));
        List<WebElement> listOfCategories = driver.findElements(categoryMainListLocator);
        List<String> titlesListOfCategories = new ArrayList<>();
        for (int i = 0; i < listOfCategories.size(); i++) {
            titlesListOfCategories.add(listOfCategories.get(i).getText());
        }
        return titlesListOfCategories;
    }

    public void setSessionCookie(Cookie cookie) {
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
    }
}
