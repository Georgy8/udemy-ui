package com.udemy;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.HeaderSectionConst.CATEGORYLIST;

public class CategoriesTest extends TestBase {


    @Test(description = "Check list categories")
    public void checkListCategories() {

        homePage.openHomePage();
        headerSection.openListOfCateogries();
        Assert.assertEquals(headerSection.getTitlesListOfCategories(), CATEGORYLIST);


    }
}
