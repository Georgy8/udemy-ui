package com.udemy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    By signupPopupButtonLocator = By.xpath("//*[@data-purpose='header' or @role='navigation']//*[starts-with(text(),'Sign')]"); //-//div[contains(@class,'signup')]//button
    By userAvatarLocator = By.xpath("(//*[@class='user-initials' or contains(@class,'dropdown-button-avatar')])[1]");
    By userEmailInProfileDropdownLocator = By.xpath("//*[contains(@class,'user-profile-dropdown--email') or contains(@data-purpose,'edit-profile')]");
    By searchFieldLocator = By.xpath("//*[contains(@id,'search-form-autocomplete') or contains(@data-purpose,'search-input')]");
    By searchFieldCoursesLocator = By.xpath("//form[@action='/courses/search/']//input");
    By categoryButtonLocator = By.xpath("//*[contains(text(),'Categories') or contains(@data-purpose,'browse-courses-link')]");  //-//a[@data-purpose='browse-courses-link']
    By categoryMainListLocator = By.xpath("//*[contains(@class,'level-one')]//li"); //-//ul[@aria-label='Категории']//following-sibling::span[@class='fx']

    public void openSignupPopup() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupPopupButtonLocator));
        WebElement signupPopupButton = driver.findElement(signupPopupButtonLocator);
        signupPopupButton.click();
    }

    public String getUserEmail() {
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarLocator));
        WebElement userAvatar = driver.findElement(userAvatarLocator);
        actions.moveToElement(userAvatar).perform();
        actions.moveToElement(userAvatar).perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(userEmailInProfileDropdownLocator));
        WebElement userEmailInProfileDropdown = driver.findElement(userEmailInProfileDropdownLocator);
        return userEmailInProfileDropdown.getText();
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
