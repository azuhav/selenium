package com.duck.web;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GooglePage  {

    WebDriver driver;

    public static String ducks = "ducks";

    @FindBy(how = How.CSS, using = "input[type='text'][name='q']")
    private WebElement searchForm;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void generateSearchResult() {

        searchForm.click();
        searchForm.sendKeys(GooglePage.ducks);
        searchForm.sendKeys(Keys.ENTER);

    }

}
