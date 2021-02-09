package com.azuhav.sample.tests;

import com.azuhav.sample.core.Utils;
import com.azuhav.sample.pages.GooglePage;
import com.azuhav.sample.pages.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GoogleDuckTest {

    public WebDriver driver;

    SearchResultPage searchResultPage;
    GooglePage googlePage;

    String URL = Utils.readJson("url");

    @BeforeMethod
    public void setUp(String browserType) throws Exception {

        if (browserType.equalsIgnoreCase(BrowserType.CHROME)) {
            System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase(BrowserType.FIREFOX)) {
            System.setProperty("webdriver.firefox.driver", ".\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            throw new Exception("Not valid browser type");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void searchDucksInThePageTextTest() {

        driver.get(URL);

        googlePage = new GooglePage(driver);
        googlePage.generateSearchResult();

        searchResultPage = new SearchResultPage(driver);
        Assert.assertTrue(searchResultPage.verifyDucksInPageText());

    }

    @Test
    public void searchDucksInThePageLinksTest() {

        driver.get(URL);

        googlePage = new GooglePage(driver);
        googlePage.generateSearchResult();

        searchResultPage = new SearchResultPage(driver);
        Assert.assertTrue(searchResultPage.verifyDucksInLinkText());

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();

    }

    public WebDriver getDriver() {

        return this.driver;

    }

}