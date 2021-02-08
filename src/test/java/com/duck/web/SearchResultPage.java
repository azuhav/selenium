package com.duck.web;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyDucksInPageText() {

        String pageText = driver.findElement(By.cssSelector("#rcnt")).getText();

        return StringUtils.containsIgnoreCase(pageText, GooglePage.ducks);

    }

    public boolean verifyDucksInLinkText() {

        List<WebElement> headers = driver.findElements(By.cssSelector("#rcnt h3 > span"));

        StringBuilder stringBuilder = new StringBuilder();

        headers.forEach(header -> stringBuilder.append(header.getText()).append(" "));

        String linkText = stringBuilder.toString();

        return StringUtils.containsIgnoreCase(linkText, GooglePage.ducks);

    }

}