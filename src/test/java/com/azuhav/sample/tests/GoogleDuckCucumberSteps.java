package com.azuhav.sample.tests;

import com.azuhav.sample.tests.GoogleDuckTest;
import com.azuhav.sample.core.Utils;
import com.azuhav.sample.pages.GooglePage;
import com.azuhav.sample.pages.SearchResultPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class GoogleDuckCucumberSteps {

    public GooglePage googlePage;
    public SearchResultPage searchResultPage;
    public GoogleDuckTest googleDuckTest = new GoogleDuckTest();

    public WebDriver driver;
    public String URL = Utils.readJson("url");

    @Before
    public void init() throws Exception {

        googleDuckTest.setUp("chrome");

    }

    @Given("^a user opens Google search page$")
    public void navigateToGooglePage() throws Exception {

        googleDuckTest.getDriver().get(URL);

    }

    @When("^the user performs (.*) search$")
    public void searchDucks(String birds) {

        googlePage = new GooglePage(googleDuckTest.getDriver());
        googlePage.generateSearchResult(birds);

    }

    @Then("^ducks are present on the search result page$")
    public void verifyDucksInPageText() {

        searchResultPage = new SearchResultPage(googleDuckTest.getDriver());
        assertTrue(searchResultPage.verifyDucksInPageText());

    }

    @Then("^ducks are present on the link text$")
    public void verifyDucksInLinkText() {

        searchResultPage = new SearchResultPage(googleDuckTest.getDriver());
        assertTrue(searchResultPage.verifyDucksInLinkText());

    }

    @After
    public void closeBrowser() {

        googleDuckTest.getDriver().quit();

    }

}