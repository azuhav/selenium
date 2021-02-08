package com.duck.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GoogleDuckTest {

    WebDriver driver;

    SearchResultPage searchResultPage;
    GooglePage googlePage;

    String URL = "https://google.com";

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);

        googlePage = new GooglePage(driver);
        googlePage.generateSearchResult();


    }

    @Test
    public void searchDucksInThePageTextTest() {

        searchResultPage = new SearchResultPage(driver);
        Assert.assertTrue(searchResultPage.verifyDucksInPageText());

    }

    @Test
    public void searchDucksInThePageLinksTest() {

        searchResultPage = new SearchResultPage(driver);
        Assert.assertTrue(searchResultPage.verifyDucksInLinkText());

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();

    }

}