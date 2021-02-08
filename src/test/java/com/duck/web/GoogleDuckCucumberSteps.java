package com.duck.web;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertTrue;

public class GoogleDuckCucumberSteps {

    GoogleDuckTest googleDuckTest = new GoogleDuckTest();
    GooglePage googlePage;
    SearchResultPage searchResultPage;

    @Given("a user opens Google search page")
    public void navigateToGooglePage() {

        googleDuckTest = new GoogleDuckTest();
        googleDuckTest.setUp();

    }

    @When("the user performs ducks search")
    public void searchDucks() {

        googlePage = new GooglePage(googleDuckTest.driver);
        googlePage.generateSearchResult();

    }

    @Then("ducks are present on the search result page")
    public void verifyDucksInPageText() {
        searchResultPage = new SearchResultPage(googleDuckTest.driver);
        assertTrue(searchResultPage.verifyDucksInPageText());

    }

    @Then("ducks are present on the link text")
    public void verifyDucksInLinkText() {
        searchResultPage = new SearchResultPage(googleDuckTest.driver);
        assertTrue(searchResultPage.verifyDucksInLinkText());

    }

    @After
    public void closeBrowser() {
        googlePage.driver.quit();

    }

}
