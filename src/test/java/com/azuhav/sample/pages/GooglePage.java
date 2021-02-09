package com.azuhav.sample.pages;

import com.azuhav.sample.core.Utils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {

    public WebDriver driver;

    public static String ducks = Utils.readJson("keyword");

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

    public void generateSearchResult(String text) {

        searchForm.click();
        searchForm.sendKeys(GooglePage.ducks);
        searchForm.sendKeys(Keys.ENTER);

    }

}